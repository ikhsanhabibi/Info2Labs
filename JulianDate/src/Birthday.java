
public class Birthday {
	JulianDate age;
	JulianDate today;
	public Birthday(int year, int month, int day){
		today = new JulianDate();
		age = new JulianDate(year,month,day);
		
		System.out.println("You are "+ getAgeInDays() +" Days old");
		System.out.println("You were born on a "+ getWeekdayOfBirth());
		if(birthdayToday()){
			System.out.println("Concratulations Today is your Birthday!");
		}
		if(decimalBirthday()){
			System.out.println("Concratulations Today is your  decimal Birthday!");
		}
	}
	
	public int getAgeInDays(){
		return age.calculateTimeDifference(today);
	}
	
	public String getWeekdayOfBirth(){
		return age.getWeekday();
	}
	
	public boolean birthdayToday(){
		return (age.getJDate() == today.getJDate());
	
	}
	
	public boolean decimalBirthday(){
		return (getAgeInDays() % 100 == 0);
	
	}

}
