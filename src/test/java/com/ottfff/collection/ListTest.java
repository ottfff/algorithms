package com.ottfff.collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    @Disabled
    void testAllocation() {
        log.info("Start");
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <1_000_000; i++) {
            lists.add(new ArrayList<>()); // 4 byte * 10 = 40 byte
            log.info("Allocated {} arrays, {} MB", (i+1), (i+1) * 40 / (1024 * 1024));
        }
    }
}
