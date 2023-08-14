package min.project.employeebook.service;

import min.project.employeebook.data.Employee;
import min.project.employeebook.exception.EmployeeAlreadyAddedException;
import min.project.employeebook.exception.EmployeeNotFoundException;
import min.project.employeebook.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int maxEmployees = 10;
    private final Map<String, Employee> employees;
    private final EmployeeValidationService employeeValidationService;

    public EmployeeServiceImpl(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
        this.employees = new HashMap<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentID) {
        employeeValidationService.validate(firstName, lastName);
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), salary, departmentID);
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
        Employee employee = findEmployee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String fullNameKey = firstName + " " + lastName;
        if (!employees.containsKey(fullNameKey)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(fullNameKey);
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
