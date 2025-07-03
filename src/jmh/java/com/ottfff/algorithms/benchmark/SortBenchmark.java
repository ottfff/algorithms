package com.ottfff.algorithms.benchmark;

import com.ottfff.algorithms.sorting.InsertionSort;
import com.ottfff.algorithms.sorting.MergeSort;
import com.ottfff.algorithms.sorting.QuickSort;
import com.ottfff.algorithms.sorting.Sort;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class SortBenchmark {

    @Param({"InsertionSort", "MergeSort", "QuickSort"})
    String sortingAlgorithm;
    Sort sort;

    @Param({"64", "128", "256", "1024", "10000"})
    int size;
    int[] data;

    @Setup(Level.Iteration)
    public void prepare() {
        this.data = new int[size];
        var random = new Random();
        for (int i = 0; i < data.length; i++) data[i] = random.nextInt();
        switch (sortingAlgorithm) {
            case "InsertionSort":
                sort = new InsertionSort();
                break;
            case "MergeSort":
                sort = new MergeSort();
                break;
            case "QuickSort":
                sort = new QuickSort();
                break;
            default:
                throw new IllegalStateException("Unknown sorting algorithm: " + sortingAlgorithm);
        }
    }

    @Benchmark
    public void sort() {
        int[] copy = Arrays.copyOf(data, data.length);
        sort.sort(copy);
    }
}