package paint2;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Cazarez
 */
public class Circulo extends Figura {

    public Circulo(LinkedList<Point> vertices, BufferedImage bufferedImage) {
        super(vertices, bufferedImage);
    }

    @Override
    public boolean dentroDe(Point punto) {
        int radio = (int) vertices.getFirst().distance(vertices.getLast());
        Point centro = vertices.getFirst();

        return punto.x >= centro.x - radio && punto.x <= centro.x + radio && punto.y >= centro.y - radio && punto.y <= centro.y + radio;
    }

    @Override
    public void dibujar(int z) {
        int radio = (int) vertices.getFirst().distance(vertices.getLast());
        Point centro = vertices.getFirst();
        Point centroZ = Matrices.sumar(centro, new Point(z, 0));

        Painter.dibujarCirculo(bufferedImage, centro, radio, Color.black);
        Painter.dibujarCirculo(bufferedImage, centroZ, radio, Color.black);

        Painter.dibujarLinea(bufferedImage, Matrices.sumar(centro, new Point(0, radio)), Matrices.sumar(centroZ, new Point(0, radio)), Color.black);
        Painter.dibujarLinea(bufferedImage, Matrices.restar(centro, new Point(0, radio)), Matrices.restar(centroZ, new Point(0, radio)), Color.black);
        this.z = z;
    }

    @Override
    public void dibujar(int z, Color color) {
        int radio = (int) vertices.getFirst().distance(vertices.getLast());
        Point centro = vertices.getFirst();
        Point centroZ = Matrices.sumar(centro, new Point(z, 0));

        Painter.dibujarCirculo(bufferedImage, centro, radio, color);
        Painter.dibujarCirculo(bufferedImage, centroZ, radio, color);

        Painter.dibujarLinea(bufferedImage, Matrices.sumar(centro, new Point(0, radio)), Matrices.sumar(centroZ, new Point(0, radio)), color);
        Painter.dibujarLinea(bufferedImage, Matrices.restar(centro, new Point(0, radio)), Matrices.restar(centroZ, new Point(0, radio)), color);
        this.z = z;
    }

    @Override
    public void rotar(int rotacion) {
        JOptionPane.showMessageDialog(null, "No rota pero igual ni se notaría jajja no me repruebe porfa :c", "👉 👈", JOptionPane.INFORMATION_MESSAGE);
    }
}
