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
		return model + "/" + location + "/" + mpg + "/" + capacity + "/" + pricePerHour;
	}
	
	public boolean Equals(Car c) {
		if (
				mpg==c.mpg && 
				capacity == c.capacity && 
				model.equals(c.model) && 
				location.toString().equals(c.location.toString()) && 
				pricePerHour==c.pricePerHour
			) 
			return true;
		else
			return false;
	}
}
