package csu.demo.dao;

import csu.demo.pojo.User;

public interface UserDAO {
    User getUserByAccountAndPassword(User user);
}
