package org.leviatanplatform.navigator4d;

import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.HyperCube4D;
import org.leviatanplatform.navigator4d.graphic.FigureGraphicRepresentation;

public class Main {

    public static void main(String[] args) {

        Vector pointCenter = new Vector(new double[] { 0, 0, 0, 0 });
        HyperCube4D figure = new HyperCube4D(pointCenter, 1);

        FigureGraphicRepresentation figureGraphicRepresentation = new FigureGraphicRepresentation();
        figureGraphicRepresentation.show(figure);
    }
}
