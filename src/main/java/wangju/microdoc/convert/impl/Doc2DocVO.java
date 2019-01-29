package wangju.microdoc.convert.impl;

import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wangju.microdoc.convert.Convert;
import wangju.microdoc.model.domain.Doc;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.model.vo.DocVo;
import wangju.microdoc.service.UserService;


@Log
@Component
public class Doc2DocVO implements Convert<Doc, DocVo> {

    private final
    UserService userService;

    @Autowired
    public Doc2DocVO(UserService userService) {
        this.userService = userService;
    }

    @Override
    public DocVo apply(Doc doc) {
        DocVo vo = new DocVo();
        BeanUtils.copyProperties(doc, vo);
        log.info("user id = " + doc.getUserId());
        log.info(userService.toString());
        User user = userService.get(doc.getUserId());
        User2UserVO user2UserVO = new User2UserVO();
        vo.setUser(user2UserVO.convert(user));
        return vo;
    }
}
