import javax.swing.*;
import java.awt.*;

public class Everything extends JPanel{
	
	public void paint(Graphics g) {
		super.paint(g);
		bresenham(g,100,100,200,50);
		
		bre(g,100,100,50);
	}
	
	public void ddaLine(Graphics g,int x1,int y1,int x2,int y2) {
		int dx=x2-x1;
		int dy=y2-y1;
		
		int steps=Math.max(Math.abs(dx), Math.abs(dy));
		float x_inc=(float)dx/steps;
		float y_inc=(float)dy/steps;
		
		float x=x1;
		float y=y1;
		
		for (int i=0;i<=steps;i++) {
			g.fillRect(Math.round(x), Math.round(y), 3, 3);
			x+=x_inc;
			y+=y_inc;
		}
	}
	
	public void midpoint(Graphics g,int xc,int yc,int r) {
		int x=0;
		int y=r;
		int d=1-r;
		
		plotPoints(g,xc,yc,x,y);
		
		while(x<y) {
			x++;
			if(d>0) {
				y--;
				d+=2*(x-y)+1;
			}
			else {
				d+=2*x+1;
			}
			plotPoints(g,xc,yc,x,y);
			
		}
	}
	
	public void bre(Graphics g,int xc,int yc,int r) {
		int x=0;
		int y=r;
		int d=3-2*r;
		
		plotPoints(g,xc,yc,x,y);
		
		while(x<y) {
			x++;
			if(d>0) {
				y--;
				d+=4*(x-y)+10;
			}
			else {
				d+=4*x+6;
			}
			plotPoints(g,xc,yc,x,y);
			
		}
	}
	
	public void plotPoints(Graphics g,int xc,int yc,int x,int y) {
		
		g.fillRect(xc+x, yc+y, 2, 2);
		g.fillRect(xc-x, yc+y, 2, 2);
		g.fillRect(xc+x, yc-y, 2, 2);
		g.fillRect(xc-x, yc-y, 2, 2);
		
		g.fillRect(xc+y, yc+x, 2, 2);
		g.fillRect(xc-y, yc+x, 2, 2);
		g.fillRect(xc+y, yc-x, 2, 2);
		g.fillRect(xc-y, yc-x, 2, 2);
		
	}
	
	public void bresenham(Graphics g,int x1,int y1,int x2,int y2) {
		int dx=Math.abs(x2-x1);
		int dy=Math.abs(y2-y1);
		
		int sx=x2>x1?1:-1;
		int sy=y2>y1?1:-1;
		
		if(dx>=dy) {
			int y=y1;
			int d=2*dy-dx;
			
			for(int x=x1;x!=x2;x+=sx) {
				g.fillRect(x, y, 2, 2);
				
				if(d>0) {
					y+=sy;
					d-=2*dx;
				}
				d+=2*dy;
			}
		}
		else {
			int x=x1;
			int d=2*dx-dy;
			
			for(int y=y1;y!=y2;y+=sy) {
				g.fillRect(x, y, 2, 2);
				
				if(d>0) {
					x+=sx;
					d-=2*dy;
				}
				d+=2*dx;
			}	
		}
		
		g.fillRect(x2, y2, 2, 2);
		
		
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame("jana");
		Everything panel=new Everything();
		frame.add(panel);
		frame.setSize(1000,700);
		frame.setVisible(true);

	}

}
