package paint2;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Daniel Cazarez
 */
public abstract class Figura {

    protected LinkedList<Point> vertices;
    protected BufferedImage bufferedImage;
    protected boolean seleccionada;

    public Figura(LinkedList<Point> puntos, BufferedImage bufferedImage) {
        this.vertices = puntos;
        this.bufferedImage = bufferedImage;
        seleccionada = false;
    }

    public void dibujar() {
        Painter.dibujarPoligono(bufferedImage, vertices, Color.black);
    }

    public void dibujar(Color color) {
        Painter.dibujarPoligono(bufferedImage, vertices, color);
    }

    public void rotar(int rotacion) {
        quitarCruz();
        dibujar(Color.white);
        Point centro = getCentro();
        for (int i = 0; i < vertices.size(); i++) {
            Point vertice = vertices.get(i);
            int dy = vertice.y - centro.y;
            int dx = vertice.x - centro.x;
            double angulo = Math.atan2(dy, dx);
            angulo *= 180 / Math.PI;
            if (angulo < 0) {
                angulo += 360;
            }

            int r = (int) Math.ceil(centro.distance(vertice));
            int nuevoAngulo = (int) (angulo + rotacion);
            if (nuevoAngulo < 0) {
                nuevoAngulo += 360;
            }
            if (nuevoAngulo > 360) {
                nuevoAngulo -= 360;
            }
            int x = (int) (r * Math.cos(Math.toRadians(nuevoAngulo)));
            int y = (int) (r * Math.sin(Math.toRadians(nuevoAngulo)));
            vertices.set(i, new Point(centro.x + x, centro.y + y));
        }
        dibujar();
        dibujarCruz();
    }

    public Point getCentro() {
        int xMin = vertices.getFirst().x, xMax = vertices.getFirst().x, yMin = vertices.getFirst().y, yMax = vertices.getFirst().y;
        for (Point vertice : vertices) {
            if (vertice.x < xMin) {
                xMin = vertice.x;
            }
            if (vertice.x > xMax) {
                xMax = vertice.x;
            }
            if (vertice.y < yMin) {
                yMin = vertice.y;
            }
            if (vertice.y > yMax) {
                yMax = vertice.y;
            }
        }

        int xDist = xMax - xMin, yDist = yMax - yMin;

        return new Point(xMin + xDist / 2, yMin + yDist / 2);
    }

    public void trasladar(Point nuevoCentro) {
        quitarCruz();
        Point centro = getCentro();
        dibujar(Color.white);
        int xDist = nuevoCentro.x - centro.x;
        int yDist = nuevoCentro.y - centro.y;

        for (int i = 0; i < vertices.size(); i++) {
            Point vertice = vertices.get(i);
            vertices.set(i, new Point(vertice.x + xDist, vertice.y + yDist));
        }
        dibujar();
        dibujarCruz();
    }

    public void escalar(double escalamiento) {
        quitarCruz();
        dibujar(Color.white);
        for (int i = 0; i < vertices.size(); i++) {
            vertices.set(i, Matrices.multiplicar(vertices.get(i), escalamiento));
        }
        dibujar();
        dibujarCruz();
    }

    public boolean dentroDe(Point punto) {
        int xMin = vertices.getFirst().x, xMax = vertices.getFirst().x, yMin = vertices.getFirst().y, yMax = vertices.getFirst().y;
        for (Point vertice : vertices) {
            if (vertice.x < xMin) {
                xMin = vertice.x;
            }
            if (vertice.x > xMax) {
                xMax = vertice.x;
            }
            if (vertice.y < yMin) {
                yMin = vertice.y;
            }
            if (vertice.y > yMax) {
                yMax = vertice.y;
            }
        }
        return punto.x >= xMin && punto.x <= xMax && punto.y >= yMin && punto.y <= yMax;
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public void dibujarCruz() {
        Painter.dibujarCruz(bufferedImage, getCentro(), 5);
    }

    public void quitarCruz() {
        Painter.dibujarCruz(bufferedImage, getCentro(), 5, Color.white);
        dibujar();
    }
}
