import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class froggy_runner extends JFrame  implements KeyListener,Runnable {
	
		private static final int WIDTH = 2300;
		private static final int HEIGHT = 1200;

		public froggy_runner()
		{
			super("Fullscreen");
			getContentPane().setPreferredSize(      

			Toolkit.getDefaultToolkit().getScreenSize());
			pack();
			setResizable(false);
			setLocationRelativeTo(null);
			
			
			setSize(WIDTH,HEIGHT);
			
			       
			add( new froggy() );	
	       	
			
			setVisible(true);	
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public static void main( String args[] )
		{
			froggy_runner run = new froggy_runner();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}



