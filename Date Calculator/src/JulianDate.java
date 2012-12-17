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
	 * Converts a Julian dayte to a calendar date
	 * ref :
	 * Numerical Recipes in C, 2nd ed., Cambridge University Press 1992
	 */
	 public static int[] fromJulian(int injulian) {
	   int JGREG= 15 + 31*(10+12*1582);
	   double HALFSECOND = 0.5; 
		 
	   int jalpha,ja,jb,jc,jd,je,year,month,day;
	   double julian = injulian + HALFSECOND / 86400.0;
	   ja = (int) julian;
	   if (ja>= JGREG) {
	     jalpha = (int) (((ja - 1867216) - 0.25) / 36524.25);
	     ja = ja + 1 + jalpha - jalpha / 4;
	   }

	   jb = ja + 1524;
	   jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
	   jd = 365 * jc + jc / 4;
	   je = (int) ((jb - jd) / 30.6001);
	   day = jb - jd - (int) (30.6001 * je);
	   month = je - 1;
	   if (month > 12) month = month - 12;
	   year = jc - 4715;
	   if (month > 2) year--;
	   if (year <= 0) year--;
	   
	   return new int[] {year, month, day};
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
	 * get the gergorian Date
	 * @return int julian Date
	 */
	public int[] getGergDate(){
		return fromJulian(julianDate);
	}
	
	/**
	 * get the julian Date
	 * @return int julian Date
	 */
	public int getJDate(){
		return julianDate;
	}
	

}