package Controller;
import java.time.*;
import java.time.format.DateTimeFormatter;

import Database.theaterData;
import Entity.Payment;
import Entity.User;
//import Entity.UserController;

public class LoginController {
    private static Payment payment = null;
    //login method that checks by comparing the users
    public static void Login(String email, String password) {
        //do some database queries and logic
        for(User i: SingletonUserInfo.getOnlyInstance().getUsers()) {
            System.out.println("Checking "+i.getEmail());
        	if(i.getEmail().equals(email)) {
        		if(i.getPassword().equals(password)) {
        			UserController.setUser(i);
                    return;
        		}
        	}
        }
        
        UserController.setUser(null);
        
    }
    //if user does not login skips the login
    public static void skipLogin() {
    	
    	UserController.setUser(null);
       	
    }
    //register the user and add user
    public static void registerUser(String name, String email, String card, String address, String pass) {
        LocalDate now  = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String lastpay = now.format(formatter);
        System.out.println(lastpay);

    	User user = new User(name, email, address, card, pass, lastpay);

    	UserController.setUser(user);
//        for(int i = 0; i<theaterData.getUsers().size();i++){
//            System.out.println(theaterData.getUsers().get(i).getName());
//        }
    	SingletonUserInfo.getOnlyInstance().getUsers().add(user);//local list update
    	//        for(int i = 0; i<theaterData.getUsers().size();i++){
//            System.out.println(theaterData.getUsers().get(i).getName());
//        }
    	theaterData.addUser(user);//database update
        
    }
   

}
