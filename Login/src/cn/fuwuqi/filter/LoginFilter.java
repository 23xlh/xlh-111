package cn.fuwuqi.filter;

import cn.fuwuqi.bean.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/success.html")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断用户是否登录
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        Manager loginManager = (Manager) request.getSession().getAttribute("loginManager");
        if (loginManager==null){
            //未登录挑战
            response.sendRedirect("login.html");
        }else {
            //已登录就放行
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
