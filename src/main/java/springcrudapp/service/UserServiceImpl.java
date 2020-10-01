package springcrudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcrudapp.dao.UserDao;
import springcrudapp.dao.UserDaoJpa;
import springcrudapp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = new UserDaoJpa();

    @Override
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    @Override
    public void editUser(User user) {

        userDao.editUser(user);
    }

    @Override
    public void removeUserById(int id) {

        userDao.removeUserById(id);
    }

    @Override
    public User getUserById(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}
