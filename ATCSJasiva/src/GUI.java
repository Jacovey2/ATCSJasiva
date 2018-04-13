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
}
