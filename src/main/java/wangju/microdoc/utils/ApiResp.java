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

    private Integer status = 200;
    private Object message = "ok";
    private Object data = new int[0];

    public static ApiResp init() {
        return new ApiResp();
    }

    public ApiResp status(int status) {
        this.status = status;
        return this;
    }

    public ApiResp message(Object message) {
        this.message = message;
        return this;
    }

    public ApiResp data(Object data) {
        this.data = data;
        return this;
    }

    public ResponseEntity<ApiResp> build() {
        return ResponseEntity.status(this.status).body(this);
    }


    public static ResponseEntity<ApiResp> ok(Object message, Object data) {
        return ApiResp.init().message(message).data(data).build();
    }

    public static ResponseEntity<ApiResp> ok(Object message) {
        return ApiResp.init().message(message).build();
    }

    public static ResponseEntity<ApiResp> body(Object data) {
        return ApiResp.init().message("ok").data(data).build();
    }

    public static ResponseEntity<ApiResp> err(Object message) {
        return ApiResp.init().status(400).message(message).build();
    }

    public static ResponseEntity<ApiResp> err(Object message, int status) {
        return ApiResp.init().status(status).status(status).message(message).build();
    }
}
