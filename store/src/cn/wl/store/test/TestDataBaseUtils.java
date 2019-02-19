package cn.wl.store.test;

import cn.wl.store.domain.User;
import cn.wl.store.utils.JDBCUtils;
import cn.wl.store.utils.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestDataBaseUtils {

    @Test
    public void test() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user";
        List<Object> query = qr.query(sql, new BeanListHandler<>(Object.class));
        System.out.println(query);
    }

    @Test
    public void testUser() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT into user VALUES (?,?,?,?,?,?,?,?,?,?);";
        Object[] params = {UUIDUtils.getId(), null, null, null, null, null, null, null, null, null};
        qr.update(sql, params);

    }
}
