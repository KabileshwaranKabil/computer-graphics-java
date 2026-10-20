package transformation;
import java.awt.*;
import javax.swing.*;
public class Main extends JFrame{
    public static void main(String[] args) {
        Main frame = new Main();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int[][] points = {{100, 100}, {200, 100}, {200, 200}, {100, 200}};
                int tx = 50;
                int ty = 50;
                double sx = 1.5;
                double sy = 1.5;
                double angle = 30;

                // Apply transformations
                drawPolygon(g, points);
                Translation.translate(points, tx, ty);
                Scaling.scale(points, sx, sy);
                Rotation.rotate(points, angle);

                drawPolygon(g, points);
                // Draw transformed points
                for (int[] point : points) {
                    g.fillRect(point[0], point[1], 5, 5);
                }
            }

            private void drawPolygon(Graphics g, int[][] points) {
                int n = points.length;
                for (int i = 0; i < n; i++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[(i + 1) % n][0];
                    int y2 = points[(i + 1) % n][1];
                    g.drawLine(x1, y1, x2, y2);
                }
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
