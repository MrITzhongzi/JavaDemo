package cn.wl.store.web.servlet;

import cn.wl.store.domain.User;
import cn.wl.store.service.UserService;
import cn.wl.store.service.serviceImp.UserServiceImp;
import cn.wl.store.utils.MailUtils;
import cn.wl.store.utils.MyBeanUtils;
import cn.wl.store.utils.UUIDUtils;
import cn.wl.store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends BaseServlet {

    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    public String userRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        User user = new User();

        try {

            MyBeanUtils.populate(user, parameterMap);
            user.setUid(UUIDUtils.getId());
            user.setState(0);
            user.setCode(UUIDUtils.getCode()); //生成激活

            UserService userService = new UserServiceImp();
            userService.userRegist(user);
            MailUtils.sendMail(user.getEmail(), user.getCode());
            req.setAttribute("msg", "用户注册成功，请激活。");

        } catch (Exception e) {
            req.setAttribute("msg", "用户注册失败，请重新注册。");
            e.printStackTrace();
        }
        return "/jsp/info.jsp";
    }

    public String active(HttpServletRequest req, HttpServletResponse resp) {

        String activeCode = req.getParameter("code");
        UserService userService = new UserServiceImp();
        try {
            User user = userService.userActive(activeCode);
            if (user != null) {
                req.setAttribute("msg", "用户激活成功");
                user.setState(1);
                user.setCode("");
                userService.updateUser(user);
            }
        } catch (Exception e) {
            req.setAttribute("msg", "用户激活失败");
            e.printStackTrace();
        }
        return "/store/jsp/info.jsp";
    }

    public String loginUI(HttpServletRequest req, HttpServletResponse resp) {
        return "/jsp/login.jsp";
    }

    public String userLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = new User();
        MyBeanUtils.populate(user, req.getParameterMap());

        UserService userService = new UserServiceImp();

        User user02 = null;
        try {
            user02 = userService.userLogin(user);
            req.getSession().setAttribute("loginUser", user02);
            resp.sendRedirect("/store/index.jsp");
            return null;
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
            req.setAttribute("msg", message);
            return "/store/jsp/login.jsp";
        }
    }

    public String logOut(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().invalidate();
        resp.sendRedirect("/store/index.jsp");
        return null;
    }
}

