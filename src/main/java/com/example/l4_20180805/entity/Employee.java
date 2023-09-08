package com.example.l4_20180805.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int id;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String email;
    private String password;
    private String phone_number;
    @Column(nullable = false)
    private Date hire_date;
    private String job_id;
    private BigDecimal salary;
    private BigDecimal commission_pct;
    @OneToOne
    @JoinColumn(name = "reportsTo")
    private Employee manager;
    @JoinColumn(name = "livesIn")
    @OneToOne
    private Department department;
    private int enabled;

}