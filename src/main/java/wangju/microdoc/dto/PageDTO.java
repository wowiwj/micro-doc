package wangju.microdoc.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.pagehelper.Page;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("user")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageDTO {

    private Object list;

    private long total;

    private int size;

    private int limit;

    private int totalPage;

    public static PageDTO transform(Page page) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.list = page.getResult();
        pageDTO.total = page.getTotal();
        pageDTO.size = page.getPageSize();
        pageDTO.limit = page.getPageNum();
        pageDTO.totalPage = page.getPages();
        return pageDTO;
    }
}
