package databaseTools;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDatabase {
    private static Connection conn = null;
    private static Statement statement = null;
    private static BasicDataSource dataSource = new BasicDataSource();

    public ConnectDatabase() {

    }

    static {
        try {
            /*
            * 正常的数据库连接
            * */
           /* Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接数据库……");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "admin");
            System.out.println(conn);
            System.out.println("数据库连接成功");
            statement = conn.createStatement();*/

            /*
            * 配置了数据库连接池的配置方式
            * */
            System.out.println("+++++++++++++++++++++++++");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/test01");
            dataSource.setUsername("root");
            dataSource.setPassword("admin");
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static Connection getConnection() {
        return conn;
    }

    public static Statement getStatement() {
        return statement;
    }*/

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
