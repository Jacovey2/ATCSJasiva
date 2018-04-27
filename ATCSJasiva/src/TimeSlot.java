
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
	private static boolean singleConflict(int a, int b, int c, int d) {
		int[] ints = {a,b,c,d};
		int max = a;
		int min = a;
		System.out.print("\nints: ");
		for (int i=0; i<ints.length; i++) {
			System.out.print(ints[i]+", ");
			if (max<ints[i])
				max=ints[i];
			if (min>ints[i])
				min=ints[i];
		}
		System.out.println();
		int maxdiff = Math.abs(max-min);
		System.out.println("maxdiff: "+maxdiff);
		boolean eclipse = ((maxdiff== Math.abs(a-b)) || (maxdiff== Math.abs(c-d))) && a!=d;
		System.out.println("eclipse: "+eclipse +"("+(a-b)+") ("+(c-d)+")");
		boolean contain = (a<c && c<b) || (a<d && c<b);
		System.out.println("contain: "+contain);
		return  eclipse || contain;
	}
	public String ToString () {
		return "from:"+startMonth+"/"+startDay+"/"+startYear+" "+startTime+"  to:"+endMonth+"/"+endDay+"/"+endYear+" "+endTime;
	}
}