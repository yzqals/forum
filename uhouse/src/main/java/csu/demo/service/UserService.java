package csu.demo.service;

import csu.demo.pojo.User;

public interface UserService {
    User getUserByAccountAndPassword(User user);
}
