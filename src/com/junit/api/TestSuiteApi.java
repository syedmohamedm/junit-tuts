package com.junit.api;

import junit.framework.TestResult;
import junit.framework.TestSuite;

import com.junit.basic.TestSuite1;
import com.junit.basic.TestSuite2;

public class TestSuiteApi
{
    public static void main( String[] args )
    {
        TestSuite suite = new TestSuite( TestSuite1.class, TestSuite2.class );
        TestResult result = new TestResult();
        suite.run( result );
        System.out.println( result.failureCount() );
    }
}
