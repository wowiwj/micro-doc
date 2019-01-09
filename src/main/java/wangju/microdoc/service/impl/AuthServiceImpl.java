package wangju.microdoc.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.annotation.JwtAuth;
import wangju.microdoc.domain.User;
import wangju.microdoc.domain.UserRepository;
import wangju.microdoc.service.AuthService;
import wangju.microdoc.service.UserService;

@Service
@Log
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User check(String username, String password) {

        User user = userRepository.getUserByUsername(username);
        if (user == null){
            return  null;
        }

        log.info(user.toString());
        log.info(user.getPassword());
        log.info(password);

        if (user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
