package org.tyutyunik;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();
    private int employeesCounter;

    // Add employee
    public void addEmployee(Employee employee) {
        employeesCounter += 1;
        employee.setID(employeesCounter);
        employees.add(employee);
    }

    // Remove employee
    public void removeEmployee(int ID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == ID) {
                employees.remove(i);
                break;
            }
        }
    }

    // Count of employees
    public int getCountEmployees() {
        return employees.size();
    }

    // List of all employees with full information
    public String getListOfEmployeesWithFullInfo() {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("Employee id = [%s], name = [%s], department = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getDepartment(), employees.get(i).getSalary());
            }
            return methodAnswer;
        }
    }

    // List of all employees with only names
    public String getListOfEmployeesWithOnlyNames() {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("[%s]\n", employees.get(i).getFullName());
            }
            return methodAnswer;
        }
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
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() < minSalaryEmployee) {
                    minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("[%s]", employees.get(i).getFullName());
                }
            }
            return methodAnswer;
        }
    }

    // Employee with maximum salary
    public String salaryMaxOfEmployees() {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            double minSalaryEmployee = employees.getFirst().getSalary();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() > minSalaryEmployee) {
                    minSalaryEmployee = employees.get(i).getSalary();
                    methodAnswer += String.format("[%s]", employees.get(i).getFullName());
                }
            }
            return methodAnswer;
        }
    }

    // Average salary
    public double salaryAverage() {
        if (employees.isEmpty()) {
            return 0;
        } else {
            return salaryTotal() / employees.size();
        }
    }

    // Salary indexation
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

    // Salary per department
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
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() <= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
            return methodAnswer;
        }
    }

    // Employee with minimal salary
    public String salaryAbove(double salaryLimit) {
        if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() >= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
            return methodAnswer;
        }
    }
}
