package com.sqc.academy.service;

import com.sqc.academy.entity.Student;

import java.util.List;

public interface IDepartmentService  {


    public List<Student> findAll ();


    public Student finById(Integer id);


    public  Student save(Student student);


}