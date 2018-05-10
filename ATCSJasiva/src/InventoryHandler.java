import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryHandler {
	public ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
	public ArrayList<Car> Cars = new ArrayList<Car>();
	public ArrayList<User> Users = new ArrayList<User>();
	public User CurrentUser;

	public InventoryHandler() {
		Users = new ArrayList<User>();
		Cars = new ArrayList<Car>();
		Reservations = new ArrayList<Reservation>();
		Cars = new ArrayList<Car>();
	}

	public void saveInformation() throws IOException {
		File reservationFile;
		File carFile;
		File usersFile;
		reservationFile = new File("reservations.txt");
		carFile = new File("cars.txt");
		usersFile = new File("users.txt");

		// Write Reservations to file
		FileWriter rFileWrite = new FileWriter(reservationFile);
		for (Reservation r : Reservations) {
			rFileWrite.write(r.toString() + "\n");
		}
		rFileWrite.close();

		// Write Cars
		FileWriter cFileWrite = new FileWriter(carFile);
		for (Car c : Cars) {
			cFileWrite.write(c.toString() + "\n");
		}
		cFileWrite.close();

		// Write users to file
		FileWriter uFileWrite = new FileWriter(usersFile);
		for (User u : Users) {
			uFileWrite.write(u.toString() +"\n");
		}
		uFileWrite.close();
	}

	public void loadInformation() throws FileNotFoundException {
		// read reservations in
		File reservationFile = new File("reservations.txt");
		Scanner rScanner = new Scanner(reservationFile);
		rScanner.useDelimiter("/|\\n");
		while (rScanner.hasNext()) {
			// creating timeslot from line
			int startMonth = rScanner.nextInt();
			int startDay = rScanner.nextInt();
			int startYear = rScanner.nextInt();
			int startTime = rScanner.nextInt();
			int endMonth = rScanner.nextInt();
			int endDay = rScanner.nextInt();
			int endYear = rScanner.nextInt();
			int endTime = rScanner.nextInt();
			TimeSlot ts = new TimeSlot(startMonth, startDay, startYear, startTime, endMonth, endDay, endYear, endTime);

			// Creating car from line
			String model = rScanner.next();
			Location location = new Location(rScanner.next());
			int mpg = rScanner.nextInt();
			int capacity = rScanner.nextInt();
			double pricePerHour = rScanner.nextDouble();
			Car car = new Car(mpg, capacity, model, location, pricePerHour);

			// creating user from line
			String firstName = rScanner.next();
			String lastName = rScanner.next();
			String username = rScanner.next();
			;
			String password = rScanner.next();
			;
			User user = new User(firstName, lastName, username, password);

			// Creating Reservation from read data
			Reservations.add(new Reservation(ts, car, user));
		}
		rScanner.close();

		// read cars
		File carFile = new File("cars.txt");
		Scanner cScanner = new Scanner(carFile);
		cScanner.useDelimiter("/|\\n"); // notation for "use both / and \n as delimiters"
		while (cScanner.hasNext()) {
			// Creating car from line
			String model = cScanner.next();
			Location location = new Location(cScanner.next());
			int mpg = cScanner.nextInt();
			int capacity = cScanner.nextInt();
			double pricePerHour = cScanner.nextDouble();
			// adding car to list
			Cars.add(new Car(mpg, capacity, model, location, pricePerHour));
		}
		cScanner.close();

		// read in users
		File usersFile = new File("users.txt");
		Scanner uScanner = new Scanner(usersFile);
		uScanner.useDelimiter("/|\\n");
		while (uScanner.hasNext()) {
			// creating user from line
			String firstName = uScanner.next();
			String lastName = uScanner.next();
			String username = uScanner.next();
			String password = uScanner.next();
			// adding user to list
			Users.add(new User(firstName, lastName, username, password));
		}
		uScanner.close();
	}

	public double addReservation(Car car, Location loc1, Location loc2, TimeSlot timeSlot, User user) {
		int numValidCars = 0; 
		int numInvalidCars =0;
		for (Car c : Cars) //Seems to work -NEED TO TEST
			if (c.location.toString().equals(loc1.toString()) && c.model.equals(car.model))
				numValidCars++;

		for (Reservation r : Reservations) {
			if (r.getCar().Equals(car) && r.getTimeSlot().Conflict(timeSlot)) 
				numInvalidCars++;
		}


		if (numValidCars-numInvalidCars>0) {
			Reservations.add(new Reservation(timeSlot, car, user));
			double durationDiscountRate = 0.15 / 30;
			double maxDiscount = 0.5;
			double durationInHours = timeSlot.getDuration() / 60;
			double x = durationInHours;
			double r = durationDiscountRate;
			double mD = maxDiscount;
			double gx = x * r;
			double fx = ((2 * mD) / (1 + Math.pow(Math.E, -4 * gx))) - mD;// sigmoid curve (sigmoid curve has default
																			// derivative of 1/4 at 0, thus multiplying
																			// by 4 to counteract)
			double dx = 1 - fx;
			double price = car.pricePerHour * x * dx;// TODO: add multiple location pricing
			price += loc1.distanceFrom(loc2) * 0.5;
			return price;
		} else {
			return -1;
		}
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

	public ArrayList<String> getLocations() {
		ArrayList<String> tempArray = new ArrayList<String>();
		for (Car c : Cars) {
			tempArray.add(c.location.toString());
		}
		return Collapse(tempArray);
	}

	public ArrayList<String> Collapse(ArrayList<String> arrayList) {
		ArrayList<String> tempString = new ArrayList<String>();
		for (String S : arrayList)
			if (!tempString.contains(S))
				tempString.add(S);
		return tempString;
	}

	public String[] getLocationsArray() {
		String[] list = new String[Cars.size()];
		for (int i = 0; i < Cars.size(); i++) {
			list[i] = Cars.get(i).location.toString();
		}
		return list;
	}

	public String getReservationsString() {
		String list = "";
		int counter = 1;
		for (Reservation c : Reservations) {
			list += "(" + counter + ") " + c.toNiceString() + "\n";
			counter++;
		}
		return list;
	}

	public String getCarsString() {
		String list = "";
		int counter = 1;
		for (Car c : Cars) {
			list += "(" + counter + ") " + c.toNiceString() + "\n";
			counter++;

		}
		return list;
	}

	public String getUsersString() {
		String list = "";
		int counter = 1;
		for (User u : Users) {
			list += "(" + counter + ") " + u.toNiceString() + "\n";
			counter++;
		}
		return list;
	}

	public String getLocationsString() {
		String list = "";
		int counter = 1;
		for (String l : this.getLocations()) {
			list += "(" + counter + ") " + l + "\n";
			counter++;
		}
		return list;
	}
}