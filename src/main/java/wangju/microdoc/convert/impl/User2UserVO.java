package wangju.microdoc.convert.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import wangju.microdoc.convert.Convert;
import wangju.microdoc.model.domain.User;
import wangju.microdoc.model.vo.UserVO;

@Component
public class User2UserVO implements Convert<User, UserVO> {
    @Override
    public UserVO apply(User user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
