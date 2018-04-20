import java.util.ArrayList;

public class InventoryHandler {
	public ArrayList<Reservation> Reservations;
	public ArrayList<Car> Cars;
	public ArrayList<User> Users;
	
	public InventoryHandler() {
		Users = new ArrayList<User>();
		Cars = new ArrayList<Car>();
		Reservations = new ArrayList<Reservation>();
				}
	
	public boolean addReservation(Car car, Location location, TimeSlot timeSlot, User user) {
		boolean valid=true;
		for (Reservation r:Reservations) {
			if(true){
				
			}
		}
		
		return true;
	}
	public void add(User c) { // adds to array list
		Users.add(c);
	}
	
	public void Info() { // gives all of the information of all the items in the store
		ArrayList<String> out = new ArrayList<String>();
		for (User c : Users) {
			out.add(c.getFirstName()) ;
			out.add(c.getLastName());
			out.add(c.getPassword());
			out.add(c.getUsername());
		}
	}
}