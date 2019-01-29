package wangju.microdoc.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import wangju.microdoc.enumeration.SexEnum;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserVo {
    private Long id;
    private String username;
    private SexEnum sex;
    private String avatar;
    private String bio;
    private String createTime;
    private String lastActiveTime;
}
