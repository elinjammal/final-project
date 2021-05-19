package il.cshaifasweng.OCSFMediatorExample.client;

import java.awt.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class browse_moviesController {
	void goToMoviesList(ActionEvent event) throws Exception {
        //closeWindow();
Stage primaryStage = new Stage();
Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
Scene scene = new Scene(root);
primaryStage.setScene(scene);
primaryStage.setTitle("List of movies");
primaryStage.show();
}
}
