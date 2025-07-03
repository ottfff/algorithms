package com.ottfff.algorithms.sorting;

// worst O(n^2)
// avg O(n log(n)) = ~10-20 n log(n)
// memory - stack O(n)
public class QuickSort implements Sort{
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
        }
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

}
