import java.util.ArrayList;

public class InventoryHandler {
	public ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
	public ArrayList<Car> Cars = new ArrayList<Car>();
	public ArrayList<User> Users = new ArrayList<User>();
	public User CurrentUser;

	public InventoryHandler() {
		Users = new ArrayList<User>();
		Cars = new ArrayList<Car>();
		Reservations = new ArrayList<Reservation>();
	}

	public boolean addReservation(Car car, Location location, TimeSlot timeSlot, User user) {
		boolean valid = true;
		for (Reservation r : Reservations) {
			if (r.getTimeSlot().Conflict(timeSlot))
				valid = false;
		}
		/*if (!location.Cars.contains(car))
			valid = false;*///Will not be commented in final version, but without manager login there will never be cars at any location
		Reservations.add(new Reservation(timeSlot, car, user));
		// temporary printing out of reservations
		if (valid)
			for (Reservation r : Reservations)
				System.out.println(r.toString());

		return valid;
	}

	public void add(User c) { // adds to array list
		Users.add(c);
	}

	public ArrayList<String> getUsernames() {
		ArrayList<String> tempArray = new ArrayList<String>();
		for (User u : Users) {
			tempArray.add(u.getUsername());
		}
		return tempArray;
	}

	public ArrayList<String> getPasswords() {
		ArrayList<String> tempArray = new ArrayList<String>();
		for (User u : Users) {
			tempArray.add(u.getPassword());
		}
		return tempArray;
	}

	public void Info() { // gives all of the information of all the items in the store
		ArrayList<String> out = new ArrayList<String>();
		for (User c : Users) {
			out.add(c.getFirstName());
			out.add(c.getLastName());
			out.add(c.getPassword());
			out.add(c.getUsername());
		}
	}
}