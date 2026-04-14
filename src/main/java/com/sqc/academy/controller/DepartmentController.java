package com.sqc.academy.controller;

import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.AppException;
import com.sqc.academy.exception.ErrorCode;
import com.sqc.academy.entity.Department;
import com.sqc.academy.service.IDepartmentService;
import com.sqc.academy.util.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DepartmentController {
    IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.findAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        Department department = departmentService.findDepartmentById(id);
        if(department != null){
            return ResponseEntity.ok(department);
        }

        throw new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return JsonResponse.create(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Department>> updateDepartment(@PathVariable Integer id, @RequestBody Department updateDepartment) {
        Department department = departmentService.updateDepartment(id, updateDepartment);
        if(department != null){
            return JsonResponse.ok(department);
        }
        throw new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteDepartment(@PathVariable Integer id) {
        Department department = departmentService.deleteDepartment(id);
        if(department != null){
            return JsonResponse.ok("Department delete success!!");
        }
        throw new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED);
    }
}
