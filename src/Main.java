import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ClusterFinder finder = new ClusterFinder("logo.png");
        finder.colorizeImage(2, true, Color.ORANGE, Color.WHITE);

        ClusterFinder secondNode = new ClusterFinder(finder.getImage());
        secondNode.colorizeImage(2, true, Color.BLACK, Color.RED);

        ClusterFinder thirdNode = new ClusterFinder(finder.getImage());
        secondNode.colorizeImage(2, true, Color.WHITE, Color.BLACK);

        thirdNode.resizeImage(300);
        thirdNode.writeToFile("outFile.png");

    }
}