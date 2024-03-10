package ru.ntik.naukatrainee.mapper;

import ru.ntik.naukatrainee.dto.EmployeeDto;
import ru.ntik.naukatrainee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    EmployeeDto toEmployeeDto(Employee employee);
}
