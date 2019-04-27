import java.util.ArrayList;

public class Cluster {

    private ArrayList<ColorPoint> points;
    private ColorPoint center; //all points converted to this color

    public Cluster(ColorPoint center) {
        points = new ArrayList<>();
        this.center = center;
    }

    public ArrayList<ColorPoint> getPoints() {
        return points;
    }

    public ColorPoint getCenter() {
        return this.center;
    }

    public void setCenter(ColorPoint p) {
        this.center = p;
    }

    public void clear() {
        points.clear();
    }

    public void add(ColorPoint p) {
        points.add(p);
    }

    public void recalculateCenter() {
        int sumx = 0, sumy = 0, sumz = 0;
        for (ColorPoint cp : points) {
            sumx += cp.getR();
            sumy += cp.getG();
            sumz += cp.getB();
        }
        center.setR(sumx / points.size());
        center.setG(sumy / points.size());
        center.setB(sumz / points.size());
    }
}