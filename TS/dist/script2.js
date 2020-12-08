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
    var pwd = document.getElementById('pwd');
    var value = pwd.value;
    if (value === '') {
        console.log('Password를 입력해주세요.');
    }
    else {
        checkPattern(pwd, /^\w{5,9}$/, 'Password의 형식이 다릅니다.');
    }
}
function confirmPwd() {
    var checkPwd = document.getElementById('checkPwd');
    var value = checkPwd.value;
    if (value === '') {
        console.log('Password를 확인해주세요.');
    }
    checkPattern(checkPwd, /^\w{5,9}$/, 'Password가 일치하지 않습니다.');
}
function getCheckCnt(arr) {
    var cnt = 0;
    arr.forEach(function (item) {
        if (item.checked === true) {
            cnt++;
        }
    });
    return cnt;
}
function checkBoxCnt() {
    var skill = document.getElementsByName('skill');
    if (getCheckCnt(skill) < 2) {
        console.log('스킬은 두개 이상 체크해야합니다.');
    }
}
function checkGraduate() {
    var school = document.getElementsByName('school');
    if (getCheckCnt(school) !== 1) {
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
    else {
        var regNum_1 = document.getElementById('firstRegNum');
        regNum_1.value = value.replace(/^\d{2}/, '').replace(/-/g, '');
    }
}
function checkPic() {
    var picture = document.getElementById('pic');
    var value = picture.value;
    if (value === '') {
        console.log('파일 선택은 필수입니다.');
    }
}
function checkNotice() {
    var notice = document.getElementById('notice');
    if (!notice.checked) {
        console.log('숙지사항에 체크해주세요.');
    }
}
function checkForm() {
    checkId();
    checkPwd();
    confirmPwd();
    checkBoxCnt();
    checkGraduate();
    checkAddress();
    checkBirth();
    checkPic();
    checkNotice();
}
var selectDate = document.getElementById('birthday');
selectDate.onchange = function () {
    checkBirth();
};
var button = document.getElementById('saveBt');
button.onclick = function () {
    checkForm();
};
//# sourceMappingURL=script2.js.map