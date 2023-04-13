package com.soar.service.impl;


import com.soar.bean.Student;
import com.soar.dao.StudentDao;
import com.soar.dao.impl.StudentDaoImpl;
import com.soar.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
}
