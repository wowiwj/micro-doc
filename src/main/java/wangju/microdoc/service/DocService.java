package wangju.microdoc.service;

import com.github.pagehelper.Page;
import wangju.microdoc.model.dto.DocDTO;

public interface DocService {
    Page<DocDTO> page(int page, int size);
}
