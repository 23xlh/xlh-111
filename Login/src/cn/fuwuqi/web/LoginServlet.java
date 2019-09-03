package cn.fuwuqi.web;

import cn.fuwuqi.bean.Manager;
import cn.fuwuqi.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author buguniao
 * @version v1.0
 * @date 2019/2/19 20:42
 * @description TODO
 **/
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");
        //2.处理

        Manager manager=new Manager();
        manager.setUsername(username);
        manager.setPassword(password);

        //防止恶意 验证码校验
        //y用户输入
        String checkCode = request.getParameter("checkCode");
        //服务器生成
        String  servercode = (String )request.getSession().getAttribute("code");

        if (!servercode.equalsIgnoreCase(checkCode)){
           //错误
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("验证码错误！重新登陆");

            //刷新到登陆页面
            response.setHeader("refresh","3;/login.html");
            return;
        }

        //3.响应
        ManagerService managerService=new ManagerService();
        Manager loginManager=managerService.login(manager);

        if (loginManager!=null){
                //登陆成功 把用户数据存储到Session中
            HttpSession session = request.getSession();
            session.setAttribute("loginManager",loginManager);


            //记住密码操作
            if ("rememberMe".equals(remember)){
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);

                //设置持久型cookie
                usernameCookie.setMaxAge(60*60);
                passwordCookie.setMaxAge(60*60);

                usernameCookie.setPath("/");

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }else {
                //没点记住  删除cookie
                //步骤 创建同名 设置最大存活时间为0  设置有效路径 保持一致 再发送到浏览器
                Cookie nameCookie = new Cookie("username","");
                nameCookie.setMaxAge(0);
                nameCookie.setPath("/");
                response.addCookie(nameCookie);


            }
            //记住密码操作
            request.getRequestDispatcher("/success.html").forward(request,response);
        }else {
           request.getRequestDispatcher("/error.html").forward(request,response);
            //0.2动态显示错误信息
           // String msg="用户名或密码错误！！！";
            //0.3显示登陆页面

        }


    }
}