package kata.jdbc.service;

import kata.jdbc.dao.UserDao;
import kata.jdbc.model.User;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceHibernateImpl implements UserService {

    private UserDao userDao;

    public UserServiceHibernateImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    @Transactional
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}