package il.cshaifasweng.OCSFMediatorExample.client;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;
import il.cshaifasweng.OCSFMediatorExample.entities.Movie;
import il.cshaifasweng.OCSFMediatorExample.entities.TupleObject;

public class SimpleClient extends AbstractClient {
	private static int num = 0;
	private Controller controller;
	private static SimpleClient client = null;

	private SimpleClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		TupleObject tuple_msg = (TupleObject) msg;
		System.out.println("entered handleMessageFromServer");

		if (tuple_msg.getMsg().equals("no such movie")) {

			// Update_movielistController.static_invalidDelete_label.setText("Sorry, no such
			// movie");
		}
		if (tuple_msg.getMsg().equals("All Movies")) {
			ArrayList<Movie> movies = new ArrayList<Movie>();
			movies = tuple_msg.getMovies();
			System.out.println("Size in client" + movies.size());
			if (movies != null) {
				System.out.println("movies not nullllll");

				// System.out.println(movies.get(1).getEngName());
			} else {
				System.out.println("movies is nullllll");
			}
		}
	}

	public static SimpleClient getClient() {
		if (client == null) {
			client = new SimpleClient("localhost", 3000);
		}
		return client;
	}

	public static int getNum() {
		return num;
	}

	public void setNum(int num) {
		SimpleClient.num = num;
	}

}
