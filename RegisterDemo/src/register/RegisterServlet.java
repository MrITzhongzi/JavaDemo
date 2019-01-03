package register;

import databaseTools.ConnectDatabase;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
            user.setUid(UUID.randomUUID().toString());
            regist(user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
    //注册的方法
    public void regist(User user) throws SQLException{
        //操作数据库
        QueryRunner runner = new QueryRunner(ConnectDatabase.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
                user.getEmail(),null,user.getBirthday(),user.getSex(),null,null);
    }

}
