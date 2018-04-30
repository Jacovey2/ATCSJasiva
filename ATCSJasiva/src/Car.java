public class Car {
	public int mpg;
	public int capacity;
	public String model;
	public Location location;
	public double pricePerHour;
	
	public Car (int Mpg, int Capacity, String Model, Location Location, double PricePerHour) {
		mpg=Mpg;
		capacity=Capacity;
		model=Model;
		location=Location;
		pricePerHour=PricePerHour;
	}

	public String toString() {
		return model + " at " + location + " with " + mpg + "mpg for " + capacity + " people at " + pricePerHour
				+ " dollars per hour";
	}
}
