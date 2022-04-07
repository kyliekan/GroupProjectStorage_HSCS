import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Background extends JPanel implements Runnable ,MouseListener, MouseMotionListener, KeyListener
{
	int turn;
	private Image background;
	boolean click;
	int rolltime;
	Image d1 = Toolkit.getDefaultToolkit().getImage("d1.png");
    Image d2 = Toolkit.getDefaultToolkit().getImage("d2.png");
    Image d3 = Toolkit.getDefaultToolkit().getImage("d3.png");
    Image d4 = Toolkit.getDefaultToolkit().getImage("d4.png");
    Image d5 = Toolkit.getDefaultToolkit().getImage("d5.png");
    Image d6 = Toolkit.getDefaultToolkit().getImage("d6.png");
    Image logo = Toolkit.getDefaultToolkit().getImage("logo.gif");
    Image n1 = Toolkit.getDefaultToolkit().getImage("one.png");
    Image n2 = Toolkit.getDefaultToolkit().getImage("two.png");
    Image n3 = Toolkit.getDefaultToolkit().getImage("three.png");
    Image n4 = Toolkit.getDefaultToolkit().getImage("four.png");
    Image ctrlz = Toolkit.getDefaultToolkit().getImage("ctrlz.png");
    Image b1 = Toolkit.getDefaultToolkit().getImage("titlescreen.png");
    Image fdance = Toolkit.getDefaultToolkit().getImage("fortnite-default.gif");
    Image mogus = Toolkit.getDefaultToolkit().getImage("mogus.gif");
    int[][] yourMom = new int[10][10];
    public int width, savew;
    public int height, saveh;
    public int r = 1;
    Graphics2D g2;
    Board b;
    boolean hold,startgame,win;
    int s;
    boolean start;
    int mx,my;
    
    
	public Background() {
				addMouseListener(this); /*YOU MUST have this in the constructor of a MouseListener*/
				addMouseMotionListener(this); /*YOU MUST have this in the constructor of a MouseMotionListener*/
				new Thread(this).start(); /*You have to start a new Thread in a Runnable */
				addKeyListener( this ); /*all keyListeners must have this in the constructor*/
				setFocusable( true );
				turn = 1;
				start = true;
				startgame = true;
				for(int i = 0; i < 10; i++) {
					
				}
	}
	public void paintComponent( Graphics window )
	{
		g2 = (Graphics2D) window;
    	background = Toolkit.getDefaultToolkit().getImage("chutes.png"); /*the image cannot be in the SRC folder*/
    	width = this.getSize().width;
    	height = this.getSize().height;  
    	if(width < 500) {
    		width = 500;
    	}
    	if(height < 400) {
    		height = 400;
    	}
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
		
		if(turn == 1) {
			g2.drawImage(n1, (width / 5) / 3, height - (height / 2), width/12, height / 10, this);
		}
		if(turn == 2) {
			g2.drawImage(n2, (width / 5) / 3, height - (height / 2), width/12, height / 10, this);
		}
		if(turn == 3) {
			g2.drawImage(n3, (width / 5) / 3, height - (height / 2), width/12, height / 10, this);
		}
		if(turn == 4) {
			g2.drawImage(n4, (width / 5) / 3, height - (height / 2), width/12, height / 10, this);
		}
        float thickness = 2 + width/600;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect((width / 5) / 3, height - (height / 4), width/12, height / 10, 14, 14);
        g2.drawRoundRect((width / 5) / 3, height - (height / 2), width/12, height / 10, 14, 14);
        g2.setStroke(oldStroke);
        //g2.drawImage(ctrlz, (width / 4) / 5, height - (height/8), width/8, height / 10, this);
        g2.drawImage(logo, 0, 0, width / 5, height / 4, this); 
        g2.drawImage(background, width/5, 0, width - (width / 5), height, this); 
        if(start) {
       	 b = new Board(width,height);
       	 start = false;
       	 savew = width;
       	 saveh = height;
       }
       if(savew != width || saveh != height) {
       	//System.out.println(b.getw1());
       	int ratiow1 = savew * 25 / b.getw1();
       	int ratioh1 = saveh * 30 / b.geth1();
       	int ratiow2 = savew * 25 / b.getw2();
       	int ratioh2 = saveh * 30 / b.geth2();
       	int ratiow3 = savew * 25 / b.getw3();
       	int ratioh3 = saveh * 30 / b.geth3();
       	int ratiow4 = savew * 25 / b.getw4();
       	int ratioh4 = saveh * 30 / b.geth4();
       	if(ratiow1 != 0 && ratioh1 != 0) { 
       		if(savew != width)
       			b.ChangeOne(width * 25 / ratiow1 , b.geth1());
       		if(saveh != height)
       			b.ChangeOne(b.getw1(), height * 30 / ratioh1);
       	}
       	if(ratiow2 != 0 && ratioh2 != 0) { 
       		if(savew != width)
       			b.ChangeTwo(width * 25 / ratiow2, b.geth2());
       		if(saveh != height)
       			b.ChangeTwo(b.getw2(), height * 30 / ratioh2);
       	}
       	if(ratiow3 != 0 && ratioh3 != 0) { 
       		if(savew != width)
       			b.ChangeThree(width * 25 / ratiow3, b.geth3());
       		if(saveh != height)
       			b.ChangeThree(b.getw3(), height * 30 / ratioh3);
       	}
       	if(ratiow4 != 0 && ratioh4 != 0) { 
       		if(savew != width)
       			b.ChangeFour(width * 25 / ratiow4, b.geth4());
       		if(saveh != height)
       			b.ChangeFour(b.getw4(), height * 30 / ratioh4);
       	}
       	b.resize(width,height);
       	savew = width;
       	saveh = height;
       	
       	
       }
       if(hold) {
    	   if(turn == 1) {
    		   b.ChangeOne(mx,my);
    		  
    	   }
    	   if(turn == 2) {
    		   b.ChangeTwo(mx, my);
    		  
    	   }
    	   if(turn == 3) {
    		   b.ChangeThree(mx, my);
    		   
    	   }
    	   if(turn == 4) {
    		   b.ChangeFour(mx,my);
    		  
    	   }
			b.paintComponent(g2);
			b.repaint();
        }
       if(turn == 2 && (b.getw1()) < width/5 + width/15  && b.getw1() > width/5) {
			if(b.geth1() > 0 && b.geth1() < height/10) {
				win = true;
			}
		}
       if(turn == 3 && (b.getw2()) < width/5 + width/15  && b.getw2() > width/5) {
			if(b.geth2() > 0 && b.geth2() < height/10) {
				win = true;
			}
		}
       if(turn == 4 && (b.getw3()) < width/5 + width/15  && b.getw3() > width/5) {
			if(b.geth3() > 0 && b.geth3() < height/10) {
				win = true;
			}
		}
       if(turn == 1 && (b.getw4()) < width/5 + width/15  && b.getw4() > width/5) {
			if(b.geth4() > 0 && b.geth4() < height/10) {
				win = true;
			}
		}
        b.paintComponent(g2);
        if (startgame) {
        
        	g2.drawImage(b1, 0, 0, width, height, this); 
        	g2.drawImage(fdance, 0, 0, width/10, height/10 + height/5, this); 
        	g2.drawImage(mogus,width/5 + 3 * width/5, height - height/5, width/5,height/5,this);
        }
        if (win) {
        	g2.drawImage(fdance, 0, 0, width, height, this); 
        	g2.setColor(Color.black);
        	Font myfont = new Font("comic sans", 1, width/10);
        	g2.setFont(myfont);
        	g2.drawString("WINNER", width/3, height/3 * 2);
        }
        
        
        
        
        
        
        
   //Im sorry god
        if((b.getw1()) < width/5 + ((width - width/5)/10)*4  && b.getw1() > width/5+ ((width - width/5)/10) *3) {
			if(b.geth1() > 9 * height/10 && b.geth1() < height) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*6,height/10 * 8);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*9  && b.getw1() > width/5+ ((width - width/5)/10) *8) {
			if(b.geth1() > 9 * height/10 && b.geth1() < height) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)  && b.getw1() > width/5) {
			if(b.geth1() < 9 * height/10 && b.geth1() > (height/10) * 8) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*8  && b.getw1() > width/5 + ((width - width/5)/10)*7) {
			if(b.geth1() < 8 * height/10 && b.geth1() > (height/10) * 7) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 +((width - width/5)/10)/2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)  && b.getw1() > width/5) {
			if(b.geth1() < 7 * height/10 && b.geth1() > (height/10) * 6) {
				 b.ChangeOne( width/5 + ((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*5  && b.getw1() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth1() < 7 * height/10 && b.geth1() > (height/10) * 6) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*10  && b.getw1() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth1() < 5 * height/10 && b.geth1() > (height/10) * 4) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*6 + ((width - width/5)/10)/2 ,height/10 * 3);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*10  && b.getw1() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth1() < 3 * height/10 && b.geth1() > (height/10) * 2) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)  && b.getw1() > width/5) {
			if(b.geth1() < 3 * height/10 && b.geth1() > (height/10) * 2) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		}    
        if((b.getw2()) < width/5 + ((width - width/5)/10)*4  && b.getw2() > width/5+ ((width - width/5)/10) *3) {
 			if(b.geth2() > 9 * height/10 && b.geth2() < height) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*6,height/10 * 8);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)*9  && b.getw2() > width/5+ ((width - width/5)/10) *8) {
 			if(b.geth2() > 9 * height/10 && b.geth2() < height) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 6);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)  && b.getw2() > width/5) {
 			if(b.geth2() < 9 * height/10 && b.geth2() > (height/10) * 8) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 6);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)*8  && b.getw2() > width/5 + ((width - width/5)/10)*7) {
 			if(b.geth2() < 8 * height/10 && b.geth2() > (height/10) * 7) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 +((width - width/5)/10)/2);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)  && b.getw2() > width/5) {
 			if(b.geth2() < 7 * height/10 && b.geth2() > (height/10) * 6) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 5);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)*5  && b.getw2() > width/5+ ((width - width/5)/10)*4) {
 			if(b.geth2() < 7 * height/10 && b.geth2() > (height/10) * 6) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 5);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)*10  && b.getw2() > width/5+ ((width - width/5)/10)*9) {
 			if(b.geth2() < 5 * height/10 && b.geth2() > (height/10) * 4) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*6 + ((width - width/5)/10)/2 ,height/10 * 3);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)*10  && b.getw2() > width/5+ ((width - width/5)/10)*9) {
 			if(b.geth2() < 3 * height/10 && b.geth2() > (height/10) * 2) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 - height/20);
 			}
 		} 
         if((b.getw2()) < width/5 + ((width - width/5)/10)  && b.getw2() > width/5) {
 			if(b.geth2() < 3 * height/10 && b.geth2() > (height/10) * 2) {
 				 b.ChangeTwo( width/5 + ((width - width/5)/10)/2 ,height/10 - height/20);
 			}
 		}  
        if((b.getw3()) < width/5 + ((width - width/5)/10)*4  && b.getw3() > width/5+ ((width - width/5)/10) *3) {
			if(b.geth3() > 9 * height/10 && b.geth3() < height) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*6,height/10 * 8);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*9  && b.getw3() > width/5+ ((width - width/5)/10) *8) {
			if(b.geth3() > 9 * height/10 && b.geth3() < height) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)  && b.getw3() > width/5) {
			if(b.geth3() < 9 * height/10 && b.geth3() > (height/10) * 8) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*8  && b.getw3() > width/5 + ((width - width/5)/10)*7) {
			if(b.geth3() < 8 * height/10 && b.geth3() > (height/10) * 7) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 +((width - width/5)/10)/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)  && b.getw3() > width/5) {
			if(b.geth3() < 7 * height/10 && b.geth3() > (height/10) * 6) {
				 b.ChangeThree( width/5 + ((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*5  && b.getw3() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth3() < 7 * height/10 && b.geth3() > (height/10) * 6) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*10  && b.getw3() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth3() < 5 * height/10 && b.geth3() > (height/10) * 4) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*6 + ((width - width/5)/10)/2 ,height/10 * 3);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*10  && b.getw3() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth3() < 3 * height/10 && b.geth3() > (height/10) * 2) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)  && b.getw3() > width/5) {
			if(b.geth3() < 3 * height/10 && b.geth3() > (height/10) * 2) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		}    
        if((b.getw4()) < width/5 + ((width - width/5)/10)*4  && b.getw4() > width/5+ ((width - width/5)/10) *3) {
			if(b.geth4() > 9 * height/10 && b.geth4() < height) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*6,height/10 * 8);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*9  && b.getw4() > width/5+ ((width - width/5)/10) *8) {
			if(b.geth4() > 9 * height/10 && b.geth4() < height) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)  && b.getw4() > width/5) {
			if(b.geth4() < 9 * height/10 && b.geth4() > (height/10) * 8) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 6);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*8  && b.getw4() > width/5 + ((width - width/5)/10)*7) {
			if(b.geth4() < 8 * height/10 && b.geth4() > (height/10) * 7) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 +((width - width/5)/10)/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)  && b.getw4() > width/5) {
			if(b.geth4() < 7 * height/10 && b.geth4() > (height/10) * 6) {
				 b.ChangeFour( width/5 + ((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*5  && b.getw4() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth4() < 7 * height/10 && b.geth4() > (height/10) * 6) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 5);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*10  && b.getw4() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth4() < 5 * height/10 && b.geth4() > (height/10) * 4) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*6 + ((width - width/5)/10)/2 ,height/10 * 3);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*10  && b.getw4() > width/5+ ((width - width/5)/10)*9) {
			if(b.geth4() < 3 * height/10 && b.geth4() > (height/10) * 2) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)  && b.getw4() > width/5) {
			if(b.geth4() < 3 * height/10 && b.geth4() > (height/10) * 2) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)/2 ,height/10 - height/20);
			}
		} 
        // forgive me for this sin
        
        
        
        
        
        
        
        
        
        if((b.getw1()) < width/5 + ((width - width/5)/10)*3  && b.getw1() > width/5+ ((width - width/5)/10)*2) {
			if(b.geth1() <  height/10 && b.geth1() > 0 ) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*6  && b.getw1() > width/5+ ((width - width/5)/10)*5) {
			if(b.geth1() <  height/10 && b.geth1() > 0 ) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*8  && b.getw1() > width/5+ ((width - width/5)/10)*7) {
			if(b.geth1() <  height/10 && b.geth1() > 0 ) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*7  && b.getw1() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth1() <  (height/10)*2 && b.geth1() > height/10 ) {
				 b.ChangeOne( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 7);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*4  && b.getw1() > width/5+ ((width - width/5)/10)*3) {
			if(b.geth1() <  (height/10)*4 && b.geth1() > (height/10)*3 ) {
				 b.ChangeOne( width/5  + ((width - width/5)/10)/2 ,height/10 * 4 + (height/10)/2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*2  && b.getw1() > width/5+ ((width - width/5)/10)) {
			if(b.geth1() <  (height/10)*4 && b.geth1() > (height/10)*3 ) {
				 b.ChangeOne( width/5  +((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 8 );
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*5 && b.getw1() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth1() <  (height/10)*5 && b.geth1() > (height/10)*4 ) {
				 b.ChangeOne( width/5  +((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 4 + height/10/2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*7 && b.getw1() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth1() <  (height/10)*6 && b.geth1() > (height/10)*5 ) {
				 b.ChangeOne( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 7 + height/10/2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*9 && b.getw1() > width/5+ ((width - width/5)/10)*8) {
			if(b.geth1() <  (height/10)*6 && b.geth1() > (height/10)*5 ) {
				 b.ChangeOne( width/5  +((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 8 + height/10/2);
			}
		} 
        if((b.getw1()) < width/5 + ((width - width/5)/10)*5 && b.getw1() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth1() <  (height/10)*9 && b.geth1() > (height/10)*8 ) {
				 b.ChangeOne( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 9 + height/10/2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*3  && b.getw2() > width/5+ ((width - width/5)/10)*2) {
			if(b.geth2() <  height/10 && b.geth2() > 0 ) {
				 b.ChangeTwo( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*6  && b.getw2() > width/5+ ((width - width/5)/10)*5) {
			if(b.geth2() <  height/10 && b.geth2() > 0 ) {
				 b.ChangeTwo( width/5 + ((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*8  && b.getw2() > width/5+ ((width - width/5)/10)*7) {
			if(b.geth2() <  height/10 && b.geth2() > 0 ) {
				 b.ChangeTwo( width/5 + ((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*7  && b.getw2() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth2() <  (height/10)*2 && b.geth2() > height/10 ) {
				 b.ChangeTwo( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 7);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*4  && b.getw2() > width/5+ ((width - width/5)/10)*3) {
			if(b.geth2() <  (height/10)*4 && b.geth2() > (height/10)*3 ) {
				 b.ChangeTwo( width/5  + ((width - width/5)/10)/2 ,height/10 * 4 + (height/10)/2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*2  && b.getw2() > width/5+ ((width - width/5)/10)) {
			if(b.geth2() <  (height/10)*4 && b.geth2() > (height/10)*3 ) {
				 b.ChangeTwo( width/5  +((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 8 );
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*5 && b.getw2() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth2() <  (height/10)*5 && b.geth2() > (height/10)*4 ) {
				 b.ChangeTwo( width/5  +((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 4 + height/10/2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*7 && b.getw2() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth2() <  (height/10)*6 && b.geth2() > (height/10)*5 ) {
				 b.ChangeTwo( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 7 + height/10/2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*9 && b.getw2() > width/5+ ((width - width/5)/10)*8) {
			if(b.geth2() <  (height/10)*6 && b.geth2() > (height/10)*5 ) {
				 b.ChangeTwo( width/5  +((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 8 + height/10/2);
			}
		} 
        if((b.getw2()) < width/5 + ((width - width/5)/10)*5 && b.getw2() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth2() <  (height/10)*9 && b.geth2() > (height/10)*8 ) {
				 b.ChangeTwo( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 9 + height/10/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*3  && b.getw3() > width/5+ ((width - width/5)/10)*2) {
			if(b.geth3() <  height/10 && b.geth3() > 0 ) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*6  && b.getw3() > width/5+ ((width - width/5)/10)*5) {
			if(b.geth3() <  height/10 && b.geth3() > 0 ) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*8  && b.getw3() > width/5+ ((width - width/5)/10)*7) {
			if(b.geth3() <  height/10 && b.geth3() > 0 ) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*7  && b.getw3() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth3() <  (height/10)*2 && b.geth3() > height/10 ) {
				 b.ChangeThree( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 7);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*4  && b.getw3() > width/5+ ((width - width/5)/10)*3) {
			if(b.geth3() <  (height/10)*4 && b.geth3() > (height/10)*3 ) {
				 b.ChangeThree( width/5  + ((width - width/5)/10)/2 ,height/10 * 4 + (height/10)/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*2  && b.getw3() > width/5+ ((width - width/5)/10)) {
			if(b.geth3() <  (height/10)*4 && b.geth3() > (height/10)*3 ) {
				 b.ChangeThree( width/5  +((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 8 );
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*5 && b.getw3() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth3() <  (height/10)*5 && b.geth3() > (height/10)*4 ) {
				 b.ChangeThree( width/5  +((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 4 + height/10/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*7 && b.getw3() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth3() <  (height/10)*6 && b.geth3() > (height/10)*5 ) {
				 b.ChangeThree( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 7 + height/10/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*9 && b.getw3() > width/5+ ((width - width/5)/10)*8) {
			if(b.geth3() <  (height/10)*6 && b.geth3() > (height/10)*5 ) {
				 b.ChangeThree( width/5  +((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 8 + height/10/2);
			}
		} 
        if((b.getw3()) < width/5 + ((width - width/5)/10)*5 && b.getw3() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth3() <  (height/10)*9 && b.geth3() > (height/10)*8 ) {
				 b.ChangeThree( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 9 + height/10/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*3  && b.getw4() > width/5+ ((width - width/5)/10)*2) {
			if(b.geth4() <  height/10 && b.geth4() > 0 ) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*2 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*6  && b.getw4() > width/5+ ((width - width/5)/10)*5) {
			if(b.geth4() <  height/10 && b.geth4() > 0 ) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*8  && b.getw4() > width/5+ ((width - width/5)/10)*7) {
			if(b.geth4() <  height/10 && b.geth4() > 0 ) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*7  && b.getw4() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth4() <  (height/10)*2 && b.geth4() > height/10 ) {
				 b.ChangeFour( width/5 + ((width - width/5)/10)*3 + ((width - width/5)/10)/2 ,height/10 * 7);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*4  && b.getw4() > width/5+ ((width - width/5)/10)*3) {
			if(b.geth4() <  (height/10)*4 && b.geth4() > (height/10)*3 ) {
				 b.ChangeFour( width/5  + ((width - width/5)/10)/2 ,height/10 * 4 + (height/10)/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*2  && b.getw4() > width/5+ ((width - width/5)/10)) {
			if(b.geth4() <  (height/10)*4 && b.geth4() > (height/10)*3 ) {
				 b.ChangeFour( width/5  +((width - width/5)/10) + ((width - width/5)/10)/2 ,height/10 * 8 );
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*5 && b.getw4() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth4() <  (height/10)*5 && b.geth4() > (height/10)*4 ) {
				 b.ChangeFour( width/5  +((width - width/5)/10)*7 + ((width - width/5)/10)/2 ,height/10 * 4 + height/10/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*7 && b.getw4() > width/5+ ((width - width/5)/10)*6) {
			if(b.geth4() <  (height/10)*6 && b.geth4() > (height/10)*5 ) {
				 b.ChangeFour( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 7 + height/10/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*9 && b.getw4() > width/5+ ((width - width/5)/10)*8) {
			if(b.geth4() <  (height/10)*6 && b.geth4() > (height/10)*5 ) {
				 b.ChangeFour( width/5  +((width - width/5)/10)*9 + ((width - width/5)/10)/2 ,height/10 * 8 + height/10/2);
			}
		} 
        if((b.getw4()) < width/5 + ((width - width/5)/10)*5 && b.getw4() > width/5+ ((width - width/5)/10)*4) {
			if(b.geth4() <  (height/10)*9 && b.geth4() > (height/10)*8 ) {
				 b.ChangeFour( width/5  +((width - width/5)/10)*5 + ((width - width/5)/10)/2 ,height/10 * 9 + height/10/2);
			}
		} 




    }
	public void keyTyped(KeyEvent e)
	{
	//I like Ryan <3
	}
	
	/*2*/
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_R) {
			turn--;
			win = false;
			if(turn < 1)
				turn = 4;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			startgame = false;
			repaint();
		}
	}
	
	/*3*/	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			turn++;
			if(turn > 4) {
				turn = 1;
			}
			
		}
		
	}


	
	public void roll() {
		r = (int) (Math.random() * 6) + 1;
		}
	public void mousePressed(MouseEvent e) {
		if( e.getButton() == 1) {
			int x = e.getX();
			int y = e.getY();
			if( x < (((width / 5) / 3) + (width / 12)) && x > ((width / 5) / 3)) {
				if(y < ((height - (height / 4)) + (height / 10)) && y > (height - (height / 4))) {
					click = true;
					rolltime =(int) (Math.random() * 12) + 7;				}
			}
			if(turn == 1 && x> (b.getw1()) && x < (b.getw1()+width /10)) {
				if(y > (b.geth1()) && y < (b.geth1()+height/30)) {
					hold = true;
					
					 b.paintComponent(g2);
					
				}
			}
			if(turn == 2 && x> (b.getw2()) && x < (b.getw2()+width /10)) {
				if(y > (b.geth2()) && y < (b.geth2()+height/30)) {
					hold = true;
					
					 b.paintComponent(g2);
					
				}
			}
			if(turn == 3 && x> (b.getw3()) && x < (b.getw3()+width /10)) {
				if(y > (b.geth3()) && y < (b.geth3()+height/30)) {
					hold = true;
					
					 b.paintComponent(g2);
					
				}
			}
			if(turn == 4 && x> (b.getw4()) && x < (b.getw4()+width /10)) {
				if(y > (b.geth4()) && y < (b.geth4()+height/30)) {
					hold = true;
					
					 b.paintComponent(g2);
					
				}
			}
		}
	}
	/*2 mouseReleased -- when mouse button is released*/
	public void mouseReleased(MouseEvent e) { 
		if(e.getButton() == 1) {
			hold = false;
			int x = e.getX();
			int y = e.getY();
			//b.ChangeOne(x,y);
			

		}
	}
	/*3 mouseEntered -- when the mouse enters the window */
	public void mouseEntered(MouseEvent e) { }
	/*4 mouseExited -- when the mouse exits the window*/
	public void mouseExited(MouseEvent e) { }
	/*5 mouseClicked -- when the mouse button is pressed and released*/
	public void mouseClicked(MouseEvent e) { }
	/*You MUST have these 2 methods in a MouseMotionListener*/
	/*1 mouseDragged -- when a mouse button is pressed and held down and moved*/
	public void mouseDragged(MouseEvent e){ 	
	mx = e.getX();
	my = e.getY();
	}
	/*2 mouseMoved -- when mouse cursor is moved around the window*/
	public void mouseMoved(MouseEvent e){  
		mx = e.getX();
		my = e.getY();
    	 /*this updates the X coordinate of the mouse*/
    	 /*this updates the Y coordinate of the mouse*/
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				
				if(click) {
					roll();
					rolltime --;
					if(rolltime == 0) {
						click = false;
					}	
				}  
				
				 repaint();
				 Thread.sleep(75);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}