package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Betteries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    private String name;

    private Integer wattCapacity;

    private String postCode;

}
