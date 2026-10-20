// package circle;
import java.awt.Graphics;
import java.awt.Color;
public class BresenhamCircle {
    public static void drawCircle(Graphics g,int xc,int yc,int r,Color color){
        int x = 0;
        int y = r;
        int d = 3 - 2*r;

        plotPoints(g,xc,yc,x,y,color);
        while(x<y){
            x++;
            if(d>0){
                y--;
                d += 4*(x-y)+10;
            }else{
                d += 4*x + 6;
            }
            plotPoints(g, xc, yc, x, y, color);
        }
    }

    private static void plotPoints(Graphics g, int xc, int yc, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(xc+x,yc+y,2,2);
        g.fillRect(xc+x,yc-y,2,2);
        g.fillRect(xc-x,yc+y,2,2);
        g.fillRect(xc-x,yc-y,2,2);

        g.fillRect(xc+y,yc+x,2,2);
        g.fillRect(xc-y,yc-x,2,2);
        g.fillRect(xc-y,yc+x,2,2);
        g.fillRect(xc+y,yc-x,2,2);
    }
}
