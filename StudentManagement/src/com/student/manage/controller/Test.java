package com.student.manage.controller;
import java.lang.System;
import com.student.manage.DTO.Student;
import com.student.manage.Factory.StudentServiceFactory;
import com.student.manage.service.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        String sid;
        String sname;
        String sadd ;
        String status;
        Student student=null;
        BufferedReader br=null;
        StudentService studentService= StudentServiceFactory.getStudentService();
        System.out.println("Student Management System");
        try {
            br=new BufferedReader(new InputStreamReader(System.in));

            while(true){
                System.out.println("1.ADD Student");
                System.out.println("2.SEARCH Student");
                System.out.println("3.UPDATE Student");
                System.out.println("4.DELETE Student");
                System.out.println("5.EXIT");
                System.out.print("\n");
                System.out.print("ENTER Your Option : ");
                int option=Integer.parseInt(br.readLine());

                switch(option){
                    case 1:
                        System.out.print("Student Id: ");
                        sid=br.readLine();
                        System.out.print("Student Name: ");
                        sname=br.readLine();
                        System.out.print("Student Address: ");
                        sadd =br.readLine();
                        student =new Student();
                        student.setSid(sid);
                        student.setSname(sname);
                        student.setSadd(sadd);
                        status=studentService.addStudent(student);
                        if(status.equalsIgnoreCase("success")){
                            System.out.println("Status => Student added successfully");
                        }
                         if(status.equalsIgnoreCase("existed")){
                            System.out.println("Status => Student already existed");
                        }
                      if(status.equalsIgnoreCase("failure")){
                            System.out.println("Status => Student Insertion Failure");
                        }
                        break;
                    case 2:
                        System.out.print("Student Id: ");
                        sid=br.readLine();
                        student=studentService.searchStudent(sid);
                        if(student==null){
                            System.out.println("Status : Student Not Existed");
                        }
                        else{
                            System.out.println("Student Existed");
                            System.out.println("------------------------");
                            System.out.println("Student ID: "+student.getSid());
                            System.out.println("Student NAME: "+student.getSname());
                            System.out.println("Student ADDRESS: "+student.getSadd());
                        }
                        break;
                    case 3:
                        System.out.print("Student Id: ");
                        sid=br.readLine();
                        student=studentService.searchStudent(sid);
                        if(student==null){
                            System.out.println("Status : Student NOT EXISTED ");
                        }
                        else{
                            System.out.print("Student Name[OLD:"+student.getSname()+"]NEW: ");
                            sname=br.readLine();
                            System.out.print("Student ADDRESS [OLD:"+student.getSadd()+"]NEW: ");
                            sadd=br.readLine();
                            Student newStud=new Student();
                            newStud.setSid(sid);
                            newStud.setSname(sname);
                            newStud.setSadd(sadd);
                            status=studentService.updateStudent(newStud);
                            if(status.equalsIgnoreCase("success")){
                                System.out.println("Status=> Student Updated Successfully");
                            }
                            if(status.equalsIgnoreCase("failure")){
                                System.out.println("Status=> Student Updation Failed");
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Student Id: ");
                        sid=br.readLine();
                        status= studentService.deleteStudent(sid);
                        if(status.equalsIgnoreCase("success")){
                            System.out.println("Status=> Student Deleted Successfully");
                        }
                        if(status.equalsIgnoreCase("failure")){
                            System.out.println("Status=> Student Deletion FAILURE");
                        }
                        if(status.equalsIgnoreCase("not existed")){
                            System.out.println("Status=> Student NOT EXISTED");
                        }
                        break;
                    case 5:
                        System.out.println("=>EXIT Module\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("=>Enter the valid Option\n");
                        break;

                }
            }

        } catch (Exception e) {

        }
        finally {
            try{
                br.close();
            }
            catch(Exception e){}
        }
    }
}