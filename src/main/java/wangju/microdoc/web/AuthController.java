package wangju.microdoc.web;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.annotation.PassToken;
import wangju.microdoc.domain.User;
import wangju.microdoc.service.AuthService;
import wangju.microdoc.service.TokenService;
import wangju.microdoc.validators.LoginForm;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Log
public class AuthController {

    private final
    AuthService authService;

    private final
    TokenService tokenService;

    @Autowired
    public AuthController(AuthService authService, TokenService tokenService) {
        this.authService = authService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public Object login(@Valid LoginForm loginForm) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        User user = authService.check(username,password);

        if (user == null){
            throw new RuntimeException("401");
        }
        String token = tokenService.getToken(user);
        JSONObject result = new JSONObject();
        result.put("token",token);
        result.put("user",user);
        return result;
    }
}
