package wangju.microdoc.web.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.convert.impl.Doc2DocVO;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.vo.DocVO;
import wangju.microdoc.service.DocService;
import wangju.microdoc.utils.ResultJson;

import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocController {

    private final DocService docService;


    @Autowired
    public DocController(DocService docService) {
        this.docService = docService;

    }

    @GetMapping
    public Object all(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "20") int limit
    ) {
        Page<DocVO> docs = docService.page(page, limit);
        return ResultJson.body(docs);
    }
}
