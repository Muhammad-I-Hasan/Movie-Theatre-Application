package Entity;


public class Seat {
	private int seatNum; //used to differentiate seats per showing 
	private boolean available; //used to know when a seat has been reserved or cannot be booked
	private int showtimeid; //used to link the seats to a showing
	
	//constructor
	public Seat(int seatNum) {
		this.seatNum = seatNum;
		this.available = true;
	}

	//constructor
	public Seat(int seatNum, boolean available, int showtimeid) {
		this.seatNum = seatNum;
		this.available = available;
		this.showtimeid = showtimeid;
	}
	
	//setters and getters
	public int getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(int number){
		seatNum = number;
		return;
	}
	
	public boolean getAvailable(){
		return available;
	}

	//used when a ticket has been purchaced or cancelled
	public void setAvailable(Boolean bool) {
		this.available = bool;
		return;
	}

	public int getShowtimeid(){
		return showtimeid;
	}
	public void setShowtimeid(int id){
		showtimeid = id;
		return;
	}
	
	

}
