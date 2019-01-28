package wangju.microdoc.service;

import wangju.microdoc.model.domain.User;


public interface TokenService {
    public String getToken(User user);
}
