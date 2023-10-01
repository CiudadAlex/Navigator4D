package org.leviatanplatform.geometry.projections;

/**
 * Segment2D.
 * 
 * @author Alejandro
 * 
 */
public class Segment2D {

    private final Point2D pointFinal;

    private final Point2D pointInitial;

    /**
     * Constructor for Segment2D.
     * 
     * @param pointFinal
     *            pointFinal
     * @param pointInitial
     *            pointInitial
     */
    public Segment2D(final Point2D pointFinal, final Point2D pointInitial) {
        this.pointFinal = pointFinal;
        this.pointInitial = pointInitial;
    }

    public Point2D getPointFinal() {
        return pointFinal;
    }

    public Point2D getPointInitial() {
        return pointInitial;
    }
}
