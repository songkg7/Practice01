<%--
  Created by IntelliJ IDEA.
  User: songkg7
  Date: 2021/01/21
  Time: 10:46 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>게시판 글쓰기</title>

</head>
<body>
<form name="boardRegForm" method="post" action="/boardRegProc.do">
    <b>[새 글쓰기]</b>
    <table class="tbcss1">
        <tr>
            <th>이 름</th>
            <td>
                <label>
                    <input type="text" size="10" maxlength="10" name="writer">
                </label>
            </td>
        </tr>
        <tr>
            <th>제 목</th>
            <td>
                <label>
                    <input type="text" size="40" maxlength="30" name="subject">
                </label>
            </td>
        </tr>
        <tr>
            <th>이 메 일</th>
            <td>
                <label>
                    <input type="text" size="40" maxlength="30" name="email">
                </label>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td>
                <label>
                    <textarea rows="13" cols="40" name="content"></textarea>
                </label>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <label>
                    <input type="password" size="8" maxlength="4" name="pwd">
                </label>
            </td>
        </tr>
    </table>
    <input type="button" value="저장" onclick="checkBoardRegForm();">
    <input type="reset" value="다시 작성">
    <input type="button" value="목록보기" onclick="document.boardListForm.submit();">
</form>
<form name="boardListForm" method="post" action="/boardRegForm.do">
</form>
<script>
    function checkBoardForm() {
        alert("validity Test");
        let writer = $('[name=writer]').val();
        if (writer.split(" ").join("") === "") {
            alert("이름을 입력해주세요");
            $('[name=writer]').focus();
            return;
        }

        let subject = $('[name=subject]').val();
        if (subject.split(" ").join("") === "") {
            alert("이름을 입력해주세요");
            $("[name=subject]").focus();
            return;
        }

        const email = $('[name=email]').val();
        if (email.split(" ").join("") === "") {
            alert("이름을 입력해주세요");
            $("[name=email]").focus();
            return;
        }

        const content = $('[name=content]').val();
        if (content.split(" ").join("") === "") {
            alert("이름을 입력해주세요");
            $("[name=content]").focus();
            return;
        }

        const pwd = $('[name=pwd]').val();
        if (content.split(" ").join("") === "") {
            alert("이름을 입력해주세요");
            $("[name=pwd]").focus();
        }

        if(new RegExp(/^[0-9]{4}$/).test(pwd) === false) {
            alert("암호는 숫자 4자리를 입력해주세요.");
        }

    }

    $.ajax({
        url : "/boardRegProc.do",
        type : "post",
        data : $('[name = boardRegForm]').serialize(),
        success: function (boardRegCnt) {
            if (boardRegCnt === 1) {
                alert("success");
            } else {
                alert("write fail")
            }
        },
        error: function () {
            alert("connection fail")
        }
    })
</script>
</body>
</html>
