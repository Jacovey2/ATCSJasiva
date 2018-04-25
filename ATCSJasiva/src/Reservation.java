
public class Reservation {
	private TimeSlot timeSlot;
	private Car car;
	private User user;
	
	public Reservation(TimeSlot timeSlotx, Car carx, User userx) {
		timeSlot = timeSlotx;
		car=carx;
		user=userx;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public Car getCar() {
		return car;
	}
	public User getUser() {
		return user;
	}
}
