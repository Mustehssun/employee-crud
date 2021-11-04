package com.systems.etisalat.assignment.employee.crud.controllers;

import com.systems.etisalat.assignment.employee.crud.entities.Department;
import com.systems.etisalat.assignment.employee.crud.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Department>> getDepartments(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(service.getDepartments(PageRequest.of(offset, limit)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Department> getDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDepartment(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Department> addDepartment(@RequestBody Department employee) {
        return ResponseEntity.ok(service.addDepartment(employee));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Integer id,
                                                @RequestBody Department employee) {
        return ResponseEntity.ok(service.updateDepartment(id, employee));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(value = "id") Integer id) {
        service.deleteDepartment(id);

        return ResponseEntity.ok(new Department());
    }
}
