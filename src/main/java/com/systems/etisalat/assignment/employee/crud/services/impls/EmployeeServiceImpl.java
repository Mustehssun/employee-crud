package com.systems.etisalat.assignment.employee.crud.services.impls;

import com.systems.etisalat.assignment.employee.crud.entities.Employee;
import com.systems.etisalat.assignment.employee.crud.repositories.EmployeeRepository;
import com.systems.etisalat.assignment.employee.crud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployees(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    public Employee getEmployee(String id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isEmpty()) {
            throw new EntityNotFoundException("Employee does not exist.");
        }
        return employee.get();
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = repository.findById(id);
        if(existingEmployee.isEmpty()) {
            throw new EntityNotFoundException("Employee does not exist.");
        }
        updatedEmployee.setId(id);

        return repository.save(updatedEmployee);
    }

    public void deleteEmployee(String id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isEmpty()) {
            throw new EntityNotFoundException("Employee does not exist.");
        }
        repository.deleteById(id);
    }
}
