package wangju.microdoc.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import wangju.microdoc.enumeration.SexEnum;

@Alias("user")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonProperty("gender")
    private SexEnum sex;
    private String avatar;
    private String bio;
    private String createTime;
    private String lastActiveTime;
}
