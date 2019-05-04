import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("logo.png");

        finder.colorizeImage(4,true, Color.ORANGE, Color.WHITE);

        finder.writeToFile("outFile.png");
    }
}