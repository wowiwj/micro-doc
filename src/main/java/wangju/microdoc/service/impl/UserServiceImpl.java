package wangju.microdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.domain.User;
import wangju.microdoc.domain.UserRepository;
import wangju.microdoc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(long id) {
        return userRepository.get(id);
    }

    @Override
    public User get(String username) {
        return userRepository.getByName(username);
    }

    @Override
    public int create(User user) {
        return userRepository.create(user);
    }
}
