package cn.fuwuqi.dao;

import cn.fuwuqi.bean.Student;
import cn.fuwuqi.utils.C3P0util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0util.getDataSource());
    public List<Student> findAll() {
        String sql="select * from student";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return students;
    }

    public boolean deleteByID(int id) {
        String sql="DELETE FROM student1 WHERE id = ?";
        int num = jdbcTemplate.update(sql, id);
        if (num>0){
            System.out.println("成功！");
            return true;
        }else {
            System.out.println("失败！");
            return false;
        }

    }
}
