package springcrudapp.service;

import springcrudapp.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void editUser(User user);

    void removeUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
