import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClusterFinder {

    private ColorMap colorMap;

    private BufferedImage image;
    private ArrayList<Cluster> clusters;
    private ArrayList<ColorPoint> points;

    //DESCRIPTION:
    //red is the 1D
    //green is the 1D inside red
    //blue is the 1D inside green
    private ColorPoint[][][] CUBE;

    public ClusterFinder(String path) {

        colorMap = new ColorMap();

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        initCUBE();
        System.out.println(colorMap);
    }

    public ClusterFinder(BufferedImage image) {
        this.image = image;
        initCUBE();
    }

    private void initCUBE() {

        CUBE = new ColorPoint[256][256][256];
        points = new ArrayList<>();
        clusters = new ArrayList<>();

        for (int row = 0; row < image.getHeight(); row++) {
            for (int col = 0; col < image.getWidth(); col++) {

                Color color = new Color(image.getRGB(col, row));

                CUBE[color.getRed()][color.getGreen()][color.getBlue()] =
                        new ColorPoint(color.getRed(), color.getGreen(), color.getBlue(), col, row);
                points.add(CUBE[color.getRed()][color.getGreen()][color.getBlue()]);
                colorMap.put(color, CUBE[color.getRed()][color.getGreen()][color.getBlue()]);
            }
        }
    }

    private void assignPointsToClusters() {
        for (ColorPoint p : points) {
            closestCluster(p).add(p);
        }
    }

    public Cluster closestCluster(ColorPoint p) {
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
        for (Cluster c : clusters) {
            c.recalculateCenter();
        }
    }

    private void clearClusters() {
        for (Cluster c : clusters) c.clear();
    }

    public void colorizeImage(int numClusters, boolean replacerNeeded, Color oldColor, Color newColor) {

        if (numClusters > colorMap.size()) {
            System.out.println("There aren't " + numClusters + " different colors in this image!");
        }

        for (int i = 0; i < numClusters; i++) {



            //change this so that it finds unique colors, hashmap of awtcolor to points
            clusters.add(new Cluster(points.get((int)(Math.random() * points.size()))));
        }

        for (int rep = 0; rep < 100; rep++) {

            clearClusters();
            assignPointsToClusters();
            recalculateCenters();
        }

        if (replacerNeeded) {
            new Replacer(image, CUBE, this).replace(oldColor, newColor);
        }

        for (Cluster cluster : clusters) {
            for (ColorPoint point : cluster.getPoints()) {
                image.setRGB((int) point.getX(), (int) point.getY(), point.getColor().getRGB());
            }
        }
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

    public void writeToFile(String path) {
        File outputfile = new File(path);
        try {
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("could not setup file");
        }
    }

    public void resizeImage(int newW) {
        Image tmp = image.getScaledInstance(newW, image.getHeight() / image.getWidth() * newW, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, image.getHeight() / image.getWidth() * newW, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        image = dimg;
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

    public BufferedImage getImage() {
        return this.image;
    }
}










