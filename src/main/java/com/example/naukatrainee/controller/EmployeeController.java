package com.example.naukatrainee.controller;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.findById(id);
        log.info("Employee found: {}", employee);
        return employee;
    }

    @GetMapping("/groupByName")
    public Page<String> getGroupedNames(@PageableDefault(page = 0, size = 15) Pageable pageable) {
        Page<String> groupedNames = employeeService.groupByFirstName(pageable);
        log.info("Grouped names: {}", groupedNames);
        return groupedNames;
    }

    /**
     * Поиск между датами в формате ISO (YYYY-MM-DD)
     *
     * @return список сотрудников в заданном интервале
     */
    @GetMapping("/findBetween")
    public Page<EmployeeDto> getEmployeesBetweenBirthdays( //TODO
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end,
            @PageableDefault(page = 0, size = 15) Pageable pageable) {

        Page<EmployeeDto> employees = employeeService.findBetween(start, end, pageable);
        log.info("Employees between birthdays {} and {}: {}", start, end, employees);
        return employees;
    }
}
