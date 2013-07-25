package com.junit.benchmark;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BenchmarkTestRunner
{
    public static void main( String[] args )
    {
        Result result = JUnitCore.runClasses( BenchmarkTestCase.class );
        for ( Failure failure : result.getFailures() )
        {
            System.err.println( "Junit Failure : " + failure.toString() );
        }
        System.out.println( "Junit Result : " + result.wasSuccessful() );
    }
}
