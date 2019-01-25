package wangju.microdoc.web;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wangju.microdoc.annotation.JwtAuth;
import wangju.microdoc.annotation.PassToken;
import wangju.microdoc.domain.User;
import wangju.microdoc.service.UserService;
import wangju.microdoc.utils.Response;

import javax.servlet.http.HttpServletRequest;

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
    @PassToken
    ResponseEntity<Response> all(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "20") int limit
    ) {
        Page<User> users = userService.page(page,limit);
        return Response.body(users);
    }

    @PostMapping
    User newUser(@RequestBody User newUser) {
        return new User();
    }

    @JwtAuth
    @GetMapping("/{id}")
    User one(@PathVariable Long id, HttpServletRequest request) {
        request.getAttribute("currentUser");
        User user = userService.get(id);
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
