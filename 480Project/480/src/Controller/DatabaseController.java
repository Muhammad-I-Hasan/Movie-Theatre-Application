package Controller;

import Database.theaterData;
//database controller 
public class DatabaseController {
    public DatabaseController(){
        theaterData data = new theaterData();
		theaterData.addSeats();
		theaterData.addShowtimes();
		theaterData.addMovies();
		theaterData.addTheater();
		theaterData.addTickets();
		theaterData.addUsers();
    }
}
