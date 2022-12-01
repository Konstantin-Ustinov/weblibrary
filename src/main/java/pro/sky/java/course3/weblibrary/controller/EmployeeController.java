package pro.sky.java.course3.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.weblibrary.entities.Employee;
import pro.sky.java.course3.weblibrary.service.EmployeeServiceImpl;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
        employeeServiceImpl.firstFillingEmployees();
    }

//    @GetMapping("/show-all")
//    public List<Employee> showAll(String department) {
//        return employeeService.showAll(department);
//    }
//
//    @GetMapping("/find-min-salary")
//    public Employee findMinSalary(String department) {
//        return employeeService.findMinSalaryEmployee(department);
//    }
//
//    @GetMapping("/find-max-salary")
//    public Employee findMaxSalary(String department) {
//        return employeeService.findMaxSalaryEmployee(department);
//    }

//    @GetMapping("/show-all-salary-more-average")
//    public String showAllSalaryLessLimit(@RequestParam String department) {
//        return employeeServiceImpl.findAllSalaryMoreAverage(department);
//    }

    @GetMapping("/show-all-salary-less-limit")
    public List<Employee> showAllSalaryLessLimit(@RequestParam int limit) {
        return employeeServiceImpl.showAllSalaryLessLimit(limit);
    }

    @GetMapping("/show-all-salary-more-limit")
    public List<Employee> showAllSalaryMoreLimit(@RequestParam int limit) {
        return employeeServiceImpl.showAllSalaryMoreLimit(limit);
    }

    @GetMapping("/add-new-employee")
    public String addNewEmployee(@RequestParam String name, String department, int salary) {
        return employeeServiceImpl.addEmployee(name, department, salary) ? "Сотрудник успешно добавлен" : "Ошибка при добавлении сотрудника";
    }

    @PutMapping("/department/{id}/salary/sum")
    public int sumSalaryByDepartment(@PathVariable String id) {
        return employeeServiceImpl.sumAllSalary(id);
    }

    @PutMapping("/department/{id}/salary/min")
    public Employee minSalaryByDepartment(@PathVariable String id) {
        return employeeServiceImpl.findMinSalaryEmployee(id);
    }

    @PutMapping("/department/{id}/salary/max")
    public Employee maxSalaryByDepartment(@PathVariable String id) {
        return employeeServiceImpl.findMaxSalaryEmployee(id);
    }

    @PutMapping("/department/{id}/employees")
    public List<Employee> showAllByDepartment(@PathVariable String id) {
        return employeeServiceImpl.showAll(id);
    }
}
