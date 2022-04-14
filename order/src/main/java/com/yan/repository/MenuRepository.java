package com.yan.repository;

import com.yan.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository {

    public Menu findById(long id);


}
