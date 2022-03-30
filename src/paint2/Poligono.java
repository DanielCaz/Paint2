package paint2;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Daniel Cazarez
 */
public class Poligono extends Figura {

    public Poligono(LinkedList<Point> vertices, BufferedImage bufferedImage) {
        super(vertices, bufferedImage);
    }
}
