package pro.sky.java.course3.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course3.weblibrary.entities.Employee;
import pro.sky.java.course3.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        employeeService.firstFillingEmployees();
    }

    @GetMapping("/show-all")
    public List<Employee> showAll(String department) {
        return employeeService.showAll(department);
    }

    @GetMapping("/find-min-salary")
    public Employee findMinSalary(String department) {
        return employeeService.findMinSalaryEmployee(department);
    }

    @GetMapping("/find-max-salary")
    public Employee findMaxSalary(String department) {
        return employeeService.findMaxSalaryEmployee(department);
    }

    @GetMapping("/show-all-salary-more-average")
    public String showAllSalaryLessLimit(@RequestParam String department) {
        return employeeService.findAllSalaryMoreAverage(department);
    }

    @GetMapping("/show-all-salary-less-limit")
    public List<Employee> showAllSalaryLessLimit(@RequestParam double limit) {
        return employeeService.showAllSalaryLessLimit(limit);
    }

    @GetMapping("/show-all-salary-more-limit")
    public List<Employee> showAllSalaryMoreLimit(@RequestParam double limit) {
        return employeeService.showAllSalaryMoreLimit(limit);
    }

    @GetMapping("/add-new-employee")
    public String addNewEmployee(@RequestParam String name, String department, int salary) {
        return employeeService.addEmployee(name, department, salary) ? "Сотрудник успешно добавлен" : "Ошибка при добавлении сотрудника";
    }
}
