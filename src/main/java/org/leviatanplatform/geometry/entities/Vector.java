package org.leviatanplatform.geometry.entities;

import java.util.Arrays;

import org.leviatanplatform.geometry.util.Calculator;

/**
 * Vector.
 * 
 * @author Alejandro
 * 
 */
public class Vector {

    private final double[] components;

    /**
     * Constructor for Vector.
     * 
     * @param components
     *            components
     */
    public Vector(final double[] components) {
        this.components = components;
    }

    /**
     * Returns the component.
     * 
     * @param numberDimension
     *            numberDimension
     * @return the component
     */
    public double get(final int numberDimension) {
        return components[numberDimension];
    }

    public int getDimension() {
        return components.length;
    }

    /**
     * Returns the norm of the vector.
     * 
     * @return the norm of the vector
     */
    public double norm() {

        double norm = 0;

        for (final double comp : components) {

            norm = norm + comp * comp;
        }

        norm = Math.sqrt(norm);

        return norm;
    }

    public Vector rotate(final int dimension1, final int dimension2, final double angle) {

        final double[] componentsRotated = Arrays.copyOf(components, components.length);

        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double x0 = components[dimension1];
        final double y0 = components[dimension2];

        final double x = x0 * cos - y0 * sin;
        final double y = x0 * sin + y0 * cos;

        componentsRotated[dimension1] = x;
        componentsRotated[dimension2] = y;

        return new Vector(componentsRotated);
    }

    /**
     * Returns the unit vector.
     * 
     * @return the unit vector
     */
    public Vector getUnitVector() {

        final int dimension = getDimension();
        final double norm = norm();
        final double[] componentsUnit = new double[dimension];

        for (int d = 0; d < dimension; d++) {
            componentsUnit[d] = components[d] / norm;
        }

        return new Vector(componentsUnit);
    }

    public Vector negate() {
        return Calculator.multiply(this, -1);
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof Vector)) {
            return false;
        }

        final Vector v = (Vector) obj;

        if (components.length != v.getDimension()) {
            return false;
        }

        for (int d = 0; d < components.length; d++) {

            if (components[d] != v.get(d)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {

        final StringBuilder sb = new StringBuilder();

        for (int d = 0; d < components.length; d++) {

            sb.append(components[d]);
            sb.append("|");
        }

        return sb.toString().hashCode();
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int d = 0; d < components.length; d++) {

            sb.append(components[d]);
            sb.append(", ");
        }

        sb.append(")");

        return sb.toString();
    }

    public static Vector zero(int numDimensions) {

        final double[] arrayDouble = new double[numDimensions];

        for (int i = 0; i < numDimensions; i++) {
            arrayDouble[i] = 0;
        }

        return new Vector(arrayDouble);
    }

    public static Vector unitary(int numDimensions, int dimension) {

        final double[] arrayDouble = new double[numDimensions];

        for (int i = 0; i < numDimensions; i++) {
            arrayDouble[i] = 0;
        }

        arrayDouble[dimension] = 1;

        return new Vector(arrayDouble);
    }
}
