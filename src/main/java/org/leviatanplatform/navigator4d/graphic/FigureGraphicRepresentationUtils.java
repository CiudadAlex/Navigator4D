package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.figures.EdgesFigure;

import java.awt.*;

public class FigureGraphicRepresentationUtils {

    public static void paintCurrentListOfStars(Graphics g, EdgesFigure edgesFigure, int width, int height) {

        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);

        int pixelsReference = Math.min(width, height);

        paintStar(g, edgesFigure, pixelsReference);
    }

    private static void paintStar(Graphics g, EdgesFigure edgesFigure, int pixelsReference) {

        // FIXME finish

        // Vector position = star.position();
        // double z = position.z();
        // int scaledColor = scaleColorZ(initialMaxDistance/5, z);

        // Color color = new Color(255, scaledColor, scaledColor);
        // g.setColor(color);

        // int x = scaleToScreen(initialMaxDistance, pixelsReference, position.x());
        // int y = scaleToScreen(initialMaxDistance, pixelsReference, position.y());
        // g.fillOval(x, y, 3, 3);
    }

    private static int scaleToScreen(double initialMaxDistance, int pixelsReference, double coordinate) {
        return (int) (pixelsReference * coordinate / initialMaxDistance) + pixelsReference/2;
    }
}
