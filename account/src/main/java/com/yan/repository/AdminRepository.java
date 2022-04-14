package com.yan.repository;

import com.yan.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
    public Admin login(String username, String password);
}
