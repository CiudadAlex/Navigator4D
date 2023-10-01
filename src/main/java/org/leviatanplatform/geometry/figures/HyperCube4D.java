package org.leviatanplatform.geometry.figures;

import org.leviatanplatform.geometry.entities.Vector;

/**
 * HyperCube4D hypercube of 4 Dimensions in a 4D environment.
 * 
 * @author Alejandro
 * 
 */
public class HyperCube4D extends HyperCubeND {

    public HyperCube4D(final Vector pointCenter, final double sideLenght) {
        super(pointCenter, sideLenght, 4, 4);
    }
}
