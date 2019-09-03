package cn.fuwuqi.service;

import cn.fuwuqi.bean.Manager;
import cn.fuwuqi.dao.ManagerDao;

public class ManagerService {
    ManagerDao managerDao= new ManagerDao();
    public Manager login(Manager manager) {

       return managerDao.findByUP(manager);
    }
}
