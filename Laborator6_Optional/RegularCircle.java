import java.awt.geom.Ellipse2D;

public class RegularCircle extends Ellipse2D.Double {
    private double x0;
    private double y0;
    private double radius;
    public RegularCircle(double x0Val, double y0Val, double radiusVal) {
        super(x0Val - radiusVal / 2, y0Val - radiusVal / 2, radiusVal, radiusVal);
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
