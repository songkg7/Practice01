<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/20
  Time: 5:30 오후
  To change this template use File | Settings | File Templates.
--%>
<%@include file="common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form name="loginForm" method="post" action=""></form>
</center>
<script>
    function checkLoginForm() {
        const admin_id = $('admin_id').val();
    }

    $.ajax({
        url: "/a_spring/loginProc.do",
        type: "post",
        data : {'admin_id':admin_id, 'pwd': pwd},
        success: function (admin_idCnt) {
            alert(admin_idCnt);
            if (admin_idCnt === 1) {
                alert('ajaxSuccess');
                location.replace("/a_spring/boardList.do")
            } else {
                alert('login fail');
            }
        },

        // 서버의 응답을 받지 못했을 경우
        error: function () {
            alert('fail server connect');
        }
    })
</script>
</body>
</html>
