import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Replacer {

    private BufferedImage image;
    private ColorPoint[][][] CUBE;
    private ArrayList<Cluster> clusters;

    public Replacer(BufferedImage image, int numColors) {

        clusters = new ArrayList<>();

        this.image = image;
        for (int r = 0; r < image.getHeight(); r++) {
            for (int c = 0; c < image.getWidth(); c++) {
                Color pixel = new Color(image.getRGB(c, r));
                CUBE[pixel.getRed()][pixel.getBlue()][pixel.getGreen()] =
                        new ColorPoint(pixel.getRed(), pixel.getGreen(), pixel.getBlue(), c, r);
            }
        }



    }

    public void replace(Color oldColor, Color newColor) {

    }
}
