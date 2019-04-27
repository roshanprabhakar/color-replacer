import java.awt.*;
import java.awt.image.BufferedImage;

public class Replacer {

    private BufferedImage image;
    private ColorPoint[][][] CUBE;
    private ClusterFinder finder;

    public Replacer(BufferedImage image, ColorPoint[][][] CUBE, ClusterFinder finder) {

        this.image = image;
        this.CUBE = CUBE;
        this.finder = finder;

    }

    public void replace(Color oldColor, Color newColor) {

        Cluster closestCluster = finder.closestCluster(
                new ColorPoint(oldColor.getRed(), oldColor.getGreen(), oldColor.getBlue(), 0,0)
        );

        for (ColorPoint p : closestCluster.getPoints()) {
            p.setR(newColor.getRed());
            p.setG(newColor.getGreen());
            p.setB(newColor.getBlue());
        }
    }
}
