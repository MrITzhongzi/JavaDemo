package login;

import databaseTools.ConnectDatabase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        QueryRunner qr = new QueryRunner(ConnectDatabase.getDataSource());
        try {
            List<Map<String, Object>> query = qr.query("select * from user where username = ? and password = ?", new MapListHandler(), username, password);
            if(query.size() > 0){
                System.out.println("+++++");
                System.out.println(request.getContextPath());
                System.out.println(request.getContextPath());
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
               request.setAttribute("loginInfo", "用户名密码错误");
               request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
