package org.leviatanplatform.geometry.projections;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.projections.rotation.WorldRotation;
import org.leviatanplatform.geometry.util.Calculator;

/**
 * @author Alejandro
 * 
 */
public class KonicProjectivePlane extends ProjectivePlane {

    private Vector camera;
    private final Vector cameraToScreen;

    private final Vector screenUnitX;
    private final Vector screenUnitY;
    private final Vector screenUnitZ;

    private final WorldRotation worldRotation;

    public KonicProjectivePlane(final Vector camera, final Vector cameraToScreen, final Vector screenX,
            final Vector screenY, final Vector screenZ) {

        final double scalarProductXY = Calculator.scalarProduct(screenX, screenY);
        final double scalarProductXZ = Calculator.scalarProduct(screenX, screenZ);
        final double scalarProductYZ = Calculator.scalarProduct(screenY, screenZ);

        final double scalarProductCSX = Calculator.scalarProduct(cameraToScreen, screenX);
        final double scalarProductCSY = Calculator.scalarProduct(cameraToScreen, screenY);
        final double scalarProductCSZ = Calculator.scalarProduct(cameraToScreen, screenZ);

        if (scalarProductXY != 0 || scalarProductXZ != 0 || scalarProductYZ != 0) {
            throw new IllegalArgumentException("The vectors screenX, screenY and screenZ must be orthogonal");
        }

        if (scalarProductCSX != 0 || scalarProductCSY != 0 || scalarProductCSZ != 0) {
            throw new IllegalArgumentException(
                    "The vectors cameraToScreen must be orthogonal to screenX, screenY and screenZ");
        }

        this.camera = camera;
        this.cameraToScreen = cameraToScreen;
        this.screenUnitX = screenX.getUnitVector();
        this.screenUnitY = screenY.getUnitVector();
        this.screenUnitZ = screenZ.getUnitVector();

        this.worldRotation = new WorldRotation();
    }

    @Override
    public void rotate(final int dimension1, final int dimension2, final double angle) {
        this.worldRotation.addRotation(dimension1, dimension2, angle);
    }

    @Override
    public void translate(final int dimension, final double amount) {

        Vector vector = Vector.unitary(4, dimension);
        final Vector advance = Calculator.multiply(vector, amount);
        this.camera = Calculator.add(this.camera, advance);

        System.out.println(camera);
    }

    @Override
    public void approach(final double amount) {

        final Vector advance = Calculator.multiply(this.cameraToScreen, amount);
        this.camera = Calculator.add(this.camera, advance);

        System.out.println(camera);
    }

    @Override
    public Segment2D project(final Segment segment) {

        final Point2D pointFinal = project(segment.getPointFinal());
        final Point2D pointInitial = project(segment.getPointInitial());

        return new Segment2D(pointFinal, pointInitial);
    }

    @Override
    public Point2D project(final Vector point) {

        final Vector rotatedPoint = worldRotation.rotate(point);

        final Vector c = camera;
        final Vector v = cameraToScreen;
        final Vector uv = v.getUnitVector();
        final Vector r = Calculator.substract(rotatedPoint, c);

        final double f = v.norm() / (Calculator.scalarProduct(r, uv));

        final Vector rpx = getVectorProjection(r, this.screenUnitX);
        final Vector rpy = getVectorProjection(r, this.screenUnitY);
        final Vector rpz = getVectorProjection(r, this.screenUnitZ);

        final Vector rp = Calculator.multiply(Calculator.addAll(rpx, rpy, rpz), f);

        final Vector h1 = Calculator.add(screenUnitX, screenUnitY.negate());
        final Vector h2 = Calculator.addAll(screenUnitX.negate(), screenUnitY.negate(), screenUnitZ);

        final Vector uh1 = h1.getUnitVector();
        final Vector uh2 = h2.getUnitVector();

        final double x = Calculator.scalarProduct(rp, uh1);
        final double y = Calculator.scalarProduct(rp, uh2);
        return new Point2D(x, y);
    }

    private Vector getVectorProjection(final Vector v, final Vector unitVectorDirection) {

        final double normProjected = Calculator.scalarProduct(v, unitVectorDirection);
        return Calculator.multiply(unitVectorDirection, normProjected);
    }
}
