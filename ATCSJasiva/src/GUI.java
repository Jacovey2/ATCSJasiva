import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame implements ActionListener {

	// Global variables
	private static String CurrentPanel = "Welcome";
	// (text fields in the way we are using them must be global variables)
	private JTextField signInUsernameField = new JTextField(10);
	private JTextField registerFirstNameField = new JTextField(10);
	private JTextField registerLastNameField = new JTextField(10);
	private JTextField registerUsernameField = new JTextField(10);
	private JPasswordField signInPasswordField = new JPasswordField(10);
	private JPasswordField registerPasswordField = new JPasswordField(10);
	
	//local user name and password storage
	private static ArrayList<String> usernames = new ArrayList<String>();
	private static ArrayList<String> passwords = new ArrayList<String>();
	
	//master inventory handler
	public static InventoryHandler IH;
	
	public static void main(String[] args) {
		IH = new InventoryHandler();//stays constant
		new GUI(IH, CurrentPanel);
	}

	public GUI(InventoryHandler c, String CurrentPanel) {
		// if instantiated with a specific state, it will use it, but defaults to
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

		// adding components to frame and finalizing
		loginFrame.add(signInPanel);
		loginFrame.add(registerPanel);
		loginFrame.add(existingUserLabel);
		loginFrame.add(registerLabel);
		loginFrame.add(signInButton);
		loginFrame.add(registerButton);
		loginFrame.setTitle("Login");
		loginFrame.setSize(900, 500);
		
		// button Setups
		signInButton.addActionListener(this);
		registerButton.addActionListener(this);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// WELCOME FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JFrame welcomeFrame = new JFrame("Welcome");
		welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		welcomeFrame.setLayout(null);

		// welcome frame setup
		JLabel missionLabel = new JLabel("Our Mission:");
		JLabel missionTextLabel = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JButton rentButton = new JButton("Rent a Car");
		JButton viewCarsButton = new JButton("See our Cars");
		JButton AboutButton = new JButton("JASIVA");
		JScrollPane missionTextScroll = new JScrollPane(missionTextLabel);
		
		// arranging on page
		missionLabel.setBounds(300, 140, 100, 50);
		missionTextScroll.setBounds(300, 150, 300, 70);
		rentButton.setBounds(500, 275, 150, 60);
		viewCarsButton.setBounds(250, 275, 150, 60);
		AboutButton.setBounds(300, 20, 300, 75);
		
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
		welcomeFrame.setTitle("Welcome page");
		welcomeFrame.setSize(900, 500);
		
		// activating buttons
		rentButton.addActionListener(this);
		viewCarsButton.addActionListener(this);
		AboutButton.addActionListener(this);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// CAR VIEWER FRAME
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JFrame carFrame = new JFrame("Cars"); 
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
		JButton backButton = new JButton("Back");
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
		
		//Changing button Action commands
		cheapButton.setActionCommand("cheapCar");
		lowEndButton.setActionCommand("lowEndCar");
		mediumButton.setActionCommand("mediumCar");
		highEndButton.setActionCommand("highEndCar");
		premiumButton.setActionCommand("premiumCar");
		
		// arranging components
		carViewerAboutButton.setBounds(300, 20, 300, 75);
		cheapLabel.setBounds(200, 180, 100, 100);
		lowEndLabel.setBounds(400, 180, 100, 100);
		mediumLabel.setBounds(600, 180, 100, 100);
		highEndLabel.setBounds(200, 380, 100, 100);
		premiumLabel.setBounds(400, 380, 100, 100);
		cheapButton.setBounds(140, 90, 150, 130);
		lowEndButton.setBounds(340, 90, 150, 130);
		mediumButton.setBounds(540, 90, 150, 130);
		highEndButton.setBounds(140, 280, 150, 130);
		premiumButton.setBounds(340, 280, 150, 130);
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
		JFrame bookFrame = new JFrame("Booking"); // about page panel
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

		// adding components to frame and finalizing
		//bookFrame.add(backButton);
		//bookFrame.add(carViewerAboutButton);
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

		// about frame setup
		JLabel aboutText = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JScrollPane aboutTextScroll = new JScrollPane(aboutText);// create scroll bar
		
		// arranging components
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
		// print out the command for debugging
		System.out.println("Pressed: "+evtString);
		
		// sign in to jasiva
		if (evtString.equals("Sign in")) {
			boolean valid = false;
			if (!usernames.isEmpty() && usernames.indexOf(signInUsernameField.getText())==passwords.indexOf(new String(signInPasswordField.getPassword()))) { 															
				System.out.println("success");
				valid = true;
			}
			if (valid == false) {
				System.out.println("Incorrect Username or Password");
				signInUsernameField.setText(""); 
				signInPasswordField.setText("");
			}
			else {
				this.dispose();
				new GUI(IH, "Cars");
			}
		}
		
		// register with jasiva
		if (evtString.equals("Register")) { 
			// checks if password meets requirements
			boolean validPassword = true;//passwordChecker(new String(registerPasswordField.getPassword()), registerFirstNameField.getText());
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
				// adds user names to local array lists for storage
				usernames.add(registerUsernameField.getText());
				passwords.add(new String(registerPasswordField.getPassword()));
				// clear the fields after registering successfully
				registerPasswordField.setText(""); 
				registerUsernameField.setText("");
				registerFirstNameField.setText(""); 
				registerLastNameField.setText("");
			}
		}
		if (evtString.equals("Rent a Car")) {
			this.dispose();
			new GUI(IH,"Login");
	
		}
		if (evtString.endsWith("Car")) {
			
			this.dispose();
			new GUI(IH,"Carinfo");
		}
	}

	public boolean passwordChecker(String password, String name1) {
		boolean length = false; // check variable for password length
		boolean capital = false; // check variable for if there is a capital
		boolean number = false; // check variable for if there is a number
		boolean charac = false; // check variable for if there is a special character
		boolean namecon = false; // check variable for if name is contained in password
		String name = name1.toLowerCase();
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
				System.out.println("Password is not long enough");
			if (!capital)
				System.out.println("Password does not have an upper case");
			if (!number)
				System.out.println("Password does not have a number");
			if (!charac)
				System.out.println("Password does not have a special character");
			if (!namecon)
				System.out.println("Password contains your name");
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