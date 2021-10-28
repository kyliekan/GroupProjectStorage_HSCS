import java.util.*;

public class HangmanManager
{
	Set<String> words;
	Map<Integer,String> pat;
	int x, len;
	Set<Character> guesses;
	String pattern;
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		
		if(length > 1 && max > 0)
		{
		x = max;
		len = length;
		guesses = new HashSet<Character>();
		pat = new TreeMap<Integer,String>();
		words = new HashSet<String>();
		for(int h = 0; h < 26; h++)
			pat.put(h,"-");
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
	
	public Set<String> words() { return words; }	
	
	public int guessesLeft() { return x; }
		
	public Set<Character> guesses() { return guesses; }
	
	public String pattern() { return pattern; }
	
	public String getPatt(String word, String g) {
		word = word.replaceAll(g, "!");
		word = word.replaceAll("[a-zA-Z]", "-");
		word = word.replaceAll("!", g);
		return word;
	}
	public int record( char guess )
	{
		Set<String> newwords = new HashSet<String>();
		guesses.add(guess);
		String g = Character.toString(guess);
		String[] wordlistunedited = words.toArray(new String[words.size()]);
		String[] wordlist = words.toArray(new String[words.size()]);
		
		for(int i = 0; i < wordlist.length;i++)
		{
			wordlist[i] = wordlist[i].replaceAll(g, "!");
			wordlist[i] = wordlist[i].replaceAll("[a-zA-z]", "-");
			wordlist[i] = wordlist[i].replaceAll("!", g);
		}
		int big = 0; String p2 = "";
		Map<String,Integer> groups = new HashMap<String,Integer>();
		for(String s: wordlist) {
			  if (!groups.containsKey(s)) { 
				  groups.put(s, 1);
				  if(groups.get(s) > big) {
			    	  big = groups.get(s);
			    	  p2 = s; } }
			  else {
			      int count = groups.get(s);
			      groups.put(s, count + 1);
			      if(groups.get(s) > big) {
			    	  big = groups.get(s);
			    	  p2 = s;
			      }
			    }
			}
		words = newwords;
		char[] joe = pattern.toCharArray();
		for(int h = 0; h < wordlistunedited.length; h++) {
			if(p2.equals(getPatt(wordlistunedited[h],g))) {
				newwords.add(wordlistunedited[h]);
			}
		}	
		if(pattern != p2) {
			for(int p = 0; p < pattern.length();p++) {
				if(pattern.substring(p,p+1).equals("-") && !p2.substring(p,p+1).equals("-")) {
					joe[p] = p2.charAt(p);
				}
			}
		}
		if(p2 == p2.replaceAll("[a-zA-Z]","-")){ x--; }
		pattern = "";
		for(char k: joe)
			pattern += k;
		int cnt = 0;
		for(int j = 0; j < p2.length();j++) {
			if(p2.substring(j,j+1).equals(g)) {
				cnt++;
			}
		}
		return cnt;
	}	
}
