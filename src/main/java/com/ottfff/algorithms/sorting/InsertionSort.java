package com.ottfff.algorithms.sorting;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[k]) swap(arr, k--, j);
                else break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
