package com.example.naukatrainee.service;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import com.example.naukatrainee.mapper.EmployeeMapper;
import com.example.naukatrainee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper MAPPER;

    private final EmployeeRepository EMPLOYEE_REPO;

    public EmployeeDto findById(Long id) {
        Optional<Employee> employeeById = EMPLOYEE_REPO.findById(id);
        return employeeById.map(MAPPER::toEmployeeDto)
                .orElseThrow(() -> new RuntimeException("Пользователь с id " + id + " не найден :("));
    }
}
