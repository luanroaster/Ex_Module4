package com.sqc.academy.controller;

import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.AppException;
import com.sqc.academy.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class EmployeeController {
    IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAll(EmployeeSearchRequest request) {

        List<Employee> employees = employeeService.findAll(request);

        return JsonResponse.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getById(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id).orElse(null);
        if (employee != null) {
            return JsonResponse.ok(employee);
        }
        throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> create(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return JsonResponse.create(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> update(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        if(employee != null){
            return JsonResponse.ok(employee);
        }

        throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Integer id) {
        Employee employee = employeeService.deleteEmployee(id);
        if(employee != null){
            return JsonResponse.ok("Employee delete success!");

        }
        throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
    }
}
