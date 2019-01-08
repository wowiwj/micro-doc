package wangju.microdoc.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.validators.LoginForm;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @RequestMapping("/login")
    public Object login(@Valid LoginForm loginForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors();
        }
        return loginForm.toString();
    }
}
