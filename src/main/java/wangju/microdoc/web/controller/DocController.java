package wangju.microdoc.web.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wangju.microdoc.model.dto.DocDto;
import wangju.microdoc.service.DocService;
import wangju.microdoc.utils.ResultJson;

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
            @RequestParam( value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "20") int limit
    ) {
        Page<DocDto> docs = docService.page(page, limit);
        return ResultJson.body(docs);
    }
}
