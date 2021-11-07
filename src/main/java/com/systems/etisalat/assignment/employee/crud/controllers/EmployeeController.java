package com.systems.etisalat.assignment.employee.crud.controllers;

import com.systems.etisalat.assignment.employee.crud.entities.Employee;
import com.systems.etisalat.assignment.employee.crud.services.EmployeeService;
import com.systems.etisalat.assignment.employee.crud.services.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(service.getEmployees(PageRequest.of(offset-1, limit)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(service.getEmployee(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.addEmployee(employee));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@PathVariable(value = "id") String id,
                                                @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") String id) {
        service.deleteEmployee(id);

        return ResponseEntity.ok(new Employee());
    }
}
