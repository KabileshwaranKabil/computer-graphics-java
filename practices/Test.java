import java.awt.*;
import javax.swing.*;
public class Test extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int[][] triangle ={
            {300,200},
            {200,400},
            {400,400},
            {300,200}
        };

        int[][] triangle1 = copy(triangle);
        g.setColor(Color.GREEN);
        drawPolygon(g, triangle1); // original triangle
        
        int[][] triangle2 = copy(triangle);
        g.setColor(Color.BLUE);
        scale(triangle2, 0.5, 0.5);
        drawPolygon(g, triangle2); // scaled triangle

        int[][] triangle3 = copy(triangle);
        g.setColor(Color.ORANGE);
        translate(triangle3, 100, 100);
        drawPolygon(g, triangle3);// translated triangle
        
        int[][] triangle4 = copy(triangle);
        g.setColor(Color.RED);
        rotate(triangle4, 45);
        drawPolygon(g, triangle4);// rotated triangle
    }
    public static void drawPolygon(Graphics g, int[][] shape){
        for(int i=0;i<shape.length -1;i++){
            drawLine(g,shape[i][0],shape[i][1],shape[i+1][0],shape[i+1][1]);
        }
    }
    public static void scale(int[][] xy, double sx, double sy){
        for(int i=0;i<xy.length;i++){
            xy[i][0] *= sx;
            xy[i][1] *= sy; 
        }
    }
    public static void translate(int[][] xy, int tx, int ty){
        for(int i=0;i<xy.length;i++){
            xy[i][0] += tx;
            xy[i][1] += ty; 
        }
    }
    public static int[][] copy(int[][] shape){
        int[][] copy = new int[shape.length][2];
        for(int i=0;i<shape.length;i++){
            copy[i][0] = shape[i][0];
            copy[i][1] = shape[i][1];
        }
        return copy;
    }
    public static void rotate(int[][] xy, double angle){
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        for(int i=0;i<xy.length;i++){
            int x = xy[i][0];
            int y = xy[i][1];

            xy[i][0] = (int)Math.round(x*cos - y*sin);
            xy[i][1] = (int)Math.round(x*sin + y*cos);
        }
    }
    public static void scaling(int[][] xy, int sx, int sy){
        for(int i=0;i<xy.length;i++){
            xy[i][0] *= sx;
            xy[i][1] *= sy; 
        }
    }
    public static void drawLine(Graphics g,int x1,int y1,int x2,int y2){
        // 01. Calculate difference between dx, dy
        int dy = Math.abs(y2-y1);
        int dx = Math.abs(x2-x1);

        int sx = (x2>x1)?1:-1;
        int sy = (y2>y1)?1:-1;

        int d;
        if(dx>=dy){
            d = 2*dy - dx;
            int y = y1;
            for(int x = x1;x!=x2;x+=sx){
                g.fillRect(x, y, 2, 2);
                if(d>0){
                    y+=sy;
                    d -= 2*dx;
                }
                d += 2*dy;
            }
        }else{
            d = 2*dx - dy;
            int x = x1;
            for(int y=y1;y!=y2;y+=sy){
                g.fillRect(x, y, 2, 2);
                if(d>0){
                    x+=sx;
                    d -= 2*dy;
                }
                d += 2*dx;
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Transformation");
        frame.add(new Test());
        frame.setSize(1280,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
