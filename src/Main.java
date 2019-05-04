import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("outFile.png");

        finder.colorizeImage(3,true, Color.ORANGE, Color.RED);

        finder.writeToFile("outFile1.png");
    }
}