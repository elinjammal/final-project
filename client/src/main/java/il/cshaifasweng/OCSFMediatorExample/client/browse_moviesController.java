/**
 * Sample Skeleton for 'browse_movies.fxml' Controller Class
 */

package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Movie;
import il.cshaifasweng.OCSFMediatorExample.entities.MovieTimes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

public class browse_moviesController implements Initializable {

	@FXML // fx:id="Go_back"
	private Button Go_back; // Value injected by FXMLLoader
	@FXML // fx:id="Show_screening_time"
	private Button Show_screening_time; // Value injected by FXMLLoader
	// configure the table
	@FXML
	private TableView<Movie> tableView;
	@FXML
	private TableColumn<Movie, String> firstNameColumn;
	@FXML
	private TableColumn<Movie, String> branchColumn;
//	@FXML
	// private TableColumn<Movie, LocalDate> dateColumn;

	@FXML
	void gobacktoprimary(ActionEvent event) throws IOException {
		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("List of movies");
		primaryStage.show();

	}

	@FXML
	void gotoShow_screening_time(ActionEvent event) throws IOException {
		Window window = ((Node) (event.getSource())).getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Screening_Times.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Screening_Times");
		primaryStage.show();

	}

	// this method will return an observableList of movie
	public ObservableList<Movie> getMovie() {
		ObservableList<Movie> movie = FXCollections.observableArrayList();
		List<String> AladdinActorsList2 = new ArrayList<String>();
		List<String> AladdinTimes2 = new ArrayList<String>();
		AladdinActorsList2.add("Mena Massoud");
		AladdinActorsList2.add("Naomi Scott");
		AladdinTimes2.add("18:00");
		AladdinTimes2.add("20:00");
		MovieTimes AladdinMovieTimes2 = new MovieTimes(AladdinTimes2);
		Movie AladdinMovie2 = new Movie("Aladdin", AladdinActorsList2, 128, "אלאדין", "insert aladdin movie summary",
				"Jonathan Eirich", 20, AladdinMovieTimes2);
		movie.add(AladdinMovie2);
		return movie;
	}

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// set up the column in the table
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("EngNam"));
		branchColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("HebName"));
//				dateColumn.setCellValueFactory(new PropertyValueFactory<Movie, LocalDate>("time"));

		// load dummy data
		tableView.setItems(getMovie());
	}

}
