package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Frame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    private SortingPanel panel = new SortingPanel();
    private String frameTitle = "Sorting Algorithm Visualizer";
    private Dimension frameDimensions = new Dimension(1200, 600);

    // Constructor
    public Frame() {
        this.setTitle(frameTitle);
        this.getContentPane().setPreferredSize(frameDimensions);
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(3); // Exits on close.
        this.setLocationRelativeTo(null);
    }

    public SortingPanel getPanel() {
        return this.panel;
    }
}
