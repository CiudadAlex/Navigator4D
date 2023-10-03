package org.leviatanplatform.geometry.figures;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.entities.Segment;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.util.Calculator;

/**
 * HyperCubeND.
 * 
 * @author Alejandro
 * 
 */
public class HyperCubeND extends EdgesFigure {

    private final Vector pointCenter;
    private final double sideLength;
    private final List<Segment> listSegment;

    public HyperCubeND(final Vector pointCenter, final double sideLength, final int dimensionHyperCube,
            final int dimensionEnvironment) {
        this.pointCenter = pointCenter;
        this.sideLength = sideLength;
        this.listSegment = buildHyperCube(dimensionHyperCube, dimensionEnvironment, pointCenter, sideLength);
    }

    private List<Segment> buildHyperCube(final int dimensionHyperCube, final int dimensionEnvironment,
            final Vector pointCenter, final double sideLenght) {

        final List<Segment> listSegmentFinal = new ArrayList<Segment>();
        final List<Segment> listSegmentUnit = buildUnitHyperCube(dimensionHyperCube, dimensionEnvironment);

        for (final Segment segmentUnit : listSegmentUnit) {
            listSegmentFinal.add(transformSegment(segmentUnit, pointCenter, sideLenght));
        }

        return listSegmentFinal;
    }

    private Segment transformSegment(final Segment segmentUnit, final Vector pointCenter, final double sideLenght) {

        final Vector pointFinalTransformed = Calculator.affinTransformation(segmentUnit.getPointFinal(), sideLenght,
                pointCenter);
        final Vector pointInitialTransformed = Calculator.affinTransformation(segmentUnit.getPointInitial(),
                sideLenght, pointCenter);

        return new Segment(pointFinalTransformed, pointInitialTransformed);
    }

    private List<Segment> buildUnitHyperCube(final int dimensionHyperCube, final int dimensionEnvironment) {

        final List<Vector> listPoints = getUnitHyperCubePoints(dimensionHyperCube, dimensionEnvironment);
        return matchPoints(listPoints);
    }

    private List<Vector> getUnitHyperCubePoints(final int dimensionHyperCube, final int dimensionEnvironment) {

        final List<Vector> listPoints = new ArrayList<Vector>();
        final int numberOfPoints = (int) Math.pow(2, dimensionHyperCube);

        for (int i = 0; i < numberOfPoints; i++) {
            final String binaryNumber = getBinaryRepresentation(i, dimensionHyperCube);
            final Vector point = new Vector(getValues(binaryNumber, dimensionEnvironment));
            listPoints.add(point);
        }

        return listPoints;
    }

    private String getBinaryRepresentation(final int i, final int size) {

        String binary = Integer.toBinaryString(i);
        final int zerosToAdd = size - binary.length();

        for (int k = 0; k < zerosToAdd; k++) {
            binary = "0" + binary;
        }

        return binary;
    }

    private double[] getValues(final String binaryNumber, final int dimensionEnvironment) {

        final double[] components = new double[dimensionEnvironment];
        final int dimensionHyperCube = binaryNumber.length();

        for (int d = 0; d < dimensionHyperCube; d++) {

            final Integer oneOrZero = Integer.parseInt("" + binaryNumber.charAt(d));
            components[d] = oneOrZero.doubleValue() - 0.5;
        }

        return components;
    }

    private List<Segment> matchPoints(final List<Vector> listPoints) {

        final List<Segment> listSegment = new ArrayList<Segment>();

        for (int i = 0; i < listPoints.size() - 1; i++) {

            final Vector point = listPoints.get(i);
            final List<Vector> listPointsRemaining = listPoints.subList(i + 1, listPoints.size());
            addSegmentsOfPoint(point, listPointsRemaining, listSegment);
        }

        return listSegment;
    }

    private void addSegmentsOfPoint(final Vector point, final List<Vector> listPointsRemaining,
            final List<Segment> listSegment) {

        for (final Vector pointRemaining : listPointsRemaining) {

            if (areAnEdge(point, pointRemaining)) {
                listSegment.add(new Segment(point, pointRemaining));
            }
        }
    }

    private boolean areAnEdge(final Vector point1, final Vector point2) {

        final double distance = Calculator.distance(point1, point2);
        return distance < 1.1;
    }

    public Vector getPointCenter() {
        return pointCenter;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public List<Segment> getListSegment() {
        return listSegment;
    }
}
