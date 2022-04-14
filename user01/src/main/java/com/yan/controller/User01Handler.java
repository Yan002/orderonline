package com.yan.controller;

import com.yan.entity.User;
import com.yan.entity.UserVO;
import com.yan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class User01Handler {

    @Autowired
    private UserRepository userRepository;

    /*@GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit")int limit){
        return userRepository.findAll(index,limit);
    }*/
    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        /*UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userRepository.count());
        userVO.setData(userRepository.findAll((page-1)*limit,limit));
        return userVO;*/
        return new UserVO(0,"",userRepository.count(),userRepository.findAll(index,limit));
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id){
        return userRepository.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return userRepository.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

}


