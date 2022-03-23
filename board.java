import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class board extends JPanel implements MouseListener, MouseMotionListener{
	public int curX;
	public int CurY;
	public int height;
	public int width;
	
public board(int w, int h) {
	width = w/5;
	height = h;
}
public void paintComponent(Graphics w )
{	
	GamePiece one = new GamePiece(width,height,1);
	GamePiece two = new GamePiece(width,height,2);
	GamePiece three = new GamePiece(width,height,3);
	GamePiece four = new GamePiece(width,height,4);
	
	
	
}


public void mousePressed(MouseEvent e) { }
/*2 mouseReleased -- when mouse button is released*/
public void mouseReleased(MouseEvent e) { }
/*3 mouseEntered -- when the mouse enters the window */
public void mouseEntered(MouseEvent e) { }
/*4 mouseExited -- when the mouse exits the window*/
public void mouseExited(MouseEvent e) { }
/*5 mouseClicked -- when the mouse button is pressed and released*/
public void mouseClicked(MouseEvent e) { }
/*You MUST have these 2 methods in a MouseMotionListener*/
/*1 mouseDragged -- when a mouse button is pressed and held down and moved*/
public void mouseDragged(MouseEvent e){ }
/*2 mouseMoved -- when mouse cursor is moved around the window*/
public void mouseMoved(MouseEvent e){  		
	curX = e.getX(); /*this updates the X coordinate of the mouse*/
	CurY = e.getY(); /*this updates the Y coordinate of the mouse*/
}
}