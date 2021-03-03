package experimental;

import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;



public class DrawPanel extends Canvas {
	
	
	example reference;
	int clicks =0;
	int drags =-1;

	Color c = new Color(0,0,0);
	
	BufferedImage bufferedImage ;
	
	ArrayList xclickPositions;
	ArrayList yclickPositions;
	
	ArrayList xdragPositions;
	ArrayList ydragPositions;
	boolean isClickInitialised = false;
	
	ArrayList Keyvalues;
	ArrayList WhichIconNumber;
	ArrayList WhichColor;
	
	int clickX = -1;
	int clickY = -1;
	
	int dragX =-1;
	int dragY =-1;
	
	boolean flag = false;
	boolean save = false;
	

	DrawPanel(example se)
	{
		this.reference = se;
		this.xclickPositions = new ArrayList();
		this.yclickPositions = new ArrayList();
		
		this.xdragPositions = new ArrayList();
		this.ydragPositions = new ArrayList();
		
	    this.Keyvalues = new ArrayList();
	    this.WhichColor = new ArrayList();
	    this.WhichIconNumber = new ArrayList();
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
		  if (reference.val == true && reference.DrawFlag>=0 && reference.DrawFlag<=9 ) {
				
			    if(reference.DrawFlag ==0) {
			      
			    }
							
				else
			    if (flag == true) {
			    	clicks++;
			    }
			    clickX =e.getX();
			    clickY =e.getY();
			    
				xclickPositions.add(clicks, e.getX());
				yclickPositions.add(clicks, e.getY());
	            
				xdragPositions.add(-1);
				ydragPositions.add(-1);
				
				
				isClickInitialised = true;
				flag = false;
				
		
		     System.out.println("Inside DrawPanel, click registered, showing coordinates and click index: "+xclickPositions.get(clicks)+" "+yclickPositions.get(clicks)+" "+clicks);
			 }
			}
			
			public void mouseReleased(MouseEvent e) {
				System.err.println("RELEASED");
				xdragPositions.add(-1);
				ydragPositions.add(-1);
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseAdapter() {
		
			public void mouseDragged(MouseEvent e) {
				
				if(xclickPositions.size()>=1  && reference.val == true && reference.DrawFlag >=0 && reference.DrawFlag<=9) {
				
			if(e.getX()>=0 &&e.getX()<=581   && e.getY()>=0  &&e.getY()<=292) {	
				
	        	
			    if(reference.DrawFlag >=1 && reference.DrawFlag <=5) {
			    	if(isClickInitialised == true && xclickPositions.size()>=1) {
					 drags++;
					 xdragPositions.add(drags, e.getX());
					 ydragPositions.add(drags, e.getY());
			    	 }
			    	else
				 dragX = e.getX();
				 dragY =e.getY();
				 xdragPositions.set(drags, e.getX());
				 ydragPositions.set(drags, e.getY());
				 WhichIconNumber.add(drags, reference.DrawFlag);
				 WhichColor.add(drags, reference.ColorFlag );
				 System.out.println("this figure is being drawn:"+(int)WhichIconNumber.get(drags));
				 System.out.println("Inside DrawPanel,drag;showing cords and drag count "+xdragPositions.get(drags)+" "+ydragPositions.get(drags)+" "+drags);
				 Keyvalues.add(clicks, drags ); 
                 
				 
				 flag = true;
				 isClickInitialised =false;
				 repaint();
			    	 }
				}
				
			    System.out.println("lets see key values for each x and each y clicked: "+xclickPositions.get(clicks)+" "+yclickPositions.get(clicks)+" "+Keyvalues.get(clicks));
				  
		//	repaint();
			
			}
			}
			
			
		});
		
		}
	
	
	
	
	public void update (Graphics g ) {
	
		g.setColor(c);
		BufferStrategy bs =  getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		
		if(this.reference.DrawFlag ==0  && this.reference.val == true) {
		
			int i=0;
			int j=0;
			g.clearRect(0, 0, this.getWidth(), this.getHeight());

			while(i<xclickPositions.size()) {
				
				while(j<(int)Keyvalues.get(i)) {
					
			
					if((int)WhichIconNumber.get(j) ==0) {
						
						g.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),1,1);
						 j++;
						 int temp = j;
						 temp--;
						 if(j>=1 && (int)xdragPositions.get(temp) != -1 && (int)ydragPositions.get(temp) !=-1 &&(int)xdragPositions.get(j)!=-1 && (int)ydragPositions.get(j) != -1) {
				            	
				            	g.drawLine((int)xdragPositions.get(temp), (int)ydragPositions.get(temp), (int)xdragPositions.get(j),(int)ydragPositions.get(j));
				             }
				}
					
					else if((int)WhichIconNumber.get(j) == 1) {
						g.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
                        j++;
                        
					}
					else if((int)WhichIconNumber.get(j) == 2 || (int)WhichIconNumber.get(j) == 4) {
						  g.drawRect((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                        
					}
					else if((int)WhichIconNumber.get(j) ==3 || (int)WhichIconNumber.get(j) ==5) {
						  g.drawOval((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                         
					}
					}
					
				i++;
			}
			
		}
		
		if(this.reference.DrawFlag ==1  && this.reference.val == true) {
		    
	     	g.clearRect(0, 0 ,this.getWidth(), this.getHeight());

			int i=0;
			int j=0;
	//		if(xclickPositions.size()>1) {
			while(i<xclickPositions.size()) {
				
				while(j<=(int)Keyvalues.get(i)) {
					
					if((int)WhichIconNumber.get(j) ==0) {
						g.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),1,1);
						j++;
						int temp =j;
						temp--;
						
						 if(j>=1 && (int)xdragPositions.get(temp) != -1 && (int)ydragPositions.get(temp) !=-1 &&(int)xdragPositions.get(j)!=-1 && (int)ydragPositions.get(j) != -1) {
				            	
				            	g.drawLine((int)xdragPositions.get(temp), (int)ydragPositions.get(temp), (int)xdragPositions.get(j),(int)ydragPositions.get(j));
				             }
					}
					
					else if((int)WhichIconNumber.get(j) == 1) {
						g.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
                        j++;
                      
					}
					else if((int)WhichIconNumber.get(j) == 2 || (int)WhichIconNumber.get(j) == 4) {
						  g.drawRect((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                          
					}
					else if((int)WhichIconNumber.get(j) ==3 || (int)WhichIconNumber.get(j) ==5) {
						  g.drawOval((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                         
					}
					
				}
				i++;
			}
		    
		//   }
			//	g.drawLine(clickX, clickY,dragX,dragY);
			
		}
		
		if(this.reference.DrawFlag ==2 || this.reference.DrawFlag ==4) {
			
			  int i=0;
			  int j=0;
			  g.clearRect(0, 0, this.getWidth(), this.getHeight());
			 
              while(i<xclickPositions.size()) {           
			  while(j<=(int)Keyvalues.get(i)) {
				  
				  
				  if((int)WhichIconNumber.get(j) ==0) {
						g.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),1,1);
						j++;
						int temp =j;
						temp--;
						
						 if(j>=1 && (int)xdragPositions.get(temp) != -1 && (int)ydragPositions.get(temp) !=-1 &&(int)xdragPositions.get(j)!=-1 && (int)ydragPositions.get(j) != -1) {
				            	
				            	g.drawLine((int)xdragPositions.get(temp), (int)ydragPositions.get(temp), (int)xdragPositions.get(j),(int)ydragPositions.get(j));
				             }
					}
					
					else if((int)WhichIconNumber.get(j) == 1) {
					 	g.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
                        j++;
                      
					}
					else if((int)WhichIconNumber.get(j) == 2 || (int)WhichIconNumber.get(j) == 4) {
						g.drawRect((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                        j++;
                       
					}
					else if((int)WhichIconNumber.get(j) ==3 || (int)WhichIconNumber.get(j) ==5) {
					    g.drawOval((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                        j++;
                       
					}
				 
				  }
			  i++;
			  }
			 
			}
		
		if(this.reference.DrawFlag == 3 || this.reference.DrawFlag ==5) {
			int i=0;
			int j=0;
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			 while(i<xclickPositions.size()) {           
				  while(j<=(int)Keyvalues.get(i)) {
					  
					  if((int)WhichIconNumber.get(j) ==0) {
							g.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),1,1);
							j++;
							
							int temp =j;
							temp--;
							
							 if(j>=1 && (int)xdragPositions.get(temp) != -1 && (int)ydragPositions.get(temp) !=-1 &&(int)xdragPositions.get(j)!=-1 && (int)ydragPositions.get(j) != -1) {
					            	
					            	g.drawLine((int)xdragPositions.get(temp), (int)ydragPositions.get(temp), (int)xdragPositions.get(j),(int)ydragPositions.get(j));
					             }
						}
						
						else if((int)WhichIconNumber.get(j) == 1) {
							g.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
	                        j++;
	                       
						}
						else if((int)WhichIconNumber.get(j) == 2 || (int)WhichIconNumber.get(j) == 4) {
							  g.drawRect((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
	                          j++;
	                        
						}
						else if((int)WhichIconNumber.get(j) ==3 || (int)WhichIconNumber.get(j) ==5) {
							  g.drawOval((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
	                          j++;
	                         
						}
					
				  }
				  i++;
				  }
				 
				}
		
		if(this.reference.DrawFlag >=6  && this.reference.DrawFlag<=8 ) {
			int code = this.reference.DrawFlag;
			
			if(code == 6) {
				c = new Color(255,0,0);
				g.setColor(c);
				
				
			}
			else	if(code == 7) {
				c = new Color(0,0,255);
				g.setColor(c);
				
				
			}
			
			else if (code ==8) {
				c =new Color(0,255,0);
				g.setColor(c);
				
				
			}
			
		}
		
		if(save == true) {
			System.out.println();
			save();
		}
		
		 g.dispose();
		 bs.show();

		}
	
	public void render(Graphics2D g2d) {
		int i=0;
		int j=0;
		 while(i<xclickPositions.size()) {           
			  while(j<=(int)Keyvalues.get(i)) {
				  
				  if((int)WhichIconNumber.get(j) ==0) {
						g2d.fillOval((int)xdragPositions.get(j), (int)ydragPositions.get(j),1,1);
						j++;
						
						int temp =j;
						temp--;
						
						 if(j>=1 && (int)xdragPositions.get(temp) != -1 && (int)ydragPositions.get(temp) !=-1 &&(int)xdragPositions.get(j)!=-1 && (int)ydragPositions.get(j) != -1) {
				            	
				            	g2d.drawLine((int)xdragPositions.get(temp), (int)ydragPositions.get(temp), (int)xdragPositions.get(j),(int)ydragPositions.get(j));
				             }
					}
					
					else if((int)WhichIconNumber.get(j) == 1) {
						g2d.drawLine((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j), (int)ydragPositions.get(j));
                        j++;
                       
					}
					else if((int)WhichIconNumber.get(j) == 2 || (int)WhichIconNumber.get(j) == 4) {
						  g2d.drawRect((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                        
					}
					else if((int)WhichIconNumber.get(j) ==3 || (int)WhichIconNumber.get(j) ==5) {
						  g2d.drawOval((int)xclickPositions.get(i), (int)yclickPositions.get(i), (int)xdragPositions.get(j)-(int)xclickPositions.get(i) , (int)ydragPositions.get(j)-  (int)yclickPositions.get(i) );
                          j++;
                         
					}
				
			  }
			  i++;
			  }
			 
			}
	
	
	public void save() {
		
		
		bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = bufferedImage.createGraphics();
	    g2d.setPaint(new Color(255,255,255));
	    
	    g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
	    g2d.setColor(Color.black);
	    
        render(g2d); 
		g2d.dispose();
        File file = new File("C:/Users/malware/Desktop/YourImage.png");
        try {
			ImageIO.write(bufferedImage, "PNG", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.err.println("Image SAVED.....");
	
        g2d.dispose();
     
	}
	}
				
	
	
