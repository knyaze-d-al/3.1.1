package springcrudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcrudapp.model.User;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
