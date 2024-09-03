package org.tyutyunik;

//import java.util.ArrayList;
//import java.util.List;

public class EmployeeManagement {
    //private List<Employee> employees = new ArrayList<>();
    private Employee[] employees;
    private int employeesCounter;

    // Constructor to initialize the array
    public EmployeeManagement(int initialCapacity) {
        employees = new Employee[initialCapacity];
    }

    // Add employee
    public void addEmployee(Employee employee) {
        employeesCounter += 1;
        employee.setID(employeesCounter);

        // Check if the array needs to be resized
        if (employeesCounter >= employees.length) {
            Employee[] newEmployees = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newEmployees, 0, employees.length);
            employees = newEmployees;
        }

        employees[employeesCounter - 1] = employee;

        //employees.add(employee);
    }

    // Remove employee
    public void removeEmployee(int ID) {
        int indexToRemove = -1;
        for (int i = 0; i < employeesCounter; i++) {
            if (employees[i].getID() == ID) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            // Shift elements to the left
            System.arraycopy(employees, indexToRemove + 1, employees, indexToRemove, employeesCounter - indexToRemove - 1);
            employeesCounter--;
        }
        /*for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == ID) {
                employees.remove(i);
                break;
            }
        }*/
    }

    // Count of employees
    public int getCountEmployees() {
        return employees.length;
        //return employees.size();
    }

    // List of all employees with full information
    public String getListOfEmployeesWithFullInfo() {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employeesCounter; i++) {
                methodAnswer += String.format("Employee id = [%s], name = [%s], department = [%s], salary = [%s]\n", employees[i].getID(), employees[i].getFullName(), employees[i].getDepartment(), employees[i].getSalary());
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("Employee id = [%s], name = [%s], department = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getDepartment(), employees.get(i).getSalary());
            }
            return methodAnswer;
        }*/
    }

    // List of all employees with only names
    public String getListOfEmployeesWithOnlyNames() {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employeesCounter; i++) {
                methodAnswer += String.format("[%s]\n", employees[i].getFullName());
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                methodAnswer += String.format("[%s]\n", employees.get(i).getFullName());
            }
            return methodAnswer;
        }*/
    }

    // Total salary
    public double salaryTotal() {
        if (employeesCounter == 0) {
            return 0;
        } else {
            double totalSalary = 0;
            for (int i = 0; i < employeesCounter; i++) {
                totalSalary += employees[i].getSalary();
            }
            return totalSalary;
        }
        /*if (employees.isEmpty()) {
            return 0;
        } else {
            double totalSalary = 0;
            for (Employee employee : employees) {
                totalSalary += employee.getSalary();
            }
            return totalSalary;
        }*/
    }

    // Employee with minimal salary
    public String salaryMinOfEmployees() {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            double minSalaryEmployee = employees[0].getSalary();
            for (int i = 1; i < employeesCounter; i++) {
                if (employees[i].getSalary() < minSalaryEmployee) {
                    minSalaryEmployee = employees[i].getSalary();
                    methodAnswer = String.format("[%s]", employees[i].getFullName());
                }
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
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
        }*/
    }

    // Employee with maximum salary
    public String salaryMaxOfEmployees() {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            double maxSalaryEmployee = employees[0].getSalary();
            for (int i = 1; i < employeesCounter; i++) {
                if (employees[i].getSalary() > maxSalaryEmployee) {
                    maxSalaryEmployee = employees[i].getSalary();
                    methodAnswer = String.format("[%s]", employees[i].getFullName());
                }
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
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
        }*/
    }

    // Average salary
    public double salaryAverage() {
        if (employeesCounter == 0) {
            return 0;
        } else {
            return salaryTotal() / employeesCounter;
        }
        /*if (employees.isEmpty()) {
            return 0;
        } else {
            return salaryTotal() / employees.size();
        }*/
    }

    // Salary indexation
    public String salaryIndexation(double indexationPercent) {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            for (int i = 0; i < employeesCounter; i++) {
                employees[i].setSalary(employees[i].getSalary() + (employees[i].getSalary() * indexationPercent * 0.01));
            }
            return "Произведена индексация";
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            for (Employee employee : employees) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * indexationPercent * 0.01));
            }
            return "Произведена индексация";
        }*/
    }

    // Salary per department
    public double getSalaryPerDepartment(String department) {
        if (employeesCounter == 0) {
            return 0;
        } else {
            double salaryPerDepartment = 0;
            for (int i = 0; i < employeesCounter; i++) {
                if (department.equals(employees[i].getDepartment())) {
                    salaryPerDepartment += employees[i].getSalary();
                }
            }
            return salaryPerDepartment;
        }
        /*if (employees.isEmpty()) {
            return 0;
        } else {
            double salaryPerDepartment = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (department.equals(employees.get(i).getDepartment())) {
                    salaryPerDepartment += employees.get(i).getSalary();
                }
            }
            return salaryPerDepartment;
        }*/
    }

    // Indexation for everyone in department
    public String salaryIndexationPerDepartment(double indexationPercent, String department) {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            for (int i = 0; i < employeesCounter; i++) {
                if (department.equals(employees[i].getDepartment())) {
                    employees[i].setSalary(employees[i].getSalary() + (employees[i].getSalary() * indexationPercent * 0.01));
                }
            }
            return "Произведена индексация";
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            for (int i = 0; i < employees.size(); i++) {
                if (department.equals(employees.get(i).getDepartment())) {
                    employees.get(i).setSalary(employees.get(i).getSalary() + (employees.get(i).getSalary() * indexationPercent * 0.01));
                }
            }
            return "Произведена индексация";
        }*/
    }

    // Employee with minimal salary
    public String salaryBelow(double salaryLimit) {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employeesCounter; i++) {
                if (employees[i].getSalary() <= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees[i].getID(), employees[i].getFullName(), employees[i].getSalary());
                }
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() <= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
            return methodAnswer;
        }*/
    }

    // Employee with minimal salary
    public String salaryAbove(double salaryLimit) {
        if (employeesCounter == 0) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employeesCounter; i++) {
                if (employees[i].getSalary() >= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees[i].getID(), employees[i].getFullName(), employees[i].getSalary());
                }
            }
            return methodAnswer;
        }
        /*if (employees.isEmpty()) {
            return "Нет сотрудников";
        } else {
            String methodAnswer = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalary() >= salaryLimit) {
                    methodAnswer += String.format("ID = [%s], Full Name = [%s], salary = [%s]\n", employees.get(i).getID(), employees.get(i).getFullName(), employees.get(i).getSalary());
                }
            }
            return methodAnswer;
        }*/
    }
}
