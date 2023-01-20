package kata.jdbc.service;


import kata.jdbc.dao.UserDao;
import kata.jdbc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
