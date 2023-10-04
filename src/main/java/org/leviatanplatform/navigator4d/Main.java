package org.leviatanplatform.navigator4d;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.*;
import org.leviatanplatform.geometry.projections.KonicProjectivePlane;
import org.leviatanplatform.geometry.projections.ProjectivePlane;
import org.leviatanplatform.navigator4d.graphic.FigureGraphicRepresentation;

public class Main {

    public static void main(String[] args) {

        final Vector camera = new Vector(new double[] { 0, 0, 0, 2 });
        final Vector cameraToScreen = new Vector(new double[] { 0, 0, 0, 100 });
        final Vector screenX = Vector.unitary(4, 0);
        final Vector screenY = Vector.unitary(4, 1);
        final Vector screenZ = Vector.unitary(4, 2);

        ProjectivePlane projectivePlane = new KonicProjectivePlane(camera, cameraToScreen, screenX, screenY,  screenZ);

        Vector pointCenter = Vector.zero(4);
        HyperCube4D figure = new HyperCube4D(pointCenter, 1);

        EuclideanSpace euclideanSpace = new EuclideanSpace();
        euclideanSpace.getListOfEdgesFigures().add(figure);

        FigureGraphicRepresentation figureGraphicRepresentation = new FigureGraphicRepresentation(projectivePlane, euclideanSpace);
        figureGraphicRepresentation.show();

        // FIXME finish (leyend to know the keyboard shortcuts)
    }
}
