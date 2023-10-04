package pdp.core.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.core.models.entities.User;
import pdp.core.models.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() { return this.userRepository.findAll(); }

    public User create(User user) { return this.userRepository.save(user); }
}
