package wangju.microdoc.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DocVo {
    private Long id;
    private String name;
    private String brief;
    private String headerUrl;
    private UserVo user;
    private Timestamp deleteTime;
    private Timestamp createTime;
    private Timestamp updateTime;
}