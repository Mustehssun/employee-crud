package com.systems.etisalat.assignment.employee.crud.services;

import com.systems.etisalat.assignment.employee.crud.entities.Department;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments(Pageable pageable);
    Department getDepartment(Integer id);
    Department addDepartment(Department department);
    Department updateDepartment(Integer id, Department updatedDepartment);
    void deleteDepartment(Integer id);
}
