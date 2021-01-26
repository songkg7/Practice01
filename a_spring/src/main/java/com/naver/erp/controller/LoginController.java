package com.naver.erp.controller;

import com.naver.erp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("loginForm.do")
    public ModelAndView loginForm() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginForm.jsp");
        return mav;
    }

    //    @RequestMapping(value = "/loginProc.do", method = RequestMethod.POST, produces = "application/json; charset=UTF8")
//    @PostMapping("loginProc.do")
//    @ResponseBody
//    public int getAdminIdCnt(HttpServletRequest request) {
//
//        // String admin_id = request.getParameter("admin_id");
//        // String pwd = request.getParameter("pwd");
//        return 1;
//    }

    @PostMapping("loginProc.do")
    @ResponseBody
    public int getAdminIdCnt(@RequestParam("admin_id") String admin_id, @RequestParam("pwd") String pwd
    ) {
//        System.out.println("admin_id = " + admin_id);
//        System.out.println("pwd = " + pwd);
//        return 1;

        Map<String, String> map = new HashMap<>();
        map.put("admin_id", admin_id);
        map.put("pwd", pwd);

        return this.loginService.getAdminIdCnt(map);
    }
}
