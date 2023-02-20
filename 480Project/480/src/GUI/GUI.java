

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.DatabaseController;
import Controller.LoginController;
import Controller.MovieController;
import Controller.PaymentController;
import Controller.SeatController;
import Controller.ShowtimeController;
import Controller.TicketController;
import Controller.UserController;
import Database.theaterData;
import Entity.Movie;
import Entity.Seat;
import Entity.Showtime;
import Entity.Ticket;
import Entity.User;

import javax.swing.border.MatteBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField email_txt;
	private JTextField pass_txt;
	private JLabel pass_label;
	private JTextField reg_name_txt;
	private JTextField reg_email_txt;
	private JTextField reg_pass_txt;
	private JTextField reg_card_txt;
	private JTextField reg_add_txt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DatabaseController controller = new DatabaseController();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//showtime list creation and showtime_list updates
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> showtime_list = new JList<String>(listModel);
	private JTextField purchase_email;
	private JTextField purchase_card;
	public void add()	
	{	
		showtime_list.clearSelection();
		listModel.clear();
		for(Showtime i : ShowtimeController.getShowtimes()) {
			listModel.addElement(i.getDate() +  " " + i.getTime());
	
    		System.out.println(i.getDate() +  " " + i.getTime());
		}
	System.out.println("replaced");
	  
	//ticket list creation and ticket list updates
	}
	DefaultListModel<String> listModel2 = new DefaultListModel<String>();
	//JList ticket_list = new JList(listModel);
	JList<String> ticket_list = new JList<String>(listModel2);
	public void viewTickets()	
	{	
		System.out.println(UserController.getUser().getTickets().size());
		ticket_list.clearSelection();
		listModel2.clear();
		for(Ticket i : UserController.getUser().getTickets()) {
			System.out.println(i.getMovie() +  " " + i.getTime()+  " " + i.getDate()+  " " + i.getSeat().getSeatNum());
			listModel2.addElement(i.getMovie() +  " " + i.getTime()+  " " + i.getDate()+  " " + i.getSeat().getSeatNum());
	
    		//System.out.println(i.getDate() +  " " + i.getTime());
		}
	System.out.println("replaced2");
	    
	}
	JButton[] grid = new JButton[20];
	
	//seat grid creation and seat grid updates
	public void updateSeats() {
		for (JButton i : grid) {
			//set wjether a set is available or not
			if(SeatController.getSeats().get(Integer.parseInt(i.getText())-1).getAvailable()) {
				i.setBackground(Color.green);
				i.setEnabled(true);
			} else {
				i.setBackground(Color.red);
				i.setEnabled(false);
			}
		}
		//check if the movie is an early release in which case there should only be 10% of the seats
		for(int i = 2; i < grid.length; i++) {
			if (MovieController.getMovie().getAccess() == false) {
				grid[i].setEnabled(false);
			}
		}
	}

	//update movie list for whether user should have access to early release movies
	DefaultListModel<String> listModel3 = new DefaultListModel<String>();
	//JList ticket_list = new JList(listModel);
	JList<String> movie_list = new JList<String>(listModel3);
	public void updateMovies() {
		movie_list.clearSelection();
		listModel3.clear();
		for(String i :MovieController.getString()) {
			listModel3.addElement(i);
		}
	System.out.println("replaced3");
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//initialize the content pain
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel purchase_panel = new JPanel();
		purchase_panel.setBackground(new Color(255, 255, 255));
		purchase_panel.setBounds(0, 0, 600, 385);
		contentPane.add(purchase_panel);
		purchase_panel.setLayout(null);
		purchase_panel.setVisible(false);
		purchase_panel.setEnabled(false);
		
		purchase_email = new JTextField();
		purchase_email.setBounds(113, 60, 286, 20);
		purchase_panel.add(purchase_email);
		purchase_email.setColumns(10);
		
		purchase_card = new JTextField();
		purchase_card.setBounds(113, 118, 286, 20);
		purchase_panel.add(purchase_card);
		purchase_card.setColumns(10);
		//add purhcase_panel page and related content on page
		
		
		
		JLabel purchase_ticket_info = new JLabel("Current Ticket Info");
		purchase_ticket_info.setVerticalAlignment(SwingConstants.TOP);
		purchase_ticket_info.setHorizontalAlignment(SwingConstants.LEFT);
		purchase_ticket_info.setBounds(418, 38, 158, 245);
		purchase_panel.add(purchase_ticket_info);
		
		JLabel reg_user_info = new JLabel("User Info");
		reg_user_info.setVerticalAlignment(SwingConstants.TOP);
		reg_user_info.setBounds(30, 38, 369, 238);
		purchase_panel.add(reg_user_info);
		
		JLabel unreg_user_email = new JLabel("Email");
		unreg_user_email.setBounds(36, 63, 46, 14);
		purchase_panel.add(unreg_user_email);
		
		JLabel unreg_user_card = new JLabel("Card Number");
		unreg_user_card.setBounds(30, 121, 73, 14);
		purchase_panel.add(unreg_user_card);
		JPanel movie_panel = new JPanel();
		movie_panel.setBackground(new Color(255, 255, 255));
		movie_panel.setBounds(0, 0, 600, 390);
		contentPane.add(movie_panel);
		movie_panel.setLayout(null);
		movie_panel.setVisible(false);
		movie_panel.setEnabled(true);
		//add movie_panel page to list showtimes and movies and available seats
		
			//use controller to load the list of movies
			MovieController.loadMovies();
			updateMovies();
			
			
			movie_list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			
			//add showtime_list for each movie but hide it till its required
			showtime_list.setVisible(false);
			showtime_list.setEnabled(false);
			//JList showtime_list = new JList(arr3);

			//this action listener gets the selected value in the movie list and sets the selected movie to the movie controlelr to be used once purchasing a ticket
			movie_list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					String temp = (String)movie_list.getSelectedValue();
					int index = movie_list.getSelectedIndex();
					String movieName = movie_list.getSelectedValue();
					//get index go to moviecontroller.getmovie.getshowtimes
					//MovieController.setMovie(index);
					System.out.println(movieName);
					//getSelectedIndex()
					try{MovieController.setMovieByName(movieName);}
					catch(Exception e2) {}
					// try{MovieController.setMovie(index);}
					// catch(Exception e2) {}
					System.out.println(temp);
					
					try {ShowtimeController.setShowtimes(MovieController.getMovie().getShowtimes()); }
					catch(Exception e2) {}
					
					add();
					
				}
				
			});
			
			movie_list.setBackground(new Color(192, 192, 192));
			movie_list.setBounds(20, 10, 395, 355);
			movie_panel.add(movie_list);
			
			
		
			showtime_list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			showtime_list.setBackground(new Color(192, 192, 192));
			showtime_list.setBounds(20, 10, 395, 355);
			movie_panel.add(showtime_list);
			
			JPanel seat_map = new JPanel();
			seat_map.setBackground(new Color(255, 255, 255));
			seat_map.setBounds(20, 10, 395, 355);
			movie_panel.add(seat_map);
			seat_map.setLayout(new GridLayout(5,4, 5, 5));
			
			

		   //JButton[] grid = new JButton[20];
		    
			
			JButton select_movie = new JButton("Select Movie");
			
			select_movie.setBounds(450, 27, 107, 37);
			movie_panel.add(select_movie);
			
			JButton view_tickets_button = new JButton("View Tickets");
			view_tickets_button.setBounds(450, 97, 107, 37);
			movie_panel.add(view_tickets_button);
			
			JButton cancel_selection_button = new JButton("Cancel");
			
			cancel_selection_button.setBounds(450, 167, 107, 37);
			movie_panel.add(cancel_selection_button);
			
			JLabel ticket_info = new JLabel("Current Ticket Info");
			ticket_info.setVerticalAlignment(SwingConstants.TOP);
			ticket_info.setBounds(450, 215, 107, 14);
			movie_panel.add(ticket_info);
			
			JButton select_Showtime = new JButton("Select Time");			
			select_Showtime.setVisible(false);
			select_Showtime.setEnabled(false);
			select_Showtime.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			JLabel selected_movie = new JLabel("Movie: ");
			selected_movie.setBounds(425, 240, 165, 19);
			movie_panel.add(selected_movie);
			
			JLabel selected_time = new JLabel("Time: ");
			selected_time.setBounds(425, 270, 165, 14);
			movie_panel.add(selected_time);
			
			JLabel selected_date = new JLabel("Date: ");
			selected_date.setBounds(425, 300, 165, 14);
			movie_panel.add(selected_date);
			
			JLabel selected_seat = new JLabel("Seat: ");
			selected_seat.setBounds(425, 330, 165, 14);
			movie_panel.add(selected_seat);
			select_Showtime.setBounds(450, 27, 107, 37);
			movie_panel.add(select_Showtime);
			
			JButton purchase_button = new JButton("Purchase");
			
			purchase_button.setBounds(450, 27, 107, 37);
			movie_panel.add(purchase_button);
			purchase_button.setVisible(false);
			purchase_button.setEnabled(false);
			
			
			
			//action listener for selected movie when the button is clicked the selected movie is updated
			select_movie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//get list.selectedValue and place into some string
					//then hide this button
					
					String movie = (String)movie_list.getSelectedValue();
					System.out.println("clicked");
					if(movie != null) {
						selected_movie.setText("Movie: " + movie);
						select_movie.setEnabled(false);
						select_movie.setVisible(false);
						select_Showtime.setEnabled(true);
						select_Showtime.setVisible(true);
						showtime_list.setVisible(true);
						showtime_list.setEnabled(true);
						movie_list.setVisible(false);
						movie_list.setEnabled(false);
						TicketController.UpdateTicket(null, movie, null, null, null, -1);
						//update the ticketcotnroller and go to next page
					}
				}
			});
			
			//gets the selceted showtiem in the list and adds it to the showtime controller for future use
			select_Showtime.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//todo
					//parse the string getselcted valu and put into the TicketConrller
					String[] split = ((String) showtime_list.getSelectedValue()).split(" ");
					int index = showtime_list.getSelectedIndex();
					String time = split[1];
					String date = split[0];
					System.out.println(time + " " + date);
					System.out.println(index);
					try {ShowtimeController.setShowtime(index); }
					catch(Exception e2) {
						
					}
					
					selected_time.setText("Time: " + time);
					selected_date.setText("Date: " + date);
					select_Showtime.setEnabled(false);
					select_Showtime.setVisible(false);
					purchase_button.setEnabled(true);
					purchase_button.setVisible(true);
					showtime_list.setVisible(false);
					showtime_list.setEnabled(false);
					SeatController.setSeats(ShowtimeController.getShowtime().getSeats());
					updateSeats();
					TicketController.UpdateTicket(null, null, time, date,null, -1);
					//updates current ticket and loads the seats
				}
			});
			
			//if a seat is chosen and this button is pressed, the screen changes to the purchase panel which will display whether the user 
			//is registered if not then it will require an email and card number to purchase the ticket
			purchase_button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(SeatController.getSeat() != null) {
						System.out.println(SeatController.getSeat().getSeatNum());
						purchase_button.setEnabled(false);
						purchase_button.setVisible(false);
						movie_panel.setVisible(false);
						movie_panel.setEnabled(false);
						purchase_panel.setVisible(true);
						purchase_panel.setEnabled(true);
						
						purchase_ticket_info.setText("<html>Current Ticket Info<br/><br/>Name: " 
						+ TicketController.getTicket().getMovie() + "<br/><br/>Date: "
						+ TicketController.getTicket().getDate() + "<br/><br/>Time: "
						+ TicketController.getTicket().getTime() + "<br/><br/>Seat Number: "
						+ TicketController.getTicket().getSeat().getSeatNum() + "<br/><br/>Price: $"
						+ TicketController.getTicket().getPrice() + "</html>");
						
						
						//need to check if registered
						if(UserController.getUser() != null) {
							unreg_user_email.setVisible(false);
							unreg_user_card.setVisible(false);
							purchase_email.setVisible(false);
							purchase_email.setEnabled(false);
							purchase_card.setVisible(false);
							purchase_card.setEnabled(false);
							reg_user_info.setVisible(true);
//							reg_user_info.setText("<html>Current User Info<br/>Name: " 
//							+ UserController.getUser().getName() + "<br/>Email: "
//							+ UserController.getUser().getEmail() + "<br/>Address: "
//							+ UserController.getUser().getAddress() + "<br/>Card Number: "
//							+ UserController.getUser().getCardNum() + "<br/></html>");
							if(UserController.getUser().isRegistered()) {
								reg_user_info.setText("<html>Current User Information:<br/>Name: "+ UserController.getUser().getName()+ "<br/>Email: "+ UserController.getUser().getEmail() 
								+ "<br/>Address: " + UserController.getUser().getAddress()+ "<br/>Card Number: " + UserController.getUser().getCardNum()  + "</html>");
							} else {
								reg_user_info.setText("<html>Current User Information:<br/>Email: " + UserController.getUser().getEmail() +
										"<br/>Card Number: " + UserController.getUser().getCardNum()  + "</html>");
							}
						} else {
							//reg_user_info.setText("<html>working<br/>" + "working" + "</html>");
							reg_user_info.setVisible(false);
							unreg_user_email.setVisible(true);
							unreg_user_card.setVisible(true);
							purchase_email.setVisible(true);
							purchase_email.setEnabled(true);
							purchase_card.setVisible(true);
							purchase_card.setEnabled(true);
						}
					}
				}
			});
		
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(new Color(255, 255, 255));
		login_panel.setBounds(0, 0, 600, 390);
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		email_txt = new JTextField();
		email_txt.setBounds(220, 110, 285, 20);
		login_panel.add(email_txt);
		email_txt.setColumns(10);
		
		pass_txt = new JTextField();
		pass_txt.setBounds(220, 180, 285, 20);
		login_panel.add(pass_txt);
		pass_txt.setColumns(10);
		
		JLabel email_label = new JLabel("Email");
		email_label.setHorizontalAlignment(SwingConstants.LEFT);
		email_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		email_label.setBounds(91, 87, 79, 50);
		login_panel.add(email_label);
		
		pass_label = new JLabel("Password");
		pass_label.setHorizontalAlignment(SwingConstants.LEFT);
		pass_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pass_label.setBounds(65, 153, 125, 59);
		login_panel.add(pass_label);
		
		JPanel button_panel = new JPanel();
		button_panel.setBounds(50, 275, 500, 38);
		login_panel.add(button_panel);
		button_panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton login_button = new JButton("Login");
		button_panel.add(login_button);
		login_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton register_button = new JButton("Register");
		button_panel.add(register_button);
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton skip_button = new JButton("Skip");
		
		button_panel.add(skip_button);
		skip_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		skip_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	
		
		JPanel register_panel = new JPanel();
		register_panel.setBackground(new Color(255, 255, 255));
		register_panel.setBounds(0, 0, 600, 390);
		contentPane.add(register_panel);
		register_panel.setLayout(null);
		
		JLabel reg_name = new JLabel("Name:");
		reg_name.setBounds(103, 43, 58, 14);
		register_panel.add(reg_name);
		
		JLabel reg_email = new JLabel("Email:");
		reg_email.setBounds(103, 93, 58, 14);
		register_panel.add(reg_email);
		
		JLabel reg_pass = new JLabel("Password:");
		reg_pass.setBounds(103, 143, 77, 14);
		register_panel.add(reg_pass);
		
		JLabel reg_card = new JLabel("Card Num:");
		reg_card.setBounds(103, 193, 77, 14);
		register_panel.add(reg_card);
		
		reg_name_txt = new JTextField();
		reg_name_txt.setBounds(220, 40, 285, 20);
		register_panel.add(reg_name_txt);
		reg_name_txt.setColumns(10);
		
		reg_email_txt = new JTextField();
		reg_email_txt.setBounds(220, 90, 285, 20);
		register_panel.add(reg_email_txt);
		reg_email_txt.setColumns(10);
		
		reg_pass_txt = new JTextField();
		reg_pass_txt.setBounds(220, 140, 285, 20);
		register_panel.add(reg_pass_txt);
		reg_pass_txt.setColumns(10);
		
		reg_card_txt = new JTextField();
		reg_card_txt.setBounds(220, 190, 285, 20);
		register_panel.add(reg_card_txt);
		reg_card_txt.setColumns(10);
		
		reg_add_txt = new JTextField();
		reg_add_txt.setBounds(221, 240, 285, 20);
		register_panel.add(reg_add_txt);
		reg_add_txt.setColumns(10);
		
		JLabel reg_add = new JLabel("Address: ");
		reg_add.setBounds(103, 243, 58, 14);
		register_panel.add(reg_add);
		
		JPanel regbutton_panel = new JPanel();
		regbutton_panel.setBounds(150, 300, 300, 38);
		register_panel.add(regbutton_panel);
		regbutton_panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		//checks if the correct inputs are given for each box in which case the user will be added to the database and then be treated as registered
		JButton regacc_button = new JButton("Register");
		regacc_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String email = reg_email_txt.getText();
				String address = reg_add_txt.getText();
				String name = reg_name_txt.getText();
				String pass = reg_pass_txt.getText();
				String card = reg_card_txt.getText();
				//send to registration controller to add to list of registered users
				System.out.println(email);
				System.out.println(address);
				System.out.println(name);
				System.out.println(pass);
				System.out.println(card);
				if(email.isEmpty() || address.isEmpty() || name.isEmpty() || pass.isEmpty() || card.isEmpty()) {
					System.out.println("Missing");
					JOptionPane.showMessageDialog(register_panel, "Missing Information");
				} else {
					LoginController.registerUser(name, email,card,address, pass);
					
					theaterData.updateLastPay(UserController.getUser());
					System.out.println(UserController.getUser().getLastPaymentString());
					String early = PaymentController.getRegistrationFee(UserController.getUser())+ "\nThe following movies are available for early booking: ";
					for(Movie i : MovieController.getMovies()) {
						if(i.getAccess() == false) {
							System.out.println(i.getAccess());
							early+=i.getName() + "\n";
						}
					}
					//early += "are available for early booking";
					JOptionPane.showMessageDialog(movie_panel, early);
					register_panel.setVisible(false);
					register_panel.setEnabled(false);
					login_panel.setVisible(false);
					login_panel.setEnabled(false);
					movie_panel.setVisible(true);
					movie_panel.setEnabled(true);
					updateMovies();
				}
				//go to movie_panel page

			}
		});
		regacc_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		regbutton_panel.add(regacc_button);
		
		JButton regcancel_button = new JButton("Cancel");
		regcancel_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		regbutton_panel.add(regcancel_button);
		
		
		register_panel.setVisible(false);
		register_panel.setEnabled(false);
		regcancel_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register_panel.setVisible(false);
				register_panel.setEnabled(false);
				login_panel.setVisible(true);
				login_panel.setEnabled(true);
			}
		});
		//takes you back to the login page

		
		//if user decideds to go not register/login they can continue as an unregistered user
		skip_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register_panel.setVisible(false);
				register_panel.setEnabled(false);
				login_panel.setVisible(false);
				login_panel.setEnabled(false);
				movie_panel.setVisible(true);
				movie_panel.setEnabled(true);
			}
		});
		
		//changes screen to allow user to register an account
		register_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_panel.setVisible(false);
				login_panel.setEnabled(false);
				register_panel.setVisible(true);
			}
		});
		
		//clears the ticket info and takes them to home page and displays list of movies
		cancel_selection_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//reset ticket info
				System.out.println("Cancel clicked");
				selected_movie.setText("Movie: ");
				selected_time.setText("Time: ");
				selected_date.setText("Date: ");
				selected_seat.setText("Seat: ");
				select_movie.setEnabled(true);
				select_movie.setVisible(true);
				select_Showtime.setEnabled(false);
				select_Showtime.setVisible(false);
				purchase_button.setVisible(false);
				purchase_button.setEnabled(false);
				movie_list.setVisible(true);
				movie_list.setEnabled(true);
				showtime_list.setVisible(true);
				showtime_list.setEnabled(true);
				MovieController.setMovie(-1);
				ShowtimeController.setShowtime(-1);
				SeatController.setSeat(-1);
			}
		});
		
		//This is for initialization. values get changed
		ArrayList<Seat> se = new ArrayList<Seat>();
		for(int i = 0; i < 20; i++) {
			se.add(new Seat(i+1));
		}
		SeatController.setSeats(se); 
	
		//action listener for seat grid where if selected changes color to  yellow and updates current seat in seat controller
		ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	                String text = ((JButton) e.getSource()).getText();
	                selected_seat.setText("Seat: " + text);
	                SeatController.setSeat(Integer.parseInt(text)-1);
	                TicketController.UpdateTicket(null, null, null, null,SeatController.getSeat(), -1);
	                for(JButton i: grid)
	                	if(SeatController.getSeats().get(Integer.parseInt(i.getText())-1).getAvailable()) {
	                		i.setBackground(Color.green);
	                	}
	                ((JButton)e.getSource()).setBackground(Color.yellow);
	            }
	        }
	    };
	    //creating grid of seats
	    for (int i = 0; i < grid.length ; i++) {
	    	grid[i] = new JButton(String.valueOf(i+1));
	    	grid[i].addActionListener(listener);
	        seat_map.add(grid[i]);
	        if(!SeatController.getSeats().get(i).getAvailable()) {
	        	grid[i].setBackground(Color.red);
	        	grid[i].setEnabled(false);
	        } else {
	        	grid[i].setBackground(Color.green);
	        }
	    }
	    
	    showtime_list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
		});
		//if user decides not to purchase, clears ticket and takes user back to home page
	    JButton cancel_purchase = new JButton("Cancel Purchase");
		cancel_purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purchase_panel.setVisible(false);
				purchase_panel.setEnabled(false);
				System.out.println("Cancel purchase clicked");
				selected_movie.setText("Movie: ");
				selected_time.setText("Time: ");
				selected_date.setText("Date: ");
				selected_seat.setText("Seat: ");
				select_movie.setEnabled(true);
				select_movie.setVisible(true);
				select_Showtime.setEnabled(false);
				select_Showtime.setVisible(false);
				purchase_button.setVisible(false);
				purchase_button.setEnabled(false);
				movie_list.setVisible(true);
				movie_list.setEnabled(true);
				movie_panel.setVisible(true);
				movie_panel.setEnabled(true);
				showtime_list.setVisible(false);
				showtime_list.setEnabled(false);
				MovieController.setMovie(-1);
				ShowtimeController.setShowtime(-1);
				SeatController.setSeat(-1);
			}
		});

		//takes login information and checks it throu controllers and database
		cancel_purchase.setBounds(229, 299, 140, 23);
		purchase_panel.add(cancel_purchase);
		login_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//email_label.setText("dsadsad");
				String email = email_txt.getText();
				System.out.println(email);
				String pass = pass_txt.getText();
				System.out.println(pass);
				//pass this information to a controller class to check if user is registered
				LoginController.Login(email, pass);
				if(UserController.getUser() == null) {
					System.out.println("bad info");
					JOptionPane.showMessageDialog(login_panel, "Incorrect Email/Password");
				} 
				else {
					String early = "";
					early = PaymentController.getRegistrationFee(UserController.getUser())+ "\nThe following movies are available for early booking: ";
					for(Movie i : MovieController.getMovies()) {
						if(i.getAccess() == false) {
							System.out.println(i.getAccess());
							early+=i.getName() + "\n";
						}
					}
					JOptionPane.showMessageDialog(movie_panel, early);
					register_panel.setVisible(false);
					register_panel.setEnabled(false);
					login_panel.setVisible(false);
					login_panel.setEnabled(false);
					movie_panel.setVisible(true);
					movie_panel.setEnabled(true);
					updateMovies();
				}
				
		//if registered then continue if not print out that invalid information
				
			}
		});
		JButton confirm_purchase = new JButton("Confirm Purchase");
		
		confirm_purchase.setBounds(65, 299, 140, 23);
		purchase_panel.add(confirm_purchase);
		
		JPanel ticket_panel = new JPanel();
		ticket_panel.setBackground(new Color(255, 255, 255));
		ticket_panel.setBounds(0, 0, 600, 385);
		contentPane.add(ticket_panel);
		ticket_panel.setLayout(null);
		ticket_panel.setVisible(false);
		ticket_panel.setEnabled(false);
		
		ticket_list.setBackground(new Color(192, 192, 192));
		ticket_list.setBounds(21, 11, 393, 352);
		ticket_panel.add(ticket_list);
		
		//deletes ticket from system and grants respective refund if applicable
		JButton cancel_ticket = new JButton("Cancel");
		cancel_ticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = ticket_list.getSelectedIndex();
				JOptionPane.showMessageDialog(ticket_panel, PaymentController.getRefund(index));
				
				PaymentController.CancelTicket(index);
				System.out.println(index);
				SeatController.updateSeat(TicketController.getTicket().getSeat(), true);
				//theaterData.updateSeatAvailability(TicketController.getTicket().getSeat());

				viewTickets();
				updateSeats();
				
			}
		});
		cancel_ticket.setBounds(452, 34, 89, 23);
		ticket_panel.add(cancel_ticket);
		
		JButton go_back = new JButton("Go Back");
		
		go_back.setBounds(452, 86, 89, 23);
		ticket_panel.add(go_back);
		
		//leaves the ticket page back to them enu screen with the currently available movies
		go_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("go back clicked");
				selected_movie.setText("Movie: ");
				selected_time.setText("Time: ");
				selected_date.setText("Date: ");
				selected_seat.setText("Seat: ");
				ticket_panel.setVisible(false);
				ticket_panel.setEnabled(false);
				select_movie.setEnabled(true);
				select_movie.setVisible(true);
				select_Showtime.setEnabled(false);
				select_Showtime.setVisible(false);
				purchase_button.setVisible(false);
				purchase_button.setEnabled(false);
				movie_list.setVisible(true);
				movie_list.setEnabled(true);
				movie_panel.setVisible(true);
				movie_panel.setEnabled(true);
				showtime_list.setVisible(false);
				showtime_list.setEnabled(false);
				MovieController.setMovie(-1);
				ShowtimeController.setShowtime(-1);
				SeatController.setSeat(-1);
			}
		});
	    //grid[1].setEnabled(false);
		
		//displays users current tickets
		view_tickets_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTickets();
				movie_panel.setVisible(false);
				movie_panel.setVisible(false);
				ticket_panel.setVisible(true);
				ticket_panel.setEnabled(true);
			}
		});
		//will take the ticket and add it it the users list of purchased tickets and add it to the database
		confirm_purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(purchase_panel, "Purchased!");
				//add reciept and what not
				String email = purchase_email.getText();
				String card = purchase_card.getText();
				System.out.println("Email:"+email);
				if(UserController.getUser() == null) {
					if(email.isEmpty() || card.isEmpty())
						System.out.println("missing purchase info");
					else{
						User testUser = new User(email, card);
						System.out.println("Test email "+testUser.getEmail());
						UserController.setUser(testUser);
						System.out.println("Creating user"+email);

						theaterData.addUnregisterdUser(testUser);
					}
				} 
				
				if (UserController.getUser()!= null){
					PaymentController.PurchaseTicket();
					JOptionPane.showMessageDialog(purchase_panel, PaymentController.getPayment());
					System.out.println(TicketController.getTicket().getSeat().getSeatNum());
					SeatController.updateSeat(TicketController.getTicket().getSeat(), false);
					System.out.println("Availability : "+TicketController.getTicket().getSeat().getAvailable());
					theaterData.updateSeatAvailability(TicketController.getTicket().getSeat());

					updateSeats();
					TicketController.createTicket();
					selected_movie.setText("Movie: ");
					selected_time.setText("Time: ");
					selected_date.setText("Date: ");
					selected_seat.setText("Seat: ");
					ticket_panel.setVisible(false);
					ticket_panel.setEnabled(false);
					purchase_panel.setVisible(false);
					purchase_panel.setEnabled(false);
					select_movie.setEnabled(true);
					select_movie.setVisible(true);
					select_Showtime.setEnabled(false);
					select_Showtime.setVisible(false);
					purchase_button.setVisible(false);
					purchase_button.setEnabled(false);
					movie_list.setVisible(true);
					movie_list.setEnabled(true);
					movie_panel.setVisible(true);
					movie_panel.setEnabled(true);
					showtime_list.setVisible(false);
					showtime_list.setEnabled(false);
					MovieController.setMovie(-1);
					ShowtimeController.setShowtime(-1);
					SeatController.setSeat(-1);
				}
				
				
			}
		});
	    //grid[1].setEnabled(false);
	}
}
