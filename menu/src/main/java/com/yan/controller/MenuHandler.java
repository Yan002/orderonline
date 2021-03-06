package com.yan.controller;

import com.yan.entity.Menu;
import com.yan.entity.MenuVO;
import com.yan.entity.Type;
import com.yan.repository.MenuRepository;
import com.yan.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/index")
    public String index(){ return this.port; }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return new MenuVO(0,"",menuRepository.count(),menuRepository.findAll(index,limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findTypes();
    }
    @PostMapping("/save")/*映射过来的是json数组，要处理一下才能接收*/
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }


}
