package com.ills.service;

import com.ills.dao.Dao;
import com.ills.dto.StudentDTO;
import com.ills.entities.Student;
import com.ills.entities.View;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alex on 28.11.2017.
 */
@Service
public class StudentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private Dao<Student, String> studentDAO;

    @Transactional
    public void saveStudent(StudentDTO studentDTO){
        Student student = modelMapper.map(studentDTO, Student.class);
        studentDAO.add(student);
    }

}
