package org.tyutyunik;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String department;
    private double salary;

    public Employee(String firstName, String lastName, String patronymicName, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymicName = patronymicName;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymicName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isEquals(Employee obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            return firstName.equals(obj.firstName) && lastName.equals(obj.lastName) && patronymicName.equals(obj.patronymicName) && department.equals(obj.department) && salary == obj.salary;
        }
    }

    public boolean isEqualsDepartment(Employee obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            return department.equals(obj.department);
        }
    }

    public boolean isEqualsSalary(Employee obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            return salary == obj.salary;
        }
    }

    public String toString() {
        return "Employee name = [" + this.getFullName() + "], department = [" + this.getDepartment() + "], salary = [" + this.getSalary() + "]";
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymicName, department, salary);
    }
}
