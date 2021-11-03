package com.systems.etisalat.assignment.employee.crud.services;

import com.systems.etisalat.assignment.employee.crud.entities.Department;
import com.systems.etisalat.assignment.employee.crud.repositories.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService service;

    @Autowired
    private DepartmentRepository repository;

    @Test
    public void testCrud() {
        addToRepositoryAndTestAddDepartment();
        testGetDepartments();
        testGetDepartment();
        testDeleteDepartment();
    }

    private void addToRepositoryAndTestAddDepartment() {
        addToRepositoryAndTestAddDepartment("Science", 5);
        addToRepositoryAndTestAddDepartment("Arts", 5);
        addToRepositoryAndTestAddDepartment("Humanities", 5);
        addToRepositoryAndTestAddDepartment("History", 5);
        addToRepositoryAndTestAddDepartment("Philosophy", 5);
        addToRepositoryAndTestAddDepartment("Games", 5);
        addToRepositoryAndTestAddDepartment("Development", 5);
        addToRepositoryAndTestAddDepartment("HR", 5);
        addToRepositoryAndTestAddDepartment("QA", 5);
        addToRepositoryAndTestAddDepartment("Finance", 5);
    }

    private void addToRepositoryAndTestAddDepartment(String name, long managerId) {
        Department department = new Department();
        department.setName(name);
        department.setManagerId(managerId);

        Department addedDepartment = service.addDepartment(department);
        assertThat(addedDepartment, is(notNullValue()));
        assertThat(addedDepartment.getId(), is(notNullValue()));
    }

    private void testGetDepartments() {
        List<Department> departments = service.getDepartments(PageRequest.of(0, 10));
        assertThat(departments, is(notNullValue()));
        assertThat(departments.size(), is(10));
    }

    private void testGetDepartment() {
        Department actual = service.getDepartment(1);
        assertThat(actual, is(notNullValue()));

        assertThat(actual.getId(), is(1));
        assertThat(actual.getName(), is("Science"));
        assertThat(actual.getManagerId(), is(5L));
    }

    private void testDeleteDepartment() {
        service.deleteDepartment(1);

        assertThrows(EntityNotFoundException.class, () -> service.getDepartment(1));
    }
}
