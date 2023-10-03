package org.leviatanplatform.navigator4d;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.HyperCube4D;
import org.leviatanplatform.geometry.projections.KonicProjectivePlane;
import org.leviatanplatform.geometry.projections.ProjectivePlane;
import org.leviatanplatform.navigator4d.graphic.FigureGraphicRepresentation;

public class Main {

    public static void main(String[] args) {

        final Vector camera = new Vector(new double[] { 0, 0, 0, 0 });
        final Vector cameraToScreen = new Vector(new double[] { 0, 0, 0, 1 });
        final Vector screenX = new Vector(new double[] { 1, 0, 0, 0 });
        final Vector screenY = new Vector(new double[] { 0, 1, 0, 0 });
        final Vector screenZ = new Vector(new double[] { 0, 0, 1, 0 });

        ProjectivePlane projectivePlane = new KonicProjectivePlane(camera, cameraToScreen, screenX, screenY,  screenZ);

        Vector pointCenter = new Vector(new double[] { 0, 0, 0, 0 });
        HyperCube4D figure = new HyperCube4D(pointCenter, 1);

        EuclideanSpace euclideanSpace = new EuclideanSpace();
        euclideanSpace.getListOfEdgesFigures().add(figure);

        FigureGraphicRepresentation figureGraphicRepresentation = new FigureGraphicRepresentation();
        figureGraphicRepresentation.show(projectivePlane, euclideanSpace);
    }
}
