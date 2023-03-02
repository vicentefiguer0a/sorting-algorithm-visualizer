package org.example;

public class BubbleSort {

    private int[] arr;
    private int arrIndex;
    private int compareIndex;

    // Constructor
    public BubbleSort(int[] arr) {
        this.arr = arr;
        arrIndex = 0;
        compareIndex = Integer.MAX_VALUE;
    }

    public int[] sortOneIndex() {
        // for (int i = 0; i < arr.length - 1; i++) {
        //    for (int j = 0; j < arr.length - i - 1; j++) {
        //        if (arr[j] > arr[j + 1]) {
        //            // swap arr[j+1] and arr[j]
        //            int temp = arr[j];
        //            arr[j] = arr[j + 1];
        //            arr[j + 1] = temp;
        //        }
        //    }
        // }
        // arrIndex is like the "i" in the standard bubble sort for loop.
        // and compareIndex is like the "j" in the nested for loop.

        // If the integer in the current index is greater than the integer in the next index, swap them.
        if (arr[compareIndex] > arr[compareIndex + 1]) {
            int temp = arr[compareIndex];
            arr[compareIndex] = arr[compareIndex + 1];
            arr[compareIndex + 1] = temp;
        }

        // Making sure we're not comparing with any indexes that have already been sorted.
        if ((compareIndex + 1) >= (arr.length - arrIndex - 1)) {
            arrIndex++;
            compareIndex = 0;
        }

        else compareIndex++;

        return arr;
    }

    // Getters and setters
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
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
}
