package com.example.naukatrainee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    public Long id;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String department;

    private Integer salary;
}
