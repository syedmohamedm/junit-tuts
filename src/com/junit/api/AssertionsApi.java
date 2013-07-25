package com.junit.api;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionsApi
{
    @Test
    public void testAssertApi()
    {
        String str1 = "java";
        String str2 = "java";
        String str3 = null;
        int val1 = 2;
        int val2 = 3;
        String[] expectedArray =
        {
            "one", "two", "three"
        };
        String[] resultArray =
        {
            "one", "two", "three"
        };

        // Assertion API
        assertEquals( str1, str2 );
        assertFalse( val1 > val2 );
        assertTrue( val1 < val2 );
        assertNotNull( str1 );
        assertNull( str3 );
        assertArrayEquals( expectedArray, resultArray );
    }
}
