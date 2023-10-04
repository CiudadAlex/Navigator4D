package org.leviatanplatform.navigator4d.graphic;

import org.leviatanplatform.geometry.projections.ProjectivePlane;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommandListener extends KeyAdapter {

    private final ProjectivePlane projectivePlane;
    private final JPanel canvas;

    public CommandListener(ProjectivePlane projectivePlane, JPanel canvas) {
        this.projectivePlane = projectivePlane;
        this.canvas = canvas;
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
