package com.yan.feign;


import com.yan.entity.Menu;
import com.yan.entity.MenuVO;
import com.yan.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository /*表明这个类具有对对象进行CRUD(增删改查)的功能,*/
//关联微服务
@FeignClient(value="menu")/*匹配他在注册中心的名字,相当于到localhost8080*/
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")/*根据MenuHandler的配置来设置的路径*/
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")/*根据MenuHandler的配置来设置的路径*/
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    public void update(Menu menu);



}
