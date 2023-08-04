package com.student.manage.DAO;

import com.student.manage.DTO.Student;

public interface StudentDAO {
    public String add(Student student);
    public Student search(String sid);
    public String update(Student student);
    public String delete(String sid);
}
