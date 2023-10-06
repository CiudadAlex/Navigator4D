package org.leviatanplatform.navigator4d;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.*;
import org.leviatanplatform.geometry.projections.IsometricProjectivePlane;
import org.leviatanplatform.geometry.projections.ProjectivePlane;
import org.leviatanplatform.geometry.util.Calculator;
import org.leviatanplatform.navigator4d.graphic.FigureGraphicRepresentation;
import org.leviatanplatform.navigator4d.graphic.ObjectWrapper;

public class Main {

    public static void main(String[] args) {

        final Vector screenX = Calculator.multiply(Vector.unitary(4, 0), 100000);
        final Vector screenY = Calculator.multiply(Vector.unitary(4, 1), 100000);

        ProjectivePlane isometricProjectivePlane = new IsometricProjectivePlane(screenX, screenY);

        Vector pointCenter = Vector.zero(4);
        HyperCube4D figure = new HyperCube4D(pointCenter, 200);

        EuclideanSpace euclideanSpace = new EuclideanSpace();
        euclideanSpace.getListOfEdgesFigures().add(figure);

        FigureGraphicRepresentation figureGraphicRepresentation =
                new FigureGraphicRepresentation(new ObjectWrapper<>(isometricProjectivePlane), euclideanSpace);
        figureGraphicRepresentation.show();
    }
}
