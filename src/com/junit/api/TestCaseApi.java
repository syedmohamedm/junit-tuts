package com.junit.api;

import junit.framework.TestCase;

import org.junit.Test;

public class TestCaseApi extends TestCase
{
    protected int count1;
    protected int count2;

    public void setUp()
    {
        System.out.println( "Junit Fixture : setUp()" );
        count1 = 1;
        count2 = 2;
    }

    @Test
    public void testAdd()
    {
        System.out.println( "Nos of test cases : " + this.countTestCases() );
        System.out.println( "Test case name : " + this.getName() );
        this.setName( "testAdd1" );
        System.out.println( "Updated test case name : " + this.getName() );
    }

    public void tearDown()
    {
        System.out.println( "Junit Fixture : tearDown()" );
    }
}
