import java.util.*;

public class HangmanManager
{
	Set<Character> guesses;
	int len; int maxGuesses;
	List<String> dict;
	
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
			dict = dictionary;
		}
	}
	
	public Set<String> words()
	{
		return null;
	}	
	
	public int guessesLeft()
	{
		return 0;
	}
		
	public Set<Character> guesses()
	{
		return null;
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
