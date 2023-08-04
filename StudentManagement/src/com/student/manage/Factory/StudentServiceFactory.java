package com.student.manage.Factory;

import com.student.manage.service.StudentService;
import com.student.manage.service.StudentServiceImp;

public class StudentServiceFactory {
    private  static StudentService studentService;
    static{
        studentService=new StudentServiceImp();
    }
    public static StudentService getStudentService(){
        return studentService;
    }
}
