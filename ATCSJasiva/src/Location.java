
public class Location {
	public String locationName;
	public Location (String Location) {
		locationName = Location;
	}
	public String toString() {
		return locationName;
	}
	public double distanceFrom(Location loc2){
		String loc2Name = loc2.locationName;
		double distance = -1;
		if (locationName.equals("New York City") && loc2.locationName.equals("Orlando")) {
			//distance = 
		}
		
		return distance;
	}
}
