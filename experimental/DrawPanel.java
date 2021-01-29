package experimental;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;



public class DrawPanel extends Panel {
	
	
	example reference;
	int clicks =0;
	int drags =0;
	

	ArrayList xclickPositions;
	ArrayList yclickPositions;
	
	ArrayList xdragPositions;
	ArrayList ydragPositions;
	boolean isClickInitialised = false;
	
	ArrayList Keyvalues;
	int clickX = -1;
	int clickY = -1;
	
	int dragX =-1;
	int dragY =-1;
	
	boolean flag = false;
	
	DrawPanel(example se)
	{
		this.reference = se;
		this.xclickPositions = new ArrayList();
		this.yclickPositions = new ArrayList();
		
		this.xdragPositions = new ArrayList();
		this.ydragPositions = new ArrayList();
		
		this.Keyvalues = new ArrayList();
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (reference.val == true && reference.DrawFlag>=0 && reference.DrawFlag<=9 ) {
			    if (flag == true) {
			    	clicks++;
			    }
			    clickX =e.getX();
			    clickY =e.getY();
			    
				xclickPositions.add(clicks, e.getX());
				yclickPositions.add(clicks, e.getY());
	
				isClickInitialised = true;
				flag = false;
				
		
		     System.out.println("Inside DrawPanel, click registered, showing coordinates and click index: "+xclickPositions.get(clicks)+" "+yclickPositions.get(clicks)+" "+clicks);
			 }
			}
			
		});
		
		this.addMouseMotionListener(new MouseAdapter() {
		
			public void mouseDragged(MouseEvent e) {
				
				if(xclickPositions.size()>=1  && reference.val == true && reference.DrawFlag >=0 && reference.DrawFlag<=9) {
				
			if(e.getX()>=0 &&e.getX()<=581   && e.getY()>=0  &&e.getY()<=292) {	
				
				if(reference.DrawFlag ==0) {
				
				dragX = e.getX();
				dragY =e.getY();
			   xdragPositions.add(drags, e.getX());
			   ydragPositions.add(drags, e.getY());
			   System.out.println("Inside DrawPanel,drag;showing cords and drag count "+xdragPositions.get(drags)+" "+ydragPositions.get(drags)+" "+drags);
			   Keyvalues.add(clicks, drags ); 

			   drags++;
			   isClickInitialised =false;
			   flag = true;
			   repaint();
				}
				
				else if(reference.DrawFlag >=1 && reference.DrawFlag <=5) {
				 if(isClickInitialised == true && xclickPositions.size()>=2) {
					 drags++;
				 }
				 dragX = e.getX();
				 dragY =e.getY();
				 xdragPositions.add(drags, e.getX());
				 ydragPositions.add(drags, e.getY());
				 System.out.println("Inside DrawPanel,drag;showing cords and drag count "+xdragPositions.get(drags)+" "+ydragPositions.get(drags)+" "+drags);
				 Keyvalues.add(clicks, drags ); 

				 
				 flag = true;
				 isClickInitialised =false;
				 repaint();
				}
			    System.out.println("lets see key values for each x and each y clicked: "+xclickPositions.get(clicks)+" "+yclickPositions.get(clicks)+" "+Keyvalues.get(clicks));
				  
			repaint();
			
			}
			
			}
			}
			
		});
	}
	
	
	
	
	public void update (Graphics g ) {
		
		if(this.reference.DrawFlag ==0  && this.reference.val == true) {
		
			int i=0;
			int j=0;
			g.clearRect(0, 0, this.getWidth(), this.getHeight());

			while(i<xclickPositions.size()) {
				
				while(j<(int)Keyvalues.get(i)) {
					g.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),5,5);
					j++;
				}
				i++;
			}
			
		}
		
		if(this.reference.DrawFlag ==1  && this.reference.val == true) {
		    
	     	g.clearRect(0, 0 ,this.getWidth(), this.getHeight());

			int i=0;
			int j=0;
			if(xclickPositions.size()>1) {
			while(i<xclickPositions.size()) {
				
				while(j<=(int)Keyvalues.get(i)) {
					g.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
					
					j++;
				}
				i++;
			}
		    
		   }
				g.drawLine(clickX, clickY,dragX,dragY);
			
		}
		
   
	
	}
	
	}
