import java.util.Calendar;
public class TimeSlot {

	public int startMonth;
	public int startDay;
	public int startYear;
	public int startTime;
	public int endMonth;
	public int endDay;
	public int endYear;
	public int endTime;
	
	/*
	public static void main (String[] args) {
		TimeSlot tS= new TimeSlot(2,5,2012,1100,2,5,2012,1430);
		tS.getDuration();
	}*/
	
	public TimeSlot (int StartMonth,
					int StartDay,
					int StartYear,
					int StartTime,
					int EndMonth,
					int EndDay,
					int EndYear,
					int EndTime) {
		startMonth = StartMonth;
		startDay = StartDay;
		startYear = StartYear;
		startTime =StartTime;
		endMonth = EndMonth;
		endDay = EndDay;
		endYear = EndYear;
		endTime = EndTime;
	}
	public boolean Conflict(TimeSlot ts) {
		if (!singleConflict(startYear, endYear, ts.startYear, ts.endYear)) 
			if (!singleConflict(startMonth, endMonth, ts.startMonth, ts.endMonth)) 
				if (!singleConflict(startDay, endDay, ts.startDay, ts.endDay))
					if (!singleConflict(startTime, endTime, ts.startTime, ts.endTime)) {
						return false;
					}
		return true;
	}
	public int getDuration() {
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.set(startYear, startMonth, startDay, hourFromTime(startTime),minFromTime(startTime));
		endDate.set(endYear, endMonth,endDay,hourFromTime(endTime),minFromTime(endTime));
		double timeInMillis = (double) (endDate.getTime().getTime()-startDate.getTime().getTime());
		double timeInHours  = timeInMillis*0.00000027777778;
		int    timeInMins   = (int) Math.round(timeInHours*60);
		System.out.println(timeInMins);
		return (timeInMins);
	}
	private int hourFromTime(int time) {
		return Math.round(time/100);
	}
	private int minFromTime(int time) {
		return time-Math.round(time/100)*100;
	}
	private static boolean singleConflict(int a, int b, int c, int d) {
		int[] ints = {a,b,c,d};
		int max = a;
		int min = a;
		for (int i=0; i<ints.length; i++) {
			if (max<ints[i])
				max=ints[i];
			if (min>ints[i])
				min=ints[i];
		}
		int maxdiff = Math.abs(max-min);
		boolean eclipse = ((maxdiff== Math.abs(a-b)) || (maxdiff== Math.abs(c-d))) && a!=d;
		boolean contain = (a<c && c<b) || (a<d && c<b);
		return  eclipse || contain;
	}
	public String toString () {
		return startMonth+"/"+startDay+"/"+startYear+"/"+startTime+"/"+endMonth+"/"+endDay+"/"+endYear+"/"+endTime;
	}
}