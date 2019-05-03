import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("logo.png");

        finder.colorizeImage(4, true, Color.GREEN, Color.RED);
        finder.resizeImage(400);

        finder.writeToFile("outFile.png");
    }
}