package cn.wl.store.dao.daoImp;

import cn.wl.store.dao.UserDao;
import cn.wl.store.domain.User;
import cn.wl.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    @Override
    public void userRegist(User user01) throws SQLException {

        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = { user01.getUid(), user01.getUsername(), user01.getPassword(), user01.getName(),
                user01.getEmail(), user01.getTelephone(), user01.getBirthday(), user01.getSex(), user01.getState(),
                user01.getCode() };
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql, params);

    }

    @Override
    public User userActive(String code) throws SQLException {
        String sql = "select * from user where code = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), code);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET username= ? ,PASSWORD=? ,NAME =? ,email =? ,telephone =? , birthday =?  ,sex =? ,state= ? , CODE = ? WHERE uid=?";
        Object[] params = { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(),
                user.getUid() };
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql, params);
    }
}
