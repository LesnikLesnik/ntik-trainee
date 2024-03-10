package com.example.naukatrainee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private Long id;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String department;

    private Integer salary;
}
