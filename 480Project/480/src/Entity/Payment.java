package Entity;

import java.time.*;
import java.time.format.DateTimeFormatter;

import Controller.TicketController;
import Controller.UserController;
import Database.theaterData;

import java.time.Duration;

public class Payment {
	private static User user;
	private static Ticket ticket;

	//getting payment information from the user
	public static String getPayment() {
		user = UserController.getUser();
		//getting the ticket information  and adding it to string temp
		ticket = TicketController.getTicket();
		String temp = "";
		temp += "Charged card " + user.getCardNum() + "\nReceipt sent to email " + user.getEmail() +
				"\nMovie: " + ticket.getMovie() + 
				"\nTime: " + ticket.getTime() + 
				"\nDate: " + ticket.getDate() + 
				"\nSeat: " + ticket.getSeat().getSeatNum() +
				"\nPrice: $10.0";
			
		return temp;
	}
	//method for determining how much of a refund the user gets, and the type of refund
	public static String getRefund(int index) {
		user = UserController.getUser();
		//getting ticket list so that we can remove the ticket the user wants a refund fo
		ticket = user.getTicketList().get(index);
		String temp = "";
		
		//determining the time so that we can check if it is less than 72 hours before the showing
		LocalDateTime now = LocalDateTime.now();
		String time = ticket.getTime();
		String date = ticket.getDate();
		String split[] = time.split(":");
		String split2[] = date.split("-");
		//y/m/d/h/m
		
		//ticket time is the time of the showing
		LocalDateTime ticket_time = LocalDateTime.of(Integer.parseInt(split2[2]),Integer.parseInt(split2[1]),Integer.parseInt(split2[0]),Integer.parseInt(split[0]),Integer.parseInt(split[1]));
		
		//if the user is registered and there is 72 hours before showing, they get a full refund
		if(now.plusHours(72).isBefore(ticket_time)) {
			if(user.isRegistered()) {
				
				temp += "Full refend of $10.00 credited to your account";
			}
			else {
				//otherwise they get a partial refund
				temp += "Partial refund of $8.50 credited to your account";
			}
		}
		else {
			//no refund within 72 hours
			temp+= "no refund within 72 hours of showtime";
		}
		
		return temp;
		
	}

	//method for charging the annual $20 fee for registered users
	public static String getRegistrationFee(User user){
		user = UserController.getUser();
		String temp = "";

		//determining time now
		LocalDate now = LocalDate.now();
		Duration duration = Duration.between(now.atStartOfDay(ZoneId.systemDefault()), user.getLastPayment().plusYears(1).atStartOfDay(ZoneId.systemDefault()));
		long days = duration.toDays();
		
		//formatting time now into string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String newPayDay = now.plusDays(1).format(formatter);

		if(days > 0) {
			//less than a year since last payment
			temp = "The last time you were charged our annual account fee was: " + user.getLastPaymentString()+ ". You will be charged again in " +
				Long.toString(days-1) + " days.";
			System.out.println(temp);
			theaterData.updateLastPay(user);

		}
		if(days < 0) {
			//over a year since last payment
			temp = "The last time you were charged our annual account fee was: " + user.getLastPaymentString() + 
			". You will now be charged a fee of $20 on the following card: "+ user.getCardNum() +".";
			user.setLastPayment(newPayDay);
			theaterData.updateLastPay(user);
			System.out.println(temp);

		}
		if(days == (long)365) {
			//user just registered
			temp = "Thank you for registering. You will now be charged an annual registration fee of $20 on the following card: "
			+ user.getCardNum() +". Your next billing will be on " + newPayDay+".";
			System.out.println(temp);
			user.setLastPayment(newPayDay);
			theaterData.updateLastPay(user);

		}
		return temp;
	}
}
