package min.project.employeebook.service;

import min.project.employeebook.data.Employee;
import min.project.employeebook.exception.EmployeeAlreadyAddedException;
import min.project.employeebook.exception.EmployeeNotFoundException;
import min.project.employeebook.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 10;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

        addEmployee("Petrov", "Petr", 11111, 1);
        addEmployee("Petrov", "Petr", 22222, 2);
        addEmployee("Petrov", "Petr", 33333, 3);
        addEmployee("Petrov", "Petr", 44444, 4);
        addEmployee("Petrov", "Petr", 55555, 5);
        addEmployee("Petrov", "Petr", 66666, 1);
        addEmployee("Petrov", "Petr", 77777, 2);
        addEmployee("Petrov", "Petr", 88888, 3);
        addEmployee("Petrov", "Petr", 99999, 4);

    }


    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departamentID) {
        Employee employee = new Employee(firstName, lastName, salary, departamentID);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() == maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee delEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
