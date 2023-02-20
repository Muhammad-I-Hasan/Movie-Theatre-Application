package Entity;

import java.util.ArrayList;

public class Showtime {

	private ArrayList<Seat> seats; //for every showing, there are multiple seats to pick from
	private String time; //used for the time and date of the showing
	private String date;
	private int id; //used to store the showing id
	private String movie; //used to store the movie for the showing

	//constructor
	public Showtime(String time, ArrayList<Seat> seats, int id, String movie, String date) {
		this.id = id;
		this.time = time;
		this.seats = seats;
		this.movie = movie;
		this.date = date;
	}
	
	//used to update a seat when a ticket has been purchased or cancelled
	public void updateSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
	//setters and getters
	public String getTime() {
		return this.time;
	}
	public String getDate(){
		return this.date;
	}
	public String getMovie(){
		return this.movie;
	}
	public ArrayList<Seat> getSeats(){
		return this.seats;
	}
	public int getID(){
		return this.id;
	}
}
