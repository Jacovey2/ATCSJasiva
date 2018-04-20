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
	
	//public InventoryHandler IH;
	
	public static void main (String[] args) {
		//IH = new InventoryHandler();//stays constant
		new GUI(new InventoryHandler());
		
	}
	
	public GUI(InventoryHandler c) {
		
		//IH.readFile();
		
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout); //makes the layout a spring layout
        //JPanel pan1 = new JPanel(new SpringLayout());

		String[] labels = {"Username: ", "Password: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		ArrayList<JTextField> text = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs; i++) { 
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    p.add(l);
		    if(i==1) {
			    JPasswordField textField = new JPasswordField(10);
			    text.add(textField);
			    l.setLabelFor(textField);
			    p.add(textField);
		    }else {
			    JTextField textField = new JTextField(10);
			    text.add(textField);
			    l.setLabelFor(textField);
			    p.add(textField);
		    }

		}

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p, //parent
                2,2,//rows, cols,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
		
		JLabel old = new JLabel("Existing Users"); //make new labels for both sections
		JLabel sign = new JLabel("New User");
		JButton enter = new JButton("Enter");
		JButton enter2 = new JButton(" Enter");
		
		String[] labels2 = {"First Name: ", "Last Name: ", "Username: ", "Password: "};
		int numPairs2 = labels2.length;

		//Create and populate the panel.
		JPanel p2 = new JPanel(new SpringLayout());
		ArrayList<JTextField> text2 = new ArrayList<JTextField>();
		for (int i = 0; i < numPairs2; i++) {
		    JLabel l = new JLabel(labels2[i], JLabel.TRAILING);
		    p2.add(l);
		    if(i==3) {
			    JPasswordField textField = new JPasswordField(10);
			    text2.add(textField);
			    l.setLabelFor(textField);
			    p2.add(textField);
		    }else {
			    JTextField textField = new JTextField(10);
			    text2.add(textField);
			    l.setLabelFor(textField);
			    p2.add(textField);
		    }
		}

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p2, //parent
               4,2,//rows, cols,
                3, 3,  //initX, initY
                3, 3); //xPad, yPad
		
		layout.putConstraint(SpringLayout.WEST, p2, //puts the two panels 40 pixels apart
                40,
                SpringLayout.EAST, p);
		layout.putConstraint(SpringLayout.NORTH, p2, //puts the second panel 75 pixels from the top
                75,
                SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, p, //puts the first panel 75 pixels from the top
                75,
                SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, p, //puts the first panel 75 pixels from the left screen
                75,
                SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.SOUTH, old, //puts the label panel above login info
                -5,
                SpringLayout.NORTH, p);
		layout.putConstraint(SpringLayout.SOUTH, sign, //puts other label above login info
                -5,
                SpringLayout.NORTH, p2);
		
		layout.putConstraint(SpringLayout.WEST, old, //positions labels horizontally
                40,
                SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.WEST, sign,
                80,
                SpringLayout.WEST, p2);
		
		layout.putConstraint(SpringLayout.NORTH, enter, //puts the label panel bellow login info
                5,
                SpringLayout.SOUTH, p);
		layout.putConstraint(SpringLayout.NORTH, enter2, //puts other label bellow login info
                5,
                SpringLayout.SOUTH, p2);
		
		layout.putConstraint(SpringLayout.WEST, enter, //positions labels horizontally
                100,
                SpringLayout.WEST, p);
		layout.putConstraint(SpringLayout.WEST, enter2,
                105,
                SpringLayout.WEST, p2);
		
		 // panels of window
		JPanel pan2 = new JPanel();
		JLabel Info = new JLabel("Our Mission: fgbergbraeig"); // list of all the labels and text fields
		JLabel About = new JLabel("About");
		//JScrollPane oth = new JScrollPane(num3);//create scrollbar
		JButton Rent = new JButton("Rent a Car"); 
		JButton Cars = new JButton("See our Cars");
		JButton AboutButton = new JButton("To About page");
		
		enter.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {
				if (text.get(0).getText().equals("john123")&& text.get(1).getText().equals("1234")) {
					System.out.println("success");		
					}else {
						System.out.println("Incorrect Username or Password");
					}
			}
		});
		
		enter2.addActionListener(new ActionListener() { // add objects to store
			public void actionPerformed(ActionEvent evt) {
				for(int i=0; i< c.Users.size(); i++) {
					if(text2.get(2).getText().equals(c.Users.get(i).getUsername()) || text2.get(3).getText().equals(c.Users.get(i).getPassword())){
						System.out.println("Invalid Username or Password");
					}
				}
				
				User user = new User(text2.get(0).getText(),text2.get(1).getText(),text2.get(2).getText(),text2.get(3).getText());
				c.add(user);
			}
		});
		
		//this.add(pan1); 
		this.add(p);
		this.add(p2);
		this.add(old);
		this.add(sign);
		this.add(enter);
		this.add(enter2);


		/*this.add(Info);
		this.add(About);
		this.add(AboutButton);
		this.add(Cars);
		this.add(Rent);
		*/
		this.setTitle("Button in Action");
		this.setSize(900, 375);
		this.setVisible(true);
	}
		/*add.addActionListener(new ActionListener() { // add objects to store
			public void actionPerformed(ActionEvent evt) {
				Item item = new Item(Integer.parseInt(loc2.getText()), Integer.parseInt(siz2.getText()),
						Double.parseDouble(pri2.getText()), num1.getText(), Integer.parseInt(inv2.getText()),
						Integer.parseInt(id2.getText()));
				store.add(item);
				list.setText("Current Items: " + store.findInventory());
			}
		});

		remove.addActionListener(new ActionListener() { // removes object from store
			public void actionPerformed(ActionEvent evt) {
				int i = store.findItembyName(num1.getText());
				store.remove(i);
				list.setText("Current Items: " + store.findInventory());
			}
		});

		find.addActionListener(new ActionListener() { // finds the information of a specific item
			public void actionPerformed(ActionEvent evt) {
				num3.setText(store.SInfo(num1.getText()));
			}
		});

		find2.addActionListener(new ActionListener() { // finds all in stock items
			public void actionPerformed(ActionEvent evt) {
				num3.setText(store.findInStock());
			}
		});

		info.addActionListener(new ActionListener() { // finds all info of all items
			public void actionPerformed(ActionEvent evt) {
				num3.setText(store.Info());
			}
		});

		find3.addActionListener(new ActionListener() { // finds out of stock items
			public void actionPerformed(ActionEvent evt) {
				num3.setText(store.findOutofStock());
			}
		});

		cl.addActionListener(new ActionListener() { // clears all txt fields
			public void actionPerformed(ActionEvent evt) {
				num1.setText("");
				//num2.setText("");
				num3.setText("");
				loc2.setText("");
				siz2.setText("");
				id2.setText("");
				pri2.setText("");
				id2.setText("");
				inv2.setText("");
			}
		});

		write.addActionListener(new ActionListener() { // write info to file
			public void actionPerformed(ActionEvent evt) {
				store.writeFile();
			}
		});

		ex.addActionListener(new ActionListener() { // quits program
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		*/

	
	
	/*import java.awt.Color;


public class WarehouseInterface extends JFrame implements ActionListener {
	private String State = "CustomerLogin";
	//Constants (Change for your system)
	static String DATABASENAME = "InventoryDatabase";
	static String DATABASEDIRECTORY = "/Users/jacovey/Documents/WarehouseProject/";
	//Login String
	public String loginStr;
	//text fields (must be globally accessible)
	private JTextField LoginStrTF;
	private JTextField NameField;
	private JTextField PPUField;
	private JTextField Location1Field;
	private JTextField Location2Field;
	//Inventory Handler (aka "Container")
	public static InventoryHandler IH;
	
	public WarehouseInterface (String state) {	
		//Defaults to customer login, but can be put into another mode by instantiating it with a state variable
		if (!state.equals("")) {
			State=state;
		}
		//Login Page
		if(State.equals("CustomerLogin")) {
			//Setup
			this.setLayout(new GridLayout(3,1));

			//Login Buttons
			JButton lo = new JButton("Login as Customer");
			JButton lom = new JButton("Switch to Manager login");
	    JButton ex = new JButton("Exit");
	    
	    //Listeners
	    lo.addActionListener(this);		 
	    lom.addActionListener(this);	
	    ex.addActionListener(this);
	    
	    //Adding all components to the GUI
	    this.add(lo);
	    this.add(lom);
	    this.add(ex); 
		}
		else if (State.equalsIgnoreCase("ManagerLogin")) {
			//Setup
			this.setLayout(new GridLayout(4,1));
			
			//Login Buttons
			JButton lo = new JButton("Login as Manager");
			JButton loc = new JButton("Switch to Customer login");
	    JButton ex = new JButton("Exit");
	    
	    //Listeners
	    lo.addActionListener(this);		  
	    loc.addActionListener(this);
	    ex.addActionListener(this);
	    
			//Panels
			JPanel pan1= new JPanel();
			
			//Login String Text Field
	    LoginStrTF = new JPasswordField(20);
	    LoginStrTF.setSize(100,100);
	    LoginStrTF.setEditable(true);
	    
	    //Adding all components to the GUI
	    this.add(pan1);
	    pan1.add(LoginStrTF);
	    this.add(lo);
	    this.add(loc);
	    this.add(ex); 
		}

		else if (State.equals("Manager")) {
			//Manger logins
			this.setLayout(new GridLayout(1,2));
			JPanel NavigationPanel = new JPanel();
			JPanel InterfacesPanel = new JPanel();
			JPanel AddingPanel = new JPanel();
			JPanel MovingPanel = new JPanel();
			JPanel ItemsPanel = new JPanel();
			
			//TopButtons
			JButton backToLogin = new JButton("Exit to menu");
			JButton quitOut = new JButton("Exit");
			backToLogin.addActionListener(this);
			quitOut.addActionListener(this);
			NavigationPanel.add(backToLogin);
			NavigationPanel.add(quitOut);
			
			//AddingFields
			JLabel NameFieldLabel =  new JLabel("Name:");
			NameField = new JTextField();
			JLabel PPUFieldLabel =  new JLabel("PPU:");
			PPUField = new JTextField();
			JButton Add = new JButton("Add");
			
			//MovingFields
			JLabel Loc1FieldLabel =  new JLabel("Location 1:");
			Location1Field = new JTextField();
			JLabel Loc2FieldLabel =  new JLabel("Location 2:");
			Location2Field = new JTextField();
			JButton Move = new JButton("Move");
			
			//Adding
			AddingPanel.setLayout(new GridLayout(7,1));
			AddingPanel.add(NameFieldLabel);
			AddingPanel.add(NameField);
			AddingPanel.add(PPUFieldLabel);
			AddingPanel.add(PPUField);
			Add.addActionListener(this);		  
			AddingPanel.add(Add);
			//Moving
			MovingPanel.setLayout(new GridLayout(5,1));
			MovingPanel.add(Loc1FieldLabel);
			MovingPanel.add(Location1Field);
			MovingPanel.add(Loc2FieldLabel);
			MovingPanel.add(Location2Field);
			Move.addActionListener(this);
			MovingPanel.add(Move);
			
			//Merging
			InterfacesPanel.setLayout(new GridLayout(3,1));
			InterfacesPanel.add(NavigationPanel);
			InterfacesPanel.add(AddingPanel);
			InterfacesPanel.add(MovingPanel);
			
			//Items
			ItemsPanel.setLayout(new BoxLayout(ItemsPanel,1));
			for (int i=0; i<IH.count(); i++) {
				JLabel tempLabel = new JLabel((i+1)+" - "+IH.getItemAt(i).toString());
				tempLabel.setBorder(BorderFactory.createLineBorder(Color.black));
				ItemsPanel.add(new JLabel((i+1)+" - "+IH.getItemAt(i).toString()));
			}
			//Borders
			InterfacesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			ItemsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			AddingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			MovingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			//Final Pasting
			this.add(InterfacesPanel);
			this.add(ItemsPanel);
		}
		else if (State.equals("Customer")) {
			this.setLayout(new GridLayout(3,1));
			//Top Panel
			JPanel topPanel = new JPanel();
			topPanel.setLayout(new GridLayout(2,1));
			topPanel.add(new JLabel("Ikea Warehouse", SwingConstants.CENTER));
			JPanel tableHeader= new JPanel();
			tableHeader.setLayout(new GridLayout(1,5));
			tableHeader.add(new JLabel("Name"));
			tableHeader.add(new JLabel("Price"));
			tableHeader.add(new JLabel("ID"));
			tableHeader.add(new JLabel("Location"));
			tableHeader.add(new JLabel("Buy Option"));
			topPanel.add(tableHeader);
			this.add(topPanel);
			JPanel bottomPanels = new JPanel();
			bottomPanels.setLayout(new GridLayout(1,2));
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(new BoxLayout(bottomPanel,1));
			//List of items (long grid layout)
			for (int i=0; i<IH.count(); i++) {
				JPanel tempPanel = new JPanel();
				tempPanel.setLayout(new GridLayout(1,5));
				tempPanel.add(new JLabel(IH.getItemAt(i).iD+""));
				tempPanel.add(new JLabel(IH.getItemAt(i).name));
				tempPanel.add(new JLabel(IH.getItemAt(i).location+""));
				tempPanel.add(new JLabel(IH.getItemAt(i).PPU+""));
				JButton tempButton = new JButton ("Buy "+IH.getItemAt(i).name);
				tempButton.addActionListener(this);
				tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				tempPanel.add(tempButton);
				bottomPanel.add(tempPanel);
			}
			bottomPanels.add(bottomPanel);
			this.add(bottomPanels);
			
			//Exit button
			JButton menuExit = new JButton("Exit to menu");
			menuExit.addActionListener(this);
			this.add(menuExit);
		}
		//Window Setup Final
		this.setTitle("Warehouse Interface");
    this.setSize(500, 500);                      
    this.setVisible(true);	
	}
	
	public static void main (String[] args) {
		new WarehouseInterface("");
		IH = new InventoryHandler();//stays constant
	}
	
	public void actionPerformed(ActionEvent e) {
    String str = e.getActionCommand();	    
 
    if(str.equals("Login as Customer")) {//Customer Login
  			this.dispose();
  			IH.loadInventory(DATABASENAME, DATABASEDIRECTORY);
    		new WarehouseInterface("Customer");
    } 
    else if (str.equals("Switch to Manager login")) {//Switch to Manager Login 
    		this.dispose();
    		new WarehouseInterface("ManagerLogin");
    }
    else if (str.equals("Login as Manager")) {
    		if (LoginStrTF.getText().equals("password123")) {//Very secure password
	  			this.dispose();
	  			IH.loadInventory(DATABASENAME, DATABASEDIRECTORY);
	    		new WarehouseInterface("Manager");
    		}
    }
    else if (str.equals("Switch to Customer login")) {//Switch to Customer Login 
  		this.dispose();
    		new WarehouseInterface("CustomerLogin");
    }
    else if (str.equals("Add")) { //Manager Add Button 
    		IH.addItem(NameField.getText(),Double.parseDouble(PPUField.getText()));
    		this.dispose();
    		new WarehouseInterface("Manager");
    }
    else if(str.equals("Move")) { //Manager Move Button 
    		IH.forklift(Integer.parseInt(Location1Field.getText()), Integer.parseInt(Location2Field.getText()));
    		this.dispose();
    		new WarehouseInterface("Manager");
    }
    else if(str.equals("Exit to menu")) { //Exit to Menu Button 
    		IH.saveInventory(DATABASENAME, DATABASEDIRECTORY);
    		this.dispose();
    		new WarehouseInterface("CustomerLogin");
    }  
    else if(str.startsWith("Buy")) {//Buying Button(s?)
    		IH.removeItem(str.substring(4));
    		this.dispose();
    		new WarehouseInterface("Customer");
    }
    else if(str.equals("Exit")) {//Exit App Button
    		IH.saveInventory(DATABASENAME, DATABASEDIRECTORY);
    		System.exit(0);
    }  
  }
}
*/
}
