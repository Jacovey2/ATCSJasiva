

public class Car {
	public int mpg;
	public int capacity;
	public String model;
	public Location location;
	public double pricePerHour;

	public Car(int Mpg, int Capacity, String Model, Location Location, double PricePerHour) {
		mpg = Mpg;
		capacity = Capacity;
		model = Model;
		location = Location;
		pricePerHour = PricePerHour;
	}
	public Car(Car[] carArray, String defaultName, String LocationName) {
		int index =0;
		for (int i=0; i<carArray.length; i++) 
			if(carArray[i].model.equals(defaultName))
				index=i;
		mpg = carArray[index].mpg;
		capacity = carArray[index].capacity;
		model = carArray[index].model;
		location = new Location(LocationName);
		pricePerHour = carArray[index].pricePerHour;
	};

	public String toString() {
		return model + "/" + location + "/" + mpg + "/" + capacity + "/" + pricePerHour;
	}
	public String toNiceString () {
		return model + " at " + location + " with " + mpg + "mpg. " + capacity + " person capacity. at " + pricePerHour+" dollars per hour.";
	}

	public boolean Equals(Car c) {
		if (mpg == c.mpg && capacity == c.capacity && model.equals(c.model)
				&& location.toString().equals(c.location.toString()) && pricePerHour == c.pricePerHour)
			return true;
		else
			return false;
	}
}
