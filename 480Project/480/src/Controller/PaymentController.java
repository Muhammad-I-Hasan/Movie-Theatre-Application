package Controller;
import Database.theaterData;
import Entity.Payment;
import Entity.Seat;
import Entity.Ticket;
//import Entity.TicketController;
import Entity.User;
//import Entity.UserController;

public class PaymentController {
	private static Ticket ticket = null;
	private static User user = null;
	private static Payment payment = null;
	//purchase ticket by adding the ticket to the user and updating the db
	public static void PurchaseTicket() {
		
		user = UserController.getUser();

		ticket = TicketController.getTicket();
		
		user.addTicket(ticket);

		theaterData.addTicket(ticket, user);
	}
	//cancel the ticket by setting the seat to true and then removing it from db and removing it from user
	public static void CancelTicket(int index) {
		if(user == null)
			user = UserController.getUser();
		
		user.getTicketList().get(index).getSeat().setAvailable(true);
		theaterData.deleteTicket(user.getTicketList().get(index), user);
		theaterData.updateSeatAvailability(user.getTicketList().get(index).getSeat());
		user.getTicketList().remove(index);
		
//		user = UserController.getUser();
//	
//		ticket = TicketController.getTicket();
//	
//		boolean bool = UserController.hasTicket(ticket);
//		if(bool == true) {
//			UserController.removeTicket(ticket);
//			getMessage();
//		}
	}

	public static String getRefund(int index){
		String cancelMessage = Payment.getRefund(index);
		return cancelMessage;
	}
	
	public static String getPayment(){
		String message = Payment.getPayment();
		return message;
	}

	public static String getRegistrationFee(User user){
		if(user == null)
			user = UserController.getUser();

		String message = Payment.getRegistrationFee(user);
		return message;
	}

	//updates the tickets
	public static void UpdateTicket(String movie, String time, String date, Seat seat, double price) {
		if(user == null) {
			user = UserController.getUser();
		}
		if(ticket == null) {
			ticket = TicketController.getTicket();
		}
		TicketController.UpdateTicket(user.getEmail(), movie, time, date, seat, price);
	}

	
}
