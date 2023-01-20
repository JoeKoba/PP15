package kata.jdbc.service;

import kata.jdbc.dao.UserDao;
import kata.jdbc.model.User;

import java.util.List;

public class UserServiceDaoImpl implements UserService {

    //    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDao userDao;

    public UserServiceDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
