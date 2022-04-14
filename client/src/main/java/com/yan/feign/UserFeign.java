package com.yan.feign;

import com.yan.entity.User;
import com.yan.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user01")
public interface UserFeign {

/*
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
*/

    @GetMapping("/user/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/update")
    public void update(@RequestBody User user);

}