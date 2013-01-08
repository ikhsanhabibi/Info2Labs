import java.util.Arrays;
import java.util.LinkedList;


public class HashBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashBook bla = new HashBook();
		bla.hashWords();
	}
	
	private void hashWords(){
		String[] book = {"Cda","dac", "Wolken", "Stra§e", "SŠule", "Bummerrang"};
		int MODOLO = 109829; //a prime number to generate the hash table
		//our hash table
		LinkedList<String>[] hashBook = ((LinkedList<String>[])new LinkedList[MODOLO]);
		Arrays.fill(hashBook, new LinkedList<String>());
		//hash every single word
		int numberOfWords = book.length;
		for(int i=0;i<numberOfWords;i++){
			//normalize word and save it as array so we can sort it
			String word = book[i].toLowerCase();
			String[] tempWord = word.split("(?!^)");
			Arrays.sort(tempWord);
			double hashCode = getHashCode(tempWord);
			int pos = (int) (hashCode%MODOLO);//get the position in the hash table
			hashBook[pos].add(word);
		}
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

}
