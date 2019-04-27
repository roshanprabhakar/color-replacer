import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("logo.png");
        finder.colorizeImage(2, true, Color.BLACK, Color.RED);
        finder.displayImage();


    }
}