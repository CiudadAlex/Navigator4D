package org.leviatanplatform.geometry.projections.rotation;

/**
 * @author Alejandro
 * 
 */
public class Rotation {

    private final int dimension1;
    private final int dimension2;

    private double angle;

    public Rotation(final int dimension1, final int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
        this.angle = 0;
    }

    public boolean isThisRotation(final int dimension1, final int dimension2) {

        if (this.dimension1 == dimension1 && this.dimension2 == dimension2) {
            return true;

        } else if (this.dimension1 == dimension2 && this.dimension2 == dimension1) {
            return true;
        }

        return false;
    }

    public void addAngle(final double angle) {
        this.angle = this.angle + angle;
    }

    public double getAngle() {
        return angle;
    }

    public int getDimension1() {
        return dimension1;
    }

    public int getDimension2() {
        return dimension2;
    }

}
