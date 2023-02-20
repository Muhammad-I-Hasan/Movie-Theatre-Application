package Controller;
import java.util.*;

import Database.theaterData;
import Entity.Movie;


//load movie specification of the bridge pattern
public class LoadMovies implements Load {
	@Override
	public ArrayList<Movie> load(){
		return theaterData.getTheater().getMovies();
	}
}
