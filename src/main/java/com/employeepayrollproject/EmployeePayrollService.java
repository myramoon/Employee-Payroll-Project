package com.employeepayrollproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeePayrollService {

    public enum IOService {CONSOLE_IO ,FILE_IO, DB_IO, REST_IO } ;
    private List<EmployeePayroll>  employeePayrollList;

    public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner input = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(input);
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.CONSOLE_IO);
    }

    public void writeEmployeePayrollData(EmployeePayrollService.IOService ioService) {
        if(ioService.equals(EmployeePayrollService.IOService.CONSOLE_IO))
            System.out.println("\n Writing employee pay roll to console \n " + employeePayrollList);
        else if (ioService.equals(EmployeePayrollService.IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    private void readEmployeePayrollData(Scanner input) {
        System.out.println("Enter employee id: ");
        int id = input.nextInt();
        System.out.println("Enter employee name: ");
        String name = input.next();
        System.out.println("Enter employee salary: ");
        double salary = input.nextDouble();
        employeePayrollList.add(new EmployeePayroll(id, name, salary));
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
            return 0;
    }

    @Override
    public String toString() {
        return "Writing employee pay roll " + "employeePayrollList=" + employeePayrollList + '}';
    }
}