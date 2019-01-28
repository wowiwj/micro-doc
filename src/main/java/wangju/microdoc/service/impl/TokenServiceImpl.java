package wangju.microdoc.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        String token = "";
        token = JWT.create()
                .withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
