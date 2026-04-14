package com.sqc.academy.service.impl;

import com.sqc.academy.entity.Department;
import com.sqc.academy.repository.IDepartmentRepository;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    IDepartmentRepository departmentRepository;

    public List<Department> findAllDepartments() {
        return departmentRepository.findAllDepartments();
    }

    public Department findDepartmentById(Integer id) {
        return departmentRepository.findDepartmentById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.createDepartment(department);
    }

    public Department updateDepartment(Integer id, Department updatedepartment) {
        return departmentRepository.updateDepartment(id, updatedepartment);
    }

    public Department deleteDepartment(Integer id) {
        return departmentRepository.deleteDepartment(id);
    }

}
