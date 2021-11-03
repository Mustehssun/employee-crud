package com.systems.etisalat.assignment.employee.crud.repositories;

import com.systems.etisalat.assignment.employee.crud.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
}
