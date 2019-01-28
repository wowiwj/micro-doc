package wangju.microdoc.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.domain.User;

import java.sql.Timestamp;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DocDTO {
    private Long id;
    private String name;
    private String brief;
    private String headerUrl;
    private User user;
    private Timestamp deleteTime;
    private Timestamp createTime;
    private Timestamp updateTime;
}
