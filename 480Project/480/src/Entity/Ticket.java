package Entity;

public class Ticket {

	//reference to associated user and movie/showtime/seat
	private String movie; //stores the name of the movie
	private String time; //stores time for the showing
	private String date; //stores the date of the showing
	private Seat seat;   //stores the seat being reserved
	private String email;//how we connect it with a user (easier for database)
	private double price = 10; //price of ticket
	
	//default constructor
	public Ticket() {

	}
	//constructor
	public Ticket(String email, String movie, String time, String date, Seat seat){
		this.email = email;
		this.movie = movie;
		this.time = time;
		this.date = date;
		this.seat = seat;
	}
	//constructor
	public Ticket(String email) {
		//this.user = user;
		this.email = email;
		this.movie = null;
		this.time = null;
		this.date = null;
		this.seat = null;
	}
	
	//setters and getters
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Seat getSeat() {
		return this.seat;
	}
	public String getMovie() {
		return this.movie;
	}
	public String getTime() {
		return this.time;
	}
	public String getEmail(){
		return this.email;
	}
	public String getDate() {
		return this.date;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
}
