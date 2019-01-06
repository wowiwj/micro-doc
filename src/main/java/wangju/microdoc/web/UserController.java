package wangju.microdoc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wangju.microdoc.annotation.JwtAuth;
import wangju.microdoc.domain.User;
import wangju.microdoc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> all() {
        return new ArrayList<>();
    }

    @PostMapping
    User newUser(@RequestBody User newUser) {
        return new User();
    }

    @JwtAuth
    @GetMapping("/{id}")
    User one(@PathVariable Long id, HttpServletRequest request) {
        request.getAttribute("currentUser");
        User user = userService.getUser(id);
        logger.info(String.valueOf(user.getPassword()));
        return user;
    }

    @PutMapping
    User updateUser(@RequestBody User user, @PathVariable Long id) {
        return new User();
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {

    }
}
