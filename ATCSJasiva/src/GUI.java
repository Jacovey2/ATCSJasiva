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

public class GUI extends JFrame {

	// public InventoryHandler IH;

	public static void main(String[] args) {
		// IH = new InventoryHandler();//stays constant
		new GUI(new InventoryHandler());

	}

	public GUI(InventoryHandler c) {

		// IH.readFile();
		String panel = "About"; // state string that determines which window is open
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout); // makes the layout a spring layout
		JFrame welcome = new JFrame("welcome page"); // weclome page panel
		welcome.setLayout(null);
		JFrame about = new JFrame("about page"); // about page panel
		about.setLayout(null);
		JFrame Car = new JFrame("Cars"); // about page panel
		Car.setLayout(null);
		JFrame CarInfo = new JFrame("Car Info"); // about page panel
		CarInfo.setLayout(null);
		JFrame Book = new JFrame("Booking"); // about page panel
		Book.setLayout(null);

		String[] labels = { "Username: ", "Password: " }; // labels for login page
		int numPairs = labels.length;

		// Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		ArrayList<JTextField> text = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			if (i == 1) { // makes the second textfield and password field
				JPasswordField textField = new JPasswordField(10);
				text.add(textField);
				l.setLabelFor(textField);
				p.add(textField);
			} else {
				JTextField textField = new JTextField(10);
				text.add(textField);
				l.setLabelFor(textField);
				p.add(textField);
			}
		}

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(p, // parent
				2, 2, // rows, cols,
				3, 3, // initX, initY
				3, 3); // xPad, yPad

		String[] labels2 = { "First Name: ", "Last Name: ", "Username: ", "Password: " };
		int numPairs2 = labels2.length;

		// Create and populate the panel.
		JPanel p2 = new JPanel(new SpringLayout());
		ArrayList<JTextField> text2 = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs2; i++) {
			JLabel l = new JLabel(labels2[i], JLabel.TRAILING);
			p2.add(l);
			if (i == 3) { // makes the last field a password field
				JPasswordField textField = new JPasswordField(10);
				text2.add(textField);
				l.setLabelFor(textField);
				p2.add(textField);
			} else {
				JTextField textField = new JTextField(10);
				text2.add(textField);
				l.setLabelFor(textField);
				p2.add(textField);
			}
		}

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(p2, // parent
				4, 2, // rows, cols,
				3, 3, // initX, initY
				3, 3); // xPad, yPad
		//sign up window buttons
		JLabel old = new JLabel("Existing Users"); // make new labels for both sections
		JLabel sign = new JLabel("New User");
		JButton enter = new JButton("Enter");
		JButton enter2 = new JButton(" Enter");

		layout.putConstraint(SpringLayout.WEST, p2, // puts the two panels 40 pixels apart
				40, SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.NORTH, p2, // puts the second panel 75 pixels from the top
				100, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.NORTH, p, // puts the first panel 75 pixels from the top
				100, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, p, // puts the first panel 75 pixels from the left screen
				200, SpringLayout.EAST, this);

		layout.putConstraint(SpringLayout.SOUTH, old, // puts the label panel above login info
				-5, SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.SOUTH, sign, // puts other label above login info
				-5, SpringLayout.NORTH, p2);

		layout.putConstraint(SpringLayout.WEST, old, // positions labels horizontally
				40, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.WEST, sign, 80, SpringLayout.WEST, p2);

		layout.putConstraint(SpringLayout.NORTH, enter, // puts the label panel bellow login info
				5, SpringLayout.SOUTH, p);
		layout.putConstraint(SpringLayout.NORTH, enter2, // puts other label bellow login info
				5, SpringLayout.SOUTH, p2);

		layout.putConstraint(SpringLayout.WEST, enter, // positions labels horizontally
				100, SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.WEST, enter2, 105, SpringLayout.WEST, p2);

		// panels of welcome window
		JLabel Info = new JLabel("Our Mission:"); // list of all the labels and text fields
		Info.setBounds(300, 140, 100, 50);
		JLabel Info2 = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JScrollPane oth = new JScrollPane(Info2);//create scrollbar
		oth.setBounds(300, 150, 300, 70);
		JButton Rent = new JButton("Rent a Car");
		Rent.setBounds(500, 275, 150, 60);
		JButton Cars = new JButton("See our Cars");
		Cars.setBounds(250, 275 ,150, 60);
		JButton AboutButton = new JButton("JASIVA");
		AboutButton.setForeground(Color.RED);
		AboutButton.setFont(new Font("Arial", Font.PLAIN, 70));
		AboutButton.setBounds(300, 20, 300, 75);

		//car viewer button/labels
		JButton back = new JButton("Back");
		back.setBounds(100, 50, 200, 30);
		JButton AboutButton2 = new JButton("JASIVA");
		AboutButton2.setForeground(Color.RED);
		AboutButton2.setFont(new Font("Arial", Font.PLAIN, 70));
		AboutButton2.setBounds(300, 20, 300, 75);
		JLabel cheap = new JLabel("$100");
		cheap.setBounds(200, 180, 100, 100);
		JButton cheap2 = new JButton(new ImageIcon(((new ImageIcon("cheap.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		cheap2.setBounds(140, 90, 150, 130);
		JLabel lowEnd = new JLabel("$200");
		lowEnd.setBounds(400, 180, 100, 100);
		JButton lowEnd2 = new JButton(new ImageIcon(((new ImageIcon("lowend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		lowEnd2.setBounds(340, 90, 150, 130);
		JLabel medium = new JLabel("$300");
		medium.setBounds(600, 180, 100, 100);
		JButton medium2 = new JButton(new ImageIcon(((new ImageIcon("medium.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		medium2.setBounds(540, 90, 150, 130);
		JLabel highEnd = new JLabel("$400");
		highEnd.setBounds(200, 380, 100, 100);
		JButton highEnd2 = new JButton(new ImageIcon(((new ImageIcon("highend.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		highEnd2.setBounds(140, 280, 150, 130);
		JLabel premium = new JLabel("$1000");
		premium.setBounds(400, 380, 100, 100);
		JButton premium2 = new JButton(new ImageIcon(((new ImageIcon("chiron.jpg")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		premium2.setBounds(340, 280, 150, 130);
		
		//booking buttons/lables
		JLabel pickup = new JLabel("From/Pickup:");
		pickup.setBounds(310, 130, 130, 30);
		JTextField pickup2 = new JTextField("");
		pickup2.setBounds(395, 130, 130, 30);
		JLabel check = new JLabel("Pickup is the same as drop-off");
		check.setFont(new Font("Arial", Font.PLAIN, 9));
		check.setBounds(370, 155, 170, 30);
		JCheckBox check2 = new JCheckBox();
		check2.setBounds(495, 157, 25, 25);
		JLabel drop = new JLabel("To/Drop-Off:");
		drop.setBounds(310, 180, 130, 30);
		JTextField drop2 = new JTextField("");
		drop2.setBounds(395, 180, 130, 30);
		JLabel start = new JLabel("Start time:");
		start.setBounds(310, 210, 130, 30);
		JTextField start2 = new JTextField("");
		start2.setBounds(395, 210, 130, 30);
		JLabel end = new JLabel("End time:");
		end.setBounds(310, 240, 130, 30);
		JTextField end2 = new JTextField("");
		end2.setBounds(395, 240, 130, 30);
		JButton go = new JButton("Pick a Car!");
		go.setBounds(370, 300, 150, 70);
		
		//about page buttons/labels
		JLabel aboutText = new JLabel("wejfoqregerkgheroughkdsfhaejgferg");
		JScrollPane aboutText2 = new JScrollPane(aboutText);//create scrollbar
		aboutText2.setBounds(190, 100, 500, 300);
		
		//button commands
		enter.addActionListener(new ActionListener() { // sign in button
			public void actionPerformed(ActionEvent evt) {
				boolean valid = false;
				for (int i = 0; i < c.Users.size(); i++) {
					if (text.get(0).getText().equals(c.Users.get(i).getUsername())
							&& text.get(1).getText().equals(c.Users.get(i).getPassword())) { // checks to see if
																								// username and password
																								// corresponf
						System.out.println("success");
						valid = true;
					}
				}
				if (valid == false) {
					System.out.println("Incorrect Username or Password");
				}
				for (int i = 0; i < 2; i++) {
					text.get(i).setText(""); // clears info if it is not valid
				}
			}
		});

		enter2.addActionListener(new ActionListener() { // create new account button
			public void actionPerformed(ActionEvent evt) {
				boolean valid = false;
				if (passwordChecker(text2.get(3).getText(), text2.get(0).getText()) == true) { //checks if password meets criteria
					for (int i = 0; i < c.Users.size(); i++) {
						if (text2.get(2).getText().equals(c.Users.get(i).getUsername())
								|| text2.get(3).getText().equals(c.Users.get(i).getPassword())) { // checks if username and password are used																	// and password are valid																// already used
							valid = true;
						}
					}
					if (valid == false) {
						User user = new User(text2.get(0).getText(), text2.get(1).getText(), text2.get(2).getText(),
								text2.get(3).getText()); // creates new user
						c.add(user); // adds user to arraylist
						for (int i = 0; i < 4; i++) {
							text2.get(i).setText(""); // clears all text fields
						}
					}
				} else {
					System.out.println("Invalid username or password");
					for (int i = 2; i < 4; i++) {
						text2.get(i).setText(""); // if sign up is invalid, only the username and password feilds get
													// cleard to make it easier to try again
					}
				}
			}
		});

		Rent.addActionListener(new ActionListener() { // rent button (should redirect to sign in page)
			public void actionPerformed(ActionEvent evt) {

			}
		});

		// adding items to frames
		this.add(p);
		this.add(p2);
		this.add(old);
		this.add(sign);
		this.add(enter);
		this.add(enter2);
		this.setTitle("Button in Action");
		this.setSize(900, 500);
		
		welcome.setContentPane(new JLabel(new ImageIcon("backround.jpeg")));
		welcome.add(Rent);
		welcome.add(Cars);
		welcome.add(AboutButton);
		welcome.add(Info);
		welcome.add(oth);
		welcome.setTitle("Welcome page");
		welcome.setSize(900, 500);
		
		Car.add(back);
		Car.add(AboutButton2);
		Car.add(cheap);
		Car.add(cheap2);
		Car.add(lowEnd);
		Car.add(lowEnd2);
		Car.add(medium);
		Car.add(medium2);
		Car.add(highEnd);
		Car.add(highEnd2);
		Car.add(premium);
		Car.add(premium2);
		Car.setSize(900, 500);
		
		Book.add(back);
		Book.add(AboutButton2);
		Book.add(pickup);
		Book.add(pickup2);
		Book.add(check);
		Book.add(check2);
		Book.add(drop);
		Book.add(drop2);
		Book.add(start);
		Book.add(start2);
		Book.add(end);
		Book.add(end2);
		Book.add(go);
		Book.setSize(900, 500);
		
		about.add(AboutButton2);
		about.add(aboutText2);
		about.setSize(900, 500);
		
		CarInfo.setSize(900, 500);
		

		if (panel.equals("welcome")) { // selects which panel to show
			welcome.setVisible(true);
			this.setVisible(false);
			about.setVisible(false);
			Car.setVisible(false);
			Book.setVisible(false);
			CarInfo.setVisible(false);
		}
		if (panel.equals("signIn")) {
			this.setVisible(true);
			welcome.setVisible(false);
			about.setVisible(false);
			Car.setVisible(false);
			Book.setVisible(false);
			CarInfo.setVisible(false);
		}
		if (panel.equals("About")) {
			about.setVisible(true);
			this.setVisible(false);
			welcome.setVisible(false);
			Car.setVisible(false);
			Book.setVisible(false);
			CarInfo.setVisible(false);
		}
		if (panel.equals("Car")) {
			Car.setVisible(true);
			about.setVisible(false);
			this.setVisible(false);
			welcome.setVisible(false);
			Book.setVisible(false);
			CarInfo.setVisible(false);
		}
		if (panel.equals("Book")) {
			Book.setVisible(true);
			Car.setVisible(false);
			about.setVisible(false);
			this.setVisible(false);
			welcome.setVisible(false);
			CarInfo.setVisible(false);
		}
		if (panel.equals("CarInfo")) {
			CarInfo.setVisible(true);
			Car.setVisible(false);
			about.setVisible(false);
			this.setVisible(false);
			welcome.setVisible(false);
			Book.setVisible(false);
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

	static boolean isUpper(char c) { // methods check characters against ascii library to determine if
										// upper/num/special
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
