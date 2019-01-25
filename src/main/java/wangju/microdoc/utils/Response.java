package wangju.microdoc.utils;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer status = 200;
    private Object message = "ok";
    private Object data = new int[0];

    public static Response init() {
        return new Response();
    }

    public Response status(int status) {
        this.status = status;
        return this;
    }

    public Response message(Object message) {
        this.message = message;
        return this;
    }

    public Response data(Object data) {
        this.data = this.format(data);
        return this;
    }

    public ResponseEntity<Response> build() {
        return ResponseEntity.status(this.status).body(this);
    }


    public static ResponseEntity<Response> ok(Object message, Object data) {
        return Response.init().message(message).data(data).build();
    }

    public static ResponseEntity<Response> ok(Object message) {
        return Response.init().message(message).build();
    }

    public static ResponseEntity<Response> body(Object data) {
        return Response.init().message("ok").data(data).build();
    }

    public static ResponseEntity<Response> err(Object message) {
        return Response.init().status(400).message(message).build();
    }

    public static ResponseEntity<Response> err(Object message, int status) {
        return Response.init().status(status).status(status).message(message).build();
    }

    protected Object format(Object data) {
        if (data instanceof Page) {
            JSONObject json = new JSONObject();
            json.put("content", data);
            json.put("total", ((Page) data).getTotal());
            json.put("size", ((Page) data).getPageSize());
            json.put("limit", ((Page) data).getPageNum());
            json.put("pages",((Page) data).getPages());
            return json;
        }
        return data;
    }
}
