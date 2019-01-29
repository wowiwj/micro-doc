package wangju.microdoc.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.service.UserService;

import java.sql.Timestamp;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DocDto {
    private Long id;
    private String name;
    private String brief;
    private String headerUrl;
    private User user;
    private Timestamp deleteTime;
    private Timestamp createTime;
    private Timestamp updateTime;
}
