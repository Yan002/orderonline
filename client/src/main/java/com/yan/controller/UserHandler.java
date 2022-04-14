package com.yan.controller;

import com.yan.entity.User;
import com.yan.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/*import com.yan.feign.OrderFeign;*/

@Controller
@RequestMapping("/user")
public class UserHandler {

@Autowired
private com.yan.feign.UserFeign UserFeign;

/*
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }
*/

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        /*int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(UserFeign.count());
        userVO.setData(UserFeign.findAll(index,limit));
        return userVO;*/
        int index = (page-1)*limit;
        return UserFeign.findAll(index,limit);
    }


    @GetMapping("/count")
    public int count() {
        return UserFeign.count();
    }

    @PostMapping("/save")
    public String save( User user){
        user.setRegisterdate(new Date());
        UserFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        UserFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }

/*
    @PutMapping("/update")
    public void update(@RequestBody User user){
        UserFeign.update(user);
    }
*/

}
