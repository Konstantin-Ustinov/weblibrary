package pro.sky.java.course3.weblibrary.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course3.weblibrary.repository.EmployeeBookImpl;
import pro.sky.java.course3.weblibrary.entities.Employee;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeBookImpl employeeBookImpl;

    public EmployeeServiceImpl(EmployeeBookImpl employeeBookImpl) {
        this.employeeBookImpl = employeeBookImpl;
    }

    public void firstFillingEmployees() {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("John Adam Smith", "1", 50_000);
        employees[1] = new Employee("Malcolm Masaka Hard", "1", 50_000);
        employees[2] = new Employee("Poul Ulrih Moll", "2", 55_000);
        employees[3] = new Employee("Fill Oak Seek", "3", 30_000);
        employees[5] = new Employee("Mikhael Petrovich Shumakher", "5", 50_000);
        employees[6] = new Employee("Mike Maks Tyson", "1", 100_000);
        employees[7] = new Employee("Max Miks Mini", "2", 690_000);
        employees[8] = new Employee("Senior Petrosyan Madam", "3", 550_000);
        employees[9] = new Employee("Ilon Java Mask", "5", 590_000);

        employeeBookImpl.setEmployees(employees);
    }

    public List<Employee> showAll(String department) {
        Employee[] employees = employeeBookImpl.getEmployees();
        List<Employee> sb = new LinkedList<>();
        if (department == null) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    sb.add(employees[i]);
                }
            }
        } else {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment().equals(department)) {
                    sb.add(employees[i]);
                }
            }
        }
        return sb;
    }

    public List<Employee> showAllSalaryLessLimit(int limit) {
        Employee[] employees = employeeBookImpl.getEmployees();
        List<Employee> sb = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < limit) {
                sb.add(employee);
            }
        }
        return sb;
    }

    public List<Employee> showAllSalaryMoreLimit(int limit) {
        Employee[] employees = employeeBookImpl.getEmployees();
        List<Employee> sb = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= limit) {
                sb.add(employee);
            }
        }
        return sb;
    }

    public int sumAllSalary(String department) {
        Employee[] employees = employeeBookImpl.getEmployees();
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (department.equals("all")) {
                    sum += employees[i].getSalary();
                } else if (employees[i].getDepartment().equals(department)) {
                    sum += employees[i].getSalary();
                }
            }
        }
        return sum;
    }

    public Employee findMinSalaryEmployee(String department) {
        Employee[] employees = employeeBookImpl.getEmployees();
        Employee min = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (min.getSalary() > employees[i].getSalary()) {
                    if (department == null) {
                        min = employees[i];
                    } else if (employees[i].getDepartment().equals(department)) {
                        min = employees[i];
                    }
                }
            }
        }
        return min;
    }

    public Employee findMaxSalaryEmployee(String department) {
        Employee[] employees = employeeBookImpl.getEmployees();
        Employee max = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (max.getSalary() < employees[i].getSalary()) {
                    if (department == null) {
                        max = employees[i];
                    } else if (employees[i].getDepartment().equals(department)) {
                        max = employees[i];
                    }
                }
            }
        }
        return max;
    }

//    public double findAverageSalary(String department) {
//        double sum = sumAllSalary(department);
//        return sum / numberOfEmployees(department);
//    }

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

    public boolean addEmployee(String name, String department, int salary) {

        if (!StringUtils.isAlpha(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Имя должено содержать только текст");
        } else {
            name = StringUtils.capitalize(name);
        }

        Employee newEmployee = new Employee(name, department, salary);
        return employeeBookImpl.add(newEmployee);
    }

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

//    private int numberOfEmployees(String department) {
//        Employee[] employees = employeeBookImpl.getEmployees();
//        int num = 0;
//        for (int i = 1; i < employees.length; i++) {
//            if (employees[i] != null && department.equals("all")) {
//                num++;
//            } else if (employees[i] != null && employees[i].getDepartment().equals(department)) {
//                num++;
//            }
//        }
//        return num;
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
