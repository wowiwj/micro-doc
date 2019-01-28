package wangju.microdoc.convert;


import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Convert<S, T> extends Function<S, T> {

    default T convert(final S source) {
        T transform = null;
        if (source != null) {
            transform = this.apply(source);
        }
        return transform;
    }

    default List<T> convertList(final List<S> source) {
        List<T> transform = new ArrayList<T>();
        if (source != null) {
            transform = source.stream().map(this).collect(Collectors.toList());
        }
        return transform;
    }

    default Page<T> convertPage(final Page<S> source) {
        Page<T> transform = new Page<>();
        if (source != null) {
            transform = source.stream().map(this).collect(Collectors.toCollection(Page::new));
            transform.setPageSize(source.getPageSize());
            transform.setTotal(source.getTotal());
            transform.setPageNum(source.getPageNum());
        }
        return transform;
    }

}
