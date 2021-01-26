package experimental;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;



public class DrawPanel extends Panel {
	
	
	int clicks =0;
	int drags =0;
	int xdragpositionArray[] = new int[582];
	int ydragpositionArray[] = new int[292];
	
	int xclickpositionArray[] = new int[582];
	int yclickpositionArray[] = new int[292];
	int temp =-1;
	
	
	
	boolean flag = false;
	
	DrawPanel()
	{
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				clicks++;	
				
	        System.out.println("Inside DrawPanel, click registered, showing coordinates and click count: "+e.getX()+" "+e.getX()+" "+clicks);
				
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter() {
		
			public void mouseDragged(MouseEvent e) {
				
				drags++;

		//	System.out.println("Inside DrawPanel,drag;showing cords and drag count "+xdragpositionArray[drags]+" "+ydragpositionArray[drags]+" "+drags);
			flag = false;
		
			repaint();
			}
			
		});
	}
	/*
	public void pushclickPositions(int ex, int ey) {
		
		while(temp == drags) {
			xclickpositionArray[clicks] = ex;
			yclickpositionArray[clicks] = ey;
			
			
		}
		*/
		
	
	
	
	
	
	public void paint (Graphics g ) {
		
	
		int i=0;
		
		
		
		
	}
	
	
	

}
