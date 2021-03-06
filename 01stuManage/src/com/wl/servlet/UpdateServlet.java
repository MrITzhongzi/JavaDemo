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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 接收数据
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String info = request.getParameter("info");
        String[] h = request.getParameterValues("hobby");
        String hobby = Arrays.toString(h).substring(1, Arrays.toString(h).length()-1);
        System.out.println(hobby);

        // 添加数据
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            Student student = new Student(sid,sname,gender,phone,hobby,info,date);
            StudentService<Student> service = new StudentServiceImpl();
            service.update(student);
            request.getRequestDispatcher("/studentListServlet").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
