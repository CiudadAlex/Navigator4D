package org.leviatanplatform.geometry.util;

import org.leviatanplatform.geometry.entities.Vector;

/**
 * Calculator.
 * 
 * @author Alejandro
 * 
 */
public final class Calculator {

    private Calculator() {
    }

    /**
     * Adds two Vectors.
     * 
     * @param v1
     *            v1
     * @param v2
     *            v2
     * @return the sum Vector
     */
    public static Vector add(final Vector v1, final Vector v2) {

        final int dimension = v1.getDimension();
        final double[] components = new double[dimension];

        for (int d = 0; d < dimension; d++) {
            components[d] = v1.get(d) + v2.get(d);
        }

        return new Vector(components);
    }

    /**
     * Adds all the Vectors.
     * 
     * @param arrayVectors
     *            arrayVectors
     * @return the sum Vector
     */
    public static Vector addAll(final Vector... arrayVectors) {

        if (arrayVectors.length == 0) {
            return null;

        } else if (arrayVectors.length == 1) {
            return arrayVectors[0];

        } else if (arrayVectors.length == 2) {
            return add(arrayVectors[0], arrayVectors[1]);

        } else {

            Vector sum = arrayVectors[0];

            for (int i = 1; i < arrayVectors.length; i++) {
                sum = add(sum, arrayVectors[i]);
            }

            return sum;
        }
    }

    /**
     * Substracts two Vectors.
     * 
     * @param vectorFinal
     *            pointFinal
     * @param vectorInitial
     *            pointInitial
     * @return a Vector
     */
    public static Vector substract(final Vector vectorFinal, final Vector vectorInitial) {

        final int dimension = vectorFinal.getDimension();
        final double[] components = new double[dimension];

        for (int d = 0; d < dimension; d++) {
            components[d] = vectorFinal.get(d) - vectorInitial.get(d);
        }

        return new Vector(components);
    }

    /**
     * Distance between two Points.
     * 
     * @param pointFinal
     *            pointFinal
     * @param pointInitial
     *            pointInitial
     * @return distance
     */
    public static double distance(final Vector pointFinal, final Vector pointInitial) {
        return substract(pointFinal, pointInitial).norm();
    }

    /**
     * Calculates the scalar product.
     * 
     * @param v1
     *            v1
     * @param v2
     *            v2
     * @return the scalar product
     */
    public static double scalarProduct(final Vector v1, final Vector v2) {

        final int dimension = v1.getDimension();
        double escalarProduct = 0;

        for (int d = 0; d < dimension; d++) {
            escalarProduct = escalarProduct + v1.get(d) * v2.get(d);
        }

        return escalarProduct;
    }

    /**
     * Calculates the multiplication.
     * 
     * @param v
     *            v
     * @param scalar
     *            scalar
     * @return the multiplication
     */
    public static Vector multiply(final Vector v, final double scalar) {

        final int dimension = v.getDimension();
        final double[] components = new double[dimension];

        for (int d = 0; d < dimension; d++) {
            components[d] = scalar * v.get(d);
        }

        return new Vector(components);
    }

    /**
     * Performs an affin transformation.
     * 
     * @param v
     *            vector
     * @param scalarMultiplier
     *            scalarMultiplier
     * @param translation
     *            translation
     * @return the transformed Vector
     */
    public static Vector affinTransformation(final Vector v, final double scalarMultiplier, final Vector translation) {

        final Vector vectorScaled = multiply(v, scalarMultiplier);
        return add(vectorScaled, translation);
    }
}
