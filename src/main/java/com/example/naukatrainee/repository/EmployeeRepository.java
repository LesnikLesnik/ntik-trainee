package com.example.naukatrainee.repository;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long id);

    @Query(value = "SELECT first_name FROM employees GROUP BY first_name", nativeQuery = true)
    List<String> findGroupedNames();

    @Query(value = "SELECT * FROM employees WHERE birthday BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> findBetweenBirthdays(Date start, Date end);


}
