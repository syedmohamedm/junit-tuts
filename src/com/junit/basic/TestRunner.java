package com.junit.basic;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
    public static void main( String[] args )
    {
        Result result = JUnitCore.runClasses( TestJunit.class );
        for ( Failure failure : result.getFailures() )
        {
            System.err.println( "Junit Failure : " + failure.toString() );
        }
        System.out.println( "Junit Result : " + result.wasSuccessful() );
    }
}
