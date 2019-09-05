package csu.demo.service.impl;

import csu.demo.dao.UserDAO;
import csu.demo.pojo.User;
import csu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserByAccountAndPassword(User user) {
        return userDAO.getUserByAccountAndPassword(user);
    }
}
