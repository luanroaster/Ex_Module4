package com.sqc.academy.service;

import com.sqc.academy.dto.employee.EmployeeSearchRequest;

public interface IEmployeeService {
    List<Employee> findAll(EmployeeSearchRequest request);

    Optional<Employee> findById(Integer id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Integer id, Employee updatedEmployee);

    Employee deleteEmployee(Integer id);
}
