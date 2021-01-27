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
	int drags =-1;
	

	ArrayList xclickPositions;
	ArrayList yclickPositions;
	
	ArrayList xdragPositions;
	ArrayList ydragPositions;
	boolean isClickInitialised = false;
	
	ArrayList Keyvalues;
	int temp =0;
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
			    	
					Keyvalues.add(clicks, drags ); 
				    System.out.println("lets see key values for each x and each y clicked: "+xclickPositions.get(clicks)+" "+yclickPositions.get(clicks)+" "+Keyvalues.get(clicks));
			    	clicks++;
			    }
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
				
				if(isClickInitialised == true && reference.val == true && reference.DrawFlag >=0 && reference.DrawFlag<=9) {
				
			if(e.getX()>=0 &&e.getX()<=581   && e.getY()>=0  &&e.getY()<=292) {	
				
			    drags++;
			   xdragPositions.add(drags, e.getX());
			   ydragPositions.add(drags, e.getY());
			   

	    	 System.out.println("Inside DrawPanel,drag;showing cords and drag count "+xdragPositions.get(drags)+" "+ydragPositions.get(drags)+" "+drags);
			flag = true;
		
			repaint();
			
			}
			
			}
			}
			
		});
	}
	
	
	
	
	public void paint (Graphics g ) {
		
		if(this.reference.DrawFlag ==0  && this.reference.val == true) {
		
			g.setColor(Color.red);
		g.drawLine(50, 50, 150, 150);
			
		}
		
		
   
	}
	
	
	

}
