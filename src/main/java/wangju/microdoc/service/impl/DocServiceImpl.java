package wangju.microdoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.domain.DocRepository;
import wangju.microdoc.service.DocService;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository docRepository;

    @Autowired
    public DocServiceImpl(DocRepository docRepository) {
        this.docRepository = docRepository;
    }

    @Override
    public Page<Doc> page(int page, int size) {
        PageHelper.startPage(page,size);
        return docRepository.all();
    }
}
