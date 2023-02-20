package Entity;
import java.util.ArrayList;

public class Movie {

	private ArrayList<Showtime> showtimes;
	private String name;
	//this boolean is for wheether the movie is available to public will be useful for desplaying early movies for registered users
	//we could also have a date object for release date instead
	private boolean access;
	private String theater;
	
	//Movie constructor
	public Movie(String name, ArrayList<Showtime> showtimes,String theater,boolean access) {
		this.name = name;
		this.showtimes = showtimes;
		this.theater = theater;
		this.access = access;
	}
	
	//getters and setters
	public String getName() {
		return this.name;
	}
	public void setAccess(boolean bool) {
		this.access = bool;
	}
	public boolean getAccess() {
		return this.access;
	}
	public String getTheater() {
		return this.theater;
	}
	//for getting the showtimes for each movie
	public ArrayList<Showtime> getShowtimes(){
		return showtimes;
	}
}
