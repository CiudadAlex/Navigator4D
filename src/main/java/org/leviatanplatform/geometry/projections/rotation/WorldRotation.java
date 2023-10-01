package org.leviatanplatform.geometry.projections.rotation;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.Vector;

/**
 * @author Alejandro
 * 
 */
public class WorldRotation {

    private final List<Rotation> listRotations = new ArrayList<Rotation>();

    public void addRotation(final int dimension1, final int dimension2, final double angle) {

        final Rotation rotation = findRotation(dimension1, dimension2);
        rotation.addAngle(angle);
    }

    private Rotation findRotation(final int dimension1, final int dimension2) {

        for (final Rotation rotation : this.listRotations) {

            if (rotation.isThisRotation(dimension1, dimension2)) {
                return rotation;
            }
        }

        final Rotation rotation = new Rotation(dimension1, dimension2);
        this.listRotations.add(rotation);

        return rotation;
    }

    public Vector rotate(final Vector point) {

        Vector rotatedPoint = point;

        for (final Rotation rotation : this.listRotations) {

            final int dimension1 = rotation.getDimension1();
            final int dimension2 = rotation.getDimension2();
            final double angle = rotation.getAngle();
            rotatedPoint = rotatedPoint.rotate(dimension1, dimension2, angle);
        }

        return rotatedPoint;
    }
}
