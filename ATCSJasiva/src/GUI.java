import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

		SpringLayout layout = new SpringLayout();
		this.setLayout(layout); // makes the layout a spring layout
		// JPanel pan1 = new JPanel(new SpringLayout());

		String[] labels = { "Username: ", "Password: " };
		int numPairs = labels.length;

		// Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		ArrayList<JTextField> text = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			if (i == 1) {
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

		JLabel old = new JLabel("Existing Users"); // make new labels for both sections
		JLabel sign = new JLabel("New User");
		JButton enter = new JButton("Enter");
		JButton enter2 = new JButton(" Enter");

		String[] labels2 = { "First Name: ", "Last Name: ", "Username: ", "Password: " };
		int numPairs2 = labels2.length;

		// Create and populate the panel.
		JPanel p2 = new JPanel(new SpringLayout());
		ArrayList<JTextField> text2 = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs2; i++) {
			JLabel l = new JLabel(labels2[i], JLabel.TRAILING);
			p2.add(l);
			if (i == 3) {
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

		layout.putConstraint(SpringLayout.WEST, p2, // puts the two panels 40 pixels apart
				40, SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.NORTH, p2, // puts the second panel 75 pixels from the top
				75, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.NORTH, p, // puts the first panel 75 pixels from the top
				75, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, p, // puts the first panel 75 pixels from the left screen
				75, SpringLayout.EAST, this);

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

		// panels of window
		JPanel pan2 = new JPanel();
		JLabel Info = new JLabel("Our Mission: fgbergbraeig"); // list of all the labels and text fields
		JLabel About = new JLabel("About");
		// JScrollPane oth = new JScrollPane(num3);//create scrollbar
		JButton Rent = new JButton("Rent a Car");
		JButton Cars = new JButton("See our Cars");
		JButton AboutButton = new JButton("To About page");

		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean valid = false;
				for (int i = 0; i < c.Users.size(); i++) {
					if (text.get(0).getText().equals(c.Users.get(i).getUsername())
							&& text.get(1).getText().equals(c.Users.get(i).getPassword())) {
						System.out.println("success");
						valid = true;
					}
				}
				if (valid == false) {
					System.out.println("Incorrect Username or Password");
				}
				for (int i = 0; i < 2; i++) {
					text.get(i).setText("");
				}
			}
		});

		enter2.addActionListener(new ActionListener() { // add objects to store
			public void actionPerformed(ActionEvent evt) {
				boolean invalid = false;
				for (int i = 0; i < c.Users.size(); i++) {
					if (text2.get(2).getText().equals(c.Users.get(i).getUsername())
							|| text2.get(3).getText().equals(c.Users.get(i).getPassword())) {
						invalid = true;
					}
				}
				if (invalid == false) {
					User user = new User(text2.get(0).getText(), text2.get(1).getText(), text2.get(2).getText(),
							text2.get(3).getText());
					c.add(user);
					for (int i = 0; i < 4; i++) {
						text2.get(i).setText("");
					}
				} else {
					System.out.println("Invalid username or password");
					for (int i = 2; i < 4; i++) {
						text2.get(i).setText("");
					}
				}
			}
		});

		// this.add(pan1);
		this.add(p);
		this.add(p2);
		this.add(old);
		this.add(sign);
		this.add(enter);
		this.add(enter2);

		this.setTitle("Button in Action");
		this.setSize(900, 375);
		this.setVisible(true);

		/*
		 * this.add(Info); this.add(About); this.add(AboutButton); this.add(Cars);
		 * this.add(Rent);
		 */

	}
}
