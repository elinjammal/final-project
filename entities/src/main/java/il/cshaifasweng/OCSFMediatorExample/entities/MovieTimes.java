//sofi bntymm

package il.cshaifasweng.OCSFMediatorExample.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "My_MovieTimes")
public class MovieTimes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "My_MovieTimes_id")

	private int id;
	@ElementCollection
	private List<String> time;

	public MovieTimes() {

	}

	public MovieTimes(List<String> times) {
		this.time = times;
	}

	public int getId() {
		return id;
	}

	public List<String> getTimes() {
		return time;
	}

	public void SetMovieTimes(List<String> time) {
		this.time = time;
	}

	public void PrintMovieT(List<String> mytimes) {
		System.out.format("MovieTimes: ");
		for (String String : mytimes) {
			System.out.format(" %s, ", String);
		}
	}

	public String getMovieT(List<String> mytimes) {
		String str = "";
		for (String Strings : mytimes) {
			str = str + Strings;
			str = str + ", ";
		}
		return str;
	}
}
