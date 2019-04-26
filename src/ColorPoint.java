import java.awt.*;

public class ColorPoint extends Point {

    private int red;
    private int blue;
    private int green;

    public ColorPoint(int red, int blue, int green, int x, int y) {

        this.red = red;
        this.green = green;
        this.blue = blue;

        this.x = x;
        this.y = y;

    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }
}
