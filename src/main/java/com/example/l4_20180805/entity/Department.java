package com.example.l4_20180805.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private int id;
    @Column(nullable = false)
    private String department_name;

    @OneToOne
    @JoinColumn(name = "reportsTo")

    private Employee manager;
    @JoinColumn(name = "livesIn")
    @OneToOne
    private Location location;
}
