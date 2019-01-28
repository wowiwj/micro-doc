package wangju.microdoc.model.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.pagehelper.Page;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageDTO {

    private Object list;

    private long totalCount;

    private int pageSize;

    private int pageLimit;

    private int totalPage;

    public static PageDTO transform(Page page) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.list = page.getResult();
        pageDTO.totalCount = page.getTotal();
        pageDTO.pageSize = page.getPageSize();
        pageDTO.pageLimit = page.getPageNum();
        pageDTO.totalPage = page.getPages();
        return pageDTO;
    }
}
