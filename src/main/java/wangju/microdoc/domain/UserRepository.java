package wangju.microdoc.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    public User get(Long id);

    public User getByName(String username);

    int create(User user);
}
