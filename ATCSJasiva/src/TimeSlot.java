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
	private boolean singleConflict(int a, int b, int c, int d) {
		if ((a>c && c>b) || (a>d && d>b) || (c>a && a>b && b>d) || (a==c && c>b && b>d) || (a>c && c>b && b==d))
				return true;
		return false;
	}
	private boolean inBetween(int a, int b, int c) {
		if (a<b && b<c) 
			return true;
		else return false;
	}
	private boolean contained(int a, int b, int c, int d) {
		if ((c>=a && b>=d)) {
			if (!(c==d && a==b && a==c)) {
				return true;
			}
		}
		return false;
	}
	public String ToString () {
		return "from:"+startMonth+"/"+startDay+"/"+startYear+" "+startTime+"  to:"+endMonth+"/"+endDay+"/"+endYear+" "+endTime;
	}
}