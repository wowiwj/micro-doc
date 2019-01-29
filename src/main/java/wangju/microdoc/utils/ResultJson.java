package wangju.microdoc.utils;


import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import wangju.microdoc.model.vo.PageVo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson {

    private Integer status = 200;
    private Object message = "ok";
    private Object data = new int[0];

    public static ResultJson init() {
        return new ResultJson();
    }

    public ResultJson status(int status) {
        this.status = status;
        return this;
    }

    public ResultJson message(Object message) {
        this.message = message;
        return this;
    }

    public ResultJson data(Object data) {
        this.data = this.format(data);
        return this;
    }

    public ResponseEntity<ResultJson> build() {
        return ResponseEntity.status(this.status).body(this);
    }


    public static ResponseEntity<ResultJson> ok(Object message, Object data) {
        return ResultJson.init().message(message).data(data).build();
    }

    public static ResponseEntity<ResultJson> ok(Object message) {
        return ResultJson.init().message(message).build();
    }

    public static ResponseEntity<ResultJson> body(Object data) {
        return ResultJson.init().message("ok").data(data).build();
    }

    public static ResponseEntity<ResultJson> err(Object message) {
        return ResultJson.init().status(400).message(message).build();
    }

    public static ResponseEntity<ResultJson> err(Object message, int status) {
        return ResultJson.init().status(status).message(message).build();
    }

    private Object format(Object data) {
        if (data instanceof Page) {
            return PageVo.transform((Page) data);
        }
        return data;
    }
}
