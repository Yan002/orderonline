package com.yan.controller;

import com.yan.entity.Admin;
import com.yan.entity.User;
import com.yan.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;


    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap)object;
        String result = null;
        long id = 0L;
        if(object == null){
            result = "login";
        }else{
            if ("user".equals(type)) {
                User user = new User();
                id = Long.parseLong(String.valueOf(hashMap.get("id")));
                String nickname = (String)hashMap.get("nickname");
                user.setId(id);
                user.setNickname(nickname);
                session.setAttribute("user", user);
                result = "index";
            } else if ("admin".equals(type)) {
                Admin admin = new Admin();
                id = Long.parseLong(String.valueOf(hashMap.get("id")));
                String username1 = (String)hashMap.get("username");
                admin.setId(id);
                admin.setUsername(username1);
                session.setAttribute("admin", admin);
                result = "main.html";
            }
        }
        return result;
    }

    /*注销*/
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }



}
