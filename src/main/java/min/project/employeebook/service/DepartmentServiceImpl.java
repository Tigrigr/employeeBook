package min.project.employeebook.service;

import min.project.employeebook.data.Employee;
import min.project.employeebook.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeMaxSalary(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departmentID)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeMinSalary(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departmentID)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeeFromDepartment(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departmentID)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployees() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartamentId));
    }
}
