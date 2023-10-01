package org.leviatanplatform.geometry.figures;

import java.util.Arrays;
import java.util.List;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.util.FiguresUtil;

/**
 * @author Alejandro
 * 
 */
public class Tetrahedron4D extends EdgesFigure {

    private final List<Vector> listPoints;
    private final List<Segment> listSegment;

    public Tetrahedron4D(final double sideLength) {

        final int x = 0;
        final int y = 1;
        final int z = 2;

        final double[] components1 = new double[4];
        final double[] components2 = new double[4];
        final double[] components3 = new double[4];
        final double[] components4 = new double[4];

        components1[x] = sideLength / 2;
        components2[x] = -1 * sideLength / 2;

        final double h = sideLength * Math.sqrt(3) / 2;
        components3[y] = h;

        final double hp = sideLength * Math.sqrt(6) / 3;
        components4[y] = h / 3;
        components4[z] = hp;

        listPoints = Arrays.asList(new Vector(components1), new Vector(components2), new Vector(components3),
                new Vector(components4));

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
