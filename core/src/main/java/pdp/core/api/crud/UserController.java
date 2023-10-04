package pdp.core.api.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.core.models.entities.User;
import pdp.core.models.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return this.userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return this.userService.create(user);
    }
}
