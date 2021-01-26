<!-- ****************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- ****************************************************** -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고,이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다 -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="com.naver.erp.*"%>

<html>
<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여 -->
<!--								common.jsp 파일 내의 소스를 삽입하기 -->
<%@include file="common.jsp" %>
<head><title>게시판 상세보기</title>
    <script>
    </script>
</head>
<body><center>
        <%
			//-----------------------------------------------------------------
			// HttpServletRequest 객체에 "board" 라는 키값으로 저장된 객체 꺼내기
			// ModelAndView 객체에 addObject("board",board) 로 저장된 놈이다.
			//-----------------------------------------------------------------
			BoardDTO board = (BoardDTO)request.getAttribute("board");
		%>
    <b>[글 상세 보기]</b>
    <!----------------------------------------------------------->
    <table class="tbcss1" width="500" border=1 bordercolor="#DDDDDD" cellpadding="5" align="center">
        <tr align=center>
            <th width=60>글번호
            <td width=150><%out.print(board.getB_no());%>
            <th width=60>조회수
            <td width=150><%=board.getReadcount()%>
        <tr align=center>
            <th width=60>작성자
            <td width=150><%=board.getWriter()%>
            <th width=60>작성일
            <td width=150><%=board.getReg_date()%>
        <tr>
            <th>글제목
            <td width=150 colspan=3><%=board.getSubject()%>
        <tr>
            <th>글내용
            <td width=150 colspan=3>
					<textarea name="content" rows="13" cols="45" style="border:0" readonly>
						<%=board.getContent()%>
					</textarea>
    </table><br>
    <input type="button" value="댓글쓰기" onClick="location.replace('/z_spring/boardRegForm.do?b_no=<%=board.getB_no()%>')">&nbsp;
    <input type="button" value="글 목록 보기" onClick="location.replace('/z_spring/boardList.do')">
</body>
</html>