import javax.swing.*;
import java.awt.*;

class HouseTransformation extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[][] base = {
            {-100, 100},
            {100, 100},
            {100, 300},
            {-100, 300},
            {-100, 100}
        };

        int[][] roof = {
            {-100, 100},
            {0, 0},
            {100, 100},
            {-100, 100}
        };

        int[][] door = {
            {-30, 300},
            {30, 300},
            {30, 220},
            {-30, 220},
            {-30, 300}
        };

        // Top House
        int[][] topBase = copyShape(base);
        int[][] topRoof = copyShape(roof);
        int[][] topDoor = copyShape(door);

        scale(topBase, 0.6, 0.6);
        scale(topRoof, 0.6, 0.6);
        scale(topDoor, 0.6, 0.6);

        translate(topBase, 640, 100);
        translate(topRoof, 640, 100);
        translate(topDoor, 640, 100);

        g.setColor(Color.RED);
        drawPolygon(g, topBase);
        drawPolygon(g, topRoof);
        drawPolygon(g, topDoor);


        // Bottom House
        int[][] bottomBase = copyShape(base);
        int[][] bottomRoof = copyShape(roof);
        int[][] bottomDoor = copyShape(door);

        scale(bottomBase, 0.6, 0.6);
        scale(bottomRoof, 0.6, 0.6);
        scale(bottomDoor, 0.6, 0.6);

        rotate(bottomBase, 180);
        rotate(bottomRoof, 180);
        rotate(bottomDoor, 180);

        translate(bottomBase, 640, 700);
        translate(bottomRoof, 640, 700);
        translate(bottomDoor, 640, 700);

        g.setColor(Color.YELLOW);
        drawPolygon(g, bottomBase);
        drawPolygon(g, bottomRoof);
        drawPolygon(g, bottomDoor);


        // Left House
        int[][] leftBase = copyShape(base);
        int[][] leftRoof = copyShape(roof);
        int[][] leftDoor = copyShape(door);

        scale(leftBase, 0.6, 0.6);
        scale(leftRoof, 0.6, 0.6);
        scale(leftDoor, 0.6, 0.6);

        rotate(leftBase, 270);
        rotate(leftRoof, 270);
        rotate(leftDoor, 270);

        translate(leftBase, 340, 400);
        translate(leftRoof, 340, 400);
        translate(leftDoor, 340, 400);

        g.setColor(Color.BLUE);
        drawPolygon(g, leftBase);
        drawPolygon(g, leftRoof);
        drawPolygon(g, leftDoor);


        // Right House
        int[][] rightBase = copyShape(base);
        int[][] rightRoof = copyShape(roof);
        int[][] rightDoor = copyShape(door);

        scale(rightBase, 0.6, 0.6);
        scale(rightRoof, 0.6, 0.6);
        scale(rightDoor, 0.6, 0.6);

        rotate(rightBase, 90);
        rotate(rightRoof, 90);
        rotate(rightDoor, 90);

        translate(rightBase, 940, 400);
        translate(rightRoof, 940, 400);
        translate(rightDoor, 940, 400);

        g.setColor(Color.GREEN);
        drawPolygon(g, rightBase);
        drawPolygon(g, rightRoof);
        drawPolygon(g, rightDoor);
    }

    private void drawPolygon(Graphics g, int[][] shape) {
        for (int i = 0; i < shape.length - 1; i++) {
            ddaLine(
                g,
                shape[i][0],
                shape[i][1],
                shape[i + 1][0],
                shape[i + 1][1]
            );
        }
    }

    private void translate(int[][] shape, int tx, int ty) {
        for (int i = 0; i < shape.length; i++) {
            shape[i][0] += tx;
            shape[i][1] += ty;
        }
    }

    private void scale(int[][] shape, double sx, double sy) {
        for (int i = 0; i < shape.length; i++) {
            shape[i][0] = (int) Math.round(shape[i][0] * sx);
            shape[i][1] = (int) Math.round(shape[i][1] * sy);
        }
    }

    private void rotate(int[][] shape, double angle) {
        double rad = Math.toRadians(angle);

        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        for (int i = 0; i < shape.length; i++) {
            int x = shape[i][0];
            int y = shape[i][1];

            shape[i][0] = (int) Math.round(x * cos - y * sin);
            shape[i][1] = (int) Math.round(x * sin + y * cos);
        }
    }

    private int[][] copyShape(int[][] original) {
        int[][] copy = new int[original.length][2];

        for (int i = 0; i < original.length; i++) {
            copy[i][0] = original[i][0];
            copy[i][1] = original[i][1];
        }

        return copy;
    }

    public void ddaLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        if (steps == 0) {
            g.fillRect(x1, y1, 2, 2);
            return;
        }

        float x_inc = (float) dx / steps;
        float y_inc = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 2, 2);

            x += x_inc;
            y += y_inc;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Assignment 4");

        HouseTransformation panel = new HouseTransformation();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 800);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}