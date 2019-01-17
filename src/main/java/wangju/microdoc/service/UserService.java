package wangju.microdoc.service;

import wangju.microdoc.domain.User;

public interface UserService {
    public User get(long id);

    public User get(String username);

    public int create(User user);
}
