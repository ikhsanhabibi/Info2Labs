import java.util.Arrays;
import java.util.ArrayList;


public class HashBook {
	private int modolo = 0;
	private ArrayList<String>[] hashBook;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashBook bla = new HashBook();
		bla.hashWords();
	}
	public ArrayList<String> lookup(String word){
		int pos = calculatePosition(word);
		return hashBook[pos];
	}
	/**
	 * reads in a list of words and hashes them in the way that anagrammes are mapped on the same hash
	 * @return the hash Table as an array
	 */
	private ArrayList<String>[] hashWords(){
		String[] book = {"Cda","dac", "Wolken", "Stra§e", "SŠule", "Bummerrang"};
		//TODO: read in the words from a file
		int numberOfWords = book.length;
		modolo = getNextPrime(numberOfWords); //a prime number to generate the hash table
		
		//our hash table
		hashBook = ((ArrayList<String>[])new ArrayList[modolo]);
		
		for(int i=0;i<numberOfWords;i++){
			int pos = calculatePosition(book[i]);
			if(hashBook[pos] == null){
				hashBook[pos] = new ArrayList<String>();
			}
			hashBook[pos].add(book[i]);
		}
		return hashBook;
	}
	/**
	 * calculates the postion in the hashTable
	 * @param word the word to hash
	 * @return the postition in the hash table
	 */
	private int calculatePosition(String word){
		//normalize word and save it as array so we can sort it
		word = word.toLowerCase();
		String[] tempWord = word.split("(?!^)");
		Arrays.sort(tempWord);//by sorting inside the word anagrams are mapped to the same number
		double hashCode = getHashCode(tempWord);
		return (int) (hashCode%modolo);//get the position in the hash table
	}
	/**
	 * claculates a unique number that represents a string 
	 * @param st the string given as a single letter string array
	 * @return the hashNumber
	 */
	private double getHashCode(String[] st){
		int length = st.length;
		double hashCode = 0;
		for(int i=0;i<length;i++){
			char ch = st[i].charAt(0); 
			hashCode += Math.pow(ch*31, length-i+1);
		}
		return hashCode;
	}
	/**
	 * gets the next higher prime number from a given number !a bit risky since we dont know when the next prime number will occour
	 * @param number the number to start with
	 * @return
	 */
	private int getNextPrime(int i){
		//increase the number until we find a prime number
		while(true){
			if(i==2)return i;
			int n = 2;
			while(n<i){
				if(i%n == 0){
					return i;
				}
				n++;
			}
			i++;
		}
	}

}
