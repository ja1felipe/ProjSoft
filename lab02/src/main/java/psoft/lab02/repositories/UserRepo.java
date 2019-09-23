package psoft.lab02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psoft.lab02.entities.user.User;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserRepo<T, ID extends Serializable> extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
