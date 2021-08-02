package com.github.utils;

import com.github.entity.Department;
import com.github.entity.Employee;
import com.github.service.IDepartmentService;
import com.github.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillDatabase implements CommandLineRunner {

    private final IEmployeeService employeeService;

    private final IDepartmentService departmentService;

    private List<Employee> employeesList = new ArrayList<>();

    private List<Department> departmentList = new ArrayList<>();

    @Autowired
    public FillDatabase(IEmployeeService employeeService, IDepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {
        fillDatabase();
        for (Department dep: departmentList) {
            departmentService.saveDepartment(dep);
        }

        for (Employee emp: employeesList) {
            employeeService.saveEmployee(emp);
        }
    }

    private void fillDatabase() {

        Department department1 = new Department("Sales");
        Department department2 = new Department("Marketing");
        Department department3 = new Department("Accounts");
        Department department4 = new Department("Administration");

        Employee employee1 = new Employee("Getz", "Hyundai", department1, "Salesman",BigDecimal.valueOf(15500));
        Employee employee2 = new Employee("Davis", "John",department2, "Musician",BigDecimal.valueOf(1500));
        Employee employee3 = new Employee("King", "Martin",department2, "Leader",BigDecimal.valueOf(15500));
        Employee employee4 = new Employee("Davis", "Bob",department1, "Heavymachinery",BigDecimal.valueOf(3000));
        Employee employee5 = new Employee("John", "Doe", department2, "Hobo",BigDecimal.valueOf(7000));

        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        employeesList.add(employee4);
        employeesList.add(employee5);

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);
        departmentList.add(department4);
    }
}
