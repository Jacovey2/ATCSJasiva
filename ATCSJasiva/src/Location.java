import java.util.ArrayList;

public class Location {
	public String location;
	public ArrayList<Car> Cars;
	public Location (String Location) {
		location = Location;
		Cars=new ArrayList<Car>();
	}
	public String toString() {
		return location;
	}
}
