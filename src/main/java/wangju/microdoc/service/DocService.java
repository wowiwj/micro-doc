package wangju.microdoc.service;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import wangju.microdoc.domain.Doc;

public interface DocService {
    Page<Doc> page(int page, int size);
}
