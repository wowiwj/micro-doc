package wangju.microdoc.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();

        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        JSONObject result = new JSONObject();
        result.put("message", msg);
        return result;
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Object validateException(BindException e) {
        List<ObjectError> errors = e.getAllErrors();
        Object[] messageErr = errors.stream().map(err -> {
            if(err instanceof FieldError){
                FieldError fieldError = (FieldError)err;
                String message = "";
                message += fieldError.getField();
                message += ":";
                message += fieldError.getDefaultMessage();
                return message;
            }
            return err.getDefaultMessage();
        }).toArray();

        JSONObject result = new JSONObject();
        result.put("message", messageErr);
        return result;
    }

}
