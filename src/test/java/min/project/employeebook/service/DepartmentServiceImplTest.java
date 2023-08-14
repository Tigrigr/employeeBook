package min.project.employeebook.service;

import min.project.employeebook.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static min.project.employeebook.service.EmployeeTestCons.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void showDepartmentSalarySum() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEES_SALARY_SUM, departmentService.getDepartmentSalarySum(DEPARTMENTID1));
    }
    @Test
    public void showEmployeeMaxSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE_FIRSTDEPARTMENT_MAXSALARY, departmentService.findEmployeeMaxSalary(DEPARTMENTID1));
    }
    @Test
    public void showEmployeeMinSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE_FIRSTDEPARTMENT_MINSALARY, departmentService.findEmployeeMinSalary(DEPARTMENTID1));
    }

    @Test
    public void showThrowEmployeeNotFoundExceptionFromEmployeeMaxSalary() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeMaxSalary(DEPARTMENTID1));
    }
    @Test
    public void showThrowEmployeeNotFoundExceptionFromEmployeeMinSalary() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeMinSalary(DEPARTMENTID1));
    }
    @Test
    public void showEmployeeFromDepartments() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES_FROM_TWO_DEPARTMENTS);
        assertEquals(EMPLOYEES, departmentService.findEmployeeFromDepartment(DEPARTMENTID1));
    }

    @Test
    public void showAllEmployees() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES_FROM_TWO_DEPARTMENTS);
        assertEquals(EMPLOYEES_MAP, departmentService.findAllEmployees());
    }


}