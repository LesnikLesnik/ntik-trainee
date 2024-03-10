package ru.ntik.naukatrainee.repository;

import ru.ntik.naukatrainee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

//Все запросы нативные в соответствии с заданием
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employees WHERE id = ?1", nativeQuery = true)
    Optional<Employee> findById(Long id);

    @Query(value = "SELECT first_name FROM employees GROUP BY first_name", nativeQuery = true)
    Page<String> findFirstNamesGroupedByFirstName(Pageable pageable);

    @Query(value = "SELECT * FROM employees WHERE birthday BETWEEN ?1 AND ?2", nativeQuery = true)
    Page<Employee> findAllByBirthdayBetween(Date start, Date end, Pageable pageable);

}
