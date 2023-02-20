package Controller;
import java.util.ArrayList;

import Entity.Showtime;
//showtime controller
public class ShowtimeController {
	private static ArrayList<Showtime> showtimes = null;
    private static Showtime showtime = null;
    //sets the showtime
    public static void setShowtime(int index) {
    	if(index != -1)
    		showtime = showtimes.get(index);
    	else
    		showtime= null;
    }
    //gets the showtime
    public static Showtime getShowtime() {
    	return showtime;
    }
    // get the string value of the showtime object
    public static ArrayList<String> getString(){
    	if(showtimes == null) {
    		return null;
    	}
    	ArrayList<String> temp = new ArrayList<>();
    	for(int i =0; i < showtimes.size(); i++) {
    		temp.add(showtimes.get(i).getDate() + " " + showtimes.get(i).getTime());
    	}
    	return temp;
    }
    //sets the showtime
	public static void setShowtimes(ArrayList<Showtime> showtimes2) {
		showtimes = showtimes2;
		
	}

	public static ArrayList<Showtime> getShowtimes() {
		// TODO Auto-generated method stub
		return showtimes;
	}
}
