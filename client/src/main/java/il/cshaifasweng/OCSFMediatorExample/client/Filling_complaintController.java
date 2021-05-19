package il.cshaifasweng.OCSFMediatorExample.client;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Sample Skeleton for 'Filing_complaint.fxml' Controller Class
 */


public class Filling_complaintController {

    @FXML
    void gotoprimary(ActionEvent event) throws Exception 
    {
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Main");
    	primaryStage.show();

    }
    

    @FXML
    void sendcomplain_gotoprimary(ActionEvent event) throws Exception  
    {
    	//hun lazm nzed funktsyat send_complaint mn hdlak  lawlad
    	//send_complaint(Name,content);
    	Stage primaryStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Main");
    	primaryStage.show();

    }

}

