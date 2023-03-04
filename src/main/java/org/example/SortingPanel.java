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
    private BubbleSort bubbleSort;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;
    private QuickSort quickSort;

    private JButton start;
    private JButton reset;
    private JButton bubble;
    private JButton insertion;
    private JButton selection;
    private JButton quick;

    private boolean isBubbleSorting = false;
    private boolean isInsertionSorting = false;
    private boolean isSelectionSorting = false;
    private boolean isQuickSorting = false;
    private boolean isRunning;

    // Storing button actions.
    private ActionListener startAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                start.setBackground(Color.LIGHT_GRAY);
                if (!isRunning) {
                    isRunning = true;
                    executeAnimation();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };


    private ActionListener resetAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset.setBackground(Color.RED);
            start.setBackground(Color.GREEN);

            setArray();

            // Resetting bubbleSort object.
            bubbleSort.setCompareIndex(Integer.MAX_VALUE);
            bubbleSort.setArrIndex(0);
            bubbleSort.setArr(arr);
            // Resetting insertionSort object.
            insertionSort.setArrIndex(Integer.MAX_VALUE);
            insertionSort.setCompareIndex(Integer.MAX_VALUE);
            insertionSort.setSorting(false);
            insertionSort.setArr(arr);
            // Resetting selectionSort object.
            selectionSort.setCompareIndex(Integer.MAX_VALUE);
            selectionSort.setArrIndex(Integer.MAX_VALUE);
            selectionSort.setMinIndex(Integer.MAX_VALUE);
            // Resetting quickSort object.
            quickSort.setSp(-1);
            quickSort.addNum(0);
            quickSort.addNum(79);
            quickSort.setArrIndex(Integer.MAX_VALUE);
            quickSort.setCompareIndex(Integer.MAX_VALUE);
            quickSort.setPartition(-1);
            quickSort.setPartitioning(false);

            isRunning = false;

            Timer resetTimer  = new Timer(1, e1 -> {
                reset.setBackground(Color.WHITE);
                ((Timer) e1.getSource()).stop();
            });

            resetTimer.start();
            repaint();
        }
    };

    private ActionListener bubbleAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!isRunning) {
                    isBubbleSorting = true;
                    isInsertionSorting = false;
                    isSelectionSorting = false;
                    isQuickSorting = false;
                    // TODO: Once other sorting algorithms are added later on, set their boolean value to false.
                    setButtonBackground();
                    bubble.setBackground(Color.LIGHT_GRAY);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    private ActionListener insertionAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!isRunning) {
                    isInsertionSorting = true;
                    isBubbleSorting = false;
                    isSelectionSorting = false;
                    isQuickSorting = false;
                    setButtonBackground();
                    insertion.setBackground(Color.LIGHT_GRAY);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    private ActionListener selectionAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!isRunning) {
                    isSelectionSorting = true;
                    isInsertionSorting = false;
                    isBubbleSorting = false;
                    isQuickSorting = false;
                    setButtonBackground();
                    selection.setBackground(Color.LIGHT_GRAY);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    private ActionListener quickAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!isRunning) {
                    isQuickSorting = true;
                    isBubbleSorting = false;
                    isInsertionSorting = false;
                    isSelectionSorting = false;
                    setButtonBackground();
                    quick.setBackground(Color.LIGHT_GRAY);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };

    // Constructor
    public SortingPanel() {
        random = new Random();
        arr = new int[80];
        this.setArray();

        bubbleSort = new BubbleSort(arr);
        insertionSort = new InsertionSort(arr);
        selectionSort = new SelectionSort(arr);
        quickSort = new QuickSort(arr);

        start = new JButton("Start");
        reset = new JButton("Reset");
        bubble = new JButton("Bubble Sort");
        insertion = new JButton("Insertion Sort");
        selection = new JButton("Selection Sort");
        quick = new JButton("Quick Sort");

        // Configuring "Start" button.
        start.setModel(new ButtonModel());
        start.setBackground(Color.GREEN);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.addActionListener(startAction);
        // Configuring "Reset" button.
        reset.setModel(new ButtonModel());
        reset.setBackground(Color.RED);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(resetAction);
        // Configuring "Bubble Sort" button.
        bubble.setModel(new ButtonModel());
        bubble.setBackground(Color.WHITE);
        bubble.setFocusPainted(false);
        bubble.setBorderPainted(false);
        bubble.addActionListener(bubbleAction);
        // Configuring "Insertion Sort" button.
        insertion.setModel(new ButtonModel());
        insertion.setBackground(Color.WHITE);
        insertion.setFocusPainted(false);
        insertion.setBorderPainted(false);
        insertion.addActionListener(insertionAction);
        // Configuring "Selection Sort" button.
        selection.setModel(new ButtonModel());
        selection.setBackground(Color.WHITE);
        selection.setFocusPainted(false);
        selection.setBorderPainted(false);
        selection.addActionListener(selectionAction);
        // Configuring "Quick Sort" button.
        quick.setModel(new ButtonModel());
        quick.setBackground(Color.WHITE);
        quick.setFocusPainted(false);
        quick.setBorderPainted(false);
        quick.addActionListener(quickAction);
        this.add(start);
        this.add(reset);
        this.add(bubble);
        this.add(insertion);
        this.add(selection);
        this.add(quick);
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
                }
                else {
                    if (isRunning) {
                        arr = bubbleSort.sortOneIndex();
                    }
                }
                repaint();
            });

            bubbleSortingTimer.start();
        }

        if (isInsertionSorting) {
            insertionSort.setArrIndex(1);

            Timer insertionSortTimer = new Timer(10, e -> {
                if (isSorted() || !isRunning) {
                    insertionSort.setArrIndex(Integer.MAX_VALUE);
                    insertionSort.setCompareIndex(Integer.MAX_VALUE);
                    insertionSort.setSorting(false);
                    start.setBackground(Color.WHITE);
                    ((Timer)e.getSource()).stop();
                    isRunning = false;
                } else {
                    if (isRunning) {
                        arr = insertionSort.sortOneIndex();
                    }
                }
                repaint();
            });
            insertionSortTimer.start();
        }

        if (isSelectionSorting) {
            selectionSort.setArrIndex(0);
            selectionSort.setCompareIndex(1);
            selectionSort.setMinIndex(0);

            Timer selectionSortTimer = new Timer(10, e -> {
                if (isSorted() || !isRunning) {
                    selectionSort.setArrIndex(Integer.MAX_VALUE);
                    selectionSort.setCompareIndex(Integer.MAX_VALUE);
                    selectionSort.setMinIndex(Integer.MAX_VALUE);
                    start.setBackground(Color.WHITE);
                    ((Timer)e.getSource()).stop();
                    isRunning = false;
                } else {
                    if (isRunning) {
                        arr = selectionSort.sortOneIndex();
                    }
                }
                repaint();
            });
            selectionSortTimer.start();
        }

        if (isQuickSorting) {
            Timer quickSortTimer  = new Timer(10, e -> {
                if (isSorted() || !isRunning) {
                    quickSort.setSp(-1);
                    quickSort.addNum(0);
                    quickSort.addNum(79);
                    quickSort.setArrIndex(Integer.MAX_VALUE);
                    quickSort.setCompareIndex(Integer.MAX_VALUE);
                    quickSort.setPartition(-1);
                    quickSort.setPartitioning(false);
                    isRunning = false;
                    start.setBackground(Color.WHITE);
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isRunning)
                        arr = quickSort.sortOnlyOneItem();
                }
                repaint();
            });
            quickSortTimer.start();
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.GRAY);

        for (int i = 0; i < arr.length; i++) {
            graphics.setColor(Color.BLACK);
            graphics.drawRect(i * 15, 600 - arr[i], 14, arr[i]);

            if (isBubbleSorting) {
                if (i == bubbleSort.getCompareIndex() || i == (bubbleSort.getCompareIndex() + 1)) {
                    graphics.setColor(Color.RED);
                }
            }

            if (isInsertionSorting) {
                if (i == insertionSort.getCompareIndex() || i == (insertionSort.getCompareIndex() + 1)) {
                    graphics.setColor(Color.BLUE);
                }
                if (i == insertionSort.getArrIndex()) {
                    graphics.setColor(Color.GREEN);
                }
            }

            if (isSelectionSorting) {
                if (i == selectionSort.getCompareIndex() || i == selectionSort.getMinIndex()) {
                    graphics.setColor(Color.RED);
                }
                if (i == selectionSort.getArrIndex()) {
                    graphics.setColor(Color.YELLOW);
                }
            }

            if (isQuickSorting) {

                if (i == quickSort.getArrIndex()) {
                    graphics.setColor(Color.RED);
                }

                if (i == quickSort.getCompareIndex()) {
                    graphics.setColor(Color.YELLOW);
                }

                if (i == quickSort.getPartition())
                    graphics.setColor(Color.GREEN);
            }

            graphics.fillRect(i * 15, 600 - arr[i], 14, arr[i]);
        }
    }
}
