package com.ottfff.algorithms.sorting;

public class MergeSort implements Sort {
    private int[] mergeArray;

    @Override
    public void sort(int[] arr) {
        this.mergeArray = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }

    private void merge(int[] a, int low, int high, int mid) {
        int i = low, j = mid + 1, k = low;
        while (k <= high) {
            if (i > mid) mergeArray[k++] = a[j++];
            else if (j > high) mergeArray[k++] = a[i++];
            else if (a[i] > a[j]) mergeArray[k++] = a[j++];
            else mergeArray[k++] = a[i++];
        }
        for (i = low; i <= high; i++) a[i] = mergeArray[i];
    }
}
