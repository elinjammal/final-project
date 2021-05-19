package il.cshaifasweng.OCSFMediatorExample.entities;

import java.util.List;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Messages")
	public class Movie {
		private String name_EN;
		private int length;
		private List<String> list_name_actors ;
		private String name_HW;
		private String summary;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int movie_id;
		private int movie_img;
		private String producer;
		private int Price;
		private List<Time_Hall> list_time_hall;

		public String getName_EN() {
			return name_EN;
		}
		public void setName_EN(String name_EN) {
			this.name_EN = name_EN;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public List<String> getList_name_actors() {
			return list_name_actors;
		}
		public void setList_name_actors(List<String> list_name_actors) {
			this.list_name_actors = list_name_actors;
		}
		public String getName_HW() {
			return name_HW;
		}
		public void setName_HW(String name_HW) {
			this.name_HW = name_HW;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public int getMovie_id() {
			return movie_id;
		}

		public int getMovie_img() {
			return movie_img;
		}
		public void setMovie_img(int movie_img) {
			this.movie_img = movie_img;
		}
		public String getProducer() {
			return producer;
		}
		public void setProducer(String producer) {
			this.producer = producer;
		}
		public int getPrice() {
			return Price;
		}
		public void setPrice(int price) {
			this.Price = price;
		}
		public List<Time_Hall> getList_time_hall() {
			return list_time_hall;
		}
		public void setList_time_hall(List<Time_Hall> list_time_hall) {
			this.list_time_hall = list_time_hall;
		}
				
		
		
		
		public static void DeleteMovie(String movieName) 
		{
			for(Movie current_movie : list)
			{
				if(current_movie.getName_EN().equals(movieName))
				{
					current_movie.;
				}
			}
			 
		}
		public static int ShowSeatsMap(Movie movie,int time) 
		{
			
		}
		public static void UpdateTime(Movie movie, int oldTime, int NewTime) 
		{
			
		}
		public boolean update_price(int price, boolean parameter) {
			if(parameter) {
				this.Price=price;
				}
		    return true;
		}
		public static void ChooseSeats(int time, int Seats[][], int numOfSeats) {
			
		}
		public static void PickSeats(int time,int NumOfSeats) {};
		public static void view_movies() {};
		public static int showSeatsMap(Movie Movie,int Movie_time) {};

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}
