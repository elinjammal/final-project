package il.cshaifasweng.OCSFMediatorExample.entities;

public class Hall {
	int num;
	int size;
	int EmptyChairs;
	Movie movie;
	
	public Hall(int size, Movie movie) {
		super();
		this.size = size;
		this.movie = movie;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getEmptyChairs() {
		return EmptyChairs;
	}
	public void setEmptyChairs(int emptyChairs) {
		EmptyChairs = emptyChairs;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	

}
