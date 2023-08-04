package com.student.manage.service;

import com.student.manage.DAO.StudentDAO;
import com.student.manage.DTO.Student;
import com.student.manage.Factory.StudentDAOFactory;

public class StudentServiceImp implements StudentService{
          StudentDAO studentDao;

    public String  addStudent(Student student) {
        studentDao= StudentDAOFactory.getStudentDao();
        String status=studentDao.add(student);
        return status;
    }

    @Override
    public Student searchStudent(String sid) {
        studentDao=StudentDAOFactory.getStudentDao();
        Student student=studentDao.search(sid);
        return student;
    }

    @Override
    public String updateStudent(Student newStud) {
        studentDao= StudentDAOFactory.getStudentDao();
        String status=studentDao.update(newStud);
        return status;

    }

    @Override
    public String deleteStudent(String sid) {
     studentDao=StudentDAOFactory.getStudentDao();
     String status=studentDao.delete(sid);
     return status;
    }
}
