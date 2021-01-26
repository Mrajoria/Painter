
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
	
		f.setSize(800, 400);
		
		f.setLayout(new BorderLayout());
	
		Button B[] = new Button[4];
		for(int j=0;j<B.length;j++) {
			B[j] = new Button(Integer.toHexString(j));
		}
		
		
	    Dimension size = new Dimension(f.getWidth()/4,(f.getHeight()/2));
	
		B[1].setPreferredSize(size);
		B[0].setPreferredSize(size);
		
		
	Panel pnew = new Panel();
	pnew.setLayout(new BorderLayout());
	pnew.add(B[0], BorderLayout.NORTH);
	pnew.add(B[1], BorderLayout.SOUTH);
	
	
	
	
	
		f.add(pnew, BorderLayout.WEST);
		
//		f.add(B[2], BorderLayout.NORTH);
//		f.add(B[3], BorderLayout.SOUTH);
	
		
	 
	 class somepanel extends JPanel {
		 int x =0;
		 int y =0;
		 boolean flag =  false;
		 int position = 0;
		 
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
			 
			
			 for(int z=0;z<4;z++) {
				 
				 g.setColor(Color.black);
				 g.drawRect((f.b[z].outerX+z*(f.b[z].spacing+this.position)) , f.b[z].outerY, f.b[z].outerWidth, f.b[z].outerHeight);
				 System.out.println("Current rectangle after before and after spacing "+f.b[z].outerX+" "+(f.b[z].outerX+f.b[z].spacing));
			//	 g.setColor(Color.red);
			//	 g.fillRect((f.b[z].innerX+z*(f.b[z].spacing)), f.b[z].innerY, f.b[z].innerWidth, f.b[z].innerHeigt);
				 
				 g.drawImage(f.bimg.b[z].img,(f.b[z].innerX+z*(f.b[z].spacing+this.position)), f.b[z].innerY ,  f.b[z].innerWidth, f.b[z].innerHeigt, this);
				 
				 System.out.println("inner rectangle before and after spacing "+f.b[z].innerX+" "+(f.b[z].innerX+z*(f.b[z].spacing)));
				 System.out.println(z);
				 
		
				 }
			      	 

			    }
		}
	
	 somepanel p = new somepanel();
	
	 Panel poriginal = new Panel();
	 
	 
	 poriginal.setLayout(new BoxLayout(poriginal,BoxLayout.Y_AXIS));
	 
	 poriginal.add(p);
	 
	 
		 class otherpanel extends JPanel {
		 public void paintComponent(Graphics gg) {
			 
			gg.clearRect(0, 0, this.getWidth(), this.getHeight());
			 gg.drawRect(0, 0, 50, 26);
			 
		 }
		 
	 }
	 
	 
	 otherpanel p2 = new otherpanel();
	
	 poriginal.add(p2);
	 
	 
	 f.add(poriginal, BorderLayout.CENTER);
	 
	 
	 
	 
	  f.addWindowListener(new WindowAdapter() {
		 
			 public void windowClosing(WindowEvent e) {
				 f.dispose();
			 }
		 
	 });
	
	   
	   System.out.println("Panel Width: "+p.getWidth()+" Panel Height: "+p.getHeight());
	
	   p.addMouseListener(new MouseAdapter(){
			  public void mouseClicked(MouseEvent e) {
                                                        //this referes to members of anonymous class, not the class 
			
				System.out.println("inside p1, click registered, showing cords "+e.getX()+" "+e.getY());
				p.x = e.getX();
				p.y =e.getY();
			    p.position++;
			    p.repaint();
			  }
			  
			  
		  });
	   
	   p2.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   System.out.println("inside p2, showing click cords "+e.getX()+" "+e.getY());
		   }
	   });
		   
	    f.setVisible(true);	
		f.setResizable(false);
	
		
	}
}
