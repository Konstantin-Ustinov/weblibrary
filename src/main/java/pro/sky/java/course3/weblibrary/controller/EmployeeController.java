package pro.sky.java.course3.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course3.weblibrary.service.EmployeeService;

@RestController
public class EmployeeController {

    @GetMapping("/show-all")
    public String showAll(String department) {
        return EmployeeService.showAll(department);
    }

    @GetMapping("/find-min-salary")
    public double findMinSalary(String department) {
        return EmployeeService.findMinSalary(department);
    }

    @GetMapping("/find-max-salary")
    public double findMaxSalary(String department) {
        return EmployeeService.findMaxSalary(department);
    }

    @GetMapping("/show-all-salary-more-average")
    public String showAllSalaryLessLimit(@RequestParam String department) {
        return EmployeeService.findAllSalaryMoreAverage(department);
    }

    @GetMapping("/show-all-salary-less-limit")
    public String showAllSalaryLessLimit(@RequestParam double limit) {
        return EmployeeService.showAllSalaryLessLimit(limit);
    }

    @GetMapping("/show-all-salary-more-limit")
    public String showAllSalaryMoreLimit(@RequestParam double limit) {
        return EmployeeService.showAllSalaryMoreLimit(limit);
    }
}
