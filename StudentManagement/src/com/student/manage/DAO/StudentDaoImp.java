package com.student.manage.DAO;
import com.student.manage.DTO.Student;
import com.student.manage.Factory.ConnectionFactory;

import java.sql.*;

public class StudentDaoImp implements StudentDAO{

    @Override
    public String add(Student student) {
        String status = "";
        try {
            Connection con = ConnectionFactory.getConnection();
            Statement st = con.createStatement();
            Student std = search(student.getSid());
            if (std == null) {
                int rowCount = st.executeUpdate("insert into student values ('" + student.getSid() + "','" + student.getSname() + "','" + student.getSadd() + "')");
                if (rowCount == 1) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }
           else{
                 status="existed";
                }

            }
        catch(Exception e){
            status="failure";
        }
        return status;
        }


    @Override
    public Student search(String sid) {
            Student student=null;
            try{
                    Connection con= ConnectionFactory.getConnection();
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from student where SID ='"+sid+"'");
                    boolean b=rs.next();
                student =new Student();
                    if(b==true){
                        student.setSid(rs.getString("SID"));
                        student.setSname(rs.getString("SNAME"));
                        student.setSadd(rs.getString("SADD"));
                    }
                    else{
                        student=null;

                    }
            }catch(Exception e){}
        return student;
    }

    @Override
    public String update(Student newStud) {
        String status = "";
        try {
            Connection con = ConnectionFactory.getConnection();
            Statement st = con.createStatement();
            Student stud = search(newStud.getSid());

                int rowCount = st.executeUpdate("update student set SNAME ='" + newStud.getSname() + "', SADD='" + newStud.getSadd() + "' where SID='" + newStud.getSid() + "'");
                if(rowCount==1){
                    status="success";
                }
                else{
                    status="failure";
                }



        }catch (Exception e){
            status="failure";
        }
        return null;
    }
    @Override
    public String delete(String sid) {
        String status="";
        Student stud=null;
        try {
            Connection con = ConnectionFactory.getConnection();
            Statement st = con.createStatement();
            stud = search(sid);
            if (stud == null) {
                status = "not existed";
            }
            else
            {
                int rowCount = st.executeUpdate("delete from student where SID = '" + sid + "'");
                if (rowCount == 1) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }
            }catch(Exception e){
                    status="failure";
            }

        return status;
    }
}
