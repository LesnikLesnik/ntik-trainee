package ru.ntik.naukatrainee.mapper;

import ru.ntik.naukatrainee.dto.EmployeeDto;
import ru.ntik.naukatrainee.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = EmployeeMapperImpl.class)
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    void when_map_Employee_to_EmployeeDto_then_mapped_correctly() {
        //given
        Employee employee = new Employee(1L, "John", "Dao", new Date(), "asd", 50000);

        //when
        EmployeeDto result = mapper.toEmployeeDto(employee);

        //then
        assertThat(result.getId()).isEqualTo(employee.getId());
        assertThat(result.getFirstName()).isEqualTo(employee.getFirstName());
        assertThat(result.getLastName()).isEqualTo(employee.getLastName());
        assertThat(result.getBirthday()).isEqualTo(employee.getBirthday());
        assertThat(result.getDepartment()).isEqualTo(employee.getDepartment());
        assertThat(result.getSalary()).isEqualTo(employee.getSalary());
    }
}
