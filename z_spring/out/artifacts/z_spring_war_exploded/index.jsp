<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/19
  Time: 10:57 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="loginForm" method="post" action="/z_spring/loginProc">
    <b>[로그인]</b>
    <table class="tbcss1" border="1" cellpadding="5" cellspacing="0" bordercolor="gray" width="220"
           height="80">
        <tr>
            <th bgcolor="#7fffd4">아이디</th>
        </tr>
    </table>
</form>

<script>
    $(() => {

        // name=loginForm 태그 안에 class = login 태그에 click 이벤트 발생시 실행할 함수 설정
        $("[name=loginForm] .login").on('click', function () {
            checkLoginForm();
        });
    });

    function checkLoginForm() {
        // alert("click login");
        const admin_id = $('.admin_id').val();
        if (admin_id.split(" ").join("") === "") {
            alert("관리자 아이디 입력 요망");
            $('.admin_id').val("");
        }

        const pwd = $('.pwd').val();
        if (pwd.split(" ").join("") === "") {
            alert("관리자 암호를 입력해주세요.");
            $('.pwd').val("");
        }

        $.ajax({
            url: "/z_spring/loginProc.do",
            type: "post",
            data: {'admin_id': admin_id, 'pwd': pwd},
            success: function (admin_idCnt) {
                if (admin_idCnt === 1) {
                    alert("로그인 성공");
                } else {
                    alert("입력하신 아이디 또는 암호가 틀립니다.");
                }
            },
            error: function () {
                alert("서버 접속 실패");
            }

        })

    }

</script>
</body>
</html>
