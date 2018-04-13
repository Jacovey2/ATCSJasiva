
public class Car {
	public int mpg;
	public int capacity;
	public String model;
	public String location;
	public double pricePerHour;

	public String toString() {
		return model + " at " + location + " with " + mpg + "mpg for " + capacity + " people at" + pricePerHour
				+ "dollars per hour";
	}
}
