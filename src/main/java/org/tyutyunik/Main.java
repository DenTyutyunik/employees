package org.tyutyunik;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement EmployeeControl = new EmployeeManagement();

        // Add employees
        EmployeeControl.addEmployee(new Employee("Цвітан", "Глібовицький", "Леонідович", "1", 100_000.0));
        EmployeeControl.addEmployee(new Employee("Серкан", "Булгучев", "Бакиевич", "1", 99_000.0));
        EmployeeControl.addEmployee(new Employee("Толигнів", "Давидюк", "Андрійович", "2", 128_000.1));
        EmployeeControl.addEmployee(new Employee("Martin", "O'Brien", "", "2", 120_000.0));
        EmployeeControl.addEmployee(new Employee("Охрім", "Прокопів", "Володимирович", "3", 150_000.0));
        EmployeeControl.addEmployee(new Employee("Bartosz", "O'Sullivan", "", "3", 189_000.0));
        EmployeeControl.addEmployee(new Employee("Кайыржан", "Медетбаев", "Сапарбекович", "4", 110_000.0));
        EmployeeControl.addEmployee(new Employee("Айдын", "Аубакиров", "Жанатаевич", "4", 160_000.0));
        EmployeeControl.addEmployee(new Employee("Әбділда", "Шимбулатов", "Сарсенбаевич", "5", 115_000.0));
        EmployeeControl.addEmployee(new Employee("Музаффар", "Земский", "Панкратович", "5", 123_000.0));

        // List of all employees with full information
        System.out.printf("Список всех сотрудников с полной информацией:\n%s\n", EmployeeControl.getListOfEmployeesWithFullInfo());

        // List of all employees with only names
        System.out.printf("Список всех сотрудников с только именами:\n%s\n", EmployeeControl.getListOfEmployeesWithOnlyNames());

        // Total salary (of all employees)
        System.out.printf("Общая зарплата: %s\n", EmployeeControl.salaryTotal());

        // Employee with minimal salary
        System.out.printf("Сотрудник(и) с минимальной зарплатой: %s\n", EmployeeControl.salaryMinOfEmployees());

        // Employee with maximum salary
        System.out.printf("Сотрудник(и) с максимальной зарплатой: %s\n", EmployeeControl.salaryMaxOfEmployees());

        // Average salary
        System.out.printf("Средняя зарплата: %s\n", EmployeeControl.salaryAverage());

        // Count of employees
        System.out.printf("Количество сотрудников: %s\n", EmployeeControl.getCountEmployees());

        // Salary indexation
        EmployeeControl.salaryIndexation(10);
        System.out.printf("Список всех сотрудников с полной информацией после индексации:\n%s\n", EmployeeControl.getListOfEmployeesWithFullInfo());

        // Salary per department 1
        System.out.printf("Зарплата на отдел 1: %s\n", EmployeeControl.getSalaryPerDepartment("1"));
        // Salary per department 2
        System.out.printf("Зарплата на отдел 2: %s\n", EmployeeControl.getSalaryPerDepartment("2"));
        // Salary per department 3
        System.out.printf("Зарплата на отдел 3: %s\n", EmployeeControl.getSalaryPerDepartment("3"));
        // Salary per department 4
        System.out.printf("Зарплата на отдел 4: %s\n", EmployeeControl.getSalaryPerDepartment("4"));
        // Salary per department 5
        System.out.printf("Зарплата на отдел 5: %s\n", EmployeeControl.getSalaryPerDepartment("5"));

        // Salary indexation per department 1
        EmployeeControl.salaryIndexationPerDepartment(3,"1");
        // Salary indexation per department 2
        EmployeeControl.salaryIndexationPerDepartment(7,"2");
        // Salary indexation per department 3
        EmployeeControl.salaryIndexationPerDepartment(11,"3");
        // Salary indexation per department 4
        EmployeeControl.salaryIndexationPerDepartment(5,"4");
        // Salary indexation per department 5
        EmployeeControl.salaryIndexationPerDepartment(2,"5");

        System.out.printf("Список всех сотрудников с полной информацией после индексации:\n%s\n", EmployeeControl.getListOfEmployeesWithFullInfo());

        // Every employee who gets salary below limit
        System.out.printf("Список сотрудников, кто получает зарплату менее лимита:\n%s\n", EmployeeControl.salaryBelow(140000));

        // Every employee who gets salary below limit
        System.out.printf("Список сотрудников, кто получает зарплату выше лимита:\n%s\n", EmployeeControl.salaryAbove(140000));
    }
}