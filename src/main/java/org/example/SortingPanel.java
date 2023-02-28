package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Random;

public class SortingPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1;

    private Random random;
    private int[] arr;
    private BubbleSorting bubbleSort;
    // TODO: Add other sorting algorithms once learned.

    private JButton start;
    private JButton reset;
    private JButton bubble;

    private boolean isBubbleSorting = false;
    private boolean isRunning;

    // Storing button actions.
    private ActionListener startAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                start.setBackground(Color.LIGHT_GRAY);
                if (isRunning == false)
                    isRunning = true;
                executeAnimation();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    private ActionListener bubbleAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (isRunning == false) {
                    isBubbleSorting = true;
                    // TODO: Once other sorting algorithms are added later on, set their boolean value to false.
                    setButtonBackground();
                    bubble.setBackground(Color.lightGray);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    private ActionListener resetAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset.setBackground(Color.LIGHT_GRAY);
            start.setBackground(Color.WHITE);

            setArray();

            // Resetting bubbleSort object.
            bubbleSort.setCompareIndex(Integer.MAX_VALUE);
            bubbleSort.setArrIndex(0);
            bubbleSort.setArr(arr);
            // TODO: Reset other sorting algorithm objects once added.

            isRunning = false;

            Timer resetTimer  = new Timer(1, e1 -> {
                reset.setBackground(Color.WHITE);
                ((Timer) e1.getSource()).stop();
            });

            resetTimer.start();
            repaint();
        }
    };

    // Constructor
    public SortingPanel() {
        random = new Random();
        arr = new int[80];
        this.setArray();

        bubbleSort = new BubbleSorting(arr);

        start = new JButton("Start");
        reset = new JButton("Reset");
        bubble = new JButton("Bubble");

        // Configuring "Start" button.
        start.setModel(new ButtonModel());
        start.setBackground(Color.WHITE);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.addActionListener(startAction);
        // Configuring "Reset" button.
        reset.setModel(new ButtonModel());
        reset.setBackground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(resetAction);
        // Configuring "Bubble" button.
        bubble.setModel(new ButtonModel());
        bubble.setBackground(Color.WHITE);
        bubble.setFocusPainted(false);
        bubble.setBorderPainted(false);
        bubble.addActionListener(bubbleAction);

        this.add(start);
        this.add(reset);
        this.add(bubble);
    }

    public void setButtonBackground() {
        bubble.setBackground(Color.WHITE);
    }

    public int[] getArray() {
        return this.arr;
    }

    public void setArray() {
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = random.nextInt(510) + 40;
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void executeAnimation() throws Exception {
        // Executes bubble sorting algorithm.
        if (isBubbleSorting) {
            bubbleSort.setCompareIndex(0);

            Timer bubbleSortingTimer  = new Timer(10, e -> {
                if (isSorted() || !isRunning) {
                    bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                    isRunning = false;
                    start.setBackground(Color.WHITE);
                    ((Timer)e.getSource()).stop();
                } else {
                    if (isRunning)
                        arr = bubbleSort.sortOneIndex();
                }
                repaint();
            });
            bubbleSortingTimer.start();
        }

        //TODO: add other sorting algorithm animations once added.
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.BLACK);

        for (int i = 0; i < arr.length; i++) {
            graphics.setColor(Color.WHITE);
            graphics.drawRect(i * 15, 600 - arr[i], 14, arr[i]);

            if (isBubbleSorting) {
                if (i == bubbleSort.getCompareIndex() || i == (bubbleSort.getCompareIndex() + 1)) {
                    graphics.setColor(Color.RED);
                }
            }

            graphics.fillRect(i * 15, 600 - arr[i], 14, arr[i]);
        }
    }
}
