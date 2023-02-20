package Entity;
import java.util.ArrayList;
import java.sql.*;

public class Theatre {
	private String name;	//used to set the name of the theater
	private ArrayList<Movie> movies;	//used to set the movies playing at the theater
	
	//constructor
	public Theatre(String name,ArrayList<Movie> movies) {
		this.name = name;
		this.movies = movies;
	}

	//setters and getters
	public String getName(){
		return name;
	}
	public ArrayList<Movie> getMovies(){
		return movies;
	}

}
