package wangju.microdoc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResp {
    private Integer status;
    private String message;
    private Object data;

    public static ResponseEntity<ApiResp> ok(String message, Object data) {
        ApiResp body = new ApiResp(200, message, data);
        return ResponseEntity.ok().body(body);
    }

    public static ResponseEntity<ApiResp> ok(String message) {
        ApiResp body =  new ApiResp(200, message, new ArrayList<>());
        return ResponseEntity.ok().body(body);
    }

    public static ResponseEntity<ApiResp> err(String message) {
        ApiResp body =  new ApiResp(400, message, new ArrayList<>());
        return ResponseEntity.status(400).body(body);
    }
}
