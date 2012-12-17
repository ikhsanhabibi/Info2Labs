import java.io.*;
import java.util.Arrays;

/**
 * @author Manuel & Kay
 *
 */
public class Histogram {
	//Constructor
	public Histogram(){
		
	}

	/**
	 * The main Method
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		ceate instace of Histrogramm
		Histogram histogram = new Histogram();
		int [] data = histogram.analizeFile(System.getProperty("user.dir")+"/text.txt");
		String diagram = histogram.createDiagram(data);
		histogram.saveToFile(diagram);
	}
	/**
	 * Opens a file and Saves the distribution of all the Characters to an array
	 * @param file_name String the name of the file to be opend
	 * @throws IOException
	 * @return int[] the disribution of characters in the given file
	 */
	public int[] analizeFile(String file_name) throws IOException{
		final int ASCI_LOW = 97;
		final int ASCI_UP = 65;
		final int ALPHABET = 26;
		
		int[] alphabet = new int[ALPHABET];
		//fill array with ceros
		Arrays.fill(alphabet,0);
		
		FileReader fr = new FileReader(file_name);
		int character;
		while((character = fr.read()) != -1){
//			check for lowercase characters
			if(character >= ASCI_LOW && character <= (ASCI_LOW + ALPHABET) ){
				alphabet[character - ASCI_LOW] ++;
			}
//			check for uppercase characters
			else if(character >= ASCI_UP && character <= (ASCI_UP + ALPHABET) ){
				alphabet[character - ASCI_UP] ++;
			}
					    
		}
		fr.close();
		return alphabet;
	}
	/**
	 * creates a histogram of the number of Charactes in e.g. some text
	 * @param data int[] the distribution of the charactars
	 * @return String representing the histogram
	 */
	public String createDiagram(int[] data){
		String[] alphabetChars = {"A","B","C","D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P","Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String diagram = "";
		for(int i = 0; i<data.length; i++){
			//add letter
			diagram += alphabetChars[i] + ": ";
			//add stars
			for(int n = 0;n<= data[i];n++){
				diagram += "*"; 
			}
			diagram += "\n";
			
		}
		return diagram;
	}
	
	/**
	 * Saves a given content to storage.txt. If frequency.txt does not exist it creates it.
	 * @param content  String the content that is written to the file
	 * @throws IOException
	 */
	public void saveToFile(String content) throws IOException{
		 FileWriter fstream = new FileWriter("frequency.txt");
		 BufferedWriter out = new BufferedWriter(fstream);
		 out.write(content);
		 out.close();
		
	}

}
