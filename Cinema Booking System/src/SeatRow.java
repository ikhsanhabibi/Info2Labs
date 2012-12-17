import java.util.Arrays;

/**Stores if an seat is booked or empty and is
 * also able to check for several Seats in a row
 * 
 */
public class SeatRow {
	private boolean[] seats;
	
	public SeatRow(int seatNumber){
		seats = new boolean[seatNumber];
		Arrays.fill(seats, false);
	}
	/**
	 * check if there are free seats next to each other
	 * @param how many seats are needed
	 * @return the number of the first free seat in the row of free seats. or -1 if not enoght seats are free.
	 */
	public int getFreeSeats(int seatsInRow){
		
		for(int i = 0;i<seats.length;i++){
			if(!seats[i]){
				for(int n = 0;n<seatsInRow;n++){
					if(seats[i+n]) return -1;
				}
				return i;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param firstSeat
	 * @param numberOfSeats
	 */
	public void book(int firstSeat, int numberOfSeats){
		for(int i=0;i<numberOfSeats;i++){
			seats[firstSeat + i] = true;
		}
	}
	/**
	 * 
	 * @param firstSeat
	 * @param numberOfSeats
	 */
	public void unBook(int firstSeat, int numberOfSeats){
		for(int i=0;i<numberOfSeats;i++){
			seats[firstSeat + i] = false;
		}
	}
	
	public void printSeats(){
		for(boolean seat: seats){
			if(seat) System.out.print("X");
			else System.out.print("0");
		}
	}

}
