package wangju.microdoc.service.impl;

import lombok.extern.java.Log;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.model.domain.UserRepository;
import wangju.microdoc.service.AuthService;

@Service
@Log
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User check(String username, String password) {

        User user = userRepository.getByName(username);
        if (user == null){
            return  null;
        }

        log.info(user.toString());
        log.info(user.getPassword());
        log.info(password);

        boolean checked = false;
        try {
            checked = BCrypt.checkpw(password,user.getPassword());
        }catch (Exception e){
            return null;
        }
        if (checked){
            return user;
        }
        return null;
    }
}
