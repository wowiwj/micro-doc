package wangju.microdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.domain.User;
import wangju.microdoc.domain.UserRepository;
import wangju.microdoc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(long id) {
        return userRepository.getUser(id);
    }
}
