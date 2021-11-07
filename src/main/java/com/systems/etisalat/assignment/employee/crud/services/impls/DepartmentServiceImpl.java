package com.systems.etisalat.assignment.employee.crud.services.impls;

import com.systems.etisalat.assignment.employee.crud.entities.Department;
import com.systems.etisalat.assignment.employee.crud.repositories.DepartmentRepository;
import com.systems.etisalat.assignment.employee.crud.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<Department> getDepartments(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    public Department getDepartment(Integer id) {
        Optional<Department> department = repository.findById(id);
        if(department.isEmpty()) {
            throw new EntityNotFoundException("Department does not exist.");
        }
        return department.get();
    }

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Integer id, Department updatedDepartment) {
        Optional<Department> existingDepartment = repository.findById(id);
        if(existingDepartment.isEmpty()) {
            throw new EntityNotFoundException("Department does not exist.");
        }
        updatedDepartment.setId(id);

        return repository.save(updatedDepartment);
    }

    public void deleteDepartment(Integer id) {
        Optional<Department> department = repository.findById(id);
        if(department.isEmpty()) {
            throw new EntityNotFoundException("Department does not exist.");
        }
        repository.deleteById(id);
    }
}
