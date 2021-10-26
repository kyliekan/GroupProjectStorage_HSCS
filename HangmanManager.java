import java.util.*;

public class HangmanManager
{
	Set<Character> allGuesses;
	int len; int maxGuesses; int guesses;
	Set<String> dict;
	
	public HangmanManager( List<String> dictionary, int length, int max ) throws IllegalArgumentException
	{
		if(length < 1) {
			throw new IllegalArgumentException("Length cannot be less than 1.");
		}
		if(max < 0) {
			throw new IllegalArgumentException("Max cannot be less than 0.");
		}
		else {
			maxGuesses = max;
			len = length;
			
		}
	}
	
	public Set<String> words()
	{
		HashSet<String> map = new HashSet<String>(dict);
		return map;
	}	
	
	public int guessesLeft()
	{
		return guesses;
	}
		
	public Set<Character> guesses()
	{
		return allGuesses;
	}
	
	public String pattern()
	{
		return "";
	}
	
	public int record( char guess )
	{
		return 0;
	}
}
