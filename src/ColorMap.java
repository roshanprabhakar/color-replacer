import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorMap {

    private HashMap<Color, ArrayList<ColorPoint>> map;

    public ColorMap() {
        map = new HashMap<>();
    }

    public void put(Color c, ColorPoint p) {
        if (!containsColor(c)) map.put(c, new ArrayList<>());
        map.get(getMapObject(c)).add(p);
    }

    public Color getMapObject(Color c) {
        for (Color color : map.keySet()) {
            if (c.getRed() == color.getRed() && c.getGreen() == color.getGreen() && c.getBlue() == color.getBlue()) {
                return color;
            }
        }
        return null;
    }

    public boolean containsColor(Color c) {
        for (Color color : map.keySet()) {
            if (c.getRed() == color.getRed() && c.getGreen() == color.getGreen() && c.getBlue() == color.getBlue()) return true;
        }
        return false;
    }

    public boolean containsObject(Color c) {
        return map.containsKey(c);
    }

    public ArrayList<ColorPoint> get(Color c) {
        return map.get(c);
    }
}