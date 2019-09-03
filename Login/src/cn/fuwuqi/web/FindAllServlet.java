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
 * @date 2019/2/19 19:35
 * @description TODO
 **/
@WebServlet(urlPatterns = "/findAllServlet")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService=new StudentService();
        List<Student> studentList=studentService.findAll();

        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}