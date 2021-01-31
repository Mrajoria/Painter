package experimental;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.Frame;




public class buttonImage  {
	
	InputStream input;
	
	BufferedImage img;
	String s ="";
	String add = "/experimental/resouces/";
	buttonImage b[];
    Frame frame;	
	
	
	public  void createImages(buttonImage bimgs[] ) {
		for(int x =0;x<bimgs.length;x++) {
			add = add + Integer.toString(x);
			System.out.println("lets see added file name: "+add);
			s =s+add;
			System.out.println("lets see full source string: "+s);
			try {
				
				System.out.println(s+".png");
				
			bimgs[x].input = getClass().getResourceAsStream(s+".png");
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			add ="";
			s ="resouces/";
			bimgs[x].img = new BufferedImage(51,51,BufferedImage.TYPE_INT_ARGB);
			
			 try {
		         bimgs[x].img = ImageIO.read(bimgs[x].input);
		   

		     } catch (IOException ex) {
		         ex.printStackTrace();
		     }
		     
			
		}
		
	}
	
	/*
	
	public void paint(Graphics g) {
		
		for(int x=0;x<4;x++) {
			
		
		g.drawImage(this.b[x].img,95+x*60, 95, 50, 40, this);
		}
		
	//	g.drawRect(100, 100, 50, 40);
		
	}
	
		*/
		
	
	
/*	public static void main(String args[]) {
		
		buttonImage bimg = new buttonImage();
		
		
		bimg. b = new buttonImage[4];
			for(int x=0;x<bimg.b.length;x++) {
				bimg.b[x] =  new buttonImage();
			}
		bimg.createImages(bimg.b);
		
		bimg.frame = new Frame();
		bimg.frame.setSize(400,200);
		bimg.frame.add(bimg);
		bimg.frame.setVisible(true);
		
	}
	
	*/



}
