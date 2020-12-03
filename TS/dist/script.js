"use strict";
function timeForm() {
    function getWeeks(weekNo) {
        return ['일', '월', '화', '수', '목', '금', '토'][weekNo];
    }
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    var date = today.getDate();
    var week = getWeeks(today.getDay());
    var hour = today.getHours();
    var minute = today.getMinutes();
    var sec = today.getSeconds();
    var isAM = '오전';
    if (hour > 12) {
        isAM = '오후';
        hour -= 12;
    }
    var result = year + "\uB144 " + month + "\uC6D4 " + date + "\uC77C " + week + "\uC694\uC77C " + isAM + " " + hour + "\uC2DC " + minute + "\uBD84 " + sec + "\uCD08";
    document.getElementById('nowTime').innerHTML = result;
}
function timer() {
    document.getElementById('second').innerHTML = '5';
    location.href = 'http://www.naver.com';
}
window.onload = function () {
    window.setInterval(function () { return timer(); }, 5 * 1000);
    window.setInterval(function () { return timeForm(); }, 1 * 1000);
};
//# sourceMappingURL=script.js.map