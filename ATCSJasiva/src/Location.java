import java.util.ArrayList;

public class Location {
	public String locationName;
	public ArrayList<Car> cars;
	public Location (String Location) {
		locationName = Location;
		cars=new ArrayList<Car>();
	}
	public ArrayList<Car> updateList() {
		ArrayList<Car> potentialCars = GUI.IH.Cars;
		for(Car c:potentialCars)
			//looks through the cars and if one car isn't contained in the local list, and is at this location, it adds it to local car list
			if(!cars.contains(c) && c.location.locationName==locationName) {
				cars.add(c);
			}
		return cars;
	}
	public String toString() {
		String retString = locationName;
		return retString;
	}
}
