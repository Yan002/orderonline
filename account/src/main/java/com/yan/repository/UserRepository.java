package com.yan.repository;

import com.yan.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User login(String username, String password);
}
