package wangju.microdoc.service;

import com.github.pagehelper.Page;
import wangju.microdoc.model.domain.Doc;

public interface DocService {
    Page<Doc> page(int page, int size);
}
