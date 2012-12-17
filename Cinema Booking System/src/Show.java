/**The Show stores Information about the show and the seat rows
 * 
 */

public class Show {
	private String desc;
	private int price;
	private SeatRow[] seatRows;
	/**
	 * Creates a specified number of rows with a specified number of seats
	 * @param rows how many rows are aviable for this show
	 * @param seatNumber how many seats does each row have
	 * @param price how much does one seat in this show cost
	 */
	public Show(String desc, int rows,int seatNumber, int price){
		this.desc = desc;
		this.price = price;
		seatRows = new SeatRow[rows];
		for(int i = 0; i< rows;i++){
			seatRows[i] = new SeatRow(seatNumber);
		}
	}
	
	/**
	 * 
	 * @return the price of one seat in this show
	 */
	public int getPrice(){
		return price;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public int[] findSeats(int seatsInRow){
		for(int i=0; i< seatRows.length; i++){
			int foundSeat = seatRows[i].getFreeSeats(seatsInRow);
			if(foundSeat != -1){
				return new int[] {i,foundSeat};
			}			
		}
		return null;
	}
	
	/**
	 * mark seats as booked
	 * @param row
	 * @param firstSeat
	 * @param numberOfSeats
	 * 
	 */
	public void markSeatsAsBooked(int row, int firstSeat, int numberOfSeats){
			seatRows[row].book(firstSeat, numberOfSeats);
	}
	
	/**
	 * mark seats as free
	 * @param row
	 * @param firstSeat
	 * @param numberOfSeats
	 * 
	 */
	public void markSeatsAsFree(int row, int firstSeat, int numberOfSeats){
		seatRows[row].unBook(firstSeat, numberOfSeats);
	}
	
	public void printSeatPlan(){
		System.out.print("Seatplan for: "+desc+"\n");
		for(SeatRow seatRow: seatRows){
			seatRow.printSeats();
			System.out.print("\n");
		}
	}
}