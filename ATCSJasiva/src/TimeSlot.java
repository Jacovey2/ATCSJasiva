import java.util.Date;
import java.util.Scanner;

public class TimeSlot {
	public int startMonth;
	public int startDay;
	public int startYear;
	public int startTime;
	public int endMonth;
	public int endDay;
	public int endYear;
	public int endTime;
	
	public TimeSlot (int StartMonth,
					int StartDay,
					int StartYear,
					int StartTime,
					int EndMonth,
					int EndDay,
					int EndYear,
					int EndTime) {
		startTime = StartTime;
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
	private boolean singleConflict(int start1, int end1, int start2, int end2) {
		if (!inBetween(start1, start2, end1) && !inBetween(start1, end2, end1) && !contains(start2, start1, end1, end2))
				return true;
		return false;
	}
	private boolean inBetween(int a, int b, int c) {
		if (a<b && b<c) 
			return true;
		else return false;
	}
	private boolean contains(int a, int b, int c, int d) {
		if ((a>=b && c>=d) || (d>=b && c>=a))
			return true;
		else return false;
	}
	public String ToString () {
		return "from:"+startMonth+"/"+startDay+"/"+startYear+" "+startTime+"  to:"+endMonth+"/"+endDay+"/"+endYear+" "+endTime;
	}
}