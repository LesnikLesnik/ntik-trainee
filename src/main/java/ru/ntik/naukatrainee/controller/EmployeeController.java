package ru.ntik.naukatrainee.controller;

import ru.ntik.naukatrainee.controller.annotations.DefaultApiResponses;
import ru.ntik.naukatrainee.dto.EmployeeDto;
import ru.ntik.naukatrainee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@DefaultApiResponses
@Tag(description= "Employee Controller", name="Контроллер сотрудников")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    @Operation(summary = "Получение сотрудника по id")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.findById(id);
        log.info("Employee found: {}", employee);
        return employee;
    }

    @GetMapping("/groupByName")
    @Operation(summary = "Получение страницы уникальных имен сотрудников")
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
    @Operation(summary = "Получение страницы сотрудников в заданном интервале дат рождения")
    public Page<EmployeeDto> getEmployeesBetweenBirthdays(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end,
            @PageableDefault(page = 0, size = 15) Pageable pageable) {

        Page<EmployeeDto> employees = employeeService.findBetween(start, end, pageable);
        log.info("Employees between birthdays {} and {}: {}", start, end, employees);
        return employees;
    }
}
