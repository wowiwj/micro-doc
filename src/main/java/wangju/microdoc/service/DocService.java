package wangju.microdoc.service;

import com.github.pagehelper.Page;
import wangju.microdoc.model.vo.DocVO;

public interface DocService {
    Page<DocVO> page(int page, int size);
}
