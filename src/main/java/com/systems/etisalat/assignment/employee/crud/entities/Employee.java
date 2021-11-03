package com.systems.etisalat.assignment.employee.crud.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull(message = "firstName should not be null.")
    @Length(min = 2, message = "Minimum length of firstName should be 2.")
    private String firstName;

    @NotNull(message = "lastName should not be null.")
    @Length(min = 2, message = "Minimum length of lastName should be 2.")
    private String lastName;

    private String email;

    @Pattern(regexp="^[0-9-]*$", message = "phoneNumber should contain only digits and dashes.")
    private String phoneNumber;
    private Date hireDate;

    @DecimalMin(value = "0", inclusive = false, message = "salary should be greater than 0.")
    private Double salary;
    private Integer managerId;

    @ManyToOne
    private Department department;
}
