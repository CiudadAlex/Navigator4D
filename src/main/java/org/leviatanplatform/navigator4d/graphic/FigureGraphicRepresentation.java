package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.entities.EuclideanSpace;
import org.leviatanplatform.geometry.projections.ProjectivePlane;

import javax.swing.*;
import java.awt.*;

public class FigureGraphicRepresentation {

    private JFrame frame;
    private JPanel canvas;
    private final ObjectWrapper<ProjectivePlane> projectivePlane;
    private final EuclideanSpace euclideanSpace;

    public FigureGraphicRepresentation(ObjectWrapper<ProjectivePlane> projectivePlane, EuclideanSpace euclideanSpace) {
        this.projectivePlane = projectivePlane;
        this.euclideanSpace = euclideanSpace;
    }

    public void show() {

        if (frame == null) {

            canvas = createCanvas();

            frame = new JFrame("Navigator 4D: Rotations (1-6,Q-Y) Translations (A-F,Z-V) Figure (N,M) Projection (H,J)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1600, 900);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.addKeyListener(new CommandListener(projectivePlane, euclideanSpace, canvas));

            frame.add(canvas);
        }

        SwingUtilities.invokeLater(() -> {
            canvas.invalidate();
            canvas.validate();
            canvas.repaint();
        });
    }

    private JPanel createCanvas() {

        return new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                FigureGraphicRepresentationUtils.paintCurrentListOfStars(g, projectivePlane.get(), euclideanSpace, getWidth(), getHeight());
            }
        };
    }

}
