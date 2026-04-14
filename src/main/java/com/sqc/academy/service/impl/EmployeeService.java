package com.sqc.academy.service.impl;

import com.sqc.academy.dto.employee.EmployeeSearchRequest;
import com.sqc.academy.repository.IEmployeeRepository;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository;


    public List<Employee> findAll(EmployeeSearchRequest request) {
        return employeeRepository.findAll(request);
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(Integer id ,Employee updateEmployee) {
        return employeeRepository.updateEmployee(id, updateEmployee);
    }

    public Employee deleteEmployee(Integer id) {
        return employeeRepository.deleteEmployee(id);
    }
}
