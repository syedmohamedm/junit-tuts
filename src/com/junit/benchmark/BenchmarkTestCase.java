package com.junit.benchmark;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

public class BenchmarkTestCase extends AbstractBenchmark
{
    @BenchmarkOptions( callgc = false, benchmarkRounds = 100000, warmupRounds = 10 )
    @Test
    public void testAdd()
    {
        String str = "Junit is working fine";
        assertEquals( "Junit is working fine", str );
    }
}
