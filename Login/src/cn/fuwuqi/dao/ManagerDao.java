package cn.fuwuqi.dao;

import cn.fuwuqi.bean.Manager;
import cn.fuwuqi.utils.C3P0util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ManagerDao {
    private  JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0util.getDataSource());

    public Manager findByUP(Manager manager) {
        String sql="select * from manager where username=? and password=?";

        try {
         return  jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Manager.class),
                    manager.getUsername(), manager.getPassword());
        } catch (DataAccessException e) {
            return null;
        }

    }
}
