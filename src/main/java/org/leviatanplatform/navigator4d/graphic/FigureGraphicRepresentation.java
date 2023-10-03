package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.figures.EdgesFigure;

import javax.swing.*;
import java.awt.*;

public class FigureGraphicRepresentation {

    private JFrame frame;
    private JPanel canvas;
    private EdgesFigure edgesFigure;

    public void show(EdgesFigure edgesFigure) {

        this.edgesFigure = edgesFigure;

        if (frame == null) {

            frame = new JFrame("Navigator 4D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1600, 900);
            frame.setVisible(true);
            frame.setResizable(false);

            canvas = createCanvas();
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
                FigureGraphicRepresentationUtils.paintCurrentListOfStars(g, edgesFigure, getWidth(), getHeight());
            }
        };
    }

}
