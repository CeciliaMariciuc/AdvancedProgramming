import java.awt.*;

public class RegularPolygon extends Polygon {
    private int x0;
    private int y0;
    private int radius;
    private int sides;
    public RegularPolygon(int x0Val, int y0Val, int radiusVal, int sidesVal) {
        this.x0 = x0Val; this.y0 = y0Val; this.radius = radiusVal;this.sides = sidesVal;
        double alpha = 2 * Math.PI / sidesVal;
        for (int i = 0; i < sidesVal; i++) {
            double x = x0Val + radiusVal * Math.cos(alpha * i);
            double y = y0Val + radiusVal * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
}