import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener{
	public int curX;
	public int curY;
	public int height;
	public int width;
	public int w1,w2,w3,w4;
	public int h1,h2,h3,h4;
	
	
public Board(int w, int h) {
	width = w/5;
	height = h;
	w1 = width + width/20;
	w2 = width + width/20;
	w3 = width + width/5;
	w4 = width + width/5;
	h1 = height - height/10;
	h3= height - height/10;
	h2 = height - height/25;
	h4 = height - height/25;
}
public void paintComponent(Graphics w)
{	
	GamePiece one = new GamePiece(w1,h1,1,width,height);
	GamePiece two = new GamePiece(w2,h2,2,width,height);
	GamePiece three = new GamePiece(w3,h3,3,width,height);
	GamePiece four = new GamePiece(w4,h4,4,width,height);
	one.paintComponent(w);
	two.paintComponent(w);
	three.paintComponent(w);
	four.paintComponent(w);
}
public void ChangeOne(int w, int h) {
	w1 = w; h1 = h;
}
public void ChangeTwo(int w, int h) {
	w2 = w; h2 = h;
}
public void ChangeThree(int w, int h) {
	w3 = w; h3 = h;
}
public void ChangeFour(int w, int h) {
	w4 = w; h4 = h;
}
public int getw1() {
	return w1;
}
public int getw2() {
	return w2;
}
public int getw3() {
	return w3;
}
public int getw4() {
	return w4;
}
public int geth1() {
	return h1;
}
public int geth2() {
	return h2;
}
public int geth3() {
	return h3;
}
public int geth4() {
	return h4;
}


public void mousePressed(MouseEvent e) { }
/*2 mouseReleased -- when mouse button is released*/
public void mouseReleased(MouseEvent e) { }
/*3 mouseEntered -- when the mouse enters the window */
public void mouseEntered(MouseEvent e) { }
/*4 mouseExited -- when the mouse exits the window*/
public void mouseExited(MouseEvent e) { }
/*5 mouseClicked -- when the mouse button is pressed and released*/
public void mouseClicked(MouseEvent e) { 
	if(e.getButton() == 1) {
		System.out.println(curX);
	if(curX > (w1) && curX < (w1+width /10)) {
		if(curY > (h1) && curY < (h1+height/30)) {
			w1 = curX;
			h1 = curY;
			System.out.println("k");
		}
	}
	}
}
/*You MUST have these 2 methods in a MouseMotionListener*/
/*1 mouseDragged -- when a mouse button is pressed and held down and moved*/
public void mouseDragged(MouseEvent e){
	if(curX < (w1) && curX > (w1+width /10)) {
		if(curY < (h1) && curY > (h1+height/30)) {
			w1 = curX;
			h1 = curY;
			System.out.println("k");
		}
	}
}
/*2 mouseMoved -- when mouse cursor is moved around the window*/
public void mouseMoved(MouseEvent e){  		
	curX = e.getX(); /*this updates the X coordinate of the mouse*/
	curY = e.getY(); /*this updates the Y coordinate of the mouse*/
}
}