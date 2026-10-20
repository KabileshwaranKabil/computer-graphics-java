package transformation;

public class Rotation {
    public static void rotate(int[][] points, double angle) {
        double radians = Math.toRadians(angle);
        double cosTheta = Math.cos(radians);
        double sinTheta = Math.sin(radians);

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            points[i][0] = (int) (x * cosTheta - y * sinTheta);
            points[i][1] = (int) (x * sinTheta + y * cosTheta);
        }
    }
}
