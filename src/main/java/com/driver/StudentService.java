package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String teacherName,String studentName){
        studentRepository.addStudentTeacherPair(teacherName,studentName);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

}
