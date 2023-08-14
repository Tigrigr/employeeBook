package min.project.employeebook.controller;

import min.project.employeebook.data.Employee;
import min.project.employeebook.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/salary/max")
    public Employee findEmployeeMaxSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeMaxSalary(departmentId);
    }

    @GetMapping("/{departmentId}/salary/min")
    public Employee findEmployeeMinSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeMinSalary(departmentId);
    }
    @GetMapping("/{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable int departmentId) {
        return departmentService.getDepartmentSalarySum(departmentId);
    }

    @GetMapping("/{departmentId}/employees")
    public Collection<Employee> findEmployeeFromDepartment(@PathVariable int departmentId) {
        return departmentService.findEmployeeFromDepartment(departmentId);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> findAllEmployees() {
        return departmentService.findAllEmployees();
    }
}
