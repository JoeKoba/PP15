package kata.jdbc;


import kata.jdbc.model.User;
import kata.jdbc.service.UserService;
import kata.jdbc.service.UserServiceHibernateImpl;

public class Main {
    private static final UserService userService = new UserServiceHibernateImpl();

    private static final User user1 = new User("user1", "user1", (byte) 33);
    private static final User user2 = new User("user2", "user2", (byte) 33);
    private static final User user3 = new User("user3", "user3", (byte) 33);
    private static final User user4 = new User("user4", "user4", (byte) 33);
    public static void main(String[] args) {

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
