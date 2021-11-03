package com.systems.etisalat.assignment.employee.crud.repositories;

import com.systems.etisalat.assignment.employee.crud.entities.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Integer> {
}
