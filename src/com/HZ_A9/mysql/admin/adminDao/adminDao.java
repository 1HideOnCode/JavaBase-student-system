package com.HZ_A9.mysql.admin.adminDao;

public interface adminDao {
    abstract void showAllUser();
    abstract boolean resetUser();
    abstract boolean addUser();
    abstract boolean deleteUser();
}
