package transformation;

public class Translation {
    public static void translate(int[][] points, int tx, int ty) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] += tx;
            points[i][1] += ty;
        }
    }
}
