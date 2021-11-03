package com.systems.etisalat.assignment.employee.crud.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private long managerId;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
//    private List<Employee> employees;
}
