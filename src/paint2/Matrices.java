package paint2;

import java.awt.Point;

/**
 *
 * @author Daniel Cazarez
 */
public class Matrices {

    public static Point sumar(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }

    public static Point restar(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y);
    }

    public static Point multiplicar(Point p1, Point p2) {
        return new Point(p1.x * p2.x, p1.y * p2.y);
    }
    
    public static Point sumar(Point p1, double n) {
        int nuevaX = (int) Math.round(p1.x + n);
        int nuevaY = (int) Math.round(p1.y + n);
        return new Point(nuevaX, nuevaY);
    }

    public static Point restar(Point p1, double n) {
        int nuevaX = (int) Math.round(p1.x - n);
        int nuevaY = (int) Math.round(p1.y - n);
        return new Point(nuevaX, nuevaY);
    }

    public static Point multiplicar(Point p1, double n) {
        int nuevaX = (int) Math.round(p1.x * n);
        int nuevaY = (int) Math.round(p1.y * n);
        return new Point(nuevaX, nuevaY);
    }
}
