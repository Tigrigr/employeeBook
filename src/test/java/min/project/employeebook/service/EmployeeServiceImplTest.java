package min.project.employeebook.service;

import min.project.employeebook.data.Employee;
import min.project.employeebook.exception.EmployeeAlreadyAddedException;
import min.project.employeebook.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static min.project.employeebook.service.EmployeeTestCons.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeValidationService);

    @Test
    public void showAddEmployee() {
        Employee employee = new Employee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        assertFalse(employeeService.findAll().contains(employee));
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        assertEquals(addedEmployee, employee);
        assertTrue(employeeService.findAll().contains(employee));
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    public void showThrowEmployeeAlreadyAddedException() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1));
    }
    @Test
    public void showRemoveEmployee() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        Employee delEmployee = employeeService.delEmployee(FIRST_NAME1, LAST_NAME1);
        assertEquals(addedEmployee, delEmployee);
        assertFalse(employeeService.findAll().contains(delEmployee));
        assertEquals(0, employeeService.findAll().size());
    }

    @Test
    public void showThrowEmployeeNotFoundExceptionFromDelEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.delEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void showFindEmployee() {
        Employee addedEmployee = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        assertEquals(addedEmployee, employeeService.findEmployee(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void showThrowEmployeeNotFoundExceptionFromfindEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee(FIRST_NAME1, LAST_NAME1));
    }
    @Test
    public void showFindAllEmployees() {
        Employee addedEmployee1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, SALARY1, DEPARTMENTID1);
        Employee addedEmployee2 = employeeService.addEmployee(FIRST_NAME2, LAST_NAME2, SALARY2, DEPARTMENTID2);
        assertIterableEquals(List.of(addedEmployee1, addedEmployee2), employeeService.findAll());
    }
}