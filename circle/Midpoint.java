import java.awt.Graphics;
import java.awt.Color;
public class Midpoint {
    public static void drawCircle(Graphics g, int xc, int yc, int r,Color color){
        int x = 0;
        int y = r;
        int d = 1 - r;
        plotPoints(g,xc,yc,x,y,color);
        while(x<y){
            x++;
            if(d>0){
                y--;
                d += 2*(x-y)+1;
            }else{
                d += 2*x +1;
            }
            plotPoints(g,xc,yc,x,y,color);
        }
    }
    private static void plotPoints(Graphics g,int xc,int yc, int x,int y,Color color){
        g.setColor(color);
        g.fillRect(xc+x,yc+y,2,2);
        g.fillRect(xc+x,yc-y,2,2);
        g.fillRect(xc-x,yc+y,2,2);
        g.fillRect(xc-x,yc-y,2,2);
        
        g.fillRect(xc+y,yc+x,2,2);
        g.fillRect(xc+y,yc-x,2,2);
        g.fillRect(xc-y,yc+x,2,2);
        g.fillRect(xc-y,yc-x,2,2);
    }
}
