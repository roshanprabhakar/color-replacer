import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("logo.png");
        finder.colorizeImage(2, true, Color.ORANGE, Color.RED);

        ClusterFinder secondNode = new ClusterFinder(finder.getImage());
        secondNode.colorizeImage(2, true, Color.BLACK, Color.WHITE);

        secondNode.resizeImage(300, 320);
        secondNode.displayImage();


    }
}