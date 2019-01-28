package wangju.microdoc.web.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import wangju.microdoc.annotation.JwtAuth;
import wangju.microdoc.annotation.PassToken;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.exception.UnauthorizedException;
import wangju.microdoc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Log
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(JwtAuth.class)) {
            JwtAuth jwtAuth = method.getAnnotation(JwtAuth.class);
            if (!jwtAuth.required()) {
                return true;
            }
            if (token == null) {
                throw new UnauthorizedException();
            }

            String userId;
            try {
                userId = JWT.decode(token).getAudience().get(0);
            }catch (JWTDecodeException e){
                throw new UnauthorizedException();
            }

            User user = userService.get(Long.valueOf(userId));
            if (user == null){
                throw new UnauthorizedException();
            }

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                jwtVerifier.verify(token);
            }catch (JWTVerificationException e){
                throw new UnauthorizedException();
            }

            request.setAttribute("currentUser",user);
            return true;
        }
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//
//    }
}
