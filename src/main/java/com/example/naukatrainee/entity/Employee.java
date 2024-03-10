package com.example.naukatrainee.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
//@NoArgsConstructor TODO
//@AllArgsConstructor
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="id")
    public Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="department")
    private String department;

    @Column(name="salary")
    private Integer salary;
}
