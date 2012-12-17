
public class MetricDate extends JulianDate {
	int year;
	int month;
	int week;
	int day;
	
	public MetricDate(JulianDate julianDate){
		super(julianDate.getJDate());
		convertToMetricDate();
		System.out.println("Jahr: "+year+" Monat: "+month+" Woche "+week+" Tag: "+day);
	}
	
	private void convertToMetricDate() {
		int jDate = super.getJDate();
		day = jDate%10;
		jDate -= day;
		
		week = (jDate%100)/10;
		jDate -= jDate%100;
		
		month = (jDate%1000)/100;
		jDate -= jDate%1000;
		
		year = jDate/1000;
	}
	
	public JulianDate convertToJDate(int mDay, int mWeek, int mMonth, int mYear) {
		return new JulianDate((mYear*1000)+(mMonth*100)+(mWeek*10)+(mDay));
	}

}