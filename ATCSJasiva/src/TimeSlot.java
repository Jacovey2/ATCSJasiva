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
		if (!inBetween(startYear, ts.startYear, endYear) && !inBetween(startYear, ts.endYear, endYear)) 
			if (!inBetween(startMonth, ts.startMonth, endMonth) && !inBetween(startMonth, ts.endMonth, endMonth)) 
				if (!inBetween(startDay, ts.startDay, endDay) && !inBetween(startDay, ts.endDay, endDay))
					if (!inBetween(startTime, ts.startTime, endTime) && !inBetween(startTime, ts.endTime, endTime)) {
						return false;
					}
					
					

		return true;
	}
	private boolean inBetween(int a, int b, int c) {
		if (a<=b && b<=c) 
			return true;
		else return false;
	}
	public String ToString () {
		return "from:"+startMonth+"/"+startDay+"/"+startYear+" "+startTime+"  to:"+endMonth+"/"+endDay+"/"+endYear+" "+endTime;
	}
}