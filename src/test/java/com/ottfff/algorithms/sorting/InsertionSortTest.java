package com.ottfff.algorithms.sorting;

class InsertionSortTest extends SortTest{

    @Override
    protected Sort getSortingAlgorithm() {
        return new InsertionSort();
    }
}