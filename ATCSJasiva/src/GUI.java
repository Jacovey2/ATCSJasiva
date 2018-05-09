import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class GUI implements ActionListener {
	// Global variables

	// list of default cars
	private Car[] carArray = { new Car(25, 4, "cheapCar", new Location("DEF"), 12.5),
			new Car(20, 4, "lowEndCar", new Location("DEF"), 15), new Car(15, 4, "mediumCar", new Location("DEF"), 20),
			new Car(15, 7, "highEndCar", new Location("DEF"), 28),
			new Car(10, 2, "premiumCar", new Location("DEF"), 35), new Car(0, 0, "ERROR", new Location("ERROR"), 0), };

	// Locations of cars
	String[] carTypes = new String[] { "", "cheapCar", "lowEndCar", "mediumCar", "highEndCar", "premiumCar" };
	JComboBox<String> pickupLocationsDropDown = new JComboBox<>(IH.getLocationsArray());
	JComboBox<String> dropLocationsDropDown = new JComboBox<>(IH.getLocationsArray());

	// (text fields in the way we are using them must be global variables)
	private JTextField signInUsernameField = new JTextField(10);
	private JTextField registerFirstNameField = new JTextField(10);
	private JTextField registerLastNameField = new JTextField(10);
	private JTextField registerUsernameField = new JTextField(10);
	private JPasswordField signInPasswordField = new JPasswordField(10);
	private JPasswordField registerPasswordField = new JPasswordField(10);

	// Whether the user is signed in
	boolean signedIn = false;
	// Booking Frame global variables
	JCheckBox checkField = new JCheckBox();

	// Manager Frame global Variables
	JTextField searchUserField = new JTextField("");
	JTextArea searchResultField = new JTextArea("");
	JTextArea managerLocationsList = new JTextArea();
	JTextArea managerUsersList = new JTextArea();
	JTextArea managerReservationsList = new JTextArea();
	JTextArea managerAvailableCarsList = new JTextArea();
	JScrollPane managerAllLocations = new JScrollPane(managerLocationsList);
	JScrollPane managerAllUser = new JScrollPane(managerUsersList);
	JScrollPane managerAllReservation = new JScrollPane(managerReservationsList);
	JScrollPane managerAllAvailableCars = new JScrollPane(managerAvailableCarsList);
	JTextField addRemoveCarLocations = new JTextField("");
	JComboBox<String> checkAvailableCarsDropDown = new JComboBox<>(carTypes);
	JComboBox<String> addRemoveCarDropDown = new JComboBox<>(carTypes);
	JComboBox<String> availableLocationsDropDown = new JComboBox<>(IH.getLocationsArray());

	// creating calendar selection tool
	SpinnerDateModel bookingPickupdate = new SpinnerDateModel();
	SpinnerDateModel bookingDropdate = new SpinnerDateModel();
	JSpinner bookingPickupDateSpinner = new JSpinner(bookingPickupdate);
	JSpinner bookingDropDateSpinner = new JSpinner(bookingDropdate);

	// CarViewer Images (must be global so they can be greyed out)
	JButton cheapButton;
	JButton lowEndButton;
	JButton mediumButton;
	JButton highEndButton;
	JButton premiumButton;

	// Frames
	JFrame carFrame;
	JFrame loginFrame;
	JFrame welcomeFrame;
	JFrame bookFrame;
	JFrame aboutFrame;
	JFrame managerFrame;
	JFrame[] frames;

	// master inventory handler
	public static InventoryHandler IH;

	public static void main(String[] args) {
		IH = new InventoryHandler();// stays constant
		try {
			IH.loadInformation();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + " FILE NOT FOUND");
		}
		new GUI(IH);
	}

	public GUI(InventoryHandler c) {

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// LOGIN FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		SpringLayout loginlayout = new SpringLayout();
		loginFrame = new JFrame("Login");
		loginFrame.setLayout(loginlayout); // makes the layout a spring layout

		// login frame setup
		JPanel signInPanel = new JPanel(new SpringLayout());// used to be P
		JPanel registerPanel = new JPanel(new SpringLayout());
		JLabel signInPasswordLabel = new JLabel("Password: ", JLabel.TRAILING);
		JLabel signInUsernameLabel = new JLabel("Username: ", JLabel.TRAILING);
		JLabel registerFirstNameLabel = new JLabel("First Name: ", JLabel.TRAILING);
		JLabel registerLastNameLabel = new JLabel("Last Name: ", JLabel.TRAILING);
		JLabel registerUsernameLabel = new JLabel("Username: ", JLabel.TRAILING);
		JLabel registerPasswordLabel = new JLabel("Password: ", JLabel.TRAILING);
		JLabel existingUserLabel = new JLabel("Existing Users");
		JLabel registerLabel = new JLabel("New User");
		JButton signInButton = new JButton("Sign in");
		JButton registerButton = new JButton("Register");
		JButton homeButton = new JButton("JASIVA");
		homeButton.setForeground(Color.RED);
		homeButton.setFont(new Font("Arial", Font.PLAIN, 70));

		// set labels
		signInPasswordLabel.setLabelFor(signInPasswordField);
		signInUsernameLabel.setLabelFor(signInUsernameField);
		registerFirstNameLabel.setLabelFor(registerFirstNameField);
		registerLastNameLabel.setLabelFor(registerLastNameField);
		registerUsernameLabel.setLabelFor(registerUsernameField);
		registerPasswordLabel.setLabelFor(registerPasswordField);

		// adding components to panels
		signInPanel.add(signInUsernameLabel);
		signInPanel.add(signInUsernameField);
		signInPanel.add(signInPasswordLabel);
		signInPanel.add(signInPasswordField);
		registerPanel.add(registerFirstNameLabel);
		registerPanel.add(registerFirstNameField);
		registerPanel.add(registerLastNameLabel);
		registerPanel.add(registerLastNameField);
		registerPanel.add(registerUsernameLabel);
		registerPanel.add(registerUsernameField);
		registerPanel.add(registerPasswordLabel);
		registerPanel.add(registerPasswordField);

		// lay out sign in and register panels
		SpringUtilities.makeCompactGrid(signInPanel, 2, 2, 3, 3, 3, 3);
		SpringUtilities.makeCompactGrid(registerPanel, 4, 2, 3, 3, 3, 3);

		// specific layouts of the login page
		loginlayout.putConstraint(SpringLayout.NORTH, registerPanel, 100, SpringLayout.SOUTH, loginFrame);
		loginlayout.putConstraint(SpringLayout.NORTH, signInPanel, 100, SpringLayout.SOUTH, loginFrame);
		loginlayout.putConstraint(SpringLayout.NORTH, signInButton, 5, SpringLayout.SOUTH, signInPanel);
		loginlayout.putConstraint(SpringLayout.NORTH, registerButton, 5, SpringLayout.SOUTH, registerPanel);
		loginlayout.putConstraint(SpringLayout.WEST, registerPanel, 40, SpringLayout.EAST, signInPanel);
		loginlayout.putConstraint(SpringLayout.WEST, signInPanel, 200, SpringLayout.EAST, loginFrame);
		loginlayout.putConstraint(SpringLayout.WEST, existingUserLabel, 40, SpringLayout.WEST, signInPanel);
		loginlayout.putConstraint(SpringLayout.WEST, registerLabel, 80, SpringLayout.WEST, registerPanel);
		loginlayout.putConstraint(SpringLayout.WEST, signInButton, 100, SpringLayout.WEST, signInPanel);
		loginlayout.putConstraint(SpringLayout.WEST, registerButton, 105, SpringLayout.WEST, registerPanel);
		loginlayout.putConstraint(SpringLayout.SOUTH, existingUserLabel, -5, SpringLayout.NORTH, signInPanel);
		loginlayout.putConstraint(SpringLayout.SOUTH, registerLabel, -5, SpringLayout.NORTH, registerPanel);
		loginlayout.putConstraint(SpringLayout.SOUTH, homeButton, -30, SpringLayout.NORTH, registerPanel);
		loginlayout.putConstraint(SpringLayout.EAST, homeButton, 150, SpringLayout.WEST, registerPanel);

		// adding components to frame and finalizing
		loginFrame.add(signInPanel);
		loginFrame.add(registerPanel);
		loginFrame.add(existingUserLabel);
		loginFrame.add(registerLabel);
		loginFrame.add(signInButton);
		loginFrame.add(registerButton);
		loginFrame.add(homeButton);
		loginFrame.setTitle("Login");
		loginFrame.setSize(900, 500);

		// button Setups
		signInButton.addActionListener(this);
		registerButton.addActionListener(this);
		homeButton.addActionListener(this);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// WELCOME FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		welcomeFrame = new JFrame("Welcome");
		welcomeFrame.setLayout(null);

		// welcome frame setup
		JLabel missionLabel = new JLabel("Our Mission:");
		JTextArea missionTextLabel = new JTextArea(
				"This is our mission statement: \n" + "We rent cars with purpose and heart, \n"
						+ "We think deeply about taking your money, \n" + "And we do all of this confidently!");
		JButton rentButton = new JButton("Book Now!");
		JButton viewCarsButton = new JButton("See our Cars");
		JButton AboutButton = new JButton("JASIVA");
		JButton toAbout = new JButton("About");
		JScrollPane missionTextScroll = new JScrollPane(missionTextLabel);
		JButton toManager = new JButton("Manager Interface");

		// arranging on page
		missionLabel.setBounds(300, 120, 100, 50);
		missionTextScroll.setBounds(300, 150, 300, 70);
		rentButton.setBounds(500, 275, 150, 60);
		viewCarsButton.setBounds(250, 275, 150, 60);
		AboutButton.setBounds(300, 20, 300, 75);
		toAbout.setBounds(380, 230, 130, 30);
		toManager.setBounds(0, 450, 200, 30);

		// font/appearance changes
		AboutButton.setForeground(Color.RED);
		AboutButton.setFont(new Font("Arial", Font.PLAIN, 70));
		welcomeFrame.setContentPane(new JLabel(new ImageIcon("backround.jpeg")));
		missionTextLabel.setEditable(false);

		// adding components to frame and finalizing
		welcomeFrame.add(rentButton);
		welcomeFrame.add(viewCarsButton);
		welcomeFrame.add(AboutButton);
		welcomeFrame.add(missionLabel);
		welcomeFrame.add(missionTextScroll);
		welcomeFrame.add(toAbout);
		welcomeFrame.add(toManager);
		welcomeFrame.setTitle("Welcome page");
		welcomeFrame.setSize(900, 500);
		welcomeFrame.setVisible(true);

		// activating buttons
		rentButton.addActionListener(this);
		viewCarsButton.addActionListener(this);
		AboutButton.addActionListener(this);
		toAbout.addActionListener(this);
		toManager.addActionListener(this);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// CAR VIEWER FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		carFrame = new JFrame("Cars");
		carFrame.setLayout(null);

		// car viewer setup
		JLabel cheapLabel = new JLabel("$100");
		JLabel lowEndLabel = new JLabel("$200");
		JLabel mediumLabel = new JLabel("$300");
		JLabel highEndLabel = new JLabel("$400");
		JLabel premiumLabel = new JLabel("$1000");
		cheapButton = new JButton(new ImageIcon(
				((new ImageIcon("cheapCar.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		lowEndButton = new JButton(new ImageIcon(
				((new ImageIcon("lowendCar.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		mediumButton = new JButton(new ImageIcon(
				((new ImageIcon("mediumCar.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		highEndButton = new JButton(new ImageIcon(
				((new ImageIcon("highendCar.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		premiumButton = new JButton(new ImageIcon(
				((new ImageIcon("premiumCar.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton backButton = new JButton("back");
		JButton carViewerAboutButton = new JButton("JASIVA");

		// appearance changes
		carViewerAboutButton.setForeground(Color.RED);
		carViewerAboutButton.setFont(new Font("Arial", Font.PLAIN, 70));

		// activating buttons
		cheapButton.addActionListener(this);
		lowEndButton.addActionListener(this);
		mediumButton.addActionListener(this);
		highEndButton.addActionListener(this);
		premiumButton.addActionListener(this);
		carViewerAboutButton.addActionListener(this);
		backButton.addActionListener(this);

		// Changing button Action commands
		cheapButton.setActionCommand("cheapCar");
		lowEndButton.setActionCommand("lowEndCar");
		mediumButton.setActionCommand("mediumCar");
		highEndButton.setActionCommand("highEndCar");
		premiumButton.setActionCommand("premiumCar");

		// arranging components
		carViewerAboutButton.setBounds(300, 20, 300, 75);
		cheapLabel.setBounds(200, 200, 100, 100);
		lowEndLabel.setBounds(400, 200, 100, 100);
		mediumLabel.setBounds(600, 200, 100, 100);
		highEndLabel.setBounds(200, 400, 100, 100);
		premiumLabel.setBounds(400, 400, 100, 100);
		cheapButton.setBounds(140, 110, 150, 130);
		lowEndButton.setBounds(340, 110, 150, 130);
		mediumButton.setBounds(540, 110, 150, 130);
		highEndButton.setBounds(140, 300, 150, 130);
		premiumButton.setBounds(340, 300, 150, 130);
		backButton.setBounds(100, 50, 200, 30);

		// adding components to frame and finalizing
		carFrame.add(cheapLabel);
		carFrame.add(cheapButton);
		carFrame.add(lowEndLabel);
		carFrame.add(lowEndButton);
		carFrame.add(mediumLabel);
		carFrame.add(mediumButton);
		carFrame.add(highEndLabel);
		carFrame.add(highEndButton);
		carFrame.add(premiumLabel);
		carFrame.add(premiumButton);
		carFrame.add(backButton);
		carFrame.add(carViewerAboutButton);
		carFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// BOOKING FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		bookFrame = new JFrame("Booking"); // about page panel
		bookFrame.setLayout(null);

		// booking frame setup
		JLabel pickupLabel = new JLabel("From/Pickup:");
		JLabel checkLabel = new JLabel("Pickup is the same as drop-off");
		JLabel dropLabel = new JLabel("To/Drop-Off:");
		JLabel startTLabelInstruction = new JLabel("MM/DD/YYYY/TTTT");
		JLabel startTLabel = new JLabel("Start time:");
		JLabel endTLabelInstruction = new JLabel("MM/DD/YYYY/TTTT");
		JLabel endTLabel = new JLabel("End time:");
		
		JButton pickCarButton = new JButton("Pick a Car!");
		JButton carViewerAboutButton2 = new JButton("JASIVA");
		JButton backButton2 = new JButton("back");

		// adding action listener
		pickCarButton.addActionListener(this);
		carViewerAboutButton2.addActionListener(this);
		backButton2.addActionListener(this);
		checkField.addActionListener(this);

		// appearance changes
		checkLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		startTLabelInstruction.setFont(new Font("Arial", Font.PLAIN, 10));
		endTLabelInstruction.setFont(new Font("Arial", Font.PLAIN, 10));
		carViewerAboutButton2.setForeground(Color.RED);
		carViewerAboutButton2.setFont(new Font("Arial", Font.PLAIN, 70));
		bookingPickupDateSpinner.setEditor(new JSpinner.DateEditor(bookingPickupDateSpinner, "MM/dd/yyyy/HHmm"));
		bookingDropDateSpinner.setEditor(new JSpinner.DateEditor(bookingDropDateSpinner, "MM/dd/yyyy/HHmm"));

		// arranging components
		pickupLabel.setBounds(310, 130, 110, 30);
		checkLabel.setBounds(370, 155, 170, 30);
		dropLabel.setBounds(310, 180, 110, 30);
		bookingPickupDateSpinner.setBounds(380, 220, 150, 30);
		startTLabel.setBounds(310, 220, 130, 30);
		startTLabelInstruction.setBounds(410, 202, 130, 30);
		bookingDropDateSpinner.setBounds(380, 260, 150, 30);
		endTLabel.setBounds(310, 260, 130, 30);
		endTLabelInstruction.setBounds(410, 242, 130, 30);
		pickupLocationsDropDown.setBounds(395, 130, 130, 30);
		dropLocationsDropDown.setBounds(395, 180, 130, 30);
		checkField.setBounds(495, 157, 25, 25);
		pickCarButton.setBounds(370, 300, 150, 70);
		carViewerAboutButton2.setBounds(300, 20, 300, 75);
		backButton2.setBounds(100, 50, 200, 30);

		// setting action commands
		backButton2.setActionCommand("back to signIN");
		checkField.setActionCommand("checked");

		// adding components to frame and finalizing
		bookFrame.add(backButton2);
		bookFrame.add(carViewerAboutButton2);
		bookFrame.add(pickupLabel);
		bookFrame.add(pickupLocationsDropDown);
		bookFrame.add(checkLabel);
		bookFrame.add(checkField);
		bookFrame.add(dropLabel);
		bookFrame.add(dropLocationsDropDown);
		bookFrame.add(startTLabel);
		bookFrame.add(bookingPickupDateSpinner);
		bookFrame.add(bookingDropDateSpinner);
		bookFrame.add(endTLabel);
		bookFrame.add(startTLabelInstruction);
		bookFrame.add(endTLabelInstruction);
		bookFrame.add(pickCarButton);
		bookFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// ABOUT FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		aboutFrame = new JFrame("About");
		aboutFrame.setLayout(null);

		// about frame setup
		JTextArea aboutText = new JTextArea("At JASIVA, we satisfy your need to rent a car.\n"
				+ "Our mission is to provide all our wonderful customers the authentic " + "\n"
				+ "experience of renting a car. The program may have glitches, but that  " + "\n"
				+ "is by design. To make your experience more realistic, the process " + "\n"
				+ "cannot be easy. By the end you may throw out your computer. But " + "\n"
				+ "without that struggle, the experience of renting a car just isn't right. \n\n ya know?"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "*we are not actually responsible for providing cars to any of the given\n"
				+ "locations. Prices may vary depending on duration, our general feeling\n"
				+ "about the world, the global price of wheat, and how much we want to pad \n" + "our wallets*");

		JScrollPane aboutTextScroll = new JScrollPane(aboutText);// create scroll bar
		JButton aboutHomeButton = new JButton("JASIVA");
		aboutHomeButton.setForeground(Color.RED);
		aboutHomeButton.setFont(new Font("Arial", Font.PLAIN, 70));

		// arranging components
		aboutTextScroll.setBounds(190, 100, 500, 300);
		aboutHomeButton.setBounds(300, 20, 300, 75);

		// adding action listener
		aboutHomeButton.addActionListener(this);

		// adding components to frame and finalizing
		aboutFrame.add(aboutTextScroll);
		aboutFrame.add(aboutHomeButton);
		aboutFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// MANAGER FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		managerFrame = new JFrame("Manager Frame");
		managerFrame.setLayout(null);

		// creating button/labels
		// adding and removing buttons
		JLabel removeAddCarLabel = new JLabel("Add/Remove Car at Location");
		JLabel searchUserLabel = new JLabel("Search User");
		JLabel resultLabel = new JLabel("Result");
		JScrollPane scrollSearchResultField = new JScrollPane(searchResultField);

		// Informational text Areas
		JLabel locationsLabel = new JLabel("Locations");
		JLabel reservationsLabel = new JLabel("Reservations");
		JLabel UsersLabel = new JLabel("Users");
		JLabel availableSearchLabel = new JLabel("Availablity Search");
		JLabel availableResultLabel = new JLabel("All Cars");
		JButton managerAboutHomeButton = new JButton("JASIVA");
		JButton removeAllReservations = new JButton("Remove All Reservations");
		JButton enterAvailableButton = new JButton("Enter");
		JButton addCar = new JButton("Add Vehicle");
		JButton removeCar = new JButton("Remove Vehicle");
		JButton searchUserButton = new JButton("Search");
		JButton removeUserButton = new JButton("Remove User");
		JButton removeAllUsersButton = new JButton("Remove All Users");

		// Changing functionalities

		// appearance changes
		managerAboutHomeButton.setForeground(Color.RED);
		managerAboutHomeButton.setFont(new Font("Arial", Font.PLAIN, 70));

		// arranging components
		managerAboutHomeButton.setBounds(300, 20, 300, 75);
		removeAddCarLabel.setBounds(230, 80, 180, 60);
		addRemoveCarDropDown.setBounds(200, 120, 130, 30);
		addRemoveCarLocations.setBounds(330, 120, 130, 30);
		addCar.setBounds(270, 150, 50, 20);
		removeCar.setBounds(330, 150, 50, 20);
		searchUserButton.setBounds(505, 150, 50, 20);
		searchUserField.setBounds(500, 120, 130, 30);
		searchUserLabel.setBounds(500, 80, 180, 60);
		scrollSearchResultField.setBounds(645, 110, 200, 40);
		removeUserButton.setBounds(650, 150, 95, 20);
		resultLabel.setBounds(650, 90, 50, 20);
		removeAllReservations.setBounds(410, 280, 160, 20);
		removeAllUsersButton.setBounds(635, 280, 160, 20);
		locationsLabel.setBounds(80, 280, 130, 20);
		reservationsLabel.setBounds(330, 280, 130, 20);
		UsersLabel.setBounds(580, 280, 130, 20);
		checkAvailableCarsDropDown.setBounds(20, 200, 130, 30);
		availableLocationsDropDown.setBounds(150, 200, 130, 30);
		managerAllAvailableCars.setBounds(290, 200, 500, 80);
		enterAvailableButton.setBounds(85, 230, 130, 30);
		availableSearchLabel.setBounds(85, 175, 130, 30);
		availableResultLabel.setBounds(300, 175, 130, 30);
		managerAllLocations.setBounds(80, 300, 240, 170);
		managerAllUser.setBounds(580, 300, 240, 170);
		managerAllReservation.setBounds(330, 300, 240, 170);

		// setting editable
		managerLocationsList.setEditable(false);
		managerReservationsList.setEditable(false);
		managerUsersList.setEditable(false);
		searchResultField.setEditable(false);
		managerAvailableCarsList.setEditable(false);

		// setting text fields
		managerLocationsList.setText(IH.getLocationsString());
		managerUsersList.setText(IH.getUsersString());
		managerReservationsList.setText(IH.getReservationsString());// !~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!~~~~~~~~~~~~~~~~~~~!~~~~~~~~~~~~~~!~!~~!
		managerAvailableCarsList.setText(IH.getCarsString());

		// adding action listener
		managerAboutHomeButton.addActionListener(this);
		addCar.addActionListener(this);
		removeCar.addActionListener(this);
		removeAllReservations.addActionListener(this);
		enterAvailableButton.addActionListener(this);
		searchUserButton.addActionListener(this);
		removeUserButton.addActionListener(this);
		removeAllUsersButton.addActionListener(this);

		// adding components to frame and finalizing
		managerFrame.add(managerAboutHomeButton);
		managerFrame.add(addRemoveCarDropDown);
		managerFrame.add(removeAddCarLabel);
		managerFrame.add(addRemoveCarLocations);
		managerFrame.add(addCar);
		managerFrame.add(removeCar);
		managerFrame.add(searchUserButton);
		managerFrame.add(searchUserField);
		managerFrame.add(searchUserLabel);
		managerFrame.add(scrollSearchResultField);
		managerFrame.add(removeUserButton);
		managerFrame.add(resultLabel);
		managerFrame.add(managerAllLocations);
		managerFrame.add(managerAllUser);
		managerFrame.add(managerAllReservation);
		managerFrame.add(removeAllReservations);
		managerFrame.add(locationsLabel);
		managerFrame.add(reservationsLabel);
		managerFrame.add(UsersLabel);
		managerFrame.add(checkAvailableCarsDropDown);
		managerFrame.add(availableLocationsDropDown);
		managerFrame.add(managerAllAvailableCars);
		managerFrame.add(enterAvailableButton);
		managerFrame.add(availableSearchLabel);
		managerFrame.add(availableResultLabel);
		managerFrame.add(removeAllUsersButton);
		managerFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Final setup of frames
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JFrame[] tempJFar = { welcomeFrame, loginFrame, bookFrame, aboutFrame, managerFrame, carFrame };
		frames = tempJFar;
		for (int i = 0; i < frames.length; i++) {
			frames[i].setResizable(false);
			frames[i].addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(WindowEvent winEvt) {
					try {
						IH.saveInformation();
					} catch (IOException e) {
					}
					System.exit(0);
				}
			});
		}
	}


	public void actionPerformed(ActionEvent evt) {

		String evtString = evt.getActionCommand();
		// print out the command for debugging
		System.out.println("Pressed: " + evtString);

		// sign in to jasiva
		if (evtString.equals("Sign in")) {
			boolean valid = false;
			// Getting the Usernames and Passwords for checking
			ArrayList<String> usernames = IH.getUsernames();
			ArrayList<String> passwords = IH.getPasswords();
			if (!usernames.isEmpty() && usernames.indexOf(signInUsernameField.getText()) == passwords
					.indexOf(new String(signInPasswordField.getPassword()))) {
				System.out.println("success");
				valid = true;
				signedIn = true;
				IH.CurrentUser = IH.Users.get(IH.getUsernames().indexOf(signInUsernameField.getText()));
			}
			if (valid == false) {
				System.out.println("Incorrect Username or Password");
				JOptionPane.showMessageDialog(loginFrame, "Incorrect Username or Password");
				signInUsernameField.setText("");
				signInPasswordField.setText("");
			} else
				switchToFrame(bookFrame);
		}

		// register with jasiva
		if (evtString.equals("Register")) {
			// Getting the User names for checking validity
			ArrayList<String> usernames = IH.getUsernames();
			// checks if password meets requirements

			// !!!!!!!!!!! TEMPORARY DEBUGG COMMENTING !!!!!!!!!!
			boolean validPassword = true; // passwordChecker(new String(registerPasswordField.getPassword()),
											// registerFirstNameField.getText());
			// checks if user name is already taken
			boolean validUser = usernames.isEmpty() || !usernames.contains(registerUsernameField.getText());
			// if the password is invalid, print that and why
			if (!validPassword) {
				System.out.println("Invalid password");
				registerPasswordField.setText("");
			}
			// if the user name is invalid (taken), print that
			if (!validUser) {
				System.out.println("Invalid Username");
				registerUsernameField.setText("");
			}
			// if both are valid, make a new user and clear the fields
			if (validUser && validPassword) {
				// create user
				User userCreated = new User(registerFirstNameField.getText(), registerLastNameField.getText(),
						registerUsernameField.getText(), new String(registerPasswordField.getPassword()));
				// adds user to Inventory Handler for logging
				IH.add(userCreated);
				managerUsersList.setText(IH.getUsernames().toString());
				// clear the fields after registering successfully
				registerPasswordField.setText("");
				registerUsernameField.setText("");
				registerFirstNameField.setText("");
				registerLastNameField.setText("");
			}
		}
		if (evtString.equals("Book Now!"))
			switchToFrame(loginFrame);
		if (evtString.equals("See our Cars"))
			switchToFrame(carFrame);
		if (evtString.equals("JASIVA"))
			switchToFrame(welcomeFrame);
		if (evtString.equals("Pick a Car!")) {
			String pickupLocation = pickupLocationsDropDown.getSelectedItem().toString();
			ArrayList<Car> Cars = IH.Cars;
			boolean[] available = { false, false, false, false, false };
			JButton[] carImageButtons = { cheapButton, lowEndButton, mediumButton, highEndButton, premiumButton };
			for (int i = 0; i < Cars.size(); i++) {
				if (Cars.get(i).location.toString().equals(pickupLocation)) {
					if (Cars.get(i).model.equals(carArray[0].model))
						available[0] = true;
					if (Cars.get(i).model.equals(carArray[1].model))
						available[1] = true;
					if (Cars.get(i).model.equals(carArray[2].model))
						available[2] = true;
					if (Cars.get(i).model.equals(carArray[3].model))
						available[3] = true;
					if (Cars.get(i).model.equals(carArray[4].model))
						available[4] = true;
				}
			}
			for (int i = 0; i < carImageButtons.length; i++) {
				if (available[i]) {
					carImageButtons[i].setIcon(new ImageIcon(((new ImageIcon(carArray[i].model + ".jpg")).getImage())
							.getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
				} else {
					carImageButtons[i].setEnabled(false); //setting enabled to false greys out the buttons automatically
					//carImageButtons[i].setIcon(new ImageIcon(((new ImageIcon(carArray[i].model + "Greyed.jpg")).getImage())
									//.getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
				}
			}
			switchToFrame(carFrame);
		}
		if (evtString.equals("back"))
			switchToFrame(bookFrame);
		if (evtString.equals("back to signIN"))
			switchToFrame(loginFrame);
		if (evtString.equals("About"))
			switchToFrame(aboutFrame);
		if (evtString.equals("Remove All Reservations")) {
			IH.Reservations.clear();
			managerReservationsList.setText(IH.getReservationsString());
		}
		if (evtString.equals("Remove All Users")) {
			IH.Users.clear();
			IH.Reservations.clear();
			managerUsersList.setText(IH.getUsernames().toString());
			managerReservationsList.setText(IH.getUsernames().toString());
		}
		if (evtString.equals("Enter")) { // NEEDS WORK
			// set availableCars text area to all selected types of cars at location
			String carComboBoxValue = (String) checkAvailableCarsDropDown.getSelectedItem();
			String LocationComboBoxValue = (String) availableLocationsDropDown.getSelectedItem();
			boolean found = false;
			for (int i = 0; i < IH.Cars.size(); i++)
				if (IH.Cars.get(i).model.equals(carComboBoxValue)
						&& IH.Cars.get(i).location.toString().equals(LocationComboBoxValue))
					found = true;
			if (found)
				JOptionPane.showMessageDialog(managerFrame, "Car Found", "", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(managerFrame, "Not found", "", JOptionPane.WARNING_MESSAGE);
			checkAvailableCarsDropDown.setSelectedIndex(0);
			availableLocationsDropDown.setSelectedIndex(0);
		}
		if (evtString.equals("Add Vehicle")) {
			// HERE IS WHERE I MEAN
			String locationName = addRemoveCarLocations.getText();
			if (!IH.getLocations().contains(locationName)) {// the if statement doesnt work
				availableLocationsDropDown.addItem(locationName);
				pickupLocationsDropDown.addItem(locationName);
				dropLocationsDropDown.addItem(locationName);
			}
			Car newCar = new Car(carArray, (String) addRemoveCarDropDown.getSelectedItem(), locationName);
			if (newCar.model != "ERROR")
				IH.Cars.add(newCar);
			else
				JOptionPane.showMessageDialog(managerFrame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

			addRemoveCarDropDown.setSelectedIndex(0);
			addRemoveCarLocations.setText("");
			managerAvailableCarsList.setText(IH.getCarsString());
			managerLocationsList.setText(IH.getLocationsString());

		}
		if (evtString.equals("Remove Vehicle")) {
			Car removeCar = new Car(carArray, (String) addRemoveCarDropDown.getSelectedItem(),
					addRemoveCarLocations.getText());
			String removeLocation = addRemoveCarLocations.getText();
			boolean first = true;
			int numCarsAtRemoveLocation = 0;
			ArrayList<Car> tempCars = IH.Cars;
			for (int i = 0; i < tempCars.size(); i++) {
				Car car = tempCars.get(i);
				if (car.location.toString().equals(removeLocation))
					numCarsAtRemoveLocation++;
				if (car.Equals(removeCar))
					if (first) {
						IH.Cars.remove(car);
						first = false;
					}
			}
			if (!IH.getLocations().contains(removeLocation) && numCarsAtRemoveLocation == 1) {
				availableLocationsDropDown.removeItem(removeLocation);
				pickupLocationsDropDown.removeItem(removeLocation);
				dropLocationsDropDown.removeItem(removeLocation);
			} else if (!IH.getLocations().contains(removeLocation))
				JOptionPane.showMessageDialog(managerFrame, "ERROR: Car Does Not Exist", "Error",
						JOptionPane.ERROR_MESSAGE);
			addRemoveCarLocations.setText("");
			addRemoveCarDropDown.setSelectedIndex(0);
			managerAvailableCarsList.setText(IH.getCarsString());
			managerLocationsList.setText(IH.getLocationsString());
		}
		if (evtString.equals("Search")) {
			int index = binarySearch(IH.getUsernames(), searchUserField.getText());
			if (index >= 0) {
				try {
					searchResultField.setText(IH.getUsernames().get(index) + IH.Reservations.get(index));
				} catch (IndexOutOfBoundsException e) { // in case user does not have a reservation
					searchResultField.setText(IH.getUsernames().get(index));
				}
			} else
				JOptionPane.showMessageDialog(managerFrame, "User Does Not Exist", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (evtString.equals("Remove User")) { //only allows for q reservations per user or does not work
			int index = binarySearch(IH.getUsernames(), searchUserField.getText());
			try {	
				//FIX THIS !!!!!!!!!!!!!!!!!!!!!!!!
				IH.Reservations.remove(index);//this needs to be changed to remove all reservations done by the same user
				managerReservationsList.setText(IH.getReservationsString());
			} catch (IndexOutOfBoundsException e) {
				managerReservationsList.setText(IH.getReservationsString());
			}
			IH.Users.remove(index);
			searchResultField.setText("");
			managerUsersList.setText(IH.getUsernames().toString());
		}
		if (evtString.equals("Manager Interface")) {
			// need to make password field
			String s = (String) JOptionPane.showInputDialog(welcomeFrame, "Enter Code for Access", "Input",
					JOptionPane.WARNING_MESSAGE, null, null, null);
			// If a string was returned, say so.
			if ((s != null) && (s.length() > 0) && s.equals("1234")) {
				switchToFrame(managerFrame);
				return;
			}
			if ((s != null) && s != "1234" && (s.length() > 0))
				JOptionPane.showMessageDialog(welcomeFrame, "Wrong Code", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// all the car booking options
		if (evtString.endsWith("Car")) {
			// USES DEFAULT CONSTRUCTOR FOR A DEFAULT CAR
			Car bookedCar = new Car(carArray, evtString, (String) pickupLocationsDropDown.getSelectedItem());
			if (signedIn) {
				Object[] options = { "Book!", "Cancel" };
				// Confirm Booking Message
				int returnValue = JOptionPane.showOptionDialog(carFrame,
						"Would you like book this car?\n" + bookedCar.toNiceString(),
						null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);

				if (returnValue == JOptionPane.YES_OPTION) {
					// Create car and TS for booking
					// month/day/year/time in 0000
					TimeSlot bookedTimeSlot = TSfromDateString(
							new SimpleDateFormat("MM/dd/yyyy/HHmm").format(bookingPickupDateSpinner.getValue()),
							new SimpleDateFormat("MM/dd/yyyy/HHmm").format(bookingDropDateSpinner.getValue()));
					// Add booking to IH list
					double price = IH.addReservation(bookedCar,
							new Location((String) pickupLocationsDropDown.getSelectedItem()),
							new Location((String) dropLocationsDropDown.getSelectedItem()), bookedTimeSlot,
							IH.CurrentUser);
					if (price == -1) {
						System.out.println("ThatS not a very good boy of a reservatIon :(");
						JOptionPane.showMessageDialog(carFrame, "Invalid Reservation", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						System.out.println("Price of Reservation is: " + price);
						JOptionPane.showMessageDialog(carFrame,
								"Confirm Booking: \n Car: " + bookedCar.toNiceString() + "\n TimeSlot: "
										+ bookedTimeSlot.toNiceString() + "\n Price: " + Math.round(price) + "$",
								"Confirm Booking", JOptionPane.INFORMATION_MESSAGE);
					}
					managerReservationsList.setText(IH.getReservationsString());
					switchToFrame(bookFrame);
				}
			} else if (!signedIn){
				Object[] options = { "Sign In", "See Car Info", "Cancel" };
				// Confirm Booking Message
				int returnValue = JOptionPane.showOptionDialog(carFrame, "You are not signed in", null,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[2]);
				if (returnValue == JOptionPane.YES_OPTION)
					switchToFrame(loginFrame);
				if (returnValue == JOptionPane.NO_OPTION)
					JOptionPane.showMessageDialog(carFrame,
							"Car Info\n " + bookedCar.toNiceString() );
			}
		}
		
		//System.out.println(checkField.isSelected());
		
		if (evtString.equals("checked")) {
			System.out.println(checkField.isSelected());
			if (checkField.isSelected()) {
				String selectedLocation = (String) pickupLocationsDropDown.getSelectedItem();
				dropLocationsDropDown.setSelectedItem(selectedLocation);
				dropLocationsDropDown.setEnabled(false);
			} else {
				dropLocationsDropDown.setSelectedItem(0);
				dropLocationsDropDown.setEnabled(true);
			}
		}
	
	}

	public TimeSlot TSfromDateString(String startDateString, String endDateString) {
		Scanner startDateScanner = new Scanner(startDateString);
		Scanner endDateScanner = new Scanner(endDateString);
		startDateScanner.useDelimiter("/");
		endDateScanner.useDelimiter("/");
		int startMonth = startDateScanner.nextInt();
		int startDay = startDateScanner.nextInt();
		int startYear = startDateScanner.nextInt();
		int startTime = startDateScanner.nextInt();
		int endMonth = endDateScanner.nextInt();
		int endDay = endDateScanner.nextInt();
		int endYear = endDateScanner.nextInt();
		int endTime = endDateScanner.nextInt();
		TimeSlot ts = new TimeSlot(startMonth, startDay, startYear, startTime, endMonth, endDay, endYear, endTime);
		startDateScanner.close();
		endDateScanner.close();
		return ts;
	}

	public void switchToFrame(JFrame frame) {
		for (int i = 0; i < frames.length; i++) {
			if (frame == frames[i])
				frames[i].setVisible(true);
			else
				frames[i].setVisible(false);
		}
	}

	public boolean passwordChecker(String password, String name1) {
		boolean length = false; // check variable for password length
		boolean capital = false; // check variable for if there is a capital
		boolean number = false; // check variable for if there is a number
		boolean charac = false; // check variable for if there is a special character
		boolean namecon = false; // check variable for if name is contained in password
		String name = name1.toLowerCase();
		ArrayList<String> errors = new ArrayList<String>();
		if (password.length() >= 8) // checks length
			length = true;
		char[] pass = password.toCharArray(); // converts to char array to be able to do checks
		for (int i = 0; i < password.length(); i++) {
			if (isUpper(pass[i])) // checks for upper case
				capital = true;
			if (containsNum(pass[i])) // checks for number
				number = true;
			if (containsSpecial(pass[i])) // checks for special character
				charac = true;
		}
		// checks for name
		if (!password.toLowerCase().contains(name))
			namecon = true;
		// checks to see all parameters are completed
		if (length && capital && number && charac && namecon) {
			System.out.println("Valid Password");
			return true;
		} else {
			System.out.println("Invalid Password. Please Re-Enter. The issues are:");
			if (!length)
				errors.add("Password is not long enough");
			if (!capital)
				errors.add("Password does not have an upper case");
			if (!number)
				errors.add("Password does not have a number");
			if (!charac)
				errors.add("Password does not have a special character");
			if (!namecon)
				errors.add("Password contains your name");
			String allErrors = errors.toString();
			JOptionPane.showMessageDialog(loginFrame, allErrors);
			return false;
		}
	}

	static boolean isUpper(char c) {
		return (c >= 65 && c <= 90);
	}

	static boolean containsNum(char c) {
		return (c >= 48 && c <= 57);
	}

	static boolean containsSpecial(char c) {
		return ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126));
	}

	public int binarySearch(ArrayList<String> users, String userName) {
		Collections.sort(users); // sorts array list because it is not sorted
		int first = 0;// first position in array
		int last = users.size() - 1; // last position in array
		int middle;
		boolean found = false;
		while (found == false && first <= last) {
			middle = ((first + last) / 2); // picks middle point in array
			if (users.get(middle).compareToIgnoreCase(userName) < 0) { // checks middle of list and picks left or right
																		// of it
				first = (middle + 1); // makes smaller interval if middle word is not chosen word
			} else if (users.get(middle).compareToIgnoreCase(userName) > 0) {
				last = (middle - 1);
			} else {
				System.out.println("the index is: " + middle);
				found = true; // stops loop if word is found
				return middle;
			}
		}
		return -1;
	}
}