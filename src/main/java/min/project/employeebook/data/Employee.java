package min.project.employeebook.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int departamentId;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int salary, int departamentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departamentId = departamentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    @JsonIgnore
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departamentId == employee.departamentId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departamentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departamentId=" + departamentId +
                '}';
    }
}
