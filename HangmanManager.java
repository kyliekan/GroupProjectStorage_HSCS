import java.util.*;

public class HangmanManager
{
	Set<String> words;
	Set<Character> guesses;
	String pattern;
	Map<Integer,String> pat;
	int ng;
	int len;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		
		if(length > 1 && max > 0)
		{
		len = length;
		guesses = new HashSet<Character>();
		pat = new TreeMap<Integer,String>();
		for(int h = 0; h < 26; h++)
			pat.put(h,"-");
		ng = max;
		words = new HashSet<String>();
		for (int i = 0; i < dictionary.size(); i++)
		{
			if(dictionary.get(i).length() == length)
				words.add(dictionary.get(i));
		}
		pattern = "";
		for(int i = 0; i <len; i++)
			pattern += pat.get(i);
	}
	}
	
	public Set<String> words()
	{
			return words;
	}	
	
	public int guessesLeft()
	{
		return ng;
	}
		
	public Set<Character> guesses()
	{
		return guesses;
	}
	
	public String pattern()
	{
		
		return pattern;
	}
	public String getPatt(String word, String guess1) {
		word = word.replaceAll(guess1, "!");
		word = word.replaceAll("[a-zA-Z]", "-");
		word = word.replaceAll("!", guess1);
		
		return word;
	}
	public int record( char guess )
	{
		
		Set<String> newwords = new HashSet<String>();
		guesses.add(guess);
		String guess1 = Character.toString(guess);
		String[] wordlistunedited =words.toArray(new String[words.size()]);
		String[] wordlist =words.toArray(new String[words.size()]);
		
		for(int i = 0; i < wordlist.length;i++)
		{
			wordlist[i] = wordlist[i].replaceAll(guess1, "!");
			wordlist[i] = wordlist[i].replaceAll("[a-zA-z]", "-");
			wordlist[i] = wordlist[i].replaceAll("!", guess1);
		}
		int biggest = 0;
		String pat2 = "";
		Map<String,Integer> families = new HashMap<String,Integer>();
		
		for(String s: wordlist) {
			  if (!families.containsKey(s)) { 
				  families.put(s, 1);
				  if(families.get(s) > biggest) {
			    	  biggest = families.get(s);
			    	
			    	  pat2 = s;
				  }
			  }
			  else {
			      int count = families.get(s);
			      families.put(s, count + 1);
			      if(families.get(s) > biggest) {
			    	  biggest = families.get(s);
			    	  pat2 = s;
			      }
			    }
		}
		
		for(int h = 0; h < wordlistunedited.length; h++) {
			if(pat2.equals(getPatt(wordlistunedited[h],guess1))) {
				newwords.add(wordlistunedited[h]);
			}
		}	
		words = newwords;
		char[] patarray = pattern.toCharArray();
		
		if(pattern != pat2) {
			
			for(int p = 0; p < pattern.length();p++)
			{
				if(pattern.substring(p,p+1).equals("-") && !pat2.substring(p,p+1).equals("-")) {
					patarray[p] = pat2.charAt(p);
				}
			}
		}
		if(pat2 == pat2.replaceAll("[a-zA-Z]","-"))
		{
			ng--;
		}
		pattern = "";
		for(char k: patarray)
			pattern += k;
		int count = 0;
		for(int j = 0; j < pat2.length();j++) {
			if(pat2.substring(j,j+1).equals(guess1)) {
				count++;
			}
		}
		
		return count;
	}	
}