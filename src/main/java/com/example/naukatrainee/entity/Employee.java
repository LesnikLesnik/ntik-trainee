package com.example.naukatrainee.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="")
    public Long id;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String department;

    private Integer salary;
}
