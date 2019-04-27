package com.wcy.audio_visual_club_membership_service_system.controller;

import com.wcy.audio_visual_club_membership_service_system.pojo.*;
import com.wcy.audio_visual_club_membership_service_system.service.OrderProductService;
import com.wcy.audio_visual_club_membership_service_system.service.OrderService;
import com.wcy.audio_visual_club_membership_service_system.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private ProductService productService;

    @RequestMapping("/order")
    public ModelAndView order(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("order", orderService.selectByPrimaryKey(id));
        OrderProductExample orderProductExample = new OrderProductExample();
        OrderProductExample.Criteria orderProductExampleCriteria = orderProductExample.createCriteria();
        orderProductExampleCriteria.andOrderIdEqualTo(id);
        modelAndView.addObject("products", orderProductService.selectByExample(orderProductExample));
        return modelAndView;
    }

    @RequestMapping("/order/delete")
    public ModelAndView delete(HttpSession session, @RequestParam("id") int id) {
        orderService.deleteByPrimaryKey(id);
        return orders(session);
    }

    @RequestMapping("/order/add")
    public ModelAndView add(HttpSession session, @RequestParam("pid") int pid, @RequestParam("num") int num) {
        if (session.getAttribute("identity") == null) {
            return new ModelAndView("login");
        }
        ModelAndView modelAndView = new ModelAndView("order");
        Member member = (Member) session.getAttribute("user");
        OrderInfoExample orderExample = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(member.getId());
        criteria.andStatusEqualTo("new");
        OrderInfo order;
        if (orderService.selectByExample(orderExample) == null || orderService.selectByExample(orderExample).isEmpty()) {
            order = new OrderInfo();
            order.setMemberId(((Member) session.getAttribute("user")).getId());
            orderService.insertSelective(order);
        }
        order = orderService.selectByExample(orderExample).get(0);
        OrderProductKey orderProductKey = new OrderProductKey();
        orderProductKey.setOrderId(order.getId());
        orderProductKey.setProductId(pid);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrderId(order.getId());
        orderProduct.setProductId(pid);
        orderProduct.setPrice(productService.selectByPrimaryKey(pid).getPrice());
        if (orderProductService.selectByPrimaryKey(orderProductKey) == null) {
            orderProduct.setNumber(num);
            orderProductService.insert(orderProduct);
        } else {
            orderProduct.setNumber(num + orderProductService.selectByPrimaryKey(orderProductKey).getNumber());
            orderProductService.updateByPrimaryKeySelective(orderProduct);
        }
        return order(order.getId());
    }

    @RequestMapping("/order/product/modify")
    public ModelAndView modify(@RequestParam("pid") int pid, @RequestParam("num") int num, @RequestParam("id") int id) {
        OrderProductKey orderProductKey = new OrderProductKey();
        orderProductKey.setOrderId(id);
        orderProductKey.setProductId(pid);
        OrderProduct orderProduct = orderProductService.selectByPrimaryKey(orderProductKey);
        orderProduct.setNumber(num);
        orderProductService.updateByPrimaryKeySelective(orderProduct);
        return order(id);
    }

    @RequestMapping("/order/product/delete")
    public ModelAndView deleteProduct(@RequestParam("pid") int pid, @RequestParam("id") int id) {
        OrderProductKey orderProductKey = new OrderProductKey();
        orderProductKey.setOrderId(id);
        orderProductKey.setProductId(pid);
        orderProductService.deleteByPrimaryKey(orderProductKey);
        return order(id);
    }

    @RequestMapping("/order/submit")
    public ModelAndView submit(HttpSession session, @RequestParam("id") int id, @RequestParam("place") String place) {
        OrderInfo order = orderService.selectByPrimaryKey(id);
        order.setStatus("submitted");
        order.setPlace(place);
        order.setOrderDate(new Date());
        orderService.updateByPrimaryKeySelective(order);
        return orders(session);
    }

    @RequestMapping("/order/deliver")
    public ModelAndView deliver(HttpSession session, @RequestParam("id") int id) {
        OrderInfo order = orderService.selectByPrimaryKey(id);
        order.setStatus("delivered");
        order.setDiliveryDate(new Date());
        orderService.updateByPrimaryKeySelective(order);
        return orders(session);
    }

    @RequestMapping("/orders")
    public ModelAndView orders(HttpSession session) {
        if (session.getAttribute("identity") == null) {
            return new ModelAndView("login");
        } else if (session.getAttribute("identity").equals("staff")) {
            ModelAndView modelAndView = new ModelAndView("orders");
            OrderInfoExample orderExample = new OrderInfoExample();
            OrderInfoExample.Criteria criteria = orderExample.createCriteria();
            criteria.andStatusEqualTo("submitted");
            modelAndView.addObject("orders", orderService.selectByExample(orderExample));
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("orders");
        if (session.getAttribute("identity").equals("staff")) {
            modelAndView.addObject("orders", orderService.selectByExample(new OrderInfoExample()));
            return modelAndView;
        }
        Member member = (Member) session.getAttribute("user");
        OrderInfoExample orderExample = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(member.getId());
        orderExample.setOrderByClause("order_date DESC");
        modelAndView.addObject("orders", orderService.selectByExample(orderExample));
        return modelAndView;
    }
}
