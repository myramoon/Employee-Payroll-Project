package com.employeepayrollproject;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShowMatchEmployeeEntries( ) {
        EmployeePayroll [] arrayOfEmps = {
                new EmployeePayroll(1, "Jeff Bezos" , 12000),
                new EmployeePayroll(2, "Bill Gates", 52000),
                new EmployeePayroll(3, "Mark Zuckerberg", 65892)
        };
        EmployeePayrollService employeePayrollService  ;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3 , entries);
    }
}
