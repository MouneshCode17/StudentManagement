package com.student.manage.Factory;
import com.student.manage.DAO.StudentDAO;
import com.student.manage.DAO.StudentDaoImp;
public class StudentDAOFactory {
    private static StudentDAO studentDao;
    static{
        studentDao =new StudentDaoImp();
    }
    public static StudentDAO getStudentDao(){
        return studentDao;
    }
}
