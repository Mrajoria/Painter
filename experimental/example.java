package experimental;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;



public class example extends Canvas  

{
	outerwindow o ;
	customButton b[];
	buttonImage bimg;
	
	int px =0;
	int py = 0;
	int xnew = 0;
	int ynew = 0;
	
	Frame f;
	Button b1;
	Button b2;
	Panel draw;
	boolean val = false;
	                                                                                                                      
	
	Panel p;
	Dimension size;
	int DrawFlag =-1;
	
	example(){
		
	f = new Frame();
	
	p = new Panel();
	
	 
	f.setSize(800,400);
	
	
    o = new outerwindow(this);
    
    f.setLayout(new BorderLayout());
    b1 = new Button("Draw");
    
    
    b2 = new Button("Clear");
    
     
   p.setLayout(new BorderLayout());
  
   size = new Dimension(f.getWidth()/4,f.getHeight()/2);
   
   b1.setPreferredSize(size);
   b2.setPreferredSize(size);
  
   p.add(b1,BorderLayout.NORTH);
   p.add(b2, BorderLayout.SOUTH);
  
   b1.addMouseListener(new MouseAdapter() {
	   public void mouseClicked(MouseEvent e) {
		   b1.setBackground(Color.red);
		   
		  
		   val = true;
		   
	   }
   });
   
  
  this.addMouseListener(new MouseAdapter() {
	  public void mouseClicked(MouseEvent e) {
		  if(val == true) {
			
			 px =  e.getX();
			 py = e.getY();
			 System.out.println("Showing click cords "+px+" "+py);
			 
			 repaint();
			 
			}
	  }
 });
  this.addMouseMotionListener(new MouseAdapter(){
	   public void mouseDragged(MouseEvent e) {
		   
		   xnew = e.getX();
		   ynew = e.getY();
		   System.out.println("Drag registered, showing current cords "+xnew+" "+ynew);
		//   draw(xnew, ynew);
		   
		  repaint(0,61,400,200);
	   }
	   
   } );
   
  b2.addMouseListener(new MouseAdapter() {
	  
	 public void mouseClicked(MouseEvent e) {
		val = false;
		
		b1.setBackground(getBackground());
		
         	  
	 }
	  
  });
  
    f.add(this);                             // BE CAREFULL WITH FRAME.ADD, if u add canvas or any component before and start adding other components later, it will not show;
    f.add(p, BorderLayout.WEST);          // frame.add should only be used when u arent adding other components whose size will block your component [canvas, here] 
    f.addWindowListener(o);
    f.setVisible(true);
    f.setResizable(false);	
    
    f.setLocationRelativeTo(null);
   
	}
	
	public void paint(Graphics g) {
		
		int x=0;
		while(x<9) {
		
		g.drawImage(this.bimg.b[x].img, 5+x*65, 5, 57, 57, this);
		x++;
		}
		
		if(px>5 &&px<581 &&py>5 && py<58) {
			
			
			int i=0;
			while(px-(5+i*65) >=0) {
				if(px-(5+i*65)< 57) {
					break;
				}
				
				else	if(px>(5+i*65+57) && px<5+(i+1)*65) {
						i = 1000;
						break;
					}
				else
					
					i++;
				}
			DrawFlag = i;
			System.out.println("Lets see which icon was clicked: "+DrawFlag);
			if(i!=1000) {
			g.setColor(Color.red);
			g.fillRect(2+i*65, 2, 63, 63);    //3,3 to 2,2 and 61 widht height to 63
			g.drawImage(this.bimg.b[i].img, 5+i*65, 5, 57, 57, this);
			
			}
		}
		
		else 
		{
			if(DrawFlag ==0 && val==true) {
				
				g.setColor(Color.red);
				g.fillRect(3+DrawFlag*65, 3, 61, 61);
				g.drawImage(this.bimg.b[DrawFlag].img, 5+DrawFlag*65, 5, 57, 57, this);
				g.drawLine(px, py, xnew, ynew);
				
			}
			
		}
	}

    public static void main(String args[]) {
    	example e = new example();
    	e.b = new customButton[9];
    	for(int x =0;x<e.b.length;x++) {
    		e.b[x] = new customButton();
    		
    	}
    	
    	e.bimg = new buttonImage();
    	e.bimg.b = new buttonImage[9];
    	for(int x=0;x<e.bimg.b.length;x++) {
    		e.bimg.b[x] = new buttonImage();
    	}
    	e.bimg.createImages(e.bimg.b);
    	e.repaint();
    
    }
    	
    }