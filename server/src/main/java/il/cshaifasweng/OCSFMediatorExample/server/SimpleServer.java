package il.cshaifasweng.OCSFMediatorExample.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import il.cshaifasweng.OCSFMediatorExample.entities.Movie;
import il.cshaifasweng.OCSFMediatorExample.entities.MovieTimes;
import il.cshaifasweng.OCSFMediatorExample.entities.Warning;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;

public class SimpleServer extends AbstractServer {

	private static SimpleServer server;
	private static Session session;

	private static SessionFactory getSessionFactory() throws HibernateException {

		Configuration configuration = new Configuration();

		// Add ALL of your entities here. You can also try adding a whole package.
		configuration.addAnnotatedClass(Movie.class);
		configuration.addAnnotatedClass(MovieTimes.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory x = configuration.buildSessionFactory(serviceRegistry);

		return x;
	}

	public SimpleServer(int port) {
		super(port);

	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		// TupleObject tuple_msg = (TupleObject) msg;
		System.out.println("HAY AWL EL FUNCCCCCCCCCCCCCCCC");
		String msgString = msg.toString();
		if (msgString.startsWith("#warning")) {
			Warning warning = new Warning("Warning from server!");
			try {
				client.sendToClient(warning);
				System.out.format("Sent warning to client %s\n", client.getInetAddress().getHostAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (msgString.startsWith("Delete movie ")) {
			System.out.println("HAY BE delete movieeeeeeeeeeeee");
			boolean x = deleteMovie(msg);
			if (x == false) {
				// try {
				// client.sendToClient("no such movie");
				sendToAllClients("no such movie");
				System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKK");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			} else {
				try {
					client.sendToClient("found movie");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("HAY abl EL IFFFFFFFFFFFFFFFFFFF");
		if (msgString.startsWith("Browse movies")) {
			try {
				System.out.println("HAY BE ALB EL IFFFFFFFFFFFFFFFFFFF");
				session = getSessionFactory().openSession();
				ArrayList<Movie> movies = getMovies();
				System.out.println("HAY ABL EL SEND TO CLIENTTTTTTTTTTT");
				// client.sendToClient(new TupleObject("All Movies", movies));
				client.sendToClient(msgString);
			} catch (Exception e) {
				System.out.println("exceptionnnnnnnnnnnnnnnnnnnnnnnnnnn");
				e.printStackTrace();
			}
		}
		System.out.println("HAY a5er eshi");
	}

	private boolean deleteMovie(Object msg) {
		boolean let_in = false;
		String message = ((String) msg).substring(13);
		System.out.println("DELETE FROM my_movies WHERE EngName = '" + message + "'");
		Connection c = null;
		java.sql.Statement stmt = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DataBaseForAvTipos", "root", "root-Pass1.@");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			int rs = stmt.executeUpdate("DELETE FROM my_movies WHERE EngName = '" + message + "'");
			if (rs != 0) {
				let_in = true;
			}
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
		System.out.println(let_in);
		return let_in;

		// TODO: add close connection
	}

	private static ArrayList<Movie> getMovies() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
		query.from(Movie.class);
		ArrayList<Movie> movies = (ArrayList<Movie>) session.createQuery(query).getResultList();
		return movies;
	}

}
