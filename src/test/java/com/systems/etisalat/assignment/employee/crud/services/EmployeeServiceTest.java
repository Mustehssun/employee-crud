package com.systems.etisalat.assignment.employee.crud.services;

import com.systems.etisalat.assignment.employee.crud.entities.Employee;
import com.systems.etisalat.assignment.employee.crud.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testCrud() {
        testAddEmployeeAndPrepareData();
        testGetEmployees();
        testGetEmployee();
        testDeleteEmployee();
    }

    private void testAddEmployeeAndPrepareData() {
        addToRepositoryAndTestAddEmployee("Mustehssun", "Iqbal", "mustehssun.iqbal@systemsltd.com");
        addToRepositoryAndTestAddEmployee("Sylvester", "TheCat", "sylvester.thecat@gmail.com");
        addToRepositoryAndTestAddEmployee("Tweety", "TheBird", "tweety.thebird@gmail.com");
        addToRepositoryAndTestAddEmployee("Road", "Runner", "road.runner@gmail.com");
        addToRepositoryAndTestAddEmployee("Foo", "Bar", "foo.bar@gmail.com");
        addToRepositoryAndTestAddEmployee("Alice", "Alice", "alice.alice@gmail.com");
        addToRepositoryAndTestAddEmployee("Bob", "Bob", "bob.bob@gmail.com");
        addToRepositoryAndTestAddEmployee("Test", "Test", "test.test@gmail.com");
        addToRepositoryAndTestAddEmployee("Tom", "TheCat", "tom.thecat@gmail.com");
        addToRepositoryAndTestAddEmployee("Jerry", "TheMouse", "jerry.themouse@gmail.com");
    }

    private void addToRepositoryAndTestAddEmployee(String firstName, String lastName, String email) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);

        Employee addedEmployee = service.addEmployee(employee);
        assertThat(addedEmployee, is(notNullValue()));
        assertThat(addedEmployee.getId(), is(notNullValue()));
    }

    private void testGetEmployees() {
        List<Employee> employees = service.getEmployees(PageRequest.of(0, 10));
        assertThat(employees, is(notNullValue()));
        assertThat(employees.size(), is(10));
    }

    private void testGetEmployee() {
        Employee actual = service.getEmployee("1");
        assertThat(actual, is(notNullValue()));

        Employee expected = new Employee();
        expected.setId("1");
        expected.setFirstName("Mustehssun");
        expected.setLastName("Iqbal");
        expected.setEmail("mustehssun.iqbal@systemsltd.com");

        assertThat(actual, is(expected));
    }

    private void testDeleteEmployee() {
        service.deleteEmployee("1");

        assertThrows(EntityNotFoundException.class, () -> { service.getEmployee("1"); });
    }
}
