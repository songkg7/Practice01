"use strict";
function timeForm() {
    function getWeeks(weekNo) {
        return ['일', '월', '화', '수', '목', '금', '토'][weekNo];
    }
    var nowTime = document.getElementById('nowTime');
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
    if (nowTime !== null) {
        nowTime.innerHTML = result;
    }
}
function timer(time) {
    var second = document.getElementById('second');
    if (second !== null) {
        second.innerHTML = "" + time;
        window.setInterval(function () {
            second.innerHTML = "" + --time;
            if (time === 0) {
                location.href = 'http://www.naver.com';
            }
        }, 1000);
    }
}
window.onload = function () {
    timer(5);
    window.setInterval(function () { return timeForm(); }, 1 * 1000);
};
//# sourceMappingURL=script.js.map