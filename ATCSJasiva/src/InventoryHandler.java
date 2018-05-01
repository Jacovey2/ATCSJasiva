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
	}

	public void saveInformation() throws IOException {
		// Write Reservations to file
		File reservationFile = new File("reservations.txt");
		FileWriter rFileWrite = new FileWriter(reservationFile);
		for (Reservation r : Reservations) {
			String tempString = r.getTimeSlot().toString();

			System.out.println(tempString);
			rFileWrite.write(tempString);
		}
		rFileWrite.close();

		// Write Cars
		File carFile = new File("cars.txt");
		FileWriter cFileWrite = new FileWriter(carFile);
		for (Car c : Cars) {
			cFileWrite.write(c.toString());
		}
		cFileWrite.close();

		// Write users to file
		File usersFile = new File("users.txt");
		FileWriter uFileWrite = new FileWriter(usersFile);
		for (User u : Users) {
			uFileWrite.write(u.toString());
		}
		uFileWrite.close();
	}

	public void loadInformation() throws FileNotFoundException {
		// read reservations in
		File reservationFile = new File("reservations.txt");
		Scanner rScanner = new Scanner(reservationFile);
		rScanner.useDelimiter("/");
		while (rScanner.hasNextLine()) {
			//creating timeslot from line
			int startMonth = rScanner.nextInt();
			int startDay = rScanner.nextInt();
			int startYear = rScanner.nextInt();
			int startTime = rScanner.nextInt();
			int endMonth = rScanner.nextInt();
			int endDay = rScanner.nextInt();
			int endYear = rScanner.nextInt();
			int endTime = rScanner.nextInt();
			TimeSlot ts = new TimeSlot(startMonth, startDay, startYear, startTime, endMonth, endDay, endYear, endTime);
			
			//Creating car from line
			int mpg = rScanner.nextInt();
			int capacity = rScanner.nextInt();
			String model = rScanner.next();
			Location location = new Location(rScanner.next());
			double pricePerHour = rScanner.nextInt();
			Car car = new Car(mpg, capacity, model, location, pricePerHour);
			
			//creating user from line
			String firstName = rScanner.next();
			String lastName = rScanner.next();
			String username = rScanner.next();;
			String password = rScanner.next();;
			User user = new User(firstName,lastName,username,password);
			
			//Creating Reservation from read data
			Reservations.add(new Reservation(ts,car,user));
		}
		rScanner.close();

		// read cars
		File carFile = new File("cars.txt");
		Scanner cScanner = new Scanner(carFile);
		cScanner.useDelimiter("/");
		while (cScanner.hasNextLine()) {
			//Creating car from line
			int mpg = cScanner.nextInt();
			int capacity = cScanner.nextInt();
			String model = cScanner.next();
			Location location = new Location(cScanner.next());
			double pricePerHour = cScanner.nextInt();
			//adding car to list 
			Cars.add(new Car(mpg, capacity, model, location, pricePerHour));
		}
		cScanner.close();

		// read in users
		File usersFile = new File("users.txt");
		Scanner uScanner = new Scanner(usersFile);
		uScanner.useDelimiter("/");
		while (uScanner.hasNextLine()) {
			//creating user from line
			String firstName = uScanner.next();
			String lastName = uScanner.next();
			String username = uScanner.next();
			String password = uScanner.next();
			//adding user to list
			Users.add(new User(firstName,lastName,username,password));
		}
		uScanner.close();
	}

	public double addReservation(Car car, Location location, TimeSlot timeSlot, User user) {
		boolean valid = true;
		for (Reservation r : Reservations) {
			if (r.getTimeSlot().Conflict(timeSlot))
				valid = false;
		}
		/*
		 * if (!location.Cars.contains(car)) valid = false;
		 */// Will not be commented in final version, but without manager window there will
			// never be cars at any location
		if (((timeSlot.getDuration() / 60) / 24) > 80)
			valid = false;
		Reservations.add(new Reservation(timeSlot, car, user));
		// temporary printing out of reservations
		if (valid) {
			for (Reservation r : Reservations)
				System.out.println(r.toString());
			double durationDiscoutRate = 0.15 / 30;
			double durationinHours = timeSlot.getDuration() / 60;
			double price = (car.pricePerHour * durationinHours) * (1 - (durationinHours * durationDiscoutRate));// TODO: add multiple location pricing
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