package com.example.l4_20180805.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID")
    private int id;

    private String street_address;
    private String postal_code;
    @Column(nullable = false)
    private String city;
    private String state_province;
    @OneToOne
    @JoinColumn(name = "reportsTo")
    private Country country;

}
