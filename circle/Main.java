// package circle;
import java.awt.*;
import javax.swing.*;
public class Main extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        BresenhamCircle.drawCircle(g, 250, 250, 100,Color.RED);
        BresenhamCircle.drawCircle(g, 400, 250, 100,Color.GREEN);
        BresenhamCircle.drawCircle(g, 350, 350, 100,Color.GREEN);
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawing");
        frame.add(new Main());
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
    }
}