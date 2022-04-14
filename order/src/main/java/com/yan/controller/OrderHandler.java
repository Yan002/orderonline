package com.yan.controller;

import com.yan.entity.Order;
import com.yan.entity.OrderVO;
import com.yan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController /*相当于@Controller+@ResponseBody两个注解的结合*/
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "order的端口是：" + this.port;
    }

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        order.setDate(new Date());
        orderRepository.save(order);
    }

    /*    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
        public List<Order> findAll(@PathVariable("index")int index,@PathVariable("limit")int limit,@PathVariable("uid")int uid) {
            return orderRepository.findAllByUid(index,limit,uid);
        }*/
    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index, limit, uid));
        return orderVO;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index, limit));
        return orderVO;
    }

    /*    @GetMapping("/countByUid/{uid}")
        public int countByUid(@PathVariable("uid") int uid) {
            return orderRepository.countByUid(uid);
        }*/
    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id) {
        orderRepository.updateState(id);
    }


}
