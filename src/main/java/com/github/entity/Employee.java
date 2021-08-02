package com.github.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String last_name;

    private String first_name;

    @ManyToOne
    @JoinColumn
    private Department department;

    private String job_category;

    private BigDecimal salary;

    public Employee(String last_name,
                    String first_name,
                    Department department,
                    String job_category,
                    BigDecimal salary) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.department = department;
        this.job_category = job_category;
        this.salary = salary;
    }
}
