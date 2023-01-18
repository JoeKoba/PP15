package kata.jdbc.service;

import kata.jdbc.dao.UserDaoHibernateImpl;
import kata.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }

    //    private final SessionFactory sessionFactory = Util.getSessionFactory();
//
//    public UserServiceImpl() {
//
//    }
//
//    @Override
//    @Transactional
//    public void createUsersTable() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users" +
//                    " (id mediumint not null auto_increment, name VARCHAR(50), " +
//                    "lastname VARCHAR(50), " +
//                    "age tinyint, " +
//                    "PRIMARY KEY (id))").executeUpdate();
//
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    @Transactional
//    public void dropUsersTable() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    @Transactional
//    public void saveUser(String name, String lastName, byte age) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.save(new User(name, lastName, age));
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    @Transactional
//    public void removeUserById(long id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.delete(session.get(User.class, id));
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> userList = session.createQuery("select u from User u", User.class)
//                .getResultList();
//        try {
//            transaction.commit();
//            return userList;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            transaction.rollback();
//        } finally {
//            session.close();
//        }
//        return userList;
//    }
//
//    @Override
//    @Transactional
//    public void cleanUsersTable() {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.createNativeQuery("TRUNCATE TABLE users;").executeUpdate();
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//    }

}