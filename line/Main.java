package line;
import java.awt.*;
import javax.swing.*;
/**
 * The Main class serves as the entry point for the DDA Line Drawing Algorithm application.
 * It creates a JFrame and a JPanel to draw lines and a triangle using the DDA algorithm.
 * 
 * @author M.Kabileshwaran
 */
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Line Drawing Algorithm");
        JPanel panel = new JPanel(){
            @Override 
            public void paint(Graphics g){
                // g.setColor(Color.GREEN);
                Bresenham.drawLine(g,50,100,100,50); // line BA
                Bresenham.drawLine(g,100,50,150,100); // line AC
                Bresenham.drawLine(g,50,100,150,100); // line BC

                // g.setColor(Color.RED); // to change the color of the triangle
                int [] xPoints = {50, 100, 150};
                int [] yPoints = {100, 50, 100};
                int nPoints = 3;
                g.fillPolygon(xPoints, yPoints, nPoints); // triangle ABC
            }
        };
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBackground(Color.GRAY);
    }
}