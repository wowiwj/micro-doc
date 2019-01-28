package wangju.microdoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangju.microdoc.convert.impl.Doc2DocDTO;
import wangju.microdoc.model.domain.DocRepository;
import wangju.microdoc.model.dto.DocDTO;
import wangju.microdoc.service.DocService;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository docRepository;
    private final Doc2DocDTO doc2DocDTO;

    @Autowired
    public DocServiceImpl(DocRepository docRepository,Doc2DocDTO doc2DocDTO) {
        this.docRepository = docRepository;
        this.doc2DocDTO = doc2DocDTO;
    }

    @Override
    public Page<DocDTO> page(int page, int size) {
        PageHelper.startPage(page,size);
        return doc2DocDTO.convertPage(docRepository.all());
    }
}
