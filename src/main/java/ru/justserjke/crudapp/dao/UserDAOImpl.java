package ru.justserjke.crudapp.dao;

import org.springframework.stereotype.Repository;
import ru.justserjke.crudapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void removeById(Long id) {
        entityManager.createQuery("delete User where id =:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public User findById(Long id) {
        return entityManager.createQuery("from User where id =:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

