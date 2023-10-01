package org.leviatanplatform.geometry.util;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;

/**
 * @author Alejandro
 * 
 */
public final class FiguresUtil {

    private FiguresUtil() {
    }

    /**
     * Connects all the points.
     * 
     * @param listPoints
     *            listPoints
     * @return list of segments
     */
    public static List<Segment> connectAll(final List<Vector> listPoints) {

        final List<Segment> listSegment = new ArrayList<Segment>();

        for (int i = 0; i < listPoints.size() - 1; i++) {

            final Vector point = listPoints.get(i);
            final List<Vector> listPointsRemaining = listPoints.subList(i + 1, listPoints.size());
            addSegmentsOfPoint(point, listPointsRemaining, listSegment);
        }

        return listSegment;
    }

    private static void addSegmentsOfPoint(final Vector point, final List<Vector> listPointsRemaining,
            final List<Segment> listSegment) {

        for (final Vector pointRemaining : listPointsRemaining) {
            listSegment.add(new Segment(point, pointRemaining));
        }
    }
}
