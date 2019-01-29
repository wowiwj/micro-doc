package wangju.microdoc.model.vo;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.pagehelper.Page;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageVo {

    private Object list;

    private long totalCount;

    private int pageSize;

    private int pageLimit;

    private int totalPage;

    public static PageVo transform(Page page) {
        PageVo pageVo = new PageVo();
        pageVo.list = page.getResult();
        pageVo.totalCount = page.getTotal();
        pageVo.pageSize = page.getPageSize();
        pageVo.pageLimit = page.getPageNum();
        pageVo.totalPage = page.getPages();
        return pageVo;
    }
}
