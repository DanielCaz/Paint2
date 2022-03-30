package paint2;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Daniel Cazarez
 */
public class Painter {

    public static void llenarImagen(BufferedImage bufferedImage, Color color) {
        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
    }
    
    public static void dibujarCirculo(BufferedImage bufferedImage, Point centro, int radio, Color color) {        
        Point[] puntos = new Point[361];
        for (int angulo = 0; angulo <= 360; angulo++) {
            int x = (int) (radio * Math.cos(Math.toRadians(angulo)));
            int y = (int) (radio * Math.sin(Math.toRadians(angulo)));
            puntos[angulo] = new Point(centro.x + x, centro.y + y);
        }

        for (int i = 0; i < puntos.length - 1; i++) {
            dibujarLinea(bufferedImage, puntos[i], puntos[i + 1], color);
        }
    }

    public static void dibujarPoligono(BufferedImage bufferedImage, LinkedList<Point> puntos, Color color) {
        int i;
        for (i = 0; i < puntos.size() - 1; i++) {
            Point punto = puntos.get(i);
            dibujarLinea(bufferedImage, punto, puntos.get(i + 1), color);
        }

        dibujarLinea(bufferedImage, puntos.get(i), puntos.getFirst(), color);
    }

    public static void dibujarCruz(BufferedImage bufferedImage, Point centro, int tamano) {
        Painter.dibujarLinea(bufferedImage, new Point(centro.x - tamano, centro.y), new Point(centro.x + tamano, centro.y), Color.black);
        Painter.dibujarLinea(bufferedImage, new Point(centro.x, centro.y - tamano), new Point(centro.x, centro.y + tamano), Color.black);
    }

    public static void dibujarCruz(BufferedImage bufferedImage, Point centro, int tamano, Color color) {
        Painter.dibujarLinea(bufferedImage, new Point(centro.x - tamano, centro.y), new Point(centro.x + tamano, centro.y), color);
        Painter.dibujarLinea(bufferedImage, new Point(centro.x, centro.y - tamano), new Point(centro.x, centro.y + tamano), color);
    }

    public static void dibujarLinea(BufferedImage bufferedImage, Point p1, Point p2, Color color) {
        double xr = p2.getX() - p1.getX();
        double yr = p2.getY() - p1.getY();

        int x = -1, y = -1;

        try {
            if (xr != 0) {
                double m = yr / xr;
                if (Math.abs(xr) > Math.abs(yr)) {
                    if (p1.x > p2.x) {
                        for (x = p2.x; x <= p1.x; x++) {
                            y = (int) (p1.y + (m * (x - p1.x)));
                            bufferedImage.setRGB(x, y, color.getRGB());
                        }
                    } else {
                        for (x = p1.x; x <= p2.x; x++) {
                            y = (int) (p1.y + (m * (x - p1.x)));
                            bufferedImage.setRGB(x, y, color.getRGB());
                        }
                    }
                } else {
                    if (p1.y > p2.y) {
                        for (y = p2.y; y <= p1.y; y++) {
                            x = (int) (p1.x + ((y - p1.y) / m));
                            bufferedImage.setRGB(x, y, color.getRGB());
                        }
                    } else {
                        for (y = p1.y; y <= p2.y; y++) {
                            x = (int) (p1.x + ((y - p1.y) / m));
                            bufferedImage.setRGB(x, y, color.getRGB());
                        }
                    }
                }
            } else {
                if (p1.y > p2.y) {
                    for (y = p2.y; y < p1.y; y++) {
                        x = p1.x;
                        bufferedImage.setRGB(x, y, color.getRGB());
                    }
                } else {
                    for (y = p1.y; y < p2.y; y++) {
                        x = p1.x;
                        bufferedImage.setRGB(x, y, color.getRGB());
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("La coordenada (%d, %d) está fuera de rango, pero ntp xD%n", x, y);
        }
    }
}
