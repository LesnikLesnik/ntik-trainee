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

    private final EmployeeService SERVICE;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        EmployeeDto employee = SERVICE.findById(id);
        logger.info("Employee found: {}", employee);
        return employee;
    }

    @GetMapping("/groupByName")
    public List<String> getGroupedNames() {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        List<String> groupedNames = SERVICE.groupByName();
        logger.info("Grouped names: {}", groupedNames);
        return groupedNames;
    }

    /**
     * Поиск между датами в формате ISO (YYYY-MM-DD)
     *
     * @return список сотрудников в заданном интервале
     */
    @GetMapping("/findBetween")
    public List<EmployeeDto> getEmployeesBetweenBirthdays(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        List<EmployeeDto> employees = SERVICE.findBetween(start, end);
        logger.info("Employees between birthdays {} and {}: {}", start, end, employees);
        return employees;
    }
}
