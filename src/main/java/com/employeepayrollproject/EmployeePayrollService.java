package com.employeepayrollproject;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
    public ArrayList<EmployeePayroll> employeePayrollList;

    public EmployeePayrollService(ArrayList<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner scan = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(scan);
        employeePayrollService.writeEmployeePayrollData();
    }

    private void writeEmployeePayrollData() {
        System.out.println("Employee data: " + employeePayrollList);
    }

    private void readEmployeePayrollData(Scanner scan) {
        System.out.println("Enter employee id: ");
        int id = scan.nextInt();
        System.out.println("Enter employee name: ");
        String name = scan.next();
        System.out.println("Enter employee salary: ");
        double salary = scan.nextInt();
        employeePayrollList.add(new EmployeePayroll(id , name , salary));

    }
}


