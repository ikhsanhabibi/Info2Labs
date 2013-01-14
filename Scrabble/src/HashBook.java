import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class HashBook {
	public int modolo = 0; //the size of our hash Table
	private ArrayList<String>[] hashBook; //our Hash Table
	
	//Statistics
	public int mostCollisions = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashBook hashBook = new HashBook();
		hashBook.hashWords();
		
		String testword = "ahnbelu";
		hashBook.scrabbleCheater(testword);
		System.out.print("\n Size of Hash Table:"+hashBook.modolo
						+"\n Size of max Collision:"+	hashBook.mostCollisions);
	}
	/**
	 * looks up the all permutions (plus collisions) of a word in a hash table
	 * @param word the word or set of letters we want to get the permutations from
	 * @return an Array list of all the permutaions (plus Collisions)
	 */
	public ArrayList<String> lookup(String word){
		double hashCode = getHashCode(word);
		int pos = (int) (hashCode%modolo);//get the position in the hash table
		return hashBook[pos];
	}
	public void scrabbleCheater(String letters){
		System.out.print("Words you can built from the following letters: "+letters+"\n\n");
		ArrayList<String> permutaions = lookup(letters);
		Iterator<String> it = permutaions.iterator();
		while(it.hasNext()){
			String out = it.next(); 
			if(isPermutation(out,letters)){
				System.out.println(out);
			}
		}
	}
	/**
	 * reads in a list of words and hashes them in the way that anagrammes are mapped on the same hash
	 * @return the hash Table as an array
	 */
	private ArrayList<String>[] hashWords(){
		String[] book = readInFile(System.getProperty("user.dir")+"/dictonary.txt");
		int numberOfWords = book.length;
		modolo = getNextPrime(numberOfWords); //a prime number to generate the hash table
		
		//our hash table
		hashBook = ((ArrayList<String>[])new ArrayList[modolo]);
		
		for(int i=0;i<numberOfWords;i++){
			double hashCode = getHashCode(book[i]);
			int pos = (int) (hashCode%modolo);//get the position in the hash table
			if(hashBook[pos] == null){
				hashBook[pos] = new ArrayList<String>();
			}
			hashBook[pos].add(book[i]);
			//Statistics
			if(hashBook[pos].size() > mostCollisions){
				mostCollisions = hashBook[pos].size();
			}
		}
		return hashBook;
	}
	/**
	 * claculates a unique number that represents a string 
	 * @param st the string given as a single letter string array
	 * @return the hashNumber
	 */
	private double getHashCode(String word){
		//normalize word and save it as array so we can sort it
		word = word.toLowerCase();
		String[] st = word.split("(?!^)");
		Arrays.sort(st);//by sorting inside the word anagrams are mapped to the same number
				
		int length = st.length;
		double hashCode = 0;
		for(int i=0;i<length;i++){
			char ch = st[i].charAt(0); 
			hashCode += Math.pow(ch*31, length-i+1);
		}
		return hashCode;
	}
	/**
	 * tells weather two Strings are permututations of another
	 * @param word the first String
	 * @param compare the second String
	 * @return wheather the two strings are permuations
	 */
	private boolean isPermutation(String word,String compare){
		double code1 = getHashCode(word);
		double code2 = getHashCode(compare);
		return (code1 == code2);
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
	/**
	 * reads in a file of words sepated by a blank or a newline
	 * @param file_name
	 * @return
	 */
	private String[] readInFile(String file_name){
		ArrayList<String> output = new ArrayList<String>();
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(file_name);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				String[] words = strLine.split(" ");
				for(int i=0;i<words.length;i++){
					output.add(words[i]);
				}
			}
			//Close the input stream
			in.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return output.toArray(new String[output.size()]);
		 

	}

}
