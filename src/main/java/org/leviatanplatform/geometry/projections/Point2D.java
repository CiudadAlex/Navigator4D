package org.leviatanplatform.geometry.projections;

/**
 * Point2D.
 * 
 * @author Alejandro
 * 
 */
public class Point2D {

    private double x;
    private double y;

    /**
     * Constructor for Point2D.
     * 
     * @param x
     *            x
     * @param y
     *            y
     */
    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
