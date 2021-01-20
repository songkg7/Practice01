package com.naver.erp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// URL 주소로 접속하면 호출되는 메소드를 소유한 Controller 클래스를 선언
// @Controller 를 붙임으로써 컨트롤러 클래스임을 지정한다.
@Controller
public class LoginController {

    @RequestMapping(value = "loginForm.do")
    public ModelAndView loginForm() {

        // ModelAndView 객체 생성하기
        // 호출 JSP 페이지명을 저장하기
        // return

        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginForm.jsp");
        return mav;

    }

    @RequestMapping(value = "/loginProc.do", method = RequestMethod.POST, produces = "application/json; charset=UTF8")
    @ResponseBody
    public int getAdminIdCnt(HttpServletRequest request) {
        // String admin_id = request.getParameter("admin_id");
        // String pwd = request.getParameter("pwd");
        return 1;
    }

    @ResponseBody
    public int getAdminIdCnt2(@RequestParam(value = "admin_id") String admin_id, @RequestParam(value = "pwd") String pwd
    ) {
        System.out.println("admin_id = " + admin_id);
        System.out.println("pwd = " + pwd);
        return 1;
    }

}
