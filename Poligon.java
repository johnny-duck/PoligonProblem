import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Poligon implements Serializable {
    List<Point> points;

    public Poligon() {
        this.points = new LinkedList<>();
    }

    public void addPoint(Point x) {
        //points.add(x);
        if (points.size() < 2) {
            points.add(x);
        } else {

        }
    }

    public Boolean isValid() {
        return points.size() > 2;
    }

    public Double getPermiter() throws Exception {
        if (!isValid()) throw new Exception("invalid poligon!");
        Double perimeter = 0.0d;
        for (int i = 0; i < points.size() - 1; ++i) {
            perimeter += lengthSegment(points.get(i), points.get(i + 1));
        }
        return perimeter + lengthSegment(points.get(0), points.get(points.size() - 1));
    }

    public Double getArea() {
        Double partOfAreaOne = 0d;
        Double partOfAreaTwo = 0d;
        for (int i = 0; i < points.size() - 1; ++i) {
            partOfAreaOne += points.get(i).x * points.get(i + 1).y;
            partOfAreaTwo += points.get(i + 1).x * points.get(i).y;
        }
        partOfAreaOne += points.get(points.size() - 1).x * points.get(0).y;
        partOfAreaTwo += points.get(0).x * points.get(points.size() - 1).y;

        return (double) 1 / 2 * Math.abs(partOfAreaOne - partOfAreaTwo);
    }

    private Double lengthSegment(Point z, Point t) {
        return Math.sqrt(Math.pow(z.x - t.x, 2) + Math.pow(z.y - t.y, 2));
    }

    private Double computeA(Point z, Point t) {
        return t.y - z.y;
    }

    private Double computeB(Point z, Point t) {
        return z.x - t.x;
    }

    private Double computeC(Point z, Point t) {
        return computeA(z, t) * z.x + computeB(z, t) * z.y;
    }

    private Point intersection(Point a, Point b, Point c, Point d) {
        Double a1, a2, b1, b2, c1, c2;
        a1 = computeA(a, b);
        a2 = computeA(c, d);
        b1 = computeB(a, b);
        b2 = computeA(c, d);
        Double det = a1 * b2 - a2 * b1;
        if (det.equals(0d)) return null;
        c1 = computeC(a, b);
        c2 = computeC(c, d);
        Double x = (b2 * c1 - b1 * c2) / det;
        Double y = (a1 * c2 - a2 * c1) / det;
        return new Point(x, y);
    }

    //for collinear point ONLY
    private Boolean onSegment(Point a, Point b, Point z) {
        if (z.x <= Math.max(a.x, b.x) && z.x >= Math.min(a.x, b.x)) return true;
        else return false;
    }

}
