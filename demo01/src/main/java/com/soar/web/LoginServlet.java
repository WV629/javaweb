package com.soar.web;

import com.soar.bean.Users;
import com.soar.service.UsersService;
import com.soar.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    /**
     * 登录功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UsersService service = new UsersServiceImpl();
        Users users = service.login(username, password);
        if (users == null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<script>location.href='login.jsp';alert('用户名或密码不正确')</script>");
        } else {
            resp.sendRedirect("index.jsp");
            req.getSession().setAttribute("u1",users);
        }
    }
}
