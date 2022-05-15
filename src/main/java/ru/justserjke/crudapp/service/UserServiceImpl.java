package ru.justserjke.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.justserjke.crudapp.dao.UserDAO;
import ru.justserjke.crudapp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.removeById(id);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return userDao.findById(id);
    }
}
