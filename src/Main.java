import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("outFile.png");
        finder.colorizeImage(2, true, Color.BLACK, Color.BLACK);
        finder.resizeImage(1000);
        finder.writeToFile("outFile.png");

    }
}