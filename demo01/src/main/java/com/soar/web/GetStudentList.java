package com.soar.web;

import com.soar.bean.Student;
import com.soar.service.StudentService;
import com.soar.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Educational/student/getStudentList")
public class GetStudentList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        // 调用service
        StudentService service = new StudentServiceImpl();
        List<Student> studentList = service.getStudentList();
        System.out.println(studentList);
        // 存储数据到req，跳转页面
        req.setAttribute("stulist",studentList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
