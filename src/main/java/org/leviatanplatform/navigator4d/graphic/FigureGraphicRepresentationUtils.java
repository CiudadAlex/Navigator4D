package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.projections.Point2D;
import org.leviatanplatform.geometry.projections.ProjectivePlane;
import org.leviatanplatform.geometry.projections.Segment2D;

import java.awt.*;
import java.util.List;

public class FigureGraphicRepresentationUtils {

    public static void paintCurrentListOfStars(Graphics g, ProjectivePlane projectivePlane, EuclideanSpace euclideanSpace, int width, int height) {

        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);

        paintEuclideanSpace(g, projectivePlane, euclideanSpace, width, height);
    }

    private static void paintEuclideanSpace(Graphics g, ProjectivePlane projectivePlane, EuclideanSpace euclideanSpace, int width, int height) {

        g.setColor(Color.white);

        final List<Segment2D> listSegment2D = projectivePlane.projectEdgesFigures(euclideanSpace);

        for (final Segment2D segment2D : listSegment2D) {
            drawSegment2D(g, segment2D, width, height);
        }
    }

    private static void drawSegment2D(final Graphics g, final Segment2D segment2D, int width, int height) {

        final Pixel pixelInitial = translateIntoPixel(segment2D.getPointInitial(), width, height);
        final Pixel pixelFinal = translateIntoPixel(segment2D.getPointFinal(), width, height);

        drawLine(g, pixelInitial, pixelFinal);
    }

    private static Pixel translateIntoPixel(final Point2D point2D, int width, int height) {

        // Center the (0,0)
        final double x = (float) point2D.getX() + width / 2.0;
        final double y = -1 * point2D.getY() + height / 2.0;

        return new Pixel((float) x, (float) y);
    }

    private static void drawLine(final Graphics g, final Pixel pixelInitial, final Pixel pixelFinal) {
        g.drawLine((int)pixelInitial.getX(), (int)pixelInitial.getY(), (int)pixelFinal.getX(), (int)pixelFinal.getY());
    }

}
