package wangju.microdoc.service;

import org.springframework.stereotype.Service;
import wangju.microdoc.domain.User;


public interface TokenService {
    public String getToken(User user);
}
