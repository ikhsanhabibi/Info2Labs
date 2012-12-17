
public class TestJDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JulianDate jDate1 = new JulianDate();
		JulianDate jDate2 = new JulianDate(2456230);
		JulianDate jDate3 = new JulianDate(2012,12,21);
		
		System.out.println("Convert 30.10.2012 to Julian Date Expected: 2456230");
		System.out.println(jDate1.convertToJDate(2012, 10, 30));
		
		System.out.println("Print out current weekday");
		System.out.println(jDate1.getWeekday());
		
		System.out.println("Differnce btween Julian Date: jDate2(2456231) and jDate3 (21.12.2012) ");
		System.out.println(jDate2.calculateTimeDifference(jDate3));
		
		System.out.println("Manuel");
		Birthday manuel = new Birthday(1990,9,2);
		System.out.println("Kay");
		Birthday kay = new Birthday(1986,1,30);
		
		
		MetricDate test = new MetricDate(jDate1);

	}

}
