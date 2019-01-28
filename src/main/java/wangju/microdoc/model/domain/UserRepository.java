package wangju.microdoc.model.domain;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    public User get(Long id);

    public User getByName(String username);

    int create(User user);

    Page<User> all();
}
