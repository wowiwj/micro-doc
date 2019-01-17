package wangju.microdoc.web;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.domain.User;
import wangju.microdoc.service.AuthService;
import wangju.microdoc.service.TokenService;
import wangju.microdoc.service.UserService;
import wangju.microdoc.utils.ApiResp;
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
            throw new RuntimeException("401");
        }
        String token = tokenService.getToken(user);
        JSONObject result = new JSONObject();
        result.put("token", token);
        result.put("user", user);
        return result;
    }

    @PostMapping("/register")
    public Object register(@Valid RegisterForm registerForm) {

        String username = registerForm.getUsername();
        User user = userService.get(username);
        if (user != null){
            return ApiResp.err("用户已存在");
        }
        user = new User();
        user.setUsername(username);
        String password = BCrypt.hashpw(registerForm.getPassword(),BCrypt.gensalt());
        log.info(password);
        user.setPassword(password);
        int result = userService.create(user);
        return ApiResp.ok("创建成功");
    }
}
