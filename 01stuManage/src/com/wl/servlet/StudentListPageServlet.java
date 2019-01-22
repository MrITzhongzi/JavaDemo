package com.wl.servlet;

import com.wl.domain.PageStudentBean;
import com.wl.domain.Student;
import com.wl.service.StudentService;
import com.wl.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            StudentService<Student> service = new StudentServiceImpl();
            PageStudentBean<Student> pageBean =  service.findStudentByPage(currentPage);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("list_page.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
