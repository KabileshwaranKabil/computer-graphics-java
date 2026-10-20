package transformation;

public class Scaling {
    public static void scale(int[][] points, double sx, double sy) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] = (int) (points[i][0] * sx);
            points[i][1] = (int) (points[i][1] * sy);
        }
    }
}
