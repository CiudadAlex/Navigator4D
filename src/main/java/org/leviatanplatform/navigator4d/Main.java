package org.leviatanplatform.navigator4d;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.*;
import org.leviatanplatform.geometry.projections.IsometricProjectivePlane;
import org.leviatanplatform.geometry.projections.KonicProjectivePlane;
import org.leviatanplatform.geometry.projections.ProjectivePlane;
import org.leviatanplatform.navigator4d.graphic.FigureGraphicRepresentation;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final Vector camera = new Vector(new double[] { 0, 0, 0, 2 });
        final Vector cameraToScreen = new Vector(new double[] { 0, 0, 0, 100 });
        final Vector screenX = Vector.unitary(4, 0);
        final Vector screenY = Vector.unitary(4, 1);
        final Vector screenZ = Vector.unitary(4, 2);

        ProjectivePlane projectivePlane = new KonicProjectivePlane(camera, cameraToScreen, screenX, screenY,  screenZ);
        //ProjectivePlane projectivePlane = new IsometricProjectivePlane(screenX, screenY);

        Vector pointCenter = Vector.zero(4);
        HyperCube4D figure = new HyperCube4D(pointCenter, 1);
        //Tetrahedron4D figure = new Tetrahedron4D(1);
        //HyperTetrahedron4D figure = new HyperTetrahedron4D(1);
        //Cube4D figure = new Cube4D(pointCenter, 1);
        //HyperCubeStreched4D figure = new HyperCubeStreched4D(1, 2, 1);

        EuclideanSpace euclideanSpace = new EuclideanSpace();
        euclideanSpace.getListOfEdgesFigures().add(figure);

        FigureGraphicRepresentation figureGraphicRepresentation = new FigureGraphicRepresentation(projectivePlane, euclideanSpace);
        figureGraphicRepresentation.show();

        // FIXME finish (leyend to know the keyboard shortcuts)
        // FIXME keys to change figures
    }
}
