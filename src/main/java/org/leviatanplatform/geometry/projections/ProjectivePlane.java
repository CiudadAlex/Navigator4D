package org.leviatanplatform.geometry.projections;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.EdgesFigure;

/**
 * ProjectivePlane.
 * 
 * @author Alejandro
 * 
 */
public abstract class ProjectivePlane {

    /**
     * Projects.
     * 
     * @param point
     *            point
     * @return Point2D
     */
    public abstract Point2D project(final Vector point);

    /**
     * Projects.
     * 
     * @param segment
     *            segment
     * @return Segment2D
     */
    public abstract Segment2D project(final Segment segment);

    /**
     * Rotates the ProjectivePlane in the plane of the given dimensions
     * 
     * @param dimension1
     *            dimension1
     * @param dimension2
     *            dimension2
     */
    public abstract void rotate(int dimension1, int dimension2, double angle);

    /**
     * Translates.
     *
     * @param dimension dimension
     * @param amount amount
     */
    public abstract void translate(final int dimension, final double amount);

    /**
     * Approaches.
     * 
     * @param amount
     *            amount
     */
    public abstract void approach(double amount);

    /**
     * Projects.
     * 
     * @param listPoint
     *            listPoint
     * @return List<Point2D>
     */
    public List<Point2D> projectListOfPoints(final List<Vector> listPoint) {

        final List<Point2D> listPoint2D = new ArrayList<Point2D>();

        for (final Vector point : listPoint) {
            listPoint2D.add(project(point));
        }

        return listPoint2D;
    }

    /**
     * Projects.
     * 
     * @param listSegment
     *            listSegment
     * @return List<Segment2D>
     */
    public List<Segment2D> projectListOfSegments(final List<Segment> listSegment) {

        final List<Segment2D> listSegment2D = new ArrayList<Segment2D>();

        for (final Segment segment : listSegment) {
            listSegment2D.add(project(segment));
        }

        return listSegment2D;
    }

    /**
     * Projects.
     * 
     * @param edgesFigure
     *            edgesFigure
     * @return List<Segment2D>
     */
    public List<Segment2D> project(final EdgesFigure edgesFigure) {
        return projectListOfSegments(edgesFigure.getListSegment());
    }

    /**
     * Projects the EdgesFigure of an EuclideanSpace.
     * 
     * @param euclideanSpace
     *            euclideanSpace
     * @return List<Segment2D>
     */
    public List<Segment2D> projectEdgesFigures(final EuclideanSpace euclideanSpace) {

        final List<Segment2D> listSegment2D = new ArrayList<Segment2D>();

        for (final EdgesFigure edgesFigure : euclideanSpace.getListOfEdgesFigures()) {
            listSegment2D.addAll(project(edgesFigure));
        }

        return listSegment2D;
    }

}
