import java.util.Random;

/**
 * takes a number claculates if it is a prime number
 * @author Manuel & Kay
 *
 */
public class isPrime {
	private static Random r = new Random();

	/**
	 * Claculates if a given number is prime
	 * @param int the number to check
	 * @return boolean true or false waether the number is prime 
	 */
	public static void main(String[] args) {
		//set boundaries for 20bit number
		int low_20 =  (int)Math.pow(2, 19);
		int high_20 = (int)Math.pow(2, 20);
		//set boudaries for 40 bit number
		long low_40 = (long)Math.pow(2, 39);
		long high_40 = (long)Math.pow(2, 40);

		//test a hundred 20 bit numbers if they are prime
		System.out.print("\n20 bit Numbers: \n\n");
		for(int i = 0; i < 100; i++){
			//generate Random 20 bit number
			int number_20 = r.nextInt(high_20 - low_20) + low_20;
			//check if the number is prime
			System.out.print(number_20 + "   ");
			System.out.print(checkPrime((long)number_20) + "\n");
		}
		//test a hundred 40 bit numbers if they are prime
		System.out.print("\n40 bit Numbers: \n\n");
		for(int i = 0; i < 100; i++){
			//generate Random 40 bit number
			long number_40 = low_40+((long)(r.nextDouble()*(high_40-low_40)));
			//check if the number is prime
			System.out.print(number_40 + "   ");
			System.out.print(checkPrime((long)number_40) + "\n");
		}
		
	}
	
	public static boolean checkPrime(long n){
		int steps = 1;
		if(n > 1){
			for(long i = 2; i < n; i++){
				steps ++;
				if(n%i == 0){
					System.out.print(steps + "    ");
					return false;
				}	
			}
			System.out.print(steps + "    ");
			return true;
		}
		else{
			steps = 1;
			System.out.print(steps + "    ");
			return false;
		}
		
	}

}
