package wangju.microdoc.convert.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import wangju.microdoc.convert.Convert;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.model.vo.UserVo;

@Component
public class User2UserVO implements Convert<User, UserVo> {
    @Override
    public UserVo apply(User user) {
        UserVo userVO = new UserVo();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
