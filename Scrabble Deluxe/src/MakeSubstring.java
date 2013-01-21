import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


public class MakeSubstring {
	private HashSet<String> allPerms;
	private HashSet<String> allSubstrings;
	
	/**
	 * creates all unic substrings of a String
	 * @param st the String to genereta the substrings from
	 */
	public MakeSubstring(String st){
		//create all possible permutaions of the String
		createAllPermuatations("",st);
		//then step by step take away the last character from every permutation String 
		// and safe all results in a set so we dont have duplicats
		Iterator<String> it = allPerms.iterator();
		while(it.hasNext()){
			allSubstrings.addAll(ShortenString(it.next(),2));
		}
	}
	/**
	 * returns all the found Subtrings as an array
	 * @return all the found Substrings
	 */
	public String[] getSubstrings(){
		return allSubstrings.toArray(new String[allSubstrings.size()]);
	}
	/**
	 * creaetes all the possible unic permutaios of a string
	 * @param base a base to add the permuations to normaly this would be the empty String
	 * @param add the String to get the permutaions from
	 */
	private void createAllPermuatations(String base, String add){
		//base Case
		if(add.length() <= 1){
			allPerms.add(base + add);
		}else{
			String tempAdd,tempBase;
			for(int i=0; i < add.length();i++){
				//takes out the character at position i
				tempAdd  = add.substring(0,i) + add.substring(i+1);
				//adds that missing character to the new base
				tempBase = base + add.charAt(i);
				//call this function again to get every permutation
				createAllPermuatations(tempBase,tempAdd);
			}
		}
	}
	/**
	 * removes step by step the last letter of a string and saves all steps
	 * @param st the String we create the substrings from
	 * @param shortestString the length of the shortest substring
	 * @return a String[] containg all substrings
	 */
	private HashSet<String> ShortenString(String st,int shortestString){
		// we are using a hasSet to ignonre dublicats
		HashSet<String> out = new HashSet<String>();
		int stLength = st.length();//the legth of the string we are working with
		char[] temp;
		//redeuce one character after an other untill our string is as short as  shortestString
		for(int i=-1;i<(stLength-shortestString);i++){
			temp = st.substring(0,stLength-i).toCharArray();
			Arrays.sort(temp);//sort the result to avoid dublicats
			out.add(temp.toString());
		}
		return out;
	}


}