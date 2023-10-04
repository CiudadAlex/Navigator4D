package org.leviatanplatform.geometry.projections;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.util.Calculator;

/**
 * ProjectivePlane.
 * 
 * @author Alejandro
 * 
 */
public class IsometricProjectivePlane extends ProjectivePlane {

    private Vector v1;
    private Vector v2;

    /**
     * Constructor of ProjectivePlane.
     * 
     * @param v1
     *            v1
     * @param v2
     *            v2
     */
    public IsometricProjectivePlane(final Vector v1, final Vector v2) {

        final double scalarProduct = Calculator.scalarProduct(v1, v2);

        if (scalarProduct != 0) {
            throw new IllegalArgumentException("The vectors must be orthogonal");
        }

        this.v1 = v1.getUnitVector();
        this.v2 = v2.getUnitVector();
    }

    @Override
    public Point2D project(final Vector point) {

        final double x = Calculator.scalarProduct(point, v1);
        final double y = Calculator.scalarProduct(point, v2);

        return new Point2D(x, y);
    }

    @Override
    public Segment2D project(final Segment segment) {

        final Point2D pointFinal = project(segment.getPointFinal());
        final Point2D pointInitial = project(segment.getPointInitial());

        return new Segment2D(pointFinal, pointInitial);
    }

    @Override
    public void rotate(final int dimension1, final int dimension2, final double angle) {
        this.v1 = this.v1.rotate(dimension1, dimension2, angle);
        this.v2 = this.v2.rotate(dimension1, dimension2, angle);
    }

    @Override
    public void translate(final int dimension, final double amount) {

        Vector vector = Vector.unitary(4, dimension);
        final Vector advance = Calculator.multiply(vector, amount);

        this.v1 = Calculator.add(this.v1, advance);
        this.v2 = Calculator.add(this.v2, advance);
    }

    @Override
    public void approach(final double amount) {

        double scale = 1;

        if (amount > 0) {
            scale = amount + 1;

        } else {
            scale = Math.exp(amount);
        }

        this.v1 = Calculator.multiply(v1, scale);
        this.v2 = Calculator.multiply(v2, scale);
    }
}
