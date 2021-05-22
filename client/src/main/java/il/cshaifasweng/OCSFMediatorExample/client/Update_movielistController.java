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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Sample Skeleton for 'Update_movielist.fxml' Controller Class
 */

public class Update_movielistController {

	@FXML // fx:id="invalidDelete_label"
	private static Label invalidDelete_label; // Value injected by FXMLLoader

	@FXML // fx:id="actors_box"
	private TextField actors_box; // Value injected by FXMLLoader

	@FXML // fx:id="englishName_box"
	private TextField englishName_box; // Value injected by FXMLLoader

	@FXML // fx:id="producer_box"
	private TextField producer_box; // Value injected by FXMLLoader

	@FXML // fx:id="hebrewName_box"
	private TextField hebrewName_box; // Value injected by FXMLLoader

	@FXML // fx:id="length_box"
	private TextField length_box; // Value injected by FXMLLoader

	@FXML // fx:id="price_box"
	private TextField price_box; // Value injected by FXMLLoader

	@FXML // fx:id="image_box"
	private TextField image_box; // Value injected by FXMLLoader

	@FXML // fx:id="Add_Movie"
	private Button Add_Movie; // Value injected by FXMLLoader

	@FXML // fx:id="updateMovieName_box"
	private TextField updateMovieName_box; // Value injected by FXMLLoader

	@FXML // fx:id="deleteMovieName_box"
	private TextField deleteMovieName_box;
//	private static TextField deleteMovieName_boxPublic; // Value injected by FXMLLoader

//	public void initialize(URL url, ResourceBundle rb) {// b3rfsh esh hdol el url/rb wiza lzm n3'yrn
//		Update_movielistController.deleteMovieName_boxPublic = updateMovieName_box;
//	}

	@FXML // fx:id="Delete_Movie"
	private Button Delete_Movie; // Value injected by FXMLLoader

	@FXML // fx:id="newTime_box"
	private TextField newTime_box; // Value injected by FXMLLoader

	@FXML // fx:id="oldTime_box"
	private TextField oldTime_box; // Value injected by FXMLLoader

	@FXML // fx:id="Update_Screening_Time"
	private Button Update_Screening_Time; // Value injected by FXMLLoader

	@FXML // fx:id="newPrice_box"
	private TextField newPrice_box; // Value injected by FXMLLoader

	@FXML // fx:id="updateMoviePrice_box"
	private TextField updateMoviePrice_box; // Value injected by FXMLLoader

	@FXML // fx:id="Update_Price"
	private Button Update_Price; // Value injected by FXMLLoader

	@FXML // fx:id="Back_To_Home"
	private Button Back_To_Home; // Value injected by FXMLLoader

	@FXML
	void Add_movie(ActionEvent event) {

	}

	@FXML
	void Delete_movie(ActionEvent event) throws IOException {

		SimpleClient.getClient().sendToServer("Delete movie " + deleteMovieName_box.getText());
	}

	@FXML
	void Update_screening_time(ActionEvent event) {

	}

	@FXML
	void backtohome(ActionEvent event) throws IOException {
		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Home");
		primaryStage.show();

	}

	@FXML
	void update_price(ActionEvent event) {

	}

	public TextField getDeleteMovieName_box() {
		return deleteMovieName_box;
	}

	public static Label getInvalidDelete_label() {
		return invalidDelete_label;
	}

	public void setInvalidDelete_label(Label invalidDelete_label) {
		Update_movielistController.invalidDelete_label = invalidDelete_label;
	}

}
