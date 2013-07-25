package com.junit.complete;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
@RunWith( Parameterized.class )
public class EmployeeTestCase
{
    EmployeePojo employee = new EmployeePojo();
    EmployeeService service = new EmployeeService();

    @Before
    public void initialDeclaration()
    {
        // employee.setId( 1 );
        // employee.setName( "Syed Mohamed" );
        // employee.setSalary( 1000L );
    }

    public EmployeeTestCase( String name, Long salary )
    {
        this.employee.setName( name );
        this.employee.setSalary( salary );
    }

    @Parameters
    public static Collection< Object[] > employeeParameters()
    {
        return Arrays.asList( new Object[][]
        {
            {
                "syed", 18000L
            },
            {
                "pp", 8000L
            },
            {
                "juniter", 11000L
            }
        } );
    }

    @Test
    public void testGetAnnualSalary()
    {
        Long salary = service.getAnnualSalary( employee );
        System.out.println( "Salary : " + salary );
        Assert.assertTrue( 15000 < salary.longValue() );
        Assert.assertNotNull( employee.getName() );
    }
}
