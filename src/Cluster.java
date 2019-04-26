import java.util.ArrayList;

public class Cluster {

    ArrayList<ColorPoint> points;

    public Cluster() {
        points = new ArrayList<>();
    }

    public void addPoint(ColorPoint point) {
        points.add(point);
    }

    public void removePoint(ColorPoint point) {
        points.remove(point);
    }

    public void clear() {
        points.clear();
    }

}
