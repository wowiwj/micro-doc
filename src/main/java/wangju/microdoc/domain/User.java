package wangju.microdoc.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import wangju.microdoc.enumeration.SexEnum;

@Alias("user")
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private SexEnum sex;
    private String avatar;
    private String bio;
    private String createTime;
    private String lastActiveTime;
}
