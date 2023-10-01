package org.leviatanplatform.geometry.figures;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;

/**
 * @author Alejandro
 * 
 */
public class HyperCubeStreched4D extends EdgesFigure {

    private final List<Segment> listSegment;

    private final double sideShort;
    private final double sideLong;
    private final int dimensionLong;

    public HyperCubeStreched4D(final double sideShort, final double sideLong, final int dimensionLong) {

        this.sideShort = sideShort;
        this.sideLong = sideLong;
        this.dimensionLong = dimensionLong;

        final Vector vectorZero4D = new Vector(new double[] { 0, 0, 0, 0 });
        final HyperCube4D hyperCube4D = new HyperCube4D(vectorZero4D, sideShort);

        listSegment = new ArrayList<Segment>();
        final List<Segment> listSegmentHyperCube = hyperCube4D.getListSegment();

        for (final Segment segmentHyperCube : listSegmentHyperCube) {
            listSegment.add(transformSegment(segmentHyperCube));
        }
    }

    private Segment transformSegment(final Segment segmentHyperCube) {

        final Vector pointFinal = transformPoint(segmentHyperCube.getPointFinal());
        final Vector pointInitial = transformPoint(segmentHyperCube.getPointInitial());

        return new Segment(pointFinal, pointInitial);
    }

    private Vector transformPoint(final Vector pointHyperCube) {

        final int dimension = pointHyperCube.getDimension();
        final double[] components = new double[dimension];

        for (int d = 0; d < dimension; d++) {
            components[d] = pointHyperCube.get(d);
        }

        components[dimensionLong] = components[dimensionLong] * sideLong / sideShort;

        return new Vector(components);
    }

    @Override
    public List<Segment> getListSegment() {
        return listSegment;
    }
}
