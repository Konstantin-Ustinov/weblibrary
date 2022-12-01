package pro.sky.java.course3.weblibrary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course3.weblibrary.entities.Employee;
import pro.sky.java.course3.weblibrary.repository.EmployeeBookImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    private Employee[] employeeArray;
    private int limitSalary;

    @BeforeEach
    private void setUp() {
        employeeArray = new Employee[]{new Employee("Test 1", "1", 40_000),
                new Employee(("Test 2"), "1", 60_000),
                new Employee(("Test 3"), "2", 100_000),
                new Employee(("Test 4"), "2", 160_000)};

        limitSalary = 80_000;
    }

    @Test
    void shouldReturnListAllEmployees() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getDepartment().equals("1")))
                .collect(Collectors.toList());

        assertEquals(employeeList, out.showAll("1"));
    }

    @Test
    void shouldReturnAllSalaryLessLimit() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getSalary() < limitSalary))
                .collect(Collectors.toList());

        assertEquals(employeeList, out.showAllSalaryLessLimit(limitSalary));
    }

    @Test
    void shouldReturnAllSalaryMoreLimit() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getSalary() > limitSalary))
                .collect(Collectors.toList());

        assertEquals(employeeList, out.showAllSalaryMoreLimit(limitSalary));
    }

    @Test
    void shouldReturnSumAllSalary() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getDepartment().equals("1")))
                .collect(Collectors.toList());

        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getSalary();
        }

        assertEquals(sum, out.sumAllSalary("1"));
    }

    @Test
    void findMinSalaryEmployee() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getDepartment().equals("1")))
                .collect(Collectors.toList());

        Employee min = employeeList.get(0);
        for (Employee employee : employeeList) {
            if (min.getSalary() > employee.getSalary()) {
                min = employee;
            }
        }

        assertEquals(min, out.findMinSalaryEmployee("1"));
    }

    @Test
    void findMaxSalaryEmployee() {
        when(employeeBookMock.getEmployees()).thenReturn(employeeArray);

        List<Employee> employeeList = Arrays
                .stream(employeeArray)
                .filter(employee -> (employee.getDepartment().equals("1")))
                .collect(Collectors.toList());

        Employee max = employeeList.get(0);
        for (Employee employee : employeeList) {
            if (max.getSalary() < employee.getSalary()) {
                max = employee;
            }
        }

        assertEquals(max, out.findMaxSalaryEmployee("1"));
    }

    @Test
    void addEmployee() {
        String name = "Carl";
        String department = "1";
        int salary = 40_000;

        when(employeeBookMock.add(any())).
                thenReturn(true);

        assertTrue(out.addEmployee(name, department, salary));
    }

    @Mock
    private EmployeeBookImpl employeeBookMock;

    @InjectMocks
    private EmployeeServiceImpl out;
}