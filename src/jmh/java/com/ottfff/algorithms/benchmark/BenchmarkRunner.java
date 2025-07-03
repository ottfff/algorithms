package com.ottfff.algorithms.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(".*Benchmark") // classes with benchmark
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(20)
                .warmupTime(TimeValue.milliseconds(50))
                .measurementTime(TimeValue.milliseconds(100))
                .build();

        new Runner(opt).run();
    }
}
