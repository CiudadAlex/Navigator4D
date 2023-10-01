package org.leviatanplatform.geometry.figures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;

/**
 * @author Alejandro
 * 
 */
public abstract class EdgesFigure implements Figure {

    public abstract List<Segment> getListSegment();

    @Override
    public void printInfo() {

        final List<Segment> listSegment = getListSegment();

        System.out.println(">>>>> Number of edges of " + getClass().getSimpleName() + ": " + listSegment.size());

        final Set<Vector> setPoint = new HashSet<Vector>();

        for (final Segment segment : listSegment) {
            setPoint.add(segment.getPointFinal());
            setPoint.add(segment.getPointInitial());
        }

        for (final Vector point : setPoint) {
            System.out.println(">>>>> Point: " + point.toString());
        }
    }
}
