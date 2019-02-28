package cn.wl.store.web.filter;

import cn.wl.store.domain.User;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PriviledgeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        User loginUser = (User)httpServletRequest.getSession().getAttribute("loginUser");
        if(null != loginUser) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletRequest.setAttribute("msg", "请用户登录之后再去访问");
            httpServletRequest.getRequestDispatcher("/jsp/info.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
