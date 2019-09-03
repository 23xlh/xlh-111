package cn.fuwuqi.web;

import cn.fuwuqi.bean.Student;
import cn.fuwuqi.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author buguniao
 * @version v1.0
 * @date 2019/2/19 21:28
 * @description TODO
 **/
@WebServlet(urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收
        String username = request.getParameter("username");
        int name = Integer.parseInt(username);
        //处理
        Student student=new Student();
        student.setId(name);

        //响应
        StudentService studentService=new StudentService();
     boolean i= studentService.deleteByID(student);
     if (i){
         request.getRequestDispatcher("/success.html").forward(request,response);
     }else {
         request.getRequestDispatcher("/error.html").forward(request,response);
     }
    }
}