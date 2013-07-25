package com.junit.complete;

import org.junit.runner.JUnitCore;

import com.junit.listener.TestJunitListener;

public class EmployeeTestRunner
{
    public static void main( String[] args )
    {
        JUnitCore runner = new JUnitCore();
        runner.addListener( new TestJunitListener() );
        runner.run( EmployeeTestCase.class );
        // Result result = JUnitCore.runClasses( EmployeeTestCase.class );
        // for ( Failure failure : result.getFailures() )
        // {
        // System.err.println( failure.toString() );
        // }
        // System.out.println( "Test success : " + result.wasSuccessful() );
    }
}
