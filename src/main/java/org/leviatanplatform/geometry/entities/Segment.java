package org.leviatanplatform.geometry.entities;


/**
 * Segment.
 * 
 * @author Alejandro
 * 
 */
public class Segment {

    private final Vector pointFinal;

    private final Vector pointInitial;

    /**
     * Constructor for Segment.
     * 
     * @param pointFinal
     *            pointFinal
     * @param pointInitial
     *            pointInitial
     */
    public Segment(final Vector pointFinal, final Vector pointInitial) {
        this.pointFinal = pointFinal;
        this.pointInitial = pointInitial;
    }

    public Vector getPointFinal() {
        return pointFinal;
    }

    public Vector getPointInitial() {
        return pointInitial;
    }

}
