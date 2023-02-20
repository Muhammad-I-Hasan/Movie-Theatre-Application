package Entity;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {
	
	private boolean registered; //for storing the registration status of the user
	private String name; 	//for storing the name of the user
	private String email; 	//for storing the email of the user - this is the main way we diffreentiate between users
	private String address; //for storing address of registered users
	private String cardNum;	//for storing the payment info
	private String password;//for storing the password of user
	private LocalDate lastPayment; //for storing the last date at which the user paid the annual fee
	private ArrayList<Ticket> tickets = new ArrayList<>(); //storing alll the tickets owned by a user
	
	//unregistered User constructor
	public User(String email, String cardNum) {//unregistered user who bought a ticket for the first time, other times use function addTicket()
		this.registered = false;
		this.name = null;
		this.address = null;
		this.email = email;
		this.cardNum = cardNum;
		this.lastPayment = null;

	}
	public User(String email, String cardNum, Ticket ticket) {//unregistered user who bought a ticket for the first time, other times use function addTicket()
		this.registered = false;
		this.name = null;
		this.address = null;
		this.email = email;
		this.cardNum = cardNum;
		this.lastPayment = null;
		tickets.add(ticket);
	}
	
	//registered user (info read from database and then sent to constructor
	public User(String name, String email, String address, String cardNum, String password, String lastPayment) {//create a new user at login screen, don't have ticket yet, when they purchase one use function addTicket()
		this.registered = true;
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNum = cardNum;
		this.password = password;
		if(lastPayment.length()!=0){
			this.lastPayment = LocalDate.parse(lastPayment);
		}
		
	}
	
	//getters and setters
	public boolean isRegistered() {
		return this.registered;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
			this.name = name;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNum() {
		return this.cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public void addTicket(Ticket ticket){
		this.tickets.add(ticket);
	}
	public ArrayList<Ticket> getTickets(){
		return this.tickets;
	}
	public String getPassword() {
		return this.password;
	}
	public LocalDate getLastPayment() {
		return this.lastPayment;
	}
	public String getLastPaymentString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String lastPayString = this.lastPayment.format(formatter);
		return lastPayString;
	}
	public void setLastPayment(String lastPay) {
		this.lastPayment = LocalDate.parse(lastPay);;
		return;
	}
	public ArrayList<Ticket> getTicketList(){
		return this.tickets;
	}
}
