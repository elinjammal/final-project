package il.cshaifasweng.OCSFMediatorExample.client;

import java.util.ArrayList;

import org.greenrobot.eventbus.EventBus;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;
import il.cshaifasweng.OCSFMediatorExample.entities.Movie;
import il.cshaifasweng.OCSFMediatorExample.entities.Warning;

public class SimpleClient extends AbstractClient {

	private static SimpleClient client = null;

	private SimpleClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println("awl handle from serverrrrrrrrrrrrrrrrrrrrr");
		ArrayList<Movie> movies = (ArrayList<Movie>) msg;
		System.out.println("SSSSSSSSSSSSSSSSSSss");
		for (int i = 0; i < movies.size(); i++) {
			System.out.print(movies.get(i).getEngName());
			if (msg.getClass().equals(Warning.class)) {
				EventBus.getDefault().post(new WarningEvent((Warning) msg));
			}
			if (msg.getClass().equals("no such movie")) {
				// Update_movielistController.getDeleteMovieName_box().clear();
				Update_movielistController.getInvalidDelete_label().setText("Sorry, no such movie");
			}
			System.out.println("ablllllllllllllllllllll HAMARAAAAAAAAAA BL HANDLE MSG");
			// TupleObject tuple_msg = (TupleObject) msg;
			System.out.println("B3D HAMARAAAAAAAAAA BL HANDLE MSG");
			/*
			 * if (tuple_msg.getMsg().equals("All Movies")) { ArrayList<Movie> movies =
			 * tuple_msg.getMovies(); System.out.println("SSSSSSSSSSSSSSSSSSss"); for (int i
			 * = 0; i < movies.size(); i++) { System.out.print(movies.get(i).getEngName());
			 * }
			 */
		}

	}

	public static SimpleClient getClient() {
		if (client == null) {
			client = new SimpleClient("localhost", 3000);
		}
		return client;
	}

}
