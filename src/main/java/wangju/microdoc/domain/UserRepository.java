package wangju.microdoc.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User getUser(Long id);
}
