package com.doubles.mvcboard.controller;

import java.util.List;
import java.util.Map;

import com.doubles.mvcboard.BoardDTO;
import com.doubles.mvcboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// 가상 URL 주소로 접속하며 호출되는 메소드를 소유한 [컨트롤러 클래스] 선언
// @Controller 를 붙임으로써 [컨트롤러 클래스]임을 지정한다.
@Controller
public class BoardController {
    // 속성변수 boardService 선언하고 [BoardService 인터페이스]를 구현받은 클래스를 찾아 객체 생성해 저장.
    // 관용적으로 [BoardService 인터페이스]를 구현받은 클래스명은 BoardServiceImpl 이다.
    // @Autowired 역할 -> 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
    // [인터페이스]를 구현한 [클래스]가 1개가 아니면 에러가 발생한다.
    // 단 @Autowired( required=false ) 로 선언하면 0개 이어도 에러없이 null 이 저장된다.
    // Spring 에서만 지원하는 어노테이션이다.
    @Autowired
    private BoardService boardService;


    // 가상주소 /boardListForm.do 로 접근하면 호출되는 메소드 선언
    //		@RequestMapping 내부에, method="ReqeustMethod.POST  가 없으므로
    //		가상주소 /boardListForm.do로 접근 시 get 또는 post 방식 접근 모두 허용한다.
    @RequestMapping(value = "/boardList.do")
    public ModelAndView getBoardList() {
        //*******************************************
        // [게시판 목록] 얻기
        //*******************************************
        // BoardService 인터페이스를 구현한 객체(=BoardServiceImpl) 소유의
        // getBoardList 메소드 호출해서 [게시판 목록]을
        // List<Map<String,String>> 객체로 얻기
        // 이 때 BoardService 인터페이스를 구현한 객체의 이름을 알 필요가 없다
        // 스프링이 알아서 찾아주기때문이다.
        List<Map<String, String>> boardList = this.boardService.getBoardList();

        // [ModelAndView 객체] 생성하기
        ModelAndView mav = new ModelAndView();
        // [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
        mav.setViewName("boardList.jsp");

        // [ModelAndView 객체]에  JSP 페이지에서 꺼내볼 게시판 목록이 저장된  List<Map<String,String> 객체 저장하기
        // [ModelAndView 객체]의 addObject 메소드로 저장된 DB 연동 결과물은 HttpServletRequest 객체에도 저장된다.
        mav.addObject("boardList", boardList);


        // [ModelAndView 객체] 리턴하기
        return mav;
    }

    // 가상주소 /boardRegForm.do 로 접근하면 호출되는 메소드 선언
    @RequestMapping(value = "/boardRegForm.do")
    public ModelAndView goBoardRegForm(
            //------------------------------------------------------------------------
            // 파라미터명이 b_no 인 파라마터값을 받아오는 매개변수 b_no 선언하기
            //------------------------------------------------------------------------
            @RequestParam(value = "b_no", required = false, defaultValue = "0") int b_no
            //            -----------         ------------------                            -----------------
            //          파라미터명 설정     파라미터명,값이 안들어와도 용서한다는 의미    파라미터값 없으면 0 저장
            //------------------------------------------------------------------------
            // 만약 required=true 거나  required=~ 가 없으면 반드시 파리미터값은 들어와야하고 안들어오면
            // 에러발생해서 메소드 안의 내용은 하나도 실행이 안된다.
            //------------------------------------------------------------------------

    ) {
        //------------------------------------------------------
        // [ModelAndView 객체] 생성하기
        //------------------------------------------------------
        ModelAndView mav = new ModelAndView();
        //------------------------------------------------------
        // [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
        //------------------------------------------------------
        mav.setViewName("boardRegForm.jsp");
        //------------------------------------------------------
        // [ModelAndView 객체]에  JSP 페이지에서 꺼내볼 게시판 pk 번호 저장하기
        // [ModelAndView 객체]의 addObject 메소드로 저장된 DB 연동 결과물은 HttpServletRequest 객체에도 저장된다.
        //------------------------------------------------------
        mav.addObject("b_no", b_no);
        //------------------------------------------------------
        // [ModelAndView 객체] 리턴하기
        //------------------------------------------------------
        return mav;
    }


    // /boardRegProc.do 로 접근하면 호출되는 메소드 선언
    @RequestMapping(
            value = "/boardRegProc.do"
            , method = RequestMethod.POST
            , produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public int insertBoard(
            //*******************************************
            // 파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
            //*******************************************
            // [파라미터명]과 [BoardDTO 객체]의 [속성변수명]이 같으면
            // setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다.
            // [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다.
            // [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면
            // [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다.
            // 이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
            // 이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String으로 해야한다.
            // 이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
            // 매개변수로 들어온 [DTO 객체]는 이 메소드가 끝난 후 호출되는 JSP 페이지로 그대로 이동한다.
            // 즉, HttpServletRequest 객체에 boardDTO 라는 키값명으로 저장된다.
            BoardDTO boardDTO
    ) {

        System.out.println("BoardController.insertBoard 안으로 들어옴");
        //-------------------------------------------
        // 게시판 글 입력하고 [게시판 입력 적용행의 개수] 저장할 변수 선언
        //-------------------------------------------
        int boardRegCnt = 0;
        try {
            //-------------------------------------------
            // [BoardServiceImpl 객체]의 insertBoard 메소드 호출로
            // 게시판 글 입력하고 [게시판 입력 적용행의 개수] 얻기
            //-------------------------------------------
            boardRegCnt = this.boardService.insertBoard(boardDTO);

            System.out.println("BoardController.insertBoard 실행 성공");
        } catch (Exception ex) {
            System.out.println("BoardController.insertBoard 메소드 실행 시 예외발생!");
            boardRegCnt = -1;
        }

        return boardRegCnt;
    }


    // /boardContentForm.do 접속 시 호출되는 메소드 선언
    @RequestMapping(
            value = "/boardContentForm.do"
    )
    public ModelAndView goBoardContentForm(
            //------------------------------------
            // b_no 라는 파라미터명에 해당하는 파라미터값이 저장되는 매개변수 b_no 선언
            // 관용적으로 파라미터명과 파라미터값 저장 변수의 스펠링은 동일하게 준다.
            // 게시판 PK 번호가 매개변수로 들어오므로 매개변수 자료형은 int 로한다.
            // String 으로 받아도 문제 없다.
            //------------------------------------
            @RequestParam(value = "b_no") int b_no
    ) {

        // [ModelAndView 객체] 생성하기
        ModelAndView mav = new ModelAndView();
        // [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
        mav.setViewName("boardContentForm.jsp");


        // [BoardServiceImpl 객체]의 getBoard 메소드 호출로 [1개의 게시판 글]을 BoardDTO 객체에 담아오기
        BoardDTO board = this.boardService.getBoard(b_no);


        // [ModelAndView 객체]에 검색한 BoardDTO 객체 저장하기
        // [ModelAndView 객체]의 addObject 메소드로 저장된 놈은 HttpServletRequest 객체에도 저장된다.
        mav.addObject("board", board);

        // [ModelAndView 객체] 리턴하기
        return mav;
    }
}

