package com.soar.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginout")
public class LoginOut extends HttpServlet {
    /**
     * 退出登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 清空session
        req.getSession().invalidate();
        // 重定向到首页
        // resp.sendRedirect("login.jsp");
        // 由于此项目的HTML是用框架写的，因此用上面的方法无法完整退出，改用下面的方法
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<script>alert('退出成功！');top.location.href='login.jsp'</script>");
    }
}
