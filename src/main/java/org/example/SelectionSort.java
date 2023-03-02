package org.example;

public class SelectionSort {

    private int arrIndex;
    private int compareIndex;
    private int minIndex;
    private int[] arr;
    private boolean findingMin;

    // Constructor
    public SelectionSort(int[] arr) {
        this.arr = arr;
        arrIndex = 0;
        compareIndex = 1;
        minIndex = 0;
        findingMin = false;
    }

    public void swapNumbers(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] sortOneIndex() {
        if (!findingMin) {
            minIndex = arrIndex;
            findingMin = true;
        }

        if (arr[compareIndex] < arr[minIndex]) {
            minIndex = compareIndex;
        }

        compareIndex++;

        if (compareIndex >= 80) {
            swapNumbers(arr, minIndex, arrIndex);
            arrIndex++;
            compareIndex = arrIndex + 1;
            findingMin = false;
        }

        return arr;
    }

    // Getters and Setters
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

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
