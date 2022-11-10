package org.example.naverpay.member.controller.login;

import org.example.naverpay.session.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class FirstPageController { // 로그인 후 첫 화면

    private SessionMgr sessionMgr;

    @Autowired
    public FirstPageController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @RequestMapping(value = "/firstpage", method = RequestMethod.GET)
    public String firstPage(Locale locale, Model model, HttpServletRequest request, HttpSession session) {


        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("mId", sessionMgr.get(session));
        }

        return "/member/login/firstpage";
    }

}
