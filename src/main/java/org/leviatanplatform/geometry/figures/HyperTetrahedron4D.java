package org.leviatanplatform.geometry.figures;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.util.FiguresUtil;

/**
 * HyperTetrahedron4D.
 * 
 * @author Alejandro
 * 
 */
public class HyperTetrahedron4D extends EdgesFigure {

    private final List<Vector> listPoints;
    private final List<Segment> listSegment;

    public HyperTetrahedron4D(final double sideLength) {

        listPoints = new ArrayList<Vector>();

        final Tetrahedron4D tetrahedron4D = new Tetrahedron4D(sideLength);
        listPoints.addAll(tetrahedron4D.getListPoints());

        final int y = 1;
        final int z = 2;
        final int w = 3;

        final double[] components5 = new double[4];

        components5[y] = sideLength * Math.sqrt(3) / 6;
        components5[z] = sideLength * Math.sqrt(6) / 12;
        components5[w] = sideLength * Math.sqrt(15) / Math.sqrt(24);

        listPoints.add(new Vector(components5));

        listSegment = FiguresUtil.connectAll(listPoints);
    }

    @Override
    public List<Segment> getListSegment() {
        return listSegment;
    }

    public List<Vector> getListPoints() {
        return listPoints;
    }

}
