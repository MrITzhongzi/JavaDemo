package com.wl.servlet;

import com.wl.dao.StudentDao;
import com.wl.dao.impl.StudentDaoImpl;
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
import java.util.List;

/***
 * 负责查询所有学生信息，呈现在list界面上
 */
@WebServlet(name = "StudentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 查询出来所有的学生
            StudentService<Student> studentService = new StudentServiceImpl();
            List<Student> all = studentService.findAll();
            request.setAttribute("list", all);
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
