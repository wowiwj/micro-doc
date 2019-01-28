package wangju.microdoc.service;


import com.github.pagehelper.Page;
import wangju.microdoc.model.domain.User;

public interface UserService {
    User get(long id);

    User get(String username);

    int create(User user);

    Page<User> page(int page,int size);

}
