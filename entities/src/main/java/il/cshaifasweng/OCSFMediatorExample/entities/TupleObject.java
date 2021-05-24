package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class TupleObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	ArrayList<Movie> movies;

	public TupleObject(String msg, ArrayList<Movie> movies) {
		this.msg = msg;
		this.movies = movies;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

}
