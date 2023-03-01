package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Teacher getTeacherByName(String name){
        if (teacherHashMap.containsKey(name)){
            return teacherHashMap.get(name);
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> students = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(name)){
            students = teacherStudentHashMap.get(name);
            return students;
        }
        return null;
    }

    public List<String> getAllStudents(){
        List allStudents = new ArrayList<>();
        for(String name:studentHashMap.keySet()){
            allStudents.add(name);
        }
        return allStudents;
    }

    public void deleteTeacherByName(String name){
        List<String> studentList = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(name)){
            studentList = teacherStudentHashMap.get(name);
            for (String student :studentList){
                if(studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
        }

        if (teacherHashMap.containsKey(name)){
            teacherHashMap.remove(name);
        }
        teacherStudentHashMap.remove(name);
    }

    public void deleteAllTeachers(){
        teacherHashMap = new HashMap<>();
        HashSet<String> studentSet = new HashSet<>();
        for (String tName: teacherStudentHashMap.keySet()){
            for (String sName:teacherStudentHashMap.get(tName)){
                studentSet.add(sName);
            }
        }
        for (String sName:studentSet){
            if (studentHashMap.containsKey(sName)){
                studentHashMap.remove(sName);
            }
        }
        teacherStudentHashMap = new HashMap<>();
    }

}
