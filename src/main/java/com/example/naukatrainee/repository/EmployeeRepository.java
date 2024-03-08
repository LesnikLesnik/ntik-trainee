package com.example.naukatrainee.repository;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long id);


}
