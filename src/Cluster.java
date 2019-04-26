import java.util.ArrayList;

public class Cluster {

    ArrayList<ColorPoint> points;
    ColorPoint center;

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

    public void calculateCenter() {

        int sumR = 0;
        int sumG = 0;
        int sumB = 0;

        for (ColorPoint point : points) {
            sumR += point.getRed();
            sumG += point.getGreen();
            sumB += point.getBlue();
        }

        center = new ColorPoint(sumR / points.size(),
                sumG / points.size(), sumB / points.size(), 0, 0);
    }



}
