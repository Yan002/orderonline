package com.yan.repository;

import com.yan.entity.Type;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository {
    public Type findById(long id);
}
