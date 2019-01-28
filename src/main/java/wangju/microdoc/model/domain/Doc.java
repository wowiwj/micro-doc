package wangju.microdoc.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("doc")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Doc {
    private Long id;
    private String name;
    private String brief;
    private String headerUrl;
    private Long userId;
    private Timestamp deleteTime;
    private Timestamp createTime;
    private Timestamp updateTime;
}