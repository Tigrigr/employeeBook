package min.project.employeebook.controller;

import min.project.employeebook.data.Employee;
import min.project.employeebook.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeMinSalary(departmentId);
    }

    @GetMapping(value = "all", params = "departmentID")
    public Collection<Employee> findEmployeeFromDepartment(@RequestParam int departmentID) {
        return departmentService.findEmployeeFromDepartment(departmentID);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> findAllEmployees() {
        return departmentService.findAllEmployees();
    }
}
