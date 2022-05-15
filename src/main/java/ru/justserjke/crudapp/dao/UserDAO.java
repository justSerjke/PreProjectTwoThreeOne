package ru.justserjke.crudapp.dao;

import ru.justserjke.crudapp.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    void removeById(Long id);

    User findById(Long id);
}
