package pro.sky.java.course3.weblibrary.repository;

import pro.sky.java.course3.weblibrary.entities.Employee;

public interface EmployeeBook {

    public Employee[] getEmployees();

    boolean add(Employee newEmployee);

    boolean delete(int id);

    boolean setSalary(int id, int salary);

    boolean setDepartment(int id, String department);
}
