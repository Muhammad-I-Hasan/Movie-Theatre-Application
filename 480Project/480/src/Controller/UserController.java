package Controller;
import java.util.ArrayList;

import Entity.Ticket;
import Entity.User;
//user controller class
public class UserController {
    
    private static User user = null;
	private static ArrayList<Ticket> tickets = null;
	//setters and getters
	public static void setUser(User user2) {
		user = user2;
	}
	public static User getUser() {
		return user;
	}
	//gets a list of the registered users
	public static ArrayList<User> getRegisteredUsers() {
//		ArrayList<User> temp = new ArrayList<>();
		SingletonUserInfo instance = SingletonUserInfo.getOnlyInstance();
		ArrayList<User> temp = instance.getUsers();
		ArrayList<User> registeredUsers = new ArrayList<>();
		for(User u : temp){
			if(u.isRegistered()){
				registeredUsers.add(u);
			}
		}
		return registeredUsers;
	}
	//get the users list
	public static ArrayList<User> getUsersList() {
		SingletonUserInfo instance = SingletonUserInfo.getOnlyInstance();
		return instance.getUsers();
	}
	//set tickets
	public static void setTickets(ArrayList<Ticket> ticketList) {
		if(ticketList == null) {return;}
		tickets.clear();
		for (Ticket t : ticketList){
			tickets.add(t);
		}
		return;
	}
	//check if the ticket is avaialable by comparing to its ticket object
	public static boolean hasTicket(Ticket ticket){
		if (tickets == null || user == null){return false;}
		for(Ticket t : tickets){
			if(t.equals(ticket)){return true;}
		}
		return false;
	}
	//remove the ticket
	public static void removeTicket(Ticket ticket){
		if (tickets == null || user == null){return;}
		if(hasTicket(ticket) == true){
			tickets.remove(ticket);
		}
		return;
	}


	
}
