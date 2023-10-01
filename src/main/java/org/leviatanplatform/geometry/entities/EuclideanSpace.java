package org.leviatanplatform.geometry.entities;

import java.util.ArrayList;
import java.util.List;

import org.leviatanplatform.geometry.figures.EdgesFigure;

/**
 * @author Alejandro
 * 
 */
public class EuclideanSpace {

    private final List<EdgesFigure> listOfEdgesFigures = new ArrayList<EdgesFigure>();

    public List<EdgesFigure> getListOfEdgesFigures() {
        return listOfEdgesFigures;
    }
}
