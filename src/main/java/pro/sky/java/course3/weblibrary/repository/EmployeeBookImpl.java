package pro.sky.java.course3.weblibrary.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course3.weblibrary.entities.Employee;

@Repository
public class EmployeeBookImpl implements EmployeeBook {
    private Employee[] employees = new Employee[10];

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public boolean add(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean setSalary(int id, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i].setSalary(salary);
                return true;
            }
        }
        return false;
    }

    public boolean setDepartment(int id, String department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i].setDepartment(department);
                return true;
            }
        }
        return false;
    }


}
