<%@ page import="com.naver.erp.BoardDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/22
  Time: 12:54 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common.jsp" %>
<head>
    <title>게시판 상세보기</title>
</head>
<body>
<%
    BoardDTO board = (BoardDTO) request.getAttribute("board");
%>
<b>[글 상세 보기]</b>
<table>
    <tr>
        <th>글번호</th>
        <td><%= board.getB_no()%>
        </td>
        <th>조회수</th>
        <td><%= board.getReadCount()%>
        </td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%= board.getWriter()%>
        </td>
        <th>작성일</th>
        <td><%= board.getReg_date()%>
        </td>
    </tr>
    <tr>
        <th>글제목</th>
        <td><%= board.getSubject()%>
        </td>
        <th>글내용</th>
        <td>
            <label>
            <textarea name="content" rows="13" cols="45" style="border: 0" readonly>
                <%=board.getContent()%>
            </textarea>
            </label>
        </td>
    </tr>
</table>
<input type="button" value="댓글쓰기" onclick="location.replace('/a_spring/boardRegForm.do<%=board.getB_no()%>')">
<input type="button" value="글 목록보기" onclick="location.replace('/a_spring/boardList.do')">
</body>
</html>
