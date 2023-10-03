package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.projections.ProjectivePlane;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommandListener extends KeyAdapter {

    private ProjectivePlane projectivePlane;
    private JPanel canvas;

    public CommandListener(ProjectivePlane projectivePlane, JPanel canvas) {
        this.projectivePlane = projectivePlane;
        this.canvas = canvas;
    }

    public void keyPressed(KeyEvent e) {

        // FIXME more rotations in other keys

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP -> projectivePlane.approach(0.0001);
            case KeyEvent.VK_DOWN -> projectivePlane.approach(-0.0001);
            case KeyEvent.VK_LEFT -> projectivePlane.rotate(3, 1, 0.01);
            case KeyEvent.VK_RIGHT -> projectivePlane.rotate(3, 1, -0.01);
        }

        SwingUtilities.invokeLater(() -> {
            canvas.invalidate();
            canvas.validate();
            canvas.repaint();
        });
    }
}
