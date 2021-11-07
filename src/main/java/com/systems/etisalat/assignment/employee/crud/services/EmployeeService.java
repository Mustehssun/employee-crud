package com.systems.etisalat.assignment.employee.crud.services;

import com.systems.etisalat.assignment.employee.crud.entities.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(Pageable pageable);
    Employee getEmployee(String id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(String id, Employee updatedEmployee);
    void deleteEmployee(String id);
}
