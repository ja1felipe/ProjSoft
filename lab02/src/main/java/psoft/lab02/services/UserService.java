package psoft.lab02.services;

import org.springframework.stereotype.Service;
import psoft.lab02.entities.user.User;
import psoft.lab02.repositories.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo<User, String> userDAO;

    public UserService(UserRepo<User, String> userDAO){
        super();
        this.userDAO = userDAO;
    }

    public User addUser(User user) {
        this.userDAO.save(user);
        return user;
    }

    public Optional<User> getUser(String email){
        return this.userDAO.findByEmail(email);
    }
}
