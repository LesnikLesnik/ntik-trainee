package com.example.naukatrainee.mapper;

import com.example.naukatrainee.dto.EmployeeDto;
import com.example.naukatrainee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee toEmployee (EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);
}
