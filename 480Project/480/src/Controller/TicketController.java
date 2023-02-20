package Controller;
import Entity.Seat;
import Entity.Ticket;

public class TicketController {
	//ticket controller
	private static Ticket ticket = null;

	public static void setTicket( Ticket ticket2) {
		ticket = ticket2;
	}
	public static Ticket getTicket() {
		return ticket;
	}
	public static void createTicket() {
		ticket = new Ticket();
	}
	public static void UpdateTicket(String email, String movie, String time, String date, Seat seat, double price) {
		if(ticket == null) {
			ticket = new Ticket();
		}if(email != null)
			ticket.setEmail(email);
		if(movie != null)
			ticket.setMovie(movie);
		if(time != null)
			ticket.setTime(time);
		if(date != null)
			ticket.setDate(date);
		if(seat != null)
			ticket.setSeat(seat);
		if(price != -1)
			ticket.setPrice(price);
		//updates the ticket by the new values if they are not nyll
		System.out.println("updated ticket");
		ticket.setSeat(SeatController.getSeat());
	}
	
}
