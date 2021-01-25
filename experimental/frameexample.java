
package experimental;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;

public class frameexample  extends Frame
{
	
	 int px =0;
	 int py=0;
	 
    customButton b[];
    buttonImage bimg;
    
	frameexample(){
		
		
		}
	

	public static void main (String args[]) {
		
		frameexample f  = new frameexample();
		f.setSize(400, 200);
		
		
		
		
		
	 class somepanel extends JPanel {
		 int x =0;
		 int y =0;
		 boolean flag =  false;
		 
		 public void paintComponent(Graphics g) {
			 
			 g.clearRect(0, 0, this.getWidth(), this.getHeight());
			 
			 f.bimg = new buttonImage();
			 f.bimg.b = new buttonImage[4];
			 
			 for(int x=0;x<f.bimg.b.length;x++) {
				 f.bimg.b[x] = new buttonImage();
				 
			 }
			 
			 f.bimg.createImages(f.bimg.b);
			 
			 
		     f.b = new customButton[4];
			  for(int x=0;x<4;x++) {
				 f.b[x] = new customButton();
				 
			 }
			 
		 
			// System.out.println("inside loop "+f.b[0].innerX+" "+f.b[0].innerY);
			 
			 
			 g.setColor(Color.black);
			 
			 g.drawRect(f.b[0].outerX,f.b[0].outerY,f.b[0].outerWidth,f.b[0].outerHeight);
			 
			 g.setColor(Color.red);
		     g.fillRect(f.b[0].innerX, f.b[0].innerY,f.b[0].innerWidth,f.b[0].innerHeigt);
			 g.drawImage(f.bimg.b[0].img,(f.b[0].innerX+0*(f.b[0].spacing)), f.b[0].innerY ,  f.b[0].innerWidth, f.b[0].innerHeigt, this);

		
			 for(int z=1;z<4;z++) {
				 
				 
				 
				 
				 
				 
				 g.setColor(Color.black);
				 g.drawRect((f.b[z].outerX+z*(f.b[z].spacing)) , f.b[z].outerY, f.b[z].outerWidth, f.b[z].outerHeight);
				 System.out.println("Current rectangle after before and after spacing "+f.b[z].outerX+" "+(f.b[z].outerX+f.b[z].spacing));
			//	 g.setColor(Color.red);
			//	 g.fillRect((f.b[z].innerX+z*(f.b[z].spacing)), f.b[z].innerY, f.b[z].innerWidth, f.b[z].innerHeigt);
				 
				 g.drawImage(f.bimg.b[z].img,(f.b[z].innerX+z*(f.b[z].spacing)), f.b[z].innerY ,  f.b[z].innerWidth, f.b[z].innerHeigt, this);
				 
				 System.out.println("inner rectangle before and after spacing "+f.b[z].innerX+" "+(f.b[z].innerX+z*(f.b[z].spacing)));
				 System.out.println(z);
				 
		
				 }
			      	 
		/*	 
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			
			 g.setColor(Color.black);
			 g.drawRect(95, 95, 60, 50);
		
			 g.setColor(Color.red);
			 g.fillRect(100, 100, 50, 40); 
			
			 System.out.println("lets check flag value "+flag);
			// super.paintComponent(g);
			*/ 
				 
				 if(x>100 &&x<340 && y>100 && y<140) {
					 
					 
					 if(x>100 &&x<160) {
					 g.setColor(Color.black);
					    g.fillRect(95, 95, 60, 50);
					 g.setColor(Color.red);
					 g.fillRect(100, 100, 50, 40);  
					 
					 g.drawImage(f.bimg.b[0].img,(f.b[0].innerX+0*(f.b[0].spacing)), f.b[0].innerY ,  f.b[0].innerWidth, f.b[0].innerHeigt, this);

					 }
					 
					 if(x>160 && x<220) {
						 
						 g.setColor(Color.black);
						    g.fillRect(95+60, 95, 60, 50);
						 g.setColor(Color.red);
						 g.fillRect(160, 100, 50, 40); 
					//     g.drawImage(pencil1, 160, 100, 50, 40, this);
						 g.drawImage(f.bimg.b[1].img,(f.b[1].innerX+1*(f.b[1].spacing)), f.b[1].innerY ,  f.b[1].innerWidth, f.b[1].innerHeigt, this);

					 }
					  
                       if(x>220 && x<280) {
						 
						 g.setColor(Color.black);
						    g.fillRect(95+60+60, 95, 60, 50);
						 g.setColor(Color.red);
						 g.fillRect(220, 100, 50, 40);   
						 g.drawImage(f.bimg.b[2].img,(f.b[2].innerX+2*(f.b[2].spacing)), f.b[2].innerY ,  f.b[2].innerWidth, f.b[2].innerHeigt, this);

					 } 
                       
                       if(x>280 && x<340) {
  						 
  						 g.setColor(Color.black);
  						    g.fillRect(95+60+60+60, 95, 60, 50);
  				//		 g.setColor(Color.red);
  				//		 g.fillRect(280, 100, 50, 40);  
  						 g.drawImage(f.bimg.b[3].img,(f.b[3].innerX+3*(f.b[3].spacing)), f.b[3].innerY ,  f.b[3].innerWidth, f.b[3].innerHeigt, this);

  					 } 
                       
                       
					}
			    }
		}
	 
	  somepanel p = new somepanel();
	
	  f.addWindowListener(new WindowAdapter() {
		 
			 public void windowClosing(WindowEvent e) {
				 f.dispose();
			 }
		 
	 });
	  
	  p.setSize(400, 200);
	   
	   System.out.println("Panel Width: "+p.getWidth()+" Panel Height: "+p.getHeight());
		
	 
	   f.add(p);
	   
	   p.addMouseListener(new MouseAdapter(){
			  public void mouseClicked(MouseEvent e) {
                                                        //this referes to members of anonymous class, not the class 
			
				System.out.println("click registered");
				System.out.println("checking  coordinates on each click "+e.getX()+" "+e.getY());
				p.x = e.getX();
				p.y =e.getY();
				
				p.repaint();
			
			  }
			  
			  
		  });
		   
	    f.setVisible(true);	
		f.setResizable(false);
	
		
	}
}
