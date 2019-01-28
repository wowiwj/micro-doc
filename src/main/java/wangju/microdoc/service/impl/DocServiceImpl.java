package wangju.microdoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.convert.impl.Doc2DocVO;
import wangju.microdoc.model.domain.DocRepository;
import wangju.microdoc.model.vo.DocVO;
import wangju.microdoc.service.DocService;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository docRepository;
    private final Doc2DocVO doc2DocVO;

    @Autowired
    public DocServiceImpl(DocRepository docRepository,Doc2DocVO doc2DocVO) {
        this.docRepository = docRepository;
        this.doc2DocVO = doc2DocVO;
    }

    @Override
    public Page<DocVO> page(int page, int size) {
        PageHelper.startPage(page,size);
        return doc2DocVO.convertPage(docRepository.all());
    }
}
