<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/21
  Time: 10:46 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common.jsp" %>
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
    <%
        // Java
        List<Map<String, String>> boardList = (List<Map<String, String>>) request.getAttribute("boardList");
        if (boardList != null) {
            for (int i = 0; i < boardList.size(); i++) {
                System.out.println("<tr>");
                Map<String, String> map = boardList.get(i);

                int print_level = Integer.parseInt(map.get("print_level"), 10);
                String blank = "";
                for (int j = 0; j < print_level; j++) {
                    blank += "&nbsp;&nbsp;&nbsp;";
                }
                if (print_level > 0) {
                    blank += "ㄴ";
                }

//                System.out.println(map.get("B_NO"));
                System.out.println("<td>" + blank + map.get("SUBJECT"));
                System.out.println("<td>" + map.get("WRITER"));
                System.out.println("<td>" + map.get("reg_date"));
                System.out.println("<td>" + map.get("readcount"));
            }
        }
    %>
</form>
</body>
</html>
