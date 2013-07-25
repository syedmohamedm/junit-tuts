package com.junit.complete;

public class EmployeeService
{
    public Long getAnnualSalary( EmployeePojo employee )
    {
        return ( employee.getSalary() * 12 );
    }
}
