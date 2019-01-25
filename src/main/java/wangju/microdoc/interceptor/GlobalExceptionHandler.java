package wangju.microdoc.interceptor;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wangju.microdoc.exception.UnauthorizedException;
import wangju.microdoc.utils.Response;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();

        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return Response.err(msg);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public Object handleUnAuthorizedException() {
        return Response.err("未授权", 401);
    }

    @ExceptionHandler(BindException.class)
    public Object validateException(BindException e) {
        List<ObjectError> errors = e.getAllErrors();
        Object[] messageErr = errors.stream().map(err -> {
            FieldError fieldError = (FieldError) err;
            String message = "";
            message += fieldError.getField();
            message += ":";
            message += fieldError.getDefaultMessage();
            return message;
        }).toArray();
        return Response.err(messageErr,422);
    }

}
