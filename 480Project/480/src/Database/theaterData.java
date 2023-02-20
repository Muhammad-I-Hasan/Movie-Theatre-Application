package Database;
import java.util.*;

import Controller.SingletonUserInfo;
import Entity.Movie;
import Entity.Seat;
import Entity.Showtime;
import Entity.Theatre;
import Entity.Ticket;
import Entity.User;

import java.sql.*;


public class theaterData {
  private static ArrayList<Seat> seats;// all the seats in the database
  private static ArrayList<Showtime> showtimes; // all the showtimes in the database
  private static ArrayList<Movie> movies; //all the movies in the database
  private static Theatre theater;// the theater in the database
  private static ArrayList<User> users; //users in the database
  private static ArrayList<Ticket> tickets; //the tickets in the database

  public theaterData(){ //initialize arraylists
      seats = new ArrayList<>();
      showtimes = new ArrayList<>();
      movies = new ArrayList<>();
      users = new ArrayList<>();
      tickets = new ArrayList<>();
  }

  public static void addSeats(){ //get all the seats from the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      String query = "SELECT * FROM seat";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        int seatnum = rs.getInt("seatnum");
        Boolean available = rs.getBoolean("available");
        int showtimeid = rs.getInt("showtimeid");          
        // save the results
        seats.add(new Seat(seatnum,available, showtimeid));
      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e);
    }
  }

  public static void addMovies(){ // get all movies from the database and add the showtimes associated with that movie
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM movie";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        
        String movie = rs.getString("movie");
        String theaterName = rs.getString("theatername");   
        Boolean released  = rs.getBoolean("released");        
        // save the results

        ArrayList<Showtime> movieShowtimes = new ArrayList<>();
        for(int i = 0; i< showtimes.size(); i++){ //get showtimes associated with the movie
          if(showtimes.get(i).getMovie().equals(movie) ){
            movieShowtimes.add(showtimes.get(i));

          }
        }
        
        movies.add(new Movie(movie, movieShowtimes, theaterName, released));

      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e);
    }
  }

  public static void addShowtimes(){ // get all showtimes and add all the seats associated with the showtime
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM showtime";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        int id = rs.getInt("id");
        String showtime = rs.getString("showtime");
        String movieName = rs.getString("moviename");   
        String date = rs.getString("date");        
        // save the results

        ArrayList<Seat> showtimeSeats = new ArrayList<>();
        for(int i = 0; i< seats.size(); i++){
          if(seats.get(i).getShowtimeid() == id){
  
            showtimeSeats.add(seats.get(i));
          }
        }
        
        showtimes.add(new Showtime(showtime, showtimeSeats, id, movieName, date));//create the showtime

      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e);
    }
  }
  

  public static void addTheater(){ // add the theater from the database, with all previously imported data in it
    try{
    // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      String query = "SELECT * FROM theater";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        String name = rs.getString("name");
        
        ArrayList<Movie> theaterMovies = new ArrayList<>();
        for (int i = 0; i< movies.size(); i++){
          if(movies.get(i).getTheater().equals(name)){
            theaterMovies.add(movies.get(i));
          }
        }
        
        // print the results
        theater = new Theatre(name, theaterMovies);
      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e);
    }
  }

  public static void addTickets(){ //import all tickets from the database and associate it with it's user
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM ticket";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        int id = rs.getInt("id");
        String time = rs.getString("time");
        String movieName = rs.getString("movieName");   
        String date = rs.getString("date"); 
        int seatNum = rs.getInt("seatnum");  
        String email = rs.getString("useremail");     
        // print the results
        Showtime showtime = null;
      
        for(int i = 0; i<showtimes.size();i++){
          if (showtimes.get(i).getDate().equals(date) && showtimes.get(i).getTime().equals(time) && showtimes.get(i).getMovie().equals(movieName)){
            showtime = showtimes.get(i);
          }
        }
        //System.out.println(showtime.getSeats().get(0));

        Movie movie = null;
        for(int i = 0; i<movies.size();i++){
          if(movies.get(i).getName().equals(movieName)){
            movie = movies.get(i);
          }
        }
        

        Seat seat = null;
        for (int i = 0; i<showtime.getSeats().size(); i++){
          if(showtime.getSeats().get(i).getSeatNum()==seatNum){
            seat = showtime.getSeats().get(i);
          }
        }
        
        tickets.add(new Ticket(email,movie.getName(),showtime.getTime(), showtime.getDate(),seat));
        System.out.println(email);
      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e);
    }
  }

  public static void addUsers(){ // get users from the database and add the tickets associated with that user
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM user";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        
        String email = rs.getString("email");
        String cardNum = rs.getString("cardnum");
        String name = rs.getString("name");   
        String password = rs.getString("password");    
        String address = rs.getString("address");  
        Boolean registered = rs.getBoolean("registered"); 
        String lastpayment = rs.getString("lastpayment");     
        // print the results

        if(registered){//add user
          users.add(new User(name, email, address, cardNum, password, lastpayment));//registered
        }else{
          users.add(new User(email, cardNum, null));//unregistered
        }


        for(int i = 0; i< tickets.size(); i++){//add the user's tickets
          if(tickets.get(i).getEmail().equals(email)){
            System.out.println("adding ticket to "+email);
            users.get(users.size()-1).addTicket(tickets.get(i));
          }
        }
        
        

      }
      SingletonUserInfo instance = SingletonUserInfo.getOnlyInstance();//use singleton pattern to have no duplicate users
      for(User i: users) {
      	instance.addUser(i);
      }
      st.close();
    }
    catch (Exception e){
      System.err.println("Got an exception! addusers");
      System.err.println(e);
    }
  }

  public static ArrayList<User> getUsers(){ //return the users from the database with the tickets associated with the user
    return users;
  }

  public static Theatre getTheater(){ //return the theater with all the database info in it
    return theater;
  }

  public static void updateSeatAvailability(Seat seat){// when a seat's availability changes, update the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "UPDATE seat SET available = ? WHERE seatnum = ? AND showtimeid = ?";
      //String query = "update seat set available = "+String.valueOf(available)+" where seatnum = "+Integer.toString(seat.getSeatNum())+", showtimeid = "+
      //seat.getShowtimeid()+":";
      PreparedStatement s = conn.prepareStatement(query);
      s.setBoolean(1,(seat.getAvailable()));
      s.setString(2, Integer.toString(seat.getSeatNum()));
      s.setString(3, Integer.toString(seat.getShowtimeid()));
      s.executeUpdate();

    }catch(Exception e){
      System.out.println(e);
    }
  }

  public static void updateLastPay(User user){//update the database with when the user last paid their user fee
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "UPDATE user SET lastpayment = ? WHERE email = ? AND registered = ?";

      
      PreparedStatement s = conn.prepareStatement(query);
      s.setString(1, user.getLastPaymentString());
      s.setString(2, user.getEmail());
      s.setBoolean(3, user.isRegistered());
      s.executeUpdate();

    }catch(Exception e){
      System.out.println(e);
    }
  }

  public static void updateMovieReleased(Movie movie, boolean released){ //when a movie goes from unreleased to  the public to released, update the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "UPDATE movie SET released = ? WHERE movie = ?";

      PreparedStatement s = conn.prepareStatement(query);
      s.setBoolean(1,(released));
      s.setString(2, (movie.getName()));
      s.executeUpdate();

    }catch(Exception e){
      System.out.println(e);
    }
  }

  public static void addUser(User user){ //add a new registered user to the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "INSERT INTO user(email,cardnum,registered,name,address,password,lastpayment) values(?,?,?,?,?,?,?) ";

      PreparedStatement s = conn.prepareStatement(query);
      System.out.println("Adding to database"+user.getEmail());
      System.out.println(user.getEmail());
      s.setString(1,user.getEmail());
      s.setString(2, user.getCardNum());
      s.setBoolean(3, user.isRegistered());
      s.setString(4, user.getName());
      s.setString(5, user.getAddress());
      s.setString(6, user.getPassword());
      s.setString(7, user.getLastPaymentString());
      s.executeUpdate();
      System.out.println("adding user");

    }catch(Exception e){
      System.out.println(e);
    }
  }
  public static void addUnregisterdUser(User user){ //add a new unregistered user to the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "INSERT INTO user(email,cardnum) values(?,?) ";

      PreparedStatement s = conn.prepareStatement(query);
      System.out.println("Adding to database"+user.getEmail());
      
      s.setString(1,user.getEmail());
      s.setString(2, user.getCardNum());
      
      s.executeUpdate();
      System.out.println("adding user");

    }catch(Exception e){
      System.out.println(e+ "here");
    }
  }

  public static void addTicket(Ticket ticket, User user){ //add a newly created ticket to the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "INSERT INTO ticket(useremail,movieName,date,time,seatNum) values(?,?,?,?,?) ";

      PreparedStatement s = conn.prepareStatement(query);
      s.setString(1, user.getEmail());
      s.setString(2, ticket.getMovie());
      s.setString(3, ticket.getDate());
      s.setString(4, ticket.getTime());
      s.setString(5, Integer.toString(ticket.getSeat().getSeatNum()));
      s.executeUpdate();

    }catch(Exception e){
      System.out.println(e);
    }
  }

  public static void deleteTicket(Ticket ticket, User user){ //when a user cancels a ticket, remove it from the database
    try{
      // create our mysql database connection
      
      String myUrl = "jdbc:mysql://localhost:3306/theater";

      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection conn = DriverManager.getConnection(myUrl, "sqluser", "password");
      
      //clear all old data in database to save altered data
      String query = "DELETE FROM ticket WHERE useremail = ? and movieName = ?and date = ?and time = ?and seatnum = ?";

      PreparedStatement s = conn.prepareStatement(query);
      s.setString(1,(user.getEmail()));
      s.setString(2, (ticket.getMovie()));
      s.setString(3, ticket.getDate());
      s.setString(4, ticket.getTime());
      s.setString(5, Integer.toString(ticket.getSeat().getSeatNum()));
      s.executeUpdate();

    }catch(Exception e){
      System.out.println(e);
    }
  }

}
