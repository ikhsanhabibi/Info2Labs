
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create booking System
		Booking bookingSystem = new Booking();
		
		//create some Shows
				Show casablanca = new Show("Casablanca",10,20,600);
				Show lostInTranslation = new Show("Lost in Translation",10,20,350);
				Show drStrangelove = new Show("Dr. Strangelove",10,20,550);
				Show drive = new Show("Drive",10,20,400);
				Show theThirdMan = new Show("the third Man",10,20,450);
		
		//make a reservation
		bookingSystem.reserveSeats(casablanca,4);
		bookingSystem.printSeatPlan(casablanca);		

	}

}
