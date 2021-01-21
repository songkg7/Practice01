<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/21
  Time: 10:46 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common.jsp"%>
<head>
    <title>게시판 목록</title>
    <script>
        function goBoardRegForm() {
            alert("goBoardRegForm test");
            location.replace("/boardRegForm.do");
        }
    </script>
</head>
<body>
<form name="boardListForm" method="post" action="/boardList.do">
    <a href="javascript:goBoardRegForm();">[새 글쓰기]</a>
</form>
</body>
</html>
