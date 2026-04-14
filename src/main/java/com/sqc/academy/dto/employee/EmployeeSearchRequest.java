package com.sqc.academy.dto.employee;

import com.sqc.academy.entity.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmployeeSearchRequest {
    String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobTo;

    Gender gender;

    String salaryRange;

    String phone;

    Integer departmentId;

}
