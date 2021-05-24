package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class MoviesList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Movie> moviesList;

	public MoviesList(ArrayList<Movie> moviesList) {
		this.moviesList = moviesList;
	}

	public ArrayList<Movie> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(ArrayList<Movie> moviesList) {
		this.moviesList = moviesList;
	}
}
