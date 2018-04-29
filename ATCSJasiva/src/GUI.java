import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame implements ActionListener {

	// Global variables
	//private static String CurrentPanel = "Welcome";
	// (text fields in the way we are using them must be global variables)
	private JTextField signInUsernameField = new JTextField(10);
	private JTextField registerFirstNameField = new JTextField(10);
	private JTextField registerLastNameField = new JTextField(10);
	private JTextField registerUsernameField = new JTextField(10);
	private JPasswordField signInPasswordField = new JPasswordField(10);
	private JPasswordField registerPasswordField = new JPasswordField(10);
	
	//Frames(temp test as global var)
	JFrame carFrame;
	JFrame loginFrame;
	JFrame welcomeFrame;
	JFrame bookFrame;
	JFrame aboutFrame;
	JFrame carInfoFrame;
	JFrame managerFrame;
	
	//master inventory handler
	public static InventoryHandler IH;
	
	public static void main(String[] args) {
		IH = new InventoryHandler();//stays constant
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
		JLabel missionTextLabel = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JButton rentButton = new JButton("Rent a Car");
		JButton viewCarsButton = new JButton("See our Cars");
		JButton AboutButton = new JButton("JASIVA");
		JButton toAbout = new JButton("About");
		JScrollPane missionTextScroll = new JScrollPane(missionTextLabel);
		JButton toManager = new JButton("Manager Interface");
		
		// arranging on page
		missionLabel.setBounds(300, 140, 100, 50);
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
		JButton cheapButton = new JButton(new ImageIcon(((new ImageIcon("cheap.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton lowEndButton = new JButton(new ImageIcon(((new ImageIcon("lowend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton mediumButton = new JButton(new ImageIcon(((new ImageIcon("medium.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton highEndButton = new JButton(new ImageIcon(((new ImageIcon("highend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton premiumButton = new JButton(new ImageIcon(((new ImageIcon("chiron.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton backButton = new JButton("back");
		JButton carViewerAboutButton = new JButton("JASIVA");

		// appearance changes
		carViewerAboutButton.setForeground(Color.RED);
		carViewerAboutButton.setFont(new Font("Arial", Font.PLAIN, 70));
		
		//activating buttons
		cheapButton.addActionListener(this);
		lowEndButton.addActionListener(this);
		mediumButton.addActionListener(this);
		highEndButton.addActionListener(this);
		premiumButton.addActionListener(this);
		carViewerAboutButton.addActionListener(this);
		backButton.addActionListener(this);
		
		//Changing button Action commands
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
		JLabel startTLabel = new JLabel("Start time:");
		JLabel endTLabel = new JLabel("End time:");
		JTextField pickupField = new JTextField("");
		JTextField dropField = new JTextField("");
		JTextField startTField = new JTextField("");
		JTextField endTField = new JTextField("");
		JCheckBox checkField = new JCheckBox();
		JButton pickCarButton = new JButton("Pick a Car!");
		JButton carViewerAboutButton2 = new JButton("JASIVA");
		JButton backButton2 = new JButton("back");
		
	
		carViewerAboutButton2.setForeground(Color.RED);
		carViewerAboutButton2.setFont(new Font("Arial", Font.PLAIN, 70));
		
		
		//adding action listener
		pickCarButton.addActionListener(this);
		carViewerAboutButton2.addActionListener(this);
		backButton2.addActionListener(this);

		// appearance changes
		checkLabel.setFont(new Font("Arial", Font.PLAIN, 9));

		// arranging components
		pickupLabel.setBounds(310, 130, 130, 30);
		checkLabel.setBounds(370, 155, 170, 30);
		dropLabel.setBounds(310, 180, 130, 30);
		startTLabel.setBounds(310, 210, 130, 30);
		endTLabel.setBounds(310, 240, 130, 30);
		pickupField.setBounds(395, 130, 130, 30);
		dropField.setBounds(395, 180, 130, 30);
		startTField.setBounds(395, 210, 130, 30);
		endTField.setBounds(395, 240, 130, 30);
		checkField.setBounds(495, 157, 25, 25);
		pickCarButton.setBounds(370, 300, 150, 70);
		carViewerAboutButton2.setBounds(300, 20, 300, 75);
		backButton2.setBounds(100, 50, 200, 30);
		
		//
		backButton2.setActionCommand("back to signIN");

		// adding components to frame and finalizing
		bookFrame.add(backButton2);
		bookFrame.add(carViewerAboutButton2);
		bookFrame.add(pickupLabel);
		bookFrame.add(pickupField);
		bookFrame.add(checkLabel);
		bookFrame.add(checkField);
		bookFrame.add(dropLabel);
		bookFrame.add(dropField);
		bookFrame.add(startTLabel);
		bookFrame.add(startTField);
		bookFrame.add(endTLabel);
		bookFrame.add(endTField);
		bookFrame.add(pickCarButton);
		bookFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// ABOUT FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		aboutFrame = new JFrame("About");
		aboutFrame.setLayout(null);

		// about frame setup
		JTextArea aboutText = new JTextArea("At JASIVA, we think about giving you a car."+ "\n"+" But you will never actually get a car."
				+ "\n"+ "Our mission is to give you the experience of booking a car."+ "\n"+" The program may have glitches, but that is by design."
				+ "\n"+"To make your experience more realistic, the process cannot be easy."+ "\n"+" By the end you may throw out your computer."
				+ "\n"+"That is how we know we have been succesful. "+ "\n"+"*we are not actually responsible for providing car*");
		JScrollPane aboutTextScroll = new JScrollPane(aboutText);// create scroll bar
		JButton aboutHomeButton = new JButton("JASIVA");
		aboutHomeButton.setForeground(Color.RED);
		aboutHomeButton.setFont(new Font("Arial", Font.PLAIN, 70));
		
		// arranging components
		aboutTextScroll.setBounds(190, 100, 500, 300);
		aboutHomeButton.setBounds(300, 20, 300, 75);

		//adding action listener
		aboutHomeButton.addActionListener(this);
		
		// adding components to frame and finalizing
		aboutFrame.add(aboutTextScroll);
		aboutFrame.add(aboutHomeButton);
		aboutFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// CAR INFO FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		carInfoFrame = new JFrame("Car Info");
		carInfoFrame.setLayout(null);
		carInfoFrame.setSize(900, 500);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Manager FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
		managerFrame = new JFrame("Manager Frame");
		managerFrame.setLayout(null);
		JButton managerAboutHomeButton = new JButton("JASIVA");
		managerAboutHomeButton.setForeground(Color.RED);
		managerAboutHomeButton.setFont(new Font("Arial", Font.PLAIN, 70));
		
		// arranging components
		managerAboutHomeButton.setBounds(300, 20, 300, 75);

		//adding action listener
		managerAboutHomeButton.addActionListener(this);
		
		// adding components to frame and finalizing
		managerFrame.add(managerAboutHomeButton);
		managerFrame.setSize(900, 500);
	}

	public void actionPerformed(ActionEvent evt) {
		
		String evtString = evt.getActionCommand();
		// print out the command for debugging
		System.out.println("Pressed: "+evtString);
		
		// sign in to jasiva
		if (evtString.equals("Sign in")) {
			boolean valid = false;
			//Getting the Usernames and Passwords for checking
			ArrayList<String> usernames = IH.getUsernames();
			ArrayList<String> passwords = IH.getPasswords();
			if (!usernames.isEmpty() && usernames.indexOf(signInUsernameField.getText())==passwords.indexOf(new String(signInPasswordField.getPassword()))) { 															
				System.out.println("success");
				valid = true;
			}
			if (valid == false) {
				System.out.println("Incorrect Username or Password");
				JOptionPane.showMessageDialog(loginFrame, "Incorrect Username or Password");
				signInUsernameField.setText(""); 
				signInPasswordField.setText("");
			}
			else {
				loginFrame.setVisible(false);
				welcomeFrame.setVisible(false);
				aboutFrame.setVisible(false);
				carFrame.setVisible(false);
				bookFrame.setVisible(true);
				carInfoFrame.setVisible(false);
				managerFrame.setVisible(false);
			}
		}
		
		// register with jasiva
		if (evtString.equals("Register")) { 
			//Getting the User names for checking validity
			ArrayList<String> usernames = IH.getUsernames();
			// checks if password meets requirements
			boolean validPassword = true;
			//passwordChecker(new String(registerPasswordField.getPassword()), registerFirstNameField.getText());
			// checks if user name is already taken
			boolean validUser = usernames.isEmpty() || !usernames.contains(registerUsernameField.getText());
			// if the password is invalid, print that and why
			if (!validPassword) {
				System.out.println("Invalid password");
				registerPasswordField.setText(""); 
			}
			//if the user name is invalid (taken), print that
			if (!validUser) {
				System.out.println("Invalid Username");
				registerUsernameField.setText(""); 
			}
			// if both are valid, make a new user and clear the fields
			if (validUser && validPassword) {
				// create user
				User user = new User(registerFirstNameField.getText(), registerLastNameField.getText(), registerUsernameField.getText(), new String(registerPasswordField.getPassword()));
				// adds user to Inventory Handler for logging
				IH.add(user); 
				// clear the fields after registering successfully
				registerPasswordField.setText(""); 
				registerUsernameField.setText("");
				registerFirstNameField.setText(""); 
				registerLastNameField.setText("");
			}
		}
		if (evtString.equals("Rent a Car")) {
			loginFrame.setVisible(true);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("See our Cars")) {
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(true);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("JASIVA")) {
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(true);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("Pick a Car!")) {
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(true);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("back")) {
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(true);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("back to signIN")) {
			loginFrame.setVisible(true);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("About")) {
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(true);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
			managerFrame.setVisible(false);
		}
		if (evtString.equals("cheapCar")) {
			Object[] options = {"Book!","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(carFrame, "Would you like book this car?" + "\n"+
			"25mpg, 4 people", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
			if (returnValue == JOptionPane.YES_OPTION) {
				//THIS IS WHERE THE BOOKING SHOULD BE CREATED
			}
		}
		if (evtString.equals("lowEndCar")) {
			Object[] options = {"Book!","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(carFrame, "Would you like book this car?" + "\n"+
			"20mpg, 5 people", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
			if (returnValue == JOptionPane.YES_OPTION) {
				//THIS IS WHERE THE BOOKING SHOULD BE CREATED
			}
		}
		if (evtString.equals("mediumCar")) {
			Object[] options = {"Book!","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(carFrame, "Would you like book this car?" + "\n"+
			"20mpg, 5 people", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
			if (returnValue == JOptionPane.YES_OPTION) {
				//THIS IS WHERE THE BOOKING SHOULD BE CREATED
			}
		}
		if (evtString.equals("highEndCar")) {
			Object[] options = {"Book!","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(carFrame, "Would you like book this car?" + "\n"+
			"10mpg, 7 people", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
			if (returnValue == JOptionPane.YES_OPTION) {
				//THIS IS WHERE THE BOOKING SHOULD BE CREATED
			}
		}
		if (evtString.equals("premiumCar")) {
			Object[] options = {"Book!","Cancel"};
			int returnValue = JOptionPane.showOptionDialog(carFrame, "Would you like book this car?" + "\n"+
			"10mpg, 2 people", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
			if (returnValue == JOptionPane.YES_OPTION) {
				//THIS IS WHERE THE BOOKING SHOULD BE CREATED
			}
		}
		if (evtString.equals("Manager Interface")) {
			//need to make password field
			String s = (String)JOptionPane.showInputDialog(welcomeFrame,"Enter Code for Access","Input", JOptionPane.WARNING_MESSAGE,null,null,null);
			//If a string was returned, say so.
			if ((s != null) && (s.length() > 0) && s.equals("1234")) {
				managerFrame.setVisible(true);
				loginFrame.setVisible(false);
				welcomeFrame.setVisible(false);
				aboutFrame.setVisible(false);
				carFrame.setVisible(false);
				bookFrame.setVisible(false);
				carInfoFrame.setVisible(false);
			    return;
			}if((s != null) && s != "1234" && (s.length() > 0)){
				JOptionPane.showMessageDialog(welcomeFrame,"Wrong Code","Error",JOptionPane.ERROR_MESSAGE);
			}
			
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
		if (password.length() >= 8) { // checks length
			length = true;
		}
		char[] pass = password.toCharArray(); // converts to char array to be able to do checks
		for (int i = 0; i < password.length(); i++) {
			if (isUpper(pass[i]))  // checks for upper case
				capital = true;
			if (containsNum(pass[i]))  // checks for number
				number = true;
			if (containsSpecial(pass[i]))  // checks for special character
				charac = true;
		}
		// checks for name
		if (!password.toLowerCase().contains(name)) { 
			namecon = true;
		}
		// checks to see all parameters are completed
		if (length && capital && number && charac && namecon) { 
			System.out.println("Valid Password");
			return true;
		}
		else { 
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

	static boolean isUpper(char c) { // methods check characters against ASC-II library to determine if upper/number/special
		if (c >= 65 && c <= 90) {
			return true;
		}
		return false;
	}

	static boolean containsNum(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

	static boolean containsSpecial(char c) {
		if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
			return true;
		}
		return false;
	}
}