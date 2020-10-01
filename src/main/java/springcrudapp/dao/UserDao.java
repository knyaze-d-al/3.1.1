package springcrudapp.dao;

import springcrudapp.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void editUser(User user);

    void removeUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
