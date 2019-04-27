import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClusterFinder {

    private BufferedImage image;
    private ArrayList<Cluster> clusters;
    private ArrayList<ColorPoint> points;

    //DESCRIPTION:
    //red is the 1D
    //green is the 1D inside red
    //blue is the 1D inside green
    private ColorPoint[][][] CUBE;

    public ClusterFinder(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CUBE = new ColorPoint[256][256][256];
        points = new ArrayList<>();
        clusters = new ArrayList<>();

        for (int row = 0; row < image.getHeight(); row++) {
            for (int col = 0; col < image.getWidth(); col++) {
                Color color = new Color(image.getRGB(col, row));
                CUBE[color.getRed()][color.getGreen()][color.getBlue()] =
                        new ColorPoint(color.getRed(), color.getGreen(), color.getBlue(), col, row);
                points.add(CUBE[color.getRed()][color.getGreen()][color.getBlue()]);
            }
        }
    }

    private void assignPointsToClusters() {
        for (ColorPoint p : points) {
            findClosestClusterTo(p).add(p);
        }
    }

    private Cluster findClosestClusterTo(ColorPoint p) {
        double minDistance = 362;
        Cluster closestCluster = clusters.get(0);
        for (Cluster c : clusters) {
            if (p.distanceTo(c) < minDistance) {
                closestCluster = c;
                minDistance = p.distanceTo(c);
            }
        }
        return closestCluster;
    }

    private void recalculateCenters() {
        for (Cluster c : clusters) c.recalculateCenter();
    }

    private void clearClusters() {
        for (Cluster c : clusters) c.clear();
    }

    public void colorizeImage(int clusterNum) {
        for (int i = 0; i < clusterNum; i++) {
            clusters.add(new Cluster(new ColorPoint((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), 0, 0)));
        }
        for (int rep = 0; rep < 100; rep++) {
            clearClusters();
            assignPointsToClusters();
            recalculateCenters();
        }
        updateImage();
    }

    private void updateImage() {
        for (Cluster cluster : clusters) {
            for (ColorPoint p : cluster.getPoints()) {
                image.setRGB((int) p.getX(), (int) p.getY(), new Color(cluster.getCenter().getR(), cluster.getCenter().getG(), cluster.getCenter().getB()).getRGB());
            }
        }
    }

    public void displayImage() {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }

    public ArrayList<Cluster> getClusters() {
        return clusters;
    }

    public ArrayList<ColorPoint> getPoints() {
        return points;
    }

    public ColorPoint[][][] getCUBE() {
        return CUBE;
    }
}










