import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JPanel;

public class froggy extends JPanel implements KeyListener,Runnable {
	Graphics2D window;
	public int width, height;
	public int Score;
	public int Speed;
	public int lives;
	public boolean startgame;
	public froggy(){
		new Thread(this).start(); 
		addKeyListener( this ); 
		setFocusable( true );
		startgame = true;
	}
	
	public void paintComponent( Graphics w) {
		window = (Graphics2D) w;
		width = this.getSize().width;
		height = this.getSize().height;
		window.setColor(Color.BLACK);
		window.fillRect(0,0,width,height);
		if(startgame) {
			Image start = Toolkit.getDefaultToolkit().getImage("start_button.png");
			window.drawImage(start, width/3, height/3, width/3, height/3, this);
		}		
		if(!startgame) {
			Image frog = Toolkit.getDefaultToolkit().getImage("frog.jfif");
			window.drawImage(frog, width/3, height/3, width/3, height/3, this);
		}
	}
	
	
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			startgame = false;
			
		}
	}




	@Override
	public void run() {
		 try {
				while(true) {
						 repaint();
						
							Thread.sleep(75);
				}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}// TODO Auto-generated method stub
		
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
