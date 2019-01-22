package com.wl.servlet;

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

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        StudentService<Student> service = new StudentServiceImpl();
        try {
            Student studentById = service.findStudentById(sid);
            request.setAttribute("stu", studentById);
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
