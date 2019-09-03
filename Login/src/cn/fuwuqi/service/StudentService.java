package cn.fuwuqi.service;

import cn.fuwuqi.bean.Student;
import cn.fuwuqi.dao.StudentDao;

import java.util.List;

public class StudentService {
    StudentDao studentDao=new StudentDao();
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public boolean deleteByID(Student student) {
        return studentDao.deleteByID(student.getId());

    }
}
