package com.ottfff.algorithms.sorting;

class MergeSortTest extends SortTest {

    @Override
    protected Sort getSortingAlgorithm() {
        return new MergeSort();
    }
}