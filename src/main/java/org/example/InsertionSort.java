package org.example;

public class InsertionSort {

    private int[] arr;
    private int arrIndex;
    private int compareIndex;
    private int temp;
    private boolean isSorting = false;

    // Constructor
    public InsertionSort(int[] arr) {
        this.arr = arr;
        arrIndex = 1;
    }

    public int[] sortOneIndex() {
        // for (int i = 1; i < arr.length; ++i) {
        //    int temp = arr[i];
        //    int j = i - 1;
        //
        //    while (j >= 0 && arr[j] > temp) {
        //        arr[j + 1] = arr[j];
        //        j--;
        //    }
        //    arr[j + 1] = temp;
        //}

        if (!isSorting) {
            temp = arr[arrIndex];
            compareIndex = arrIndex - 1;
            isSorting = true;
        }

        if (compareIndex >= 0 && arr[compareIndex] > temp) {
            arr[compareIndex + 1] = arr[compareIndex];
            compareIndex--;
            return arr;
        } else {
            arr[compareIndex + 1] = temp;
            arrIndex++;
        }

        isSorting = false;
        return arr;
    }

    // Getters and Setters
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

    public boolean isSorting() {
        return isSorting;
    }

    public void setSorting(boolean sorting) {
        isSorting = sorting;
    }
}
