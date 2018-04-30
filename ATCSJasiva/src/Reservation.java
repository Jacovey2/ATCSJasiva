
public class Reservation {
	private TimeSlot timeSlot;
	private Car car;
	private User user;
	
	public Reservation(TimeSlot timeSlotx, Car carx, User userx) {
		timeSlot = timeSlotx;
		car=carx;
		user=userx;
	}
	public Reservation(TimeSlot timeSlotx, User userx) {
		timeSlot = timeSlotx;
		user=userx;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car carx) {
		car=carx;
	}
	public User getUser() {
		return user;
	}
	public String toString() {
		return  timeSlot + "/" + car + "/" + user;
	}
}
