import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Background extends JPanel implements Runnable ,MouseListener, MouseMotionListener
{
	private Image background;
	Image d1 = Toolkit.getDefaultToolkit().getImage("1-die.png");
    Image d2 = Toolkit.getDefaultToolkit().getImage("2-die.png");
    Image d3 = Toolkit.getDefaultToolkit().getImage("3-die.png");
    Image d4 = Toolkit.getDefaultToolkit().getImage("4-die.png");
    Image d5 = Toolkit.getDefaultToolkit().getImage("5-die.png");
    Image d6 = Toolkit.getDefaultToolkit().getImage("6-die.png");
    Image logo = Toolkit.getDefaultToolkit().getImage("logo.jpeg");
    public int width;
    public int height;
    public int r = 1;
    Graphics2D g2;
	
	public void paintComponent( Graphics window )
	{

		//this allows us to put a png,jpg, or gif
		addMouseListener(this); /*YOU MUST have this in the constructor of a MouseListener*/
		addMouseMotionListener(this); /*YOU MUST have this in the constructor of a MouseMotionListener*/
		new Thread(this).start(); /*You have to start a new Thread in a Runnable */
		
		g2 = (Graphics2D) window;
    	background = Toolkit.getDefaultToolkit().getImage("chutes.jpg"); /*the image cannot be in the SRC folder*/
    	
    	width = this.getSize().width;
    	height = this.getSize().height;
    	//int width = this.getSize().width;
        //int height = this.getSize().height;
        
        g2.setColor(new Color(227, 214, 165));
        g2.fillRect(0, 0, width, height);
        g2.setColor(Color.BLACK);
        
        
        if(r == 1) 
			 g2.drawImage(d1, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
			
		if(r == 2) 
			 g2.drawImage(d2, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
			
		if(r == 3) 
			 g2.drawImage(d3, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
			
		if(r == 4) 
			 g2.drawImage(d4, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
			 
		if(r == 5) 
			 g2.drawImage(d5, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
			
		if(r == 6)
			 g2.drawImage(d6, (width / 5) / 3, height - (height / 4), width/12, height / 10, this);
		
        float thickness = 2 + width/600;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect((width / 5) / 3, height - (height / 4), width/12, height / 10, 14, 14);
        g2.setStroke(oldStroke);
        
        g2.drawImage(logo, 0, 0, width / 5, height / 4, this); 
        g2.drawImage(background, width/5, 0, width - (width / 5), height, this); 
        
       
    }
	
	public void roll() {
		r = (int) (Math.random() * 6) + 1;
		repaint();
	}
	
	
	/*1 mousePressed -- when mouse button is pressed*/
	public void mousePressed(MouseEvent e) {
		if( e.getButton() == 1) {
			int x = e.getX();
			int y = e.getY();
			if(x < (((width / 5) / 3) + (width / 12)) && x > ((width / 5) / 3)) {
				if(y < ((height - (height / 4)) + (height / 10)) && y > (height - (height / 4))) {
					this.roll();
				}
			}
		}
	}
	/*2 mouseReleased -- when mouse button is released*/
	public void mouseReleased(MouseEvent e) { }
	/*3 mouseEntered -- when the mouse enters the window */
	public void mouseEntered(MouseEvent e) { }
	/*4 mouseExited -- when the mouse exits the window*/
	public void mouseExited(MouseEvent e) { }
	/*5 mouseClicked -- when the mouse button is pressed and released*/
	public void mouseClicked(MouseEvent e) { 
		
		
	}

/*You MUST have these 2 methods in a MouseMotionListener*/
	/*1 mouseDragged -- when a mouse button is pressed and held down and moved*/
	public void mouseDragged(MouseEvent e){  }
	/*2 mouseMoved -- when mouse cursor is moved around the window*/
	public void mouseMoved(MouseEvent e){  		
    	 /*this updates the X coordinate of the mouse*/
    	 /*this updates the Y coordinate of the mouse*/
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}