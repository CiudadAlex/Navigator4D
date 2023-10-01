package org.leviatanplatform.geometry.figures;

import org.leviatanplatform.geometry.entities.Vector;

/**
 * Cube4D cubee of 3 Dimensions in a 4D environment.
 * 
 * @author Alejandro
 * 
 */
public class Cube4D extends HyperCubeND {

    public Cube4D(final Vector pointCenter, final double sideLenght) {
        super(pointCenter, sideLenght, 3, 4);
    }

}
