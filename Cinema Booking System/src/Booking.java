import java.util.ArrayList;


/**The class that takes care of the proces in general
 * 
 */

/**
 * @author Manuel & Kay
 *
 */
public class Booking {
	//all stored reservations
	private ArrayList<Reservation> reservations;
	
	public Booking(){
		//create list of reservations
		reservations = new ArrayList<Reservation>();
	}
	
	public void reserveSeats(Show show, int seatsInRow){
		int[] seatsToBook = show.findSeats(seatsInRow);
		int price = caculatePrice(show,seatsInRow);

		if(seatsToBook != null){
			//save reservation
			reservations.add(new Reservation(seatsToBook[0],seatsToBook[1],seatsInRow,show,price));
			//mark seats as booked
			show.markSeatsAsBooked(seatsToBook[0], seatsToBook[1], seatsInRow);
			System.out.print("Yor reservartion was succesfull \n You'll have to pay "+price+" Cents \n \n");
		}else{
			System.out.print("There are not enugh free Seats - Sorry \n \n");
		}
	}
	
	private int caculatePrice(Show show, int numberOfBookedSeats){
		return show.getPrice() * numberOfBookedSeats;
	}
	
	public void deleteReservation(int reservationNumber){
		Reservation resToDelete = reservations.get(reservationNumber);
		Show show = resToDelete.getReservedShow();
		show.markSeatsAsFree(resToDelete.getRowNumber(), resToDelete.getSeatNumber(), resToDelete.getReservedSeats());
	}
	
	public void printSeatPlan(Show show){
		show.printSeatPlan();
	}

}
