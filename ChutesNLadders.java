import java.awt.*;
import javax.swing.*;

public class ChutesNLadders extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public ChutesNLadders()
	{
		super("MouseBob Runner");

		setSize(WIDTH,HEIGHT);
		
		       
		add( new Background() );	
       	
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		ChutesNLadders run = new ChutesNLadders();
	}
}