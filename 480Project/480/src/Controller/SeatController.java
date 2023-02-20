package Controller;
import java.util.ArrayList;

import Entity.Seat;

public class SeatController {
	private static ArrayList<Seat> seats = null;
	private static Seat seat = null;
	//sets the seat
	public static void setSeat(int index) {
    	if(index != -1){
    		seat = seats.get(index);
		}
    	else {
    		seat = null;
		}
    }
    //gets the seat
    public static Seat getSeat() {
    	return seat;
    }
    //get string of all the seats from the seatnumbers
    public static ArrayList<String> getString(){
    	if(seats == null) {
    		return null;
    	}
    	ArrayList<String> temp = new ArrayList<>();
    	for(int i =0; i < seats.size(); i++) {
    		temp.add(Integer.toString(seats.get(i).getSeatNum()));
    	}
    	return temp;
    }

	public static void setSeats(ArrayList<Seat> seats2) {
		seats = seats2;
	}

	public static ArrayList<Seat> getSeats() {
		return seats;
	}
	//updates the seats
    public static void updateSeat(Seat seat2, boolean available){
        if(seat == null) {
    		return;
    	}
		if (seat == seat2){
			seat.setAvailable(available); 
		}
		System.out.println("seatNum: "+ seat.getSeatNum() + " showtimeID: "+ seat.getShowtimeid());
	

    }
}
