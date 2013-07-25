package com.junit.api;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestCaseApiRunner
{
    public static void main( String[] args )
    {
        Result result = JUnitCore.runClasses( TestCaseApi.class );
        for ( Failure failure : result.getFailures() )
        {
            System.out.println( failure.toString() );
        }
        System.out.println( result.wasSuccessful() );
    }
}
