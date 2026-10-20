package line;
/*
* @author M.Kabileshwaran
*/
import java.awt.Graphics;
public class Bresenham {
    /*
    * @param g The graphics context to draw on.
    * @param x1 The x-coordinate of the first endpoint.
    * @param y1 The y-coordinate of the first endpoint. 
    * @param x2 The x-coordinate of the second endpoint.
    * @param y2 The y-coordinate of the second endpoint.
    */
    public static void drawLine(Graphics g, int x1,int y1, int x2, int y2){
        // 01. calculate the differences - dy,dx
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);

        // 02. calculate sx, sy
        int sx = (x2>x1)?1:-1;
        int sy = (y2>y1)?1:-1;

        if(dx>=dy){
            int d = 2*dy - dx;
            int y = y1;
            for(int x = x1;x!=x2;x+=sx){
                g.fillRect(x, y, 1, 1);
                if(d>0){
                    y+=sy;
                    d = d - 2*dx;
                }
                d += 2*dy;
            }
        }else{
            int d = 2*dx -dy;
            int x = x1;
            for(int y = y1;y!=y2;y+=sy){
                g.fillRect(x, y, 1, 1);
                if(d>0){
                    x+=sx;
                    d = d - 2*dy;
                }
                d += 2*dx;
            }
        }
    }    
}