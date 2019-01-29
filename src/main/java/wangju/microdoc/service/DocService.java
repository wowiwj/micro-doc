package wangju.microdoc.service;

import com.github.pagehelper.Page;
import wangju.microdoc.model.dto.DocDto;

public interface DocService {
    Page<DocDto> page(int page, int size);
}
