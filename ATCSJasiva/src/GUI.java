import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
	//Container store;

	public GUI(Container c) {
		//store = c;
		//store.readFile();
		JPanel pan1 = new JPanel(); // panels of window
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		pan1.setLayout(new GridLayout(5, 1));
		pan2.setLayout(new GridLayout(3, 3));
		pan3.setLayout(new GridLayout(5, 1));
		this.setLayout(new GridLayout());
		JLabel list = new JLabel("Current Items:"); // list of all the labels and text fields
		list.setText("Current Items: " + store.findInventory());
		JTextField item = new JTextField(5);
		item.setSize(300, 300);
		JLabel lab1 = new JLabel("Enter Object Name:");
		JTextField num1 = new JTextField(5);
		num1.setSize(300, 300);
		//JLabel lab2 = new JLabel("Search for Item"); //realized button was unnecesary so I commented it out
		//JTextField num2 = new JTextField(5);
		//num2.setSize(300, 300);
		JLabel lab3 = new JLabel("Result");
		JTextArea num3 = new JTextArea(" ",20,1);
		JScrollPane oth = new JScrollPane(num3);//create scrollbar
		num3.setSize(400, 600);

		JLabel loc = new JLabel("        Location:"); // text fields and labels for other info
		JTextField loc2 = new JTextField(5);
		loc2.setSize(300, 300);
		JLabel siz = new JLabel("         Size:");
		JTextField siz2 = new JTextField(5);
		siz2.setSize(300, 300);
		JLabel id = new JLabel("          ID: ");
		JTextField id2 = new JTextField(5);
		id2.setSize(300, 300);
		JLabel pri = new JLabel("         Price:");
		JTextField pri2 = new JTextField(5);
		pri2.setSize(300, 5);
		JLabel inv = new JLabel("         Inventory: ");
		JTextField inv2 = new JTextField(5);
		inv2.setSize(300, 300);

		JButton add = new JButton("Add Object"); // all the buttons
		JButton remove = new JButton("Remove Object");
		JButton ex = new JButton("Exit");
		JButton find = new JButton("Search");
		JButton find2 = new JButton("In Stock");
		JButton find3 = new JButton("Out Of Stock");
		JButton info = new JButton("Items info");
		JButton cl = new JButton("Clear");
		JButton write = new JButton("Save");//write to file

		add.addActionListener(new ActionListener() { // add objects to store
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

		this.add(pan1); //adding panels to interface
		this.add(pan3);
		this.add(pan2);

		pan1.add(list);
		pan1.add(lab1);
		pan1.add(num1);
		//pan1.add(lab2);
		//pan1.add(num2);
		pan1.add(lab3);
		//pan1.add(num3); create scrollbar instead
		pan1.add(oth);

		pan2.add(add);
		pan2.add(remove);
		pan2.add(find);
		pan2.add(find2);
		pan2.add(find3);
		pan2.add(info);
		pan2.add(write);
		pan2.add(cl);
		pan2.add(ex);

		pan3.add(loc);
		pan3.add(loc2);
		pan3.add(siz);
		pan3.add(siz2);
		pan3.add(id);
		pan3.add(id2);
		pan3.add(pri);
		pan3.add(pri2);
		pan3.add(inv);
		pan3.add(inv2);

		this.setTitle("Button in Action");
		this.setSize(900, 375);
		this.setVisible(true);
	}
	/*import java.awt.Color;
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
