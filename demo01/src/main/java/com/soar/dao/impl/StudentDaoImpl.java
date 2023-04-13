package com.soar.dao.impl;


import com.soar.bean.Student;
import com.soar.dao.DBUtils;
import com.soar.dao.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DBUtils implements StudentDao {
    @Override
    public List<Student> getStudentList() {
        String sql = "select * from student";
        List<Student> studentList = new ArrayList<>();
        try {
            resultSet = query(sql, null);
            while (resultSet.next()){
                Student student = new Student();
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setStuName(resultSet.getString("stuname"));
                student.setSex(resultSet.getInt("sex"));
                student.setPhone(resultSet.getString("phone"));
                student.setProfession(resultSet.getString("profession"));
                student.setRegDate(resultSet.getDate("regdate"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return studentList;
    }
}
