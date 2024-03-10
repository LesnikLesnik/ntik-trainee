package com.example.naukatrainee.service;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import com.example.naukatrainee.mapper.EmployeeMapper;
import com.example.naukatrainee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<String> groupByName() {
        return EMPLOYEE_REPO.findGroupedNames();
    }

    public List<EmployeeDto> findBetween(Date start, Date end) {
        List<Employee> employees = EMPLOYEE_REPO.findBetweenBirthdays(start, end);
        return employees.stream()
                .map(MAPPER::toEmployeeDto)
                .toList();
    }
}
