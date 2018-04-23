import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GUI extends JFrame implements ActionListener {

	// Global variables
	private static String CurrentPanel = "Welcome";
	private JTextField signInUsernameField = new JTextField(10);
	private JTextField registerFirstNameField = new JTextField(10);
	private JTextField registerLastNameField = new JTextField(10);
	private JTextField registerUsernameField = new JTextField(10);
	private JPasswordField signInPasswordField = new JPasswordField(10);
	private JPasswordField registerPasswordField = new JPasswordField(10);
	public InventoryHandler c;
	
	private static ArrayList<String> usernames = new ArrayList<String>();
	private static ArrayList<String> passwords = new ArrayList<String>();
	
	public static InventoryHandler IH;

	public static void main(String[] args) {
		IH = new InventoryHandler();//stays constant
		new GUI(IH, CurrentPanel);
	}

	

	public GUI(InventoryHandler c, String CurrentPanel) {
		// If instantiated with a specific state, it will use it, but defaults to
		// "Welcome panel"
		String currentPanel = CurrentPanel;
		if (CurrentPanel == "") {
			currentPanel = "Welcome"; // state string that determines which window is open
		}

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// LOGIN FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		SpringLayout loginlayout = new SpringLayout();
		JFrame loginFrame = new JFrame("Login");
		loginFrame.setLayout(loginlayout); // makes the layout a spring layout

		// Login Panel setup
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

		// Lay out sign in and register panels
		SpringUtilities.makeCompactGrid(signInPanel, 2, 2, 3, 3, 3, 3);
		SpringUtilities.makeCompactGrid(registerPanel, 4, 2, 3, 3, 3, 3);

		// Specific layouts of the login page
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

		// adding components to frame and finalizing
		loginFrame.add(signInPanel);
		loginFrame.add(registerPanel);
		loginFrame.add(existingUserLabel);
		loginFrame.add(registerLabel);
		loginFrame.add(signInButton);
		loginFrame.add(registerButton);
		loginFrame.setTitle("Login");
		loginFrame.setSize(900, 500);
		
		//Button Setups
		signInButton.addActionListener(this);
		registerButton.addActionListener(this);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// WELCOME FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JFrame welcomeFrame = new JFrame("Welcome");
		welcomeFrame.setLayout(null);

		JLabel missionLabel = new JLabel("Our Mission:");
		JLabel missionTextLabel = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JButton rentButton = new JButton("Rent a Car");
		JButton viewCarsButton = new JButton("See our Cars");
		JButton AboutButton = new JButton("JASIVA");
		JScrollPane oth = new JScrollPane(missionTextLabel); // create scrollbar

		missionLabel.setBounds(300, 140, 100, 50);
		oth.setBounds(300, 150, 300, 70);
		rentButton.setBounds(500, 275, 150, 60);
		viewCarsButton.setBounds(250, 275, 150, 60);
		AboutButton.setForeground(Color.RED);
		AboutButton.setFont(new Font("Arial", Font.PLAIN, 70));
		AboutButton.setBounds(300, 20, 300, 75);

		// adding components to frame and finalizing
		welcomeFrame.setContentPane(new JLabel(new ImageIcon("backround.jpeg")));
		welcomeFrame.add(rentButton);
		welcomeFrame.add(viewCarsButton);
		welcomeFrame.add(AboutButton);
		welcomeFrame.add(missionLabel);
		welcomeFrame.add(oth);
		welcomeFrame.setTitle("Welcome page");
		welcomeFrame.setSize(900, 500);
		
		//activating buttons
		rentButton.addActionListener(this);
		viewCarsButton.addActionListener(this);
		AboutButton.addActionListener(this);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// CAR VIEWER
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// car viewer button/labels
		JFrame carFrame = new JFrame("Cars"); // about page panel
		carFrame.setLayout(null);

		JLabel cheapLabel = new JLabel("$100");
		JLabel lowEndLabel = new JLabel("$200");
		JLabel mediumLabel = new JLabel("$300");
		JLabel highEndLabel = new JLabel("$400");
		JLabel premiumLabel = new JLabel("$1000");

		JButton cheapButton = new JButton(new ImageIcon(
				((new ImageIcon("cheap.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton lowEndButton = new JButton(new ImageIcon(
				((new ImageIcon("lowend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton mediumButton = new JButton(new ImageIcon(
				((new ImageIcon("medium.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton highEndButton = new JButton(new ImageIcon(
				((new ImageIcon("highend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton premiumButton = new JButton(new ImageIcon(
				((new ImageIcon("chiron.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		JButton backButton = new JButton("Back");
		JButton carViewerAboutButton = new JButton("JASIVA");

		//
		carViewerAboutButton.setForeground(Color.RED);
		carViewerAboutButton.setFont(new Font("Arial", Font.PLAIN, 70));
		carViewerAboutButton.setBounds(300, 20, 300, 75);

		// Label Bounds
		cheapLabel.setBounds(200, 180, 100, 100);
		lowEndLabel.setBounds(400, 180, 100, 100);
		mediumLabel.setBounds(600, 180, 100, 100);
		highEndLabel.setBounds(200, 380, 100, 100);
		premiumLabel.setBounds(400, 380, 100, 100);

		// Button Bounds
		cheapButton.setBounds(140, 90, 150, 130);
		lowEndButton.setBounds(340, 90, 150, 130);
		mediumButton.setBounds(540, 90, 150, 130);
		highEndButton.setBounds(140, 280, 150, 130);
		premiumButton.setBounds(340, 280, 150, 130);
		backButton.setBounds(100, 50, 200, 30);

		// adding components to frame and finalizing
		carFrame.add(backButton);
		carFrame.add(carViewerAboutButton);
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
		carFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// BOOKING FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		JFrame bookFrame = new JFrame("Booking"); // about page panel
		bookFrame.setLayout(null);
		
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

		pickupLabel.setBounds(310, 130, 130, 30);
		checkLabel.setFont(new Font("Arial", Font.PLAIN, 9));
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

		// adding components to frame and finalizing
		bookFrame.add(backButton);
		bookFrame.add(carViewerAboutButton);
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
		JFrame aboutFrame = new JFrame("About");
		aboutFrame.setLayout(null);

		JLabel aboutText = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JScrollPane aboutTextScroll = new JScrollPane(aboutText);// create scroll bar
		aboutTextScroll.setBounds(190, 100, 500, 300);

		// adding components to frame and finalizing
		aboutFrame.add(aboutText);
		aboutFrame.add(aboutTextScroll);
		aboutFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// CAR INFO FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JFrame carInfoFrame = new JFrame("Car Info");
		carInfoFrame.setLayout(null);
		carInfoFrame.setSize(900, 500);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// SELECTING WHICH FRAME TO USE
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		if (currentPanel.equals("Welcome")) {
			welcomeFrame.setVisible(true);
			loginFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
		}
		if (currentPanel.equals("Login")) {
			loginFrame.setVisible(true);
			welcomeFrame.setVisible(false);
			aboutFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
		}
		if (currentPanel.equals("About")) {
			aboutFrame.setVisible(true);
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			carFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
		}
		if (currentPanel.equals("Cars")) {
			carFrame.setVisible(true);
			aboutFrame.setVisible(false);
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			bookFrame.setVisible(false);
			carInfoFrame.setVisible(false);
		}
		if (currentPanel.equals("Book")) {
			bookFrame.setVisible(true);
			carFrame.setVisible(false);
			aboutFrame.setVisible(false);
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			carInfoFrame.setVisible(false);
		}
		if (currentPanel.equals("CarInfo")) {
			carInfoFrame.setVisible(true);
			carFrame.setVisible(false);
			aboutFrame.setVisible(false);
			loginFrame.setVisible(false);
			welcomeFrame.setVisible(false);
			bookFrame.setVisible(false);
		}
	}

	public void actionPerformed(ActionEvent evt) {
		
		String evtString = evt.getActionCommand();
		System.out.println("Pressed: "+evtString);
		if (evtString.equals("Sign in")) {
			boolean valid = false;
			if (usernames.size()==0) {
				//checks if it is a valid combination of user name and password
				if (!usernames.isEmpty() && usernames.indexOf(signInUsernameField.getText())==passwords.indexOf(new String(signInPasswordField.getPassword()))) { 															
					System.out.println("success");
					valid = true;
				}
			}
			if (valid == false) 
				System.out.println("Incorrect Username or Password");
			else {
				this.dispose();
				new GUI(c, "Cars");
			}
		}
		if (evtString.equals("Register")) { // create new account button 
			if (passwordChecker(new String(registerPasswordField.getPassword()), registerFirstNameField.getText()) == true) { // checks if password meets requirements
				//if the user name is not contained within the accumulated user name list
				if (usernames.isEmpty()) {
					//create user
					User user = new User(registerFirstNameField.getText(), registerLastNameField.getText(), registerUsernameField.getText(), new String(registerPasswordField.getPassword()));
					//Adds user to Inventory Handler for logging
					//c.Users.add(user); 
					usernames.add(registerUsernameField.getText());
					passwords.add(new String(registerPasswordField.getPassword()));

				}
				else if (!usernames.contains(registerUsernameField.getText())) {
					//create user
					User user = new User(registerFirstNameField.getText(), registerLastNameField.getText(), registerUsernameField.getText(), new String(registerPasswordField.getPassword()));
					
					//Adds user to Inventory Handler for logging
					//c.add(user); 
					usernames.add(registerUsernameField.getText());
					passwords.add(new String(registerPasswordField.getPassword()));
				}
				
				registerPasswordField.setText(""); 
				registerUsernameField.setText("");
				registerFirstNameField.setText(""); 
				registerLastNameField.setText("");
			} else {
				System.out.println("Invalid username or password");
				for (int i = 2; i < 4; i++) {
					//clear fields to ease re-trying
					registerPasswordField.setText(""); 
					registerUsernameField.setText("");
				}
			}
		}
		if (evtString.equals("Rent a Car")) {
			this.dispose();
			new GUI(c,"Login");
		}
	}

	public boolean passwordChecker(String password, String name1) {
		int check1 = 0; // check variable for password length
		int check2 = 0; // check variable for if there is a capital
		int check3 = 0; // check variable for if there is a number
		int check4 = 0; // check variable for if there is a special character
		int check5 = 0; // check variable for if name is contained in password
		boolean good = false;
		String name = name1.toLowerCase();
		while (good == false) { // loop that repeats until password is valid
			if (password.length() >= 8) { // checks length
				check1 = 1;
			}
			char[] pass = password.toCharArray(); // converts to char array to be able to do checks
			for (int i = 0; i < password.length(); i++) {
				if (isUpper(pass[i]) == true) { // checks for upper case
					check2 = 1;
				}
				if (containsNum(pass[i]) == true) { // checks for number
					check3 = 1;
				}
				if (containsSpecial(pass[i]) == true) { // checks for special character
					check4 = 1;
				}
			}
			if (password.contains(name) == false) { // checks for name
				check5 = 1;
			}
			if (check1 == 1 && check2 == 1 && check3 == 1 && check4 == 1 && check5 == 1) { // checks to see all
																							// parameters are completed
				good = true;// stops loop
				System.out.println("Valid Password");
				return true;
			}
			if (check1 == 0 || check2 == 0 || check3 == 0 || check4 == 0 || check5 == 0) { // checks if parameters are
																							// bad and reports the
																							// issues
				System.out.println("Invalid Password. Please Re-Enter.The issues are:");
				if (check1 == 0)
					System.out.println("Password is not long enough");
				if (check2 == 0)
					System.out.println("Password does not have an upper case");
				if (check3 == 0)
					System.out.println("Password does not have a number");
				if (check4 == 0)
					System.out.println("Password does not have a special character");
				if (check5 == 0)
					System.out.println("Password contains your name");
				return false;
			}
		}
		return false;
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
