package org.example;

public class QuickSort {

    private int[] arr;
    private int[] stack;
    private int arrIndex;
    private int compareIndex;
    private int low;
    private int high;
    private int sp;
    private int partition;
    private int x;

    private boolean isPartitioning = false;

    // Constructor
    public QuickSort(int[] arr) {
        this.arr = arr;
        stack = new int[80];
        arrIndex = 0;
        compareIndex = 0;
        low = 0;
        high = 79;
        sp = -1;
        partition = -1;
        x = 0;
        stack[++sp] = 0;
        stack[++sp] = 79;
    }

    public void swapElements(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void addNum(int num) {
        sp++;
        stack[sp] = num;
    }

    // Method sorts arr[] using iterative QuickSort.
    public int[] sortOnlyOneItem() {
        // Keeps popping elements in array until stack isn't empty.
        if (sp >= 0) {
            if (!isPartitioning) {
                high = stack[sp--];
                low = stack[sp];
                arrIndex = low - 1;
                x = arr[high];
                compareIndex = low;
                isPartitioning = true;
            }
            // Setting pivot element in its correct position.
            if (compareIndex <= high - 1) {
                if (arr[compareIndex] <= x) {
                    arrIndex++;
                    swapElements(arr, arrIndex, compareIndex);
                }
                compareIndex++;
                return arr;
            }
            swapElements(arr, arrIndex + 1, high);
            partition = arrIndex + 1;
            sp--;
            // If there are elements on the left side of pivot, push them to the left side of the stack.
            if (partition - 1 > low) {
                stack[++sp] = low;
                stack[++sp] = partition - 1;
            }

            // If there are elements on the right side of pivot, push them to the right side of the stack.
            if (partition + 1 < high) {
                stack[++sp] = partition + 1;
                stack[++sp] = high;
            }
            isPartitioning = false;
        }

        return arr;
    }

    // Getters & Setters
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getArrIndex() {
        return arrIndex;
    }

    public void setArrIndex(int arrIndex) {
        this.arrIndex = arrIndex;
    }

    public int getCompareIndex() {
        return compareIndex;
    }

    public void setCompareIndex(int compareIndex) {
        this.compareIndex = compareIndex;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isPartitioning() {
        return isPartitioning;
    }

    public void setPartitioning(boolean partitioning) {
        isPartitioning = partitioning;
    }
}
