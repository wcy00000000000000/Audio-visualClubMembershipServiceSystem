package com.wcy.audio_visual_club_membership_service_system.controller;

import com.wcy.audio_visual_club_membership_service_system.pojo.Member;
import com.wcy.audio_visual_club_membership_service_system.pojo.Product;
import com.wcy.audio_visual_club_membership_service_system.pojo.ProductExample;
import com.wcy.audio_visual_club_membership_service_system.service.MemberService;
import com.wcy.audio_visual_club_membership_service_system.service.ProductService;
import com.wcy.audio_visual_club_membership_service_system.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginLogoutRegisterController {

    @Resource
    private ProductService productService;
    @Resource
    private MemberService memberService;
    @Resource
    private StaffService staffService;

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause("release_date DESC");
        List<Product> products = productService.selectByExample(productExample);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, @RequestParam("account") String account, @RequestParam("password") String password) {
        if (staffService.selectByPrimaryKey(account) != null) {
            if (staffService.selectByPrimaryKey(account).getPassword().equals(password)) {
                session.setAttribute("identity", "staff");
                session.setAttribute("user", staffService.selectByPrimaryKey(account));
                return index();
            }
        } else if (memberService.selectByAccount(account) != null) {
            if (memberService.selectByAccount(account).getPassword().equals(password)) {
                session.setAttribute("identity", "member");
                session.setAttribute("user", memberService.selectByAccount(account));
                return index();
            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("warning", "incorrect account or password");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("identity");
        session.removeAttribute("user");
        return index();
    }

    @RequestMapping("/register")
    public ModelAndView register(HttpSession session, @RequestParam("account") String account, @RequestParam("password") String password) {
        if (staffService.selectByPrimaryKey(account) != null) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("warning", "account already exists");
            return modelAndView;
        } else if (memberService.selectByAccount(account) != null) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("warning", "account already exists");
            return modelAndView;
        }
        Member member = new Member();
        member.setAccount(account);
        member.setPassword(password);
        memberService.insertSelective(member);
        session.setAttribute("identity", "member");
        session.setAttribute("user", staffService.selectByPrimaryKey(account));
        return index();
    }
}
