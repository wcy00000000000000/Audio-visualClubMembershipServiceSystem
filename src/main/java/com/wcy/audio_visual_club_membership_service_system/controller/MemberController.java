package com.wcy.audio_visual_club_membership_service_system.controller;


import com.wcy.audio_visual_club_membership_service_system.pojo.Member;
import com.wcy.audio_visual_club_membership_service_system.pojo.MemberExample;
import com.wcy.audio_visual_club_membership_service_system.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Resource
    private MemberService memberService;

    @RequestMapping("/user")
    public ModelAndView user(HttpSession session) {
        if (session.getAttribute("identity") == null) {
            return new ModelAndView("login");
        } else if (session.getAttribute("identity").equals("staff")) {
            ModelAndView modelAndView = new ModelAndView("users");
            modelAndView.addObject("users", memberService.selectByExample(new MemberExample()));
            return modelAndView;
        } else {
            return new ModelAndView("user");
        }
    }

    @RequestMapping("/user/change")
    public ModelAndView change() {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("change", true);
        return modelAndView;
    }

    @RequestMapping("/user/modify")
    public String modify(HttpSession session, Member member) {
        memberService.updateByPrimaryKeySelective(member);
        session.setAttribute("user", member);
        return "user";
    }

    @RequestMapping("/user/delete")
    public ModelAndView delete(@RequestParam("id") int id) {
        memberService.deleteByPrimaryKey(id);
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", memberService.selectByExample(new MemberExample()));
        return modelAndView;
    }

    @RequestMapping("/user/detail")
    public String detail(HttpSession session, @RequestParam("id") int id) {
        session.setAttribute("user", memberService.selectByPrimaryKey(id));
        return "user";
    }

}
