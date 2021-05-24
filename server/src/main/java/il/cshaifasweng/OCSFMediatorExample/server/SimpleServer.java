package il.cshaifasweng.OCSFMediatorExample.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import il.cshaifasweng.OCSFMediatorExample.entities.Movie;
import il.cshaifasweng.OCSFMediatorExample.entities.TupleObject;
import il.cshaifasweng.OCSFMediatorExample.entities.Warning;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;

public class SimpleServer extends AbstractServer {

	public SimpleServer(int port) {
		super(port);

	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("beinning of FUNCCCCCCCCCCCCCCCC");
		TupleObject tuple_msg = (TupleObject) msg;
		// String msgString = msg.toString();
		if (tuple_msg.getMsg().startsWith("#warning")) {
			Warning warning = new Warning("Warning from server!");
			try {
				client.sendToClient(warning);
				System.out.format("Sent warning to client %s\n", client.getInetAddress().getHostAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (tuple_msg.getMsg().startsWith("Delete movie ")) {
			System.out.println("in delete movieeeeeeeeeeeee");
			boolean x = deleteMovie(msg);
			if (x == false) {
				// try {
				// client.sendToClient("no such movie");
				try {
					client.sendToClient(new TupleObject("no such movie", null));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKK");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			} else {
				try {
					// client.sendToClient("found movie");
					client.sendToClient(new TupleObject("found movie", null));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("before the IFFFFFFFFFFFFFFFFFFF");
		if (tuple_msg.getMsg().startsWith("Browse movies")) {
			try {
				ArrayList<Movie> movies = getMoviesList();
				System.out.println("size in handle msg from client func: " + movies.size());
				// System.out.println(movies.get(0).getEngName());
				client.sendToClient(new TupleObject("All Movies", movies));
				// client.sendToClient(tuple_msg);
			} catch (Exception e) {
				System.out.println("exceptionnnnnnnnnnnnnnnnnnnnnnnnnnn");
				e.printStackTrace();
			}
		}
		if (tuple_msg.getMsg().startsWith("Add Screening Time")) {
			String name = tuple_msg.getMovies().get(0).getEngName();
			String Newtime = tuple_msg.getMovies().get(0).getHebName();
			AddScreeningTime(name, Newtime, null);
		}
		System.out.println("End of handle msg from client func");
	}

	private boolean deleteMovie(Object msg) {
		boolean let_in = false;
		String message = ((String) msg).substring(13);
		System.out.println("DELETE FROM movies WHERE EngName = '" + message + "'");
		Connection c = null;
		java.sql.Statement stmt = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewDB", "root", "root-Pass1.@");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			int rs = stmt.executeUpdate("DELETE FROM movies WHERE EngName = '" + message + "'");
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

	private static ArrayList<Movie> getMoviesList() {
		System.out.println("beginning of get movie list func (of server)");
//		ArrayList<Movie> movies = new ArrayList<Movie>();
//		Movie movie = new Movie();
//		System.out.println("SELECT* FROM movies");// aw my_moviesssssssss aw databaseforavtipos.movie
//		Connection c = null;
//		java.sql.Statement stmt = null;
//		try {
//			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewDB", "root", "root-Pass1.@");
//			c.setAutoCommit(false);
//			System.out.println("Opened database successfully");
//			stmt = c.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT* FROM movies");
//			while (rs.next()) {
//				System.out.println("Table contains before everything" + rs.getRow() + " rows");
//				if (rs.getString("Eng_name") != null && rs.getString("Heb_Name") != null && rs.getInt("lenth") != 0
//				/* && rs.getObject("My_ActorsNames") != null */ && rs.getString("summary") != null
//						&& rs.getString("producer") != null && rs.getInt("price") != 0) {
//					String engName = rs.getString("Eng_name");
//					System.out.println("ENGNAME = " + engName);
//					String hebName = rs.getString("Heb_Name");
//					System.out.println("HEBNAME = " + hebName);
//					int len = rs.getInt("lenth");
//					System.out.println("LEN = " + len);
//					ArrayList<String> actors = new ArrayList<String>();
//					String summary = rs.getString("summary");
//					System.out.println("SUMMARY = " + summary);
//					String producer = rs.getString("producer");
//					System.out.println("PRODUCER = " + producer);
//					int price = rs.getInt("price");
//					System.out.println("PRICE = " + price);
//					movie = new Movie(engName, actors, len, hebName, summary, producer, price, null);
//					movies.add(movie);
//
//				}
////				int rowCount = rs.getRow();
////				for (int row = 1; row <= rowCount; ++row) {
////					Object movie = rs.getObject(row);
////					movies.add((Movie) movie);
////				}
//				System.out.println("Table contains " + rs.getRow() + " rows");
//				System.out.println("THe first movie before is: " + movies.get(0).getEngName());
//			}
//			stmt.close();
//			c.close();
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
//		}
//		System.out.println("Operation done successfully");
//		System.out.println("THe size of movies list after is: " + movies.size());
//		return movies;

		CriteriaBuilder builder = App.session.getCriteriaBuilder();
		CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
		query.from(Movie.class);
		List<Movie> data = App.session.createQuery(query).getResultList();
		System.out.println("SIZE OF MOVIES LIST in get movies func: " + data.size());
		// System.out.println("FIRST MOVIE: " + data.get(0).getEngName());
		return (ArrayList<Movie>) data;
	}

	private void AddScreeningTime(String name, String newTime, String oldTime) {
		// System.out.println("SELECT FROM movies WHERE EngName = '" + name + "'");
		Connection c = null;
		java.sql.Statement stmt = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewDB", "root", "root-Pass1.@");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			if (newTime == null) {
				/* add */}

			if (oldTime == null) {
				/* remove */} else {
//				CriteriaUpdate<Movie> criteriaUpdate = cb.createCriteriaUpdate(Movie.class);
//				Root<Movie> root = criteriaUpdate.from(Movie.class);
//				criteriaUpdate.set("itemPrice", newPrice);
//				criteriaUpdate.where(cb.equal(root.get("itemPrice"), oldPrice));
//
//				Transaction transaction = session.beginTransaction();
//				session.createQuery(criteriaUpdate).executeUpdate();
//				transaction.commit();
			}
			// before we need a query that takes movie name and returns the movie id and
			// then we need another query that add/remove/update screening time to the movie
			// id
			ResultSet rs = stmt.executeQuery("?????????????????????????????????????????");
			if (rs != null) {

			}
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}
