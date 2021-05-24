package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.MoviesList;

public class MoviesListEvent {
	private MoviesList moviesList;

	public MoviesList getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(MoviesList moviesList) {
		this.moviesList = moviesList;
	}

}
