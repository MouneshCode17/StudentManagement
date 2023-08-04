package com.student.manage.service;
import com.student.manage.DTO.Student;
public interface StudentService {
    public  String  addStudent(Student student);
    public Student searchStudent(String sid);
    public String updateStudent(Student student);
    public String deleteStudent(String sid);
}
