package com.github.repository;

import com.github.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT department_id, max(salary) as maxsalary, min(salary) as minsalary FROM employees e GROUP BY department_id HAVING max(salary) >= 15000 AND min(salary) < 5000", nativeQuery = true)
    List<Employee> getMinAndMaxSalaryInDepartment();

}
