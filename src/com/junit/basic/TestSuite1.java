package com.junit.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSuite1
{
    @Test
    public void testAdd()
    {
        String str = "Junit is working fine";
        assertEquals( "Junit is working fine", str );
    }
}
