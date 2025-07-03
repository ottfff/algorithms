package com.ottfff.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

abstract class SortTest {
    protected abstract Sort getSortingAlgorithm();
    private final Sort sort = getSortingAlgorithm();

    @Test
    void testSort() {
        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        sort.sort(arr);
        assertThat(arr).containsExactly(1, 2, 3, 4, 5, 6, 7);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        sort.sort(arr);
        assertThat(arr).containsExactly(1, 2, 3, 4, 5, 6, 7);

        arr = new int[]{1, 3, 2, 4, 7, 6, 5};
        sort.sort(arr);
        assertThat(arr).containsExactly(1, 2, 3, 4, 5, 6, 7);

        arr = new int[]{3, 3, 3, 2, 2, 2, 6, 6, 6, 1, 1, 1};
        sort.sort(arr);
        assertThat(arr).containsExactly(1, 1, 1, 2, 2, 2, 3, 3, 3, 6, 6, 6);
    }


    @Test
    void testSortRandom() {
        Random random = new Random(8261);
        int[] a = new int[1024];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j] = random.nextInt();
            }
            var map1 = new HashMap<Integer, Integer>();
            for (int j = 0; j < a.length; j++) {
                map1.put(a[j], map1.getOrDefault(a[j], 0) + 1);
            }
            sort.sort(a);
            for (int j = 1; j < a.length; j++) {
                assertThat(a[j]).isGreaterThanOrEqualTo(a[j - 1]);
            }
            var map2 = new HashMap<Integer, Integer>();
            for (int j = 0; j < a.length; j++) {
                map2.put(a[j], map2.getOrDefault(a[j], 0) + 1);
            }
            assertThat(map1).isEqualTo(map2);

        }
    }
}