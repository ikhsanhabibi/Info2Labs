/**
 *stores the Information to specific reservations
 *@param rowNumber in Which row are the reseved seats
 *@param seatNumber what is the first reseved seat in taht row
 *@param reservedSeats how many seats are reserved
 */
public class Reservation {
	//Information about the booking
	private int rowNumber;
	private int seatNumber;
	private int reservedSeats;
	private Show reservedShow;
	private int totalPrice;
	
	/**
	 * 
	 * @param rowNumber the row in which the seats are booked
	 * @param seatNumber first of the booked seats
	 * @param reservedSeats number of booked seats
	 * @param reservedShow the Show in which the seats are booked
	 * @param totalPrice price of all booked seats
	 */
	public Reservation(int rowNumber, int seatNumber,int reservedSeats, Show reservedShow, int totalPrice){
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.reservedSeats = reservedSeats;
		this.reservedShow = reservedShow;
		this.totalPrice = totalPrice;
	}
	/**
	 * 
	 * @return the row in wich the seats are booked
	 */
	public int getRowNumber(){
		return rowNumber;
		
	}
	/**
	 * 
	 * @return Index of the first of the booked seats
	 */
	public int getSeatNumber(){
		return seatNumber;
		
	}
	/**
	 * 
	 * @return Number of booked seats
	 */
	public int getReservedSeats(){
		return reservedSeats;
		
	}
	 /** 
	 * @return the show in wich the seats are reserved
	 */
	public Show getReservedShow(){
		return reservedShow;
		
	}
	/**
	 * 
	 * @return price of all booked seats
	 */
	public int gettotalPrice(){
		return totalPrice;
		
	}
}
