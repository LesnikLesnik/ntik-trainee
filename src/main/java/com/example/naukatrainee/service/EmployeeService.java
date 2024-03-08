package com.example.naukatrainee.service;

import com.example.naukatrainee.entity.Employee;
import com.example.naukatrainee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final Employee EMPLOYEE;

    private final EmployeeRepository EMPLOYEE_REPO;


}
