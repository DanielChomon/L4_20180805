package com.example.l4_20180805.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobID")
    private int id;
    @Column(nullable = false)
    private String job_title;
    @Column(nullable = false)
    private int min_salary;
    private int max_salary;

}
