package pro.sky.java.course3.weblibrary.service;

import pro.sky.java.course3.weblibrary.entities.Employee;
import java.util.List;

public interface EmployeeService {

    public void firstFillingEmployees();

    List<Employee> showAll(String department);

    List<Employee> showAllSalaryLessLimit(int limit);

    List<Employee> showAllSalaryMoreLimit(int limit);

    int sumAllSalary(String department);

    Employee findMinSalaryEmployee(String department);

    Employee findMaxSalaryEmployee(String department);

    //String findAllSalaryMoreAverage(String department);

    //double findAverageSalary(String department);

//    public String showAllFio() {
//        Employee[] employees = employeeBook.getEmployees();
//        StringBuilder sb = new StringBuilder();
//        for (int list = 1, i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                sb.append(list).append("). ").append(employees[i].getFio()).append("\n");
//                list++;
//            }
//        }
//        return sb.toString();
//    }
//
//    public boolean riseSalary(String department, int percent) {
//        Employee[] employees = employeeBook.getEmployees();
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null && department.equals("all")) {
//                employees[i].setSalary(employees[i].getSalary() * ((percent + 100) / 100.0));
//            } else if (employees[i] != null && employees[i].getDepartment().equals(department)) {
//                    employees[i].setSalary(employees[i].getSalary() * ((percent + 100) / 100.0));
//            }
//        }
//        employeeBook.setEmployees(employees);
//        return true;
//    }

    boolean addEmployee(String name, String department, int salary);

//    public boolean deleteEmployee(int id) {
//        return employeeBook.delete(id);
//    }
//
//    public boolean setSalary(int id, int salary) {
//        return employeeBook.setSalary(id, salary);
//    }
//
//    public boolean setDepartment(int id, String department) {
//        return employeeBook.setDepartment(id, department);
//    }

//
//    public String pluralizeRubles(int num) {
//        int end10 = num%10;
//        int end100 = num%100;
//
//        if ((end10 >= 2) & (end10 <= 4)) {
//            return " рубля";
//        } else if ((end100 >= 5 || end10 >= 5) || (end100 == 0 || end10 == 0)){
//            return  " рублей";
//        } else {
//            return " рубль";
//        }
//    }
}
