package com.example.naukatrainee.service;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import com.example.naukatrainee.exceptions.BusinessException;
import com.example.naukatrainee.mapper.EmployeeMapper;
import com.example.naukatrainee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepo;

    public EmployeeDto findById(Long id) {
        return employeeRepo.findById(id)
                .map(employeeMapper::toEmployeeDto)
                .orElseThrow(() -> new BusinessException("Пользователь с id " + id + " не найден :("));
    }

    /**
     * Список сгруппированных по именам сотрудников
     *
     * @return возвращает список уникальных имен
     */
    public Page<String> groupByName(Pageable pageable) {
        return employeeRepo.findFirstNamesGroupedByFirstName(pageable);
    }

    public Page<EmployeeDto> findBetween(Date start, Date end, Pageable pageable) {
        Page<Employee> employees = employeeRepo.findAllByBirthdayBetween(start, end, pageable);
        return employees.map(employeeMapper::toEmployeeDto);
    }
}
