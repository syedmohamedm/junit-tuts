package com.junit.listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class TestJunitListener extends RunListener
{
    public void testRunStarted( Description description ) throws java.lang.Exception
    {
        System.out.println( "Number of testcases to execute : " + description.testCount() );
    }

    public void testRunFinished( Result result ) throws java.lang.Exception
    {
        System.out.println( "Number of testcases executed : " + result.getRunCount() );
    }
}
