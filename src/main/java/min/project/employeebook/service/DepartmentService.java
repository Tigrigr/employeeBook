package min.project.employeebook.service;

import min.project.employeebook.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeMaxSalary(int departmentId);

    Employee findEmployeeMinSalary(int departmentId);

    Collection<Employee> findEmployeeFromDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllEmployees();

    Integer getDepartmentSalarySum(int departmentId);
}
