package Controller;
import java.util.ArrayList;

import Entity.Movie;
import Entity.User;
//import Entity.UserController;


//movie controller
public class MovieController {
    private static ArrayList<Movie> movies = null;
    private static Movie movie = null;
    private static User user = null;
    private static Load load = new LoadMovies();
    
  //String method that gets the array list of all movie names
    public static ArrayList<String> getString(){
    	if(movies == null) {
    		return null;
    	}
    	ArrayList<String> temp = new ArrayList<>();
        // for every movie in list
        // if user is null or unregistered then check if movie is publicly available and add else dont add
        // else if user is registered then add all movies
    	for(int i =0; i < movies.size(); i++) {
            if(UserController.getUser() == null) {
                System.out.println("1");
                if(movies.get(i).getAccess() == true)
                    temp.add(movies.get(i).getName());
            } else if (UserController.getUser().isRegistered() == false) {
                System.out.println("2");
                if(movies.get(i).getAccess() == true)
                    temp.add(movies.get(i).getName());
            } else {
                System.out.println("3");
                temp.add(movies.get(i).getName());
            }
    	}
    	return temp;
    }
    //load movies by using the bridge pattern
    public static void loadMovies() {
    	movies = load.load();
    }
    //gets the movie a user can see by seeing if they are registered if they are they can see unlisted movie if not they can only see listed movies
    public static ArrayList<Movie> getMovies(){
        if(user == null) {user = UserController.getUser();}
        ArrayList<Movie> temp = new ArrayList<>();

        if(user.isRegistered()){ //checks if the user is registered
            for(Movie m : movies){
                temp.add(m);
            }
        }
        else{
            for(Movie m : movies){
                if(m.getAccess() == true){
                    temp.add(m);
                }
            }
        }
        return temp;
    }
    
    public static Movie getMovie() {
    	return movie;
    }

    public static void setMovieByName(String name) {
        for(Movie i : movies) {
            if(name.equals(i.getName())) {
                movie = i;
                return;
            }
        }
    }
    public static void setMovie(int i) {
    	if(i != -1)
    		movie = movies.get(i);
    	else
    		movie = null;
    }
    public static Movie selectMovie(int index){
//        ArrayList<Movie> temp = new ArrayList<>();
        if(movies == null) {
            return null;
        }
        if(index < 0 || index > movies.size()) {
            return null;
        }
        //interact with db or feeder class

        return  movies.get(index);
    }
    public static Movie getMovieFromName(String name) {
		
    	if(name == null || movies == null) {
    		return null;
    	}
    	for(Movie m: movies) {
    		if (m.getName().equals(name)){
    			return m;
    		}
    	}
    	return null;
    	
    }
    public static void setMovies(ArrayList<Movie> m) {
    	movies = m;
    }
    
}
