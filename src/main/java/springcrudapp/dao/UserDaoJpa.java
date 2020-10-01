package springcrudapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springcrudapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoJpa implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        entityManager.merge(entityManager.find(User.class, user.getId()));
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
