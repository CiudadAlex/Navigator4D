package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.entities.Vector;
import org.leviatanplatform.geometry.figures.*;
import org.leviatanplatform.geometry.projections.ProjectivePlane;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class CommandListener extends KeyAdapter {

    private final ProjectivePlane projectivePlane;
    private final EuclideanSpace euclideanSpace;
    private final JPanel canvas;
    private List<EdgesFigure> figures = buildListEdgesFigure();
    private Integer indexFigure;

    public CommandListener(ProjectivePlane projectivePlane, EuclideanSpace euclideanSpace, JPanel canvas) {
        this.projectivePlane = projectivePlane;
        this.euclideanSpace = euclideanSpace;
        this.canvas = canvas;
    }

    private void changeFigure(boolean next) {
        EdgesFigure figure = next ? nextFigure() : previousFigure();
        euclideanSpace.getListOfEdgesFigures().clear();
        euclideanSpace.getListOfEdgesFigures().add(figure);
    }

    private EdgesFigure nextFigure() {
        indexFigure = indexFigure == null ? 0 : ( indexFigure + 1 ) % figures.size();
        return figures.get(indexFigure);
    }

    private EdgesFigure previousFigure() {
        indexFigure = indexFigure == null || indexFigure == 0 ? figures.size() - 1 : indexFigure - 1;
        return figures.get(0);
    }

    private List<EdgesFigure> buildListEdgesFigure() {

        Vector pointCenter = Vector.zero(4);
        HyperCube4D hyperCube4D = new HyperCube4D(pointCenter, 1);
        Tetrahedron4D tetrahedron4D = new Tetrahedron4D(1);
        HyperTetrahedron4D hyperTetrahedron4D = new HyperTetrahedron4D(1);
        Cube4D cube4D = new Cube4D(pointCenter, 1);
        HyperCubeStreched4D hyperCubeStreched4D = new HyperCubeStreched4D(1, 2, 1);

        return List.of(hyperCube4D, tetrahedron4D, hyperTetrahedron4D, cube4D, hyperCubeStreched4D);
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP -> projectivePlane.approach(-0.0001);
            case KeyEvent.VK_DOWN -> projectivePlane.approach(0.0001);

            case KeyEvent.VK_LEFT -> rot01(0.01);
            case KeyEvent.VK_RIGHT -> rot01(-0.01);

            case KeyEvent.VK_1 -> rot02(0.01);
            case KeyEvent.VK_Q -> rot02(-0.01);

            case KeyEvent.VK_2 -> rot03(0.01);
            case KeyEvent.VK_W -> rot03(-0.01);

            case KeyEvent.VK_3 -> rot12(0.01);
            case KeyEvent.VK_E -> rot12(-0.01);

            case KeyEvent.VK_4 -> rot13(0.01);
            case KeyEvent.VK_R -> rot13(-0.01);

            case KeyEvent.VK_5 -> rot23(0.01);
            case KeyEvent.VK_T -> rot23(-0.01);

            case KeyEvent.VK_A -> trans0(0.01);
            case KeyEvent.VK_Z -> trans0(-0.01);

            case KeyEvent.VK_S -> trans1(0.01);
            case KeyEvent.VK_X -> trans1(-0.01);

            case KeyEvent.VK_D -> trans2(0.01);
            case KeyEvent.VK_C -> trans2(-0.01);

            case KeyEvent.VK_F -> trans3(0.01);
            case KeyEvent.VK_V -> trans3(-0.01);

            case KeyEvent.VK_N -> changeFigure(false);
            case KeyEvent.VK_M -> changeFigure(true);
        }

        SwingUtilities.invokeLater(() -> {
            canvas.invalidate();
            canvas.validate();
            canvas.repaint();
        });
    }

    private void trans0(double amount) {
        projectivePlane.translate(0, amount);
    }

    private void trans1(double amount) {
        projectivePlane.translate(1, amount);
    }

    private void trans2(double amount) {
        projectivePlane.translate(2, amount);
    }

    private void trans3(double amount) {
        projectivePlane.translate(3, amount);
    }

    private void rot01(double angle) {
        projectivePlane.rotate(0, 1, angle);
    }

    private void rot02(double angle) {
        projectivePlane.rotate(0, 2, angle);
    }

    private void rot03(double angle) {
        projectivePlane.rotate(0, 3, angle);
    }

    private void rot12(double angle) {
        projectivePlane.rotate(1, 2, angle);
    }

    private void rot13(double angle) {
        projectivePlane.rotate(1, 3, angle);
    }

    private void rot23(double angle) {
        projectivePlane.rotate(2, 3, angle);
    }
}
