package wangju.microdoc.web.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.exception.UnauthorizedException;
import wangju.microdoc.service.AuthService;
import wangju.microdoc.service.TokenService;
import wangju.microdoc.service.UserService;
import wangju.microdoc.utils.ResultJson;
import wangju.microdoc.validators.LoginForm;
import wangju.microdoc.validators.RegisterForm;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Log
public class AuthController {

    private final AuthService authService;
    private final TokenService tokenService;
    private  final UserService userService;

    @Autowired
    public AuthController(AuthService authService, TokenService tokenService, UserService userService) {
        this.authService = authService;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Object login(@Valid LoginForm loginForm) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        User user = authService.check(username, password);
        if (user == null) {
            throw new UnauthorizedException();
        }
        String token = tokenService.getToken(user);

        JSONObject data = new JSONObject();
        data.put("token", token);
        data.put("user", user);
        return ResultJson.body(data);
    }

    @PostMapping("/register")
    public Object register(@Valid RegisterForm registerForm) {

        String username = registerForm.getUsername();
        User user = userService.get(username);
        if (user != null){
            return ResultJson.err("用户已存在");
        }
        user = new User();
        user.setUsername(username);
        String password = BCrypt.hashpw(registerForm.getPassword(),BCrypt.gensalt());
        log.info(password);
        user.setPassword(password);
        userService.create(user);
        return ResultJson.ok("创建成功");
    }
}
