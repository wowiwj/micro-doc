package wangju.microdoc.domain;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository {
    Page<Doc> all();
}
