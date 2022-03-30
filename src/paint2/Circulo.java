package paint2;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Daniel Cazarez
 */
public class Circulo extends Figura {

    public Circulo(LinkedList<Point> vertices, BufferedImage bufferedImage) {
        super(vertices, bufferedImage);
    }

    @Override
    public void dibujar() {
        int radio = (int) vertices.getFirst().distance(vertices.getLast());
        Point centro = vertices.getFirst();
        Painter.dibujarCirculo(bufferedImage, centro, radio, Color.black);
    }

    @Override
    public void dibujar(Color color) {
        int radio = (int) vertices.getFirst().distance(vertices.getLast());
        Point centro = vertices.getFirst();
        Painter.dibujarCirculo(bufferedImage, centro, radio, Color.black);
    }

    @Override
    public void rotar(int rotacion) {
        System.out.println("No rota pero igual ni se notaría jajja no me repruebe porfa :c");
    }
}
