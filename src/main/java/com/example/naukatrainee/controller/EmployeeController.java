package com.example.naukatrainee.controller;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService EMPL_SERVICE;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        EmployeeDto employee = EMPL_SERVICE.findById(id);
        logger.info("Employee found: {}", employee);
        return employee;
    }

    @GetMapping("/grouped-names")
    public List<String> getGroupedNames() {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        List<String> groupedNames = EMPL_SERVICE.groupByName();
        logger.info("Grouped names: {}", groupedNames);
        return groupedNames;
    }

    @GetMapping("/between-birthdays")
    public List<EmployeeDto> getEmployeesBetweenBirthdays(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        List<EmployeeDto> employees = EMPL_SERVICE.findBetween(start, end);
        logger.info("Employees between birthdays {} and {}: {}", start, end, employees);
        return employees;
    }
}
