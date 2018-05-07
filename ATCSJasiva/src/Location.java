
public class Location {
	public String locationName;
	public Location (String Location) {
		locationName = Location;
	}
	public String toString() {
		return locationName;
	}
	public double distanceFrom(Location loc1, Location loc2){
		String loc1Name = loc1.locationName;
		String loc2Name = loc2.locationName;
		double distance = -1;
		if (loc1.equals("New York City") && loc2.equals("Orlando")) {
			
		}
		
		return distance;
	}
}
