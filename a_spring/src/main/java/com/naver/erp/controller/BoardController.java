package com.naver.erp.controller;

import com.naver.erp.BoardDTO;
import com.naver.erp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList.do")
    public ModelAndView getBoardList() {

        // 게시판 목록 얻기
        List<Map<String, String>> boardList = this.boardService.getBoardList();

        // ModelAndView 객체 생성
        ModelAndView mav = new ModelAndView();
        mav.setViewName("boardList.jsp");

        // 객체의 addObject 메소드로 저장된 DB 연동 결과물은 HttpServletRequest 객체에도 저장된다.
        mav.addObject("boardList", boardList);

        return mav;
    }

    @RequestMapping(value = "/boardRegForm.do")
    // required 는 값이 반드시 들어와야하는지의 유무를 체크한다.
    // defaultValue 는 null 값이 들어올 경우 기본적으로 주는 값이다.
    public ModelAndView goBoardRegForm(@RequestParam(value = "b_no", required = false, defaultValue = "0") int b_no) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("boardRegForm.jsp");
        return mav;
    }

    @PostMapping("/boardRegProc.do")
    @ResponseBody
    public int insertBoard(BoardDTO boardDTO) {
        /*
         파라미터값을 저장할 객체를 매개변수로 선언

         파라미터명과 BoardDTO 객체의 속성변수명이 같으면
         setter 메소드가 작동되어 파라미터값이 속성변수에 저장된다.
         속성변수명에 대응하는 파라미터명이 없으면 setter 메소드가 작동되지 않는다.
         속성변수명에 대응하는 파라미터명이 있는데 파라미터값이 없으면 속성변수의 자료형에 관계없이 null 값이 저장된다.
         이 때 속성변수의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
         이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String 으로 해야한다.
         이런 에러가 발생하면 메소드 안의 실행구문은 하나도 실행되지 않는다.
         매개변수로 들어온 DTO 객체는 이 메소드가 끝난 후 호출되는 JSP 페이지로 그대로 이동한다.
         즉, HttpServletRequest 객체에 boardDTO 라는 키값명으로 저장된다.
        */
/*
        System.out.println("boardDTO.getWriter() = " + boardDTO.getWriter());
        System.out.println("boardDTO.getSubject() = " + boardDTO.getSubject());
        System.out.println("boardDTO.getContent() = " + boardDTO.getContent());
        System.out.println("boardDTO.getPwd() = " + boardDTO.getPwd());
        System.out.println("boardDTO.getEmail() = " + boardDTO.getEmail());
*/
        try {
            return this.boardService.insertBoard(boardDTO);
        } catch (Exception ex) {
            System.out.println("예외 발생");
        }


        return this.boardService.insertBoard(boardDTO);
    }

    @PostMapping("/boardContentForm.do")
    public ModelAndView goBoardContentForm(@RequestParam("b_no") int b_no) {
        System.out.println("b_no = " + b_no);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("boardContentForm.jsp");

        BoardDTO board = this.boardService.getBoard(b_no);
        mav.addObject("board", board);

        return mav;
    }
}
