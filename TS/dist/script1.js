"use strict";
var id = 'abc123!';
var password = '1234ffff';
var regExp = new RegExp(/^[a-z][a-z0-9_]{5,14}$/);
var regExpPwd = new RegExp(/^[a-z0-9_]{5,13}$/);
var result = regExp.test(id);
var resultPwd = regExpPwd.test(password);
if (result) {
    console.log(id + "\uB294 \uC801\uD569\uD55C \uD328\uD134\uC785\uB2C8\uB2E4.");
}
else {
    console.log(id + "\uB294 \uBD80\uC801\uD569\uD55C \uD328\uD134\uC785\uB2C8\uB2E4.");
}
if (resultPwd) {
    console.log(password + "\uB294 \uC801\uD569\uD55C \uD328\uD134\uC785\uB2C8\uB2E4.");
}
else {
    console.log(password + "\uB294 \uBD80\uC801\uD569\uD55C \uD328\uD134\uC785\uB2C8\uB2E4.");
}
var phoneNum = '010-7366-060';
var regExpPhone = new RegExp(/^01(0|1|6-9)[-]?\d{4}[-]?\d{4}$/);
var resultPhone = regExpPhone.test(phoneNum);
console.log(resultPhone);
var person = '차효ab';
var regExpStr = new RegExp(/^(([가-힣]{2,})|([a-zA-Z]{2,}))$/);
var resultStr = regExpStr.test(person);
console.log(resultStr);
var regist = '940403-3344354';
var regNum = new RegExp(/^\d{6}-?(1|3)\d{6}$/);
console.log(regNum.test(regist));
//# sourceMappingURL=script1.js.map