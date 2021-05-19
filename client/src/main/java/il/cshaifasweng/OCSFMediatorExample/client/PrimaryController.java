package il.cshaifasweng.OCSFMediatorExample.client;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */



public class PrimaryController {

    @FXML
    void gotoFiling_complaint(ActionEvent event) throws Exception 
    {
    	//closeWindow();
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("Filing_complaint.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Filing Complaint");
    	primaryStage.show();

    }

    @FXML
    void gotoLogin(ActionEvent event) throws Exception 
    {
    	//closeWindow();
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Log in");
    	primaryStage.show();

    }

    @FXML
    void gotobrowse_movies(ActionEvent event) throws Exception 
    {
    	//closeWindow();
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("browse_movies.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Browse movies list");
    	primaryStage.show();

    }

}

