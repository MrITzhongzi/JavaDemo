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

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int sid = Integer.parseInt(request.getParameter("sid"));
            System.out.println("sid=" + sid);
            StudentService<Student> service = new StudentServiceImpl();
            service.delete(sid);

            request.getRequestDispatcher("studentListServlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
