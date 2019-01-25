package wangju.microdoc.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import wangju.microdoc.domain.Doc;
import wangju.microdoc.domain.User;

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

    public static DocDTO transform(Doc doc) {


        return new DocDTO();
    }

}
