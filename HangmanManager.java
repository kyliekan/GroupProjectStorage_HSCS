import java.util.*;

public class HangmanManager
{
	Set<Character> allGuesses;
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
		}
	}
	
	public Set<String> words()
	{
		HashSet<String> set = new HashSet<String>(dict);
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
		
		return pattern;
	}
	
	public int record( char guess )
	{
		return 0;
	}
}
