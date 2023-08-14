package min.project.employeebook.service;

import min.project.employeebook.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeTestCons {
    public static final String FIRST_NAME1 = "Ivan";
    public static final String LAST_NAME1 = "Ivanov";
    public static final String FIRST_NAME2 = "Petr";
    public static final String LAST_NAME2 = "Petrov";
    public static final String FIRST_NAME3 = "Sasha";
    public static final String LAST_NAME3 = "Sashov";
    public static final String FIRST_NAME4 = "Stas";
    public static final String LAST_NAME4 = "Stasov";

    public static final Employee EMPLOYEE_FIRSTDEPARTMENT_MINSALARY = new Employee("Ivan", "Ivanov", 1000, 1);
    public static final Employee EMPLOYEE_FIRSTDEPARTMENT_MAXSALARY = new Employee("Petr", "Petrov", 5000, 1);
    public static final Employee EMPLOYEE_SECONDDEPARTMENT_MINSALARY = new Employee("Stas", "Stasov", 2000, 2);
//    public static final Employee EMPLOYEE_SECONDDEPARTMENT_MAXSALARY = new Employee("Igor", "Igorev", 6000, 2);

    public static final List<Employee> EMPLOYEES = List.of(EMPLOYEE_FIRSTDEPARTMENT_MINSALARY,
            EMPLOYEE_FIRSTDEPARTMENT_MAXSALARY);
    public static final List<Employee> EMPLOYEES_FROM_TWO_DEPARTMENTS = List.of(EMPLOYEE_FIRSTDEPARTMENT_MINSALARY,
            EMPLOYEE_FIRSTDEPARTMENT_MAXSALARY, EMPLOYEE_SECONDDEPARTMENT_MINSALARY);

    public static final Map<Integer, List<Employee>> EMPLOYEES_MAP = EMPLOYEES_FROM_TWO_DEPARTMENTS.stream()
            .collect(Collectors.groupingBy(Employee::getDepartamentId));
    public static final int EMPLOYEES_SALARY_SUM = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();
    public static final int SALARY1 = 1000;
    public static final int SALARY2 = 5000;
    public static final int DEPARTMENTID1 = 1;
    public static final int DEPARTMENTID2 = 2;


}
