package Controller;
import java.util.ArrayList;

import Entity.User;

public class SingletonUserInfo {

	//singleton object
    private static SingletonUserInfo onlyInstance;
    private ArrayList<User >userList;



    private SingletonUserInfo(){
        userList = new ArrayList<User>();

    }
    //public method to create or get the singleton reference
    public static SingletonUserInfo getOnlyInstance() {
        if(onlyInstance == null) {onlyInstance = new SingletonUserInfo();}
        return onlyInstance;
    }
    //sets the singleton
    public static void setOnlyInstance(SingletonUserInfo onlyInstance) {
        SingletonUserInfo.onlyInstance = onlyInstance;
    }
    //adds the user
    public void addUser(User user) {
        userList.add(user);
    }


    //gets the user
    public User getUser(int index) {
        User temp = userList.get(index);
        return temp;
    }
    //checks to see if the username is correct
    public boolean checkUserByNameAndPassword(String username, String password) {

        for(int i =0; i < userList.size(); i ++) {
            if(userList.get(i).getName().equals(username) && userList.get(i).getPassword().equals(password)) {
                return true;
            }
        }

//        usernameList.

        return false;
    }
    //get the users
    public  ArrayList<User> getUsers(){
    	return userList;
    }

    //remove the user
    public boolean removeUserByNameAndPassword(String username, String password) {



        for(int i =0; i < userList.size(); i ++) {
            if(userList.get(i).getName().equals(username) && userList.get(i).getPassword().equals(password)) {
                userList.remove(i);
                return true;
            }
        }

//        usernameList.

        return false;
    }



}