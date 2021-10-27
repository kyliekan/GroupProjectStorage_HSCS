import java.util.*;

public class HangmanManager
{
	Set<Character> allGuesses;
	HashSet<String> set;
	int len; int maxGuesses; int guesses;
	List<String> dict;
	String pattern;
	
	public HangmanManager( List<String> dictionary, int length, int max ) throws IllegalArgumentException
	{
		pattern = "";
		if(length < 1) {
			throw new IllegalArgumentException("Length cannot be less than 1.");
		}
		if(max < 0) {
			throw new IllegalArgumentException("Max cannot be less than 0.");
		}
		else {
			maxGuesses = max;
			len = length;
			dict = dictionary;
			
			for(int i = 0; i < length; i++) 
				pattern += "-";
			
			set = new HashSet<String>();
		}
	}
	
	public Set<String> words()
	{
		return set;
	}	
	
	public int guessesLeft()
	{
		return maxGuesses - guesses;
	}
		
	public Set<Character> guesses()
	{
		return allGuesses;
	}
	
	public String pattern()
	{
		if(set.isEmpty())
			throw new IllegalStateException("Word set cannot be empty."); 
		return pattern;
	}
	
	public int record( char guess )
	{
		return 0;
	}
}
