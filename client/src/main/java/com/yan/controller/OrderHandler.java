package com.yan.controller;

import com.yan.entity.*;
import com.yan.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session){
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        orderFeign.save(order);
        return "index.html";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid( page, limit,user.getId());
    }

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return orderFeign.findAll(index,limit);
    }


    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") long id){
        orderFeign.updateState(id);
        return "redirect:/account/redirect/order_handler";
    }
}
