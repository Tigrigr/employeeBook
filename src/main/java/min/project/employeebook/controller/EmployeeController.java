package min.project.employeebook.controller;

import min.project.employeebook.data.Employee;
import min.project.employeebook.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String firstName, @RequestParam String lastName,
                                        @RequestParam Integer salary, @RequestParam Integer departamentID) {
        Employee employee = employeeService.addEmployee(firstName, lastName, salary, departamentID);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/remove")
    public ResponseEntity<Employee> del(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.delEmployee(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> find(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findEmployee(firstName, lastName);
        return ResponseEntity.ok(employee);
    }
}
