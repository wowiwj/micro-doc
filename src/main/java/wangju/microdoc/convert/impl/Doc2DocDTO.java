package wangju.microdoc.convert.impl;

import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wangju.microdoc.convert.Convert;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.model.dto.DocDto;
import wangju.microdoc.service.UserService;

@Component
@Log
public class Doc2DocDTO implements Convert<Doc, DocDto> {

    private final
    UserService userService;

    @Autowired
    public Doc2DocDTO(UserService userService) {
        this.userService = userService;
    }

    @Override
    public DocDto apply(Doc doc) {
        DocDto dto = new DocDto();
        BeanUtils.copyProperties(doc, dto);
        log.info("user id = " + doc.getUserId());
        log.info(userService.toString());
        User user = userService.get(doc.getUserId());
        dto.setUser(user);
        return dto;
    }

}
