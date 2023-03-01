package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    //<student_name,Student object>
    HashMap<String,Student> studentHashMap = new HashMap<>();
    //<teacher_name,Teacher object>
    HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    //<teacher_name,list of all student names assigned to that teacher>
    HashMap<String, List<String>> teacherStudentHashMap = new HashMap<>();

    public void addStudent(Student student){
        String studentName = student.getName();
        studentHashMap.put(studentName,student);
    }

    public void addTeacher(Teacher teacher){
        String teachername = teacher.getName();
        teacherHashMap.put(teachername,teacher);
    }

    public void addStudentTeacherPair(String teacherName,String studentName){
        List<String> studentsList = new ArrayList<>();
        if(teacherStudentHashMap.containsKey(teacherName)){
            studentsList = teacherStudentHashMap.get(teacherName);
            studentsList.add(studentName);
            teacherStudentHashMap.put(teacherName,studentsList);
        }
        else {
            studentsList.add(studentName);
            teacherStudentHashMap.put(teacherName,studentsList);
        }
    }

    public Student getStudentByName(String name){
        if(studentHashMap.containsKey(name)){
            return studentHashMap.get(name);
        }
        return null;
    }

}
