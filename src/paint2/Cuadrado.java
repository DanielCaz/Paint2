package paint2;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Daniel Cazarez
 */
public class Cuadrado extends Figura {

    public Cuadrado(LinkedList<Point> vertices, BufferedImage bufferedImage) {
        super(vertices, bufferedImage);
    }

    @Override
    public void dibujar() {
        Point temp1 = new Point(vertices.getFirst().x, vertices.getLast().y);
        Point temp2 = new Point(vertices.getLast().x, vertices.getFirst().y);
        Painter.dibujarLinea(bufferedImage, vertices.getFirst(), temp1, Color.black);
        Painter.dibujarLinea(bufferedImage, temp1, vertices.getLast(), Color.black);
        Painter.dibujarLinea(bufferedImage, vertices.getLast(), temp2, Color.black);
        Painter.dibujarLinea(bufferedImage, temp2, vertices.getFirst(), Color.black);
    }

    @Override
    public void dibujar(Color color) {
        Point temp1 = new Point(vertices.getFirst().x, vertices.getLast().y);
        Point temp2 = new Point(vertices.getLast().x, vertices.getFirst().y);
        Painter.dibujarLinea(bufferedImage, vertices.getFirst(), temp1, color);
        Painter.dibujarLinea(bufferedImage, temp1, vertices.getLast(), color);
        Painter.dibujarLinea(bufferedImage, vertices.getLast(), temp2, color);
        Painter.dibujarLinea(bufferedImage, temp2, vertices.getFirst(), color);
    }
}
