import java.util.Calendar;


public class JulianDate {
	private int julianDate;

	public JulianDate(int year, int month, int day){
		julianDate = convertToJDate(year, month, day);
	}
	
	public JulianDate(int jDate){
		julianDate = jDate;
	}
	
	public JulianDate(){
		Calendar date = Calendar.getInstance();
		julianDate = convertToJDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH)+1, date.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * convert classic Date to Julian Date
	 * @param year
	 * @param month
	 * @param day
	 * @return int Julian Date
	 */
	public int convertToJDate(int year, int month, int day){
		if(month < 2){
			year--;
			month = month +12;
		}
		//Test for use of gregorian calender
		int together = Integer.parseInt(""+year +month+ day);
		int b;
		if(together <= 15821004){
			b = 0;
		}
		else if(together >= 15821015){
			int a = year/100;
			    b = 2 - a + a/4;
		}
		else{
			return -1;
		}

		return (int) (365.25*(year+4716)) + (int)(30.6001*(month+1)) + day + b -1525;
		
	}
	/**
	 * calculates the diffrence to an other Julian Date
	 * @param otherDate
	 * @return days Between the two Dates
	 */
	public int calculateTimeDifference(JulianDate otherDate){
		return Math.abs(julianDate - otherDate.getJDate());
	}
	
	/**
	 * returns the weekday representing the julian Date as String
	 * 
	 * @param jDate
	 * @return weekday as String
	 */
	public String getWeekday() {
		int day = (int) ((julianDate + 1.5) % 7);
		switch (day) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "Error";
		}
	}
	/**
	 * get the julian Date
	 * @return int julian Date
	 */
	public int getJDate(){
		return julianDate;
	}

}