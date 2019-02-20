package cn.wl.store.service.serviceImp;

import cn.wl.store.dao.UserDao;
import cn.wl.store.dao.daoImp.UserDaoImp;
import cn.wl.store.domain.User;
import cn.wl.store.service.UserService;

import java.sql.SQLException;

public class UserServiceImp implements UserService {

    @Override
    public void userRegist(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        userDao.userRegist(user);
    }

    @Override
    public User userActive(String code) throws SQLException {
        UserDao userDao = new UserDaoImp();
        User user = userDao.userActive(code);
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        userDao.updateUser(user);
    }

    @Override
    public User userLogin(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        User uu = userDao.userLogin(user);
        if(null == uu){
            throw new RuntimeException("密码有误！");
        } else if(uu.getState() == 0){
            throw new RuntimeException("用户未激活！");
        } else {
            return uu;
        }
    }


}
