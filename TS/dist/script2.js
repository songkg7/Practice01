"use strict";
function checkPattern(val, regExp, msg) {
    if (regExp.test(val.value) === false) {
        console.log(msg);
        val.value = '';
        val.focus();
    }
}
function checkId() {
    var uid = document.getElementById('uid');
    var value = uid.value;
    if (value === '') {
        console.log('ID를 입력해주세요.');
    }
    else {
        checkPattern(uid, /^[a-z][a-z\d_]{5,14}$/, 'ID의 형식이 다릅니다.');
    }
}
function checkPwd() {
    checkPattern(document.getElementById('pwd'), /^\w{5,9}$/, 'Password의 형식이 다릅니다.');
}
function confirmPwd() {
    var checkPwd = document.getElementById('checkPwd');
    var regExp = /^\w{5,9}$/;
    if (regExp.test(checkPwd.value) === false) {
        console.log('Password가 일치하지 않습니다.');
        checkPwd.value = '';
        checkPwd.focus();
    }
}
function checkBoxCnt() {
    var skill = document.getElementsByName('skill');
    var cnt = 0;
    for (var i = 0; i < skill.length; i++) {
        if (skill[i].checked === true) {
            cnt++;
        }
    }
    return cnt;
}
function checkGraduate() {
    var school = document.getElementsByName('school');
    var cnt = 0;
    for (var i = 0; i < school.length; i++) {
        if (school[i].checked === true) {
            cnt++;
        }
    }
    if (cnt !== 1) {
        console.log('학력은 반드시 체크해야합니다.');
    }
}
function checkAddress() {
    var addr = document.getElementById('addr');
    var value = addr.value;
    if (value === '') {
        console.log('주소지를 선택해주세요.');
    }
}
function checkBirth() {
    var date = document.getElementById('birthday');
    var value = date.value;
    if (value === '') {
        console.log('생일을 선택해주세요.');
    }
}
function checkForm() {
    checkId();
    checkPwd();
    confirmPwd();
    if (checkBoxCnt() < 2) {
        console.log('스킬은 2개 이상 체크해야합니다.');
    }
    checkGraduate();
    checkAddress();
    checkBirth();
}
var button = document.getElementById('saveBt');
button.onclick = function () {
    checkForm();
};
//# sourceMappingURL=script2.js.map