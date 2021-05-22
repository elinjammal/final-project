package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

public class PrimaryController {

	@FXML // fx:id="Update_movie_list"
	private Button Update_movie_list; // Value injected by FXMLLoader

	@FXML // fx:id="Browse_movie_list"
	private Button Browse_movie_list; // Value injected by FXMLLoader

	@FXML // fx:id="Filling_a_complaint"
	private Button Filling_a_complaint; // Value injected by FXMLLoader

	@FXML
	void gotoFillingacomplaint(ActionEvent event) throws IOException {
		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FillingComplaint.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Complaints");
		primaryStage.show();

	}

	@FXML
	void gotoLogin(ActionEvent event) throws IOException {

		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Log in");
		primaryStage.show();

	}

	@FXML
	void gotobrowse_movies(ActionEvent event) throws Exception {

		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}
		SimpleClient.getClient().sendToServer("Browse movies");
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("browse_movies.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Browse movies list");
		primaryStage.show();

	}
}
