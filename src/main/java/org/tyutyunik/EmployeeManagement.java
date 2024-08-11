package org.tyutyunik;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Count of employees
    public int getCountEmployees() {
        return employees.size();
    }

    // List of all employees with full information
    public String getListOfEmployeesWithFullInfo() {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
            //return "Нет сотрудников";
        } else {
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("Employee id = [%s], name = [%s], department = [%s], salary = [%s]\n", i, employees.get(i).getFullName(), employees.get(i).getDepartment(), employees.get(i).getSalary());
            }
            //return "";
        }
        return methodAnswer;
    }

    // List of all employees with only names
    public String getListOfEmployeesWithOnlyNames() {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
        } else {
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("[%s]\n", employees.get(i).getFullName());
            }
        }
        return methodAnswer;
    }

    // Total salary
    public double salaryTotal() {
        if (employees.isEmpty()) {
            return 0;
        } else {
            double totalSalary = 0;
            for (Employee employee : employees) {
                totalSalary += employee.getSalary();
            }
            return totalSalary;
        }
    }

    // Employee with minimal salary
    public String salaryMinOfEmployees() {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
        } else {
            double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() < minSalaryEmployee) {
                    minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("[%s]", employees.get(i).getFullName());
                }
            }
        }
        return methodAnswer;
    }

    // Employee with maximum salary
    public String salaryMaxOfEmployees() {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
        } else {
            double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() > minSalaryEmployee) {
                    minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("[%s]", employees.get(i).getFullName());
                }
            }
        }
        return methodAnswer;
    }

    // Average salary
    public double salaryAverage() {
        if (employees.isEmpty()) {
            return 0;
        } else {
            return salaryTotal() / employees.size();
        }
    }

    //
    public String salaryIndexation(double indexationPercent) {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            for (Employee employee : employees) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * indexationPercent * 0.01));
            }
            return "Произведена индексация";
        }
    }

    //
    public double getSalaryPerDepartment(String department) {
        if (employees.isEmpty()) {
            return 0;
        } else {
            double salaryPerDepartment = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (department.equals(employees.get(i).getDepartment())) {
                    salaryPerDepartment += employees.get(i).getSalary();
                }
            }
            return salaryPerDepartment;
        }
    }

    // Indexation for everyone in department
    public String salaryIndexationPerDepartment(double indexationPercent, String department) {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            for (int i = 0; i < employees.size(); i++) {
                if (department.equals(employees.get(i).getDepartment())) {
                    employees.get(i).setSalary(employees.get(i).getSalary() + (employees.get(i).getSalary() * indexationPercent * 0.01));
                }
            }
            return "Произведена индексация";
        }
    }

    // Employee with minimal salary
    public String salaryBelow(double salaryLimit) {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
        } else {
            //double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() <= salaryLimit) {
                    //minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", i, employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
        }
        return methodAnswer;
    }

    // Employee with minimal salary
    public String salaryAbove(double salaryLimit) {
        String methodAnswer = "";
        if (employees.isEmpty()) {
            methodAnswer = "Нет сотрудников";
        } else {
            //double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() >= salaryLimit) {
                    //minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", i, employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
        }
        return methodAnswer;
    }
}
