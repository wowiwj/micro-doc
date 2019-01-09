package wangju.microdoc.service;

import wangju.microdoc.domain.User;

public interface AuthService {
    public User check(String username, String password);
}
