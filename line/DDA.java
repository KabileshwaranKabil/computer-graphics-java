package line;
import java.awt.Graphics;
public class DDA{
    /**
     * Draws a line using the DDA (Digital Differential Analyzer) algorithm.
     * @param g The graphics context to draw on.
     * @param x1 The x-coordinate of the first endpoint.
     * @param y1 The y-coordinate of the first endpoint.
     * @param x2 The x-coordinate of the second endpoint.
     * @param y2 The y-coordinate of the second endpoint.
     */
    public static void drawLine(Graphics g,int x1,int y1,int x2,int y2){
        // 1. calculate the differences - dy,dx
        int dy = y2 - y1;
        int dx = x2 - x1;

        // 2. calculate the steps required for generating pixels
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        // 3. calculate the increment in x & y for each steps
        float x_increment = (float) dx/steps;
        float y_increment = (float) dy/steps;

        // 4. put pixel for each step
        float x = x1;
        float y = y1;

        // 5. Draw the pixels
        for(int k=0;k<=steps;k++){
            g.fillRect(Math.round(x), Math.round(y), 2, 2);

            x +=  x_increment;
            y +=  y_increment;
        }
    }
}