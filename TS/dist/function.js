"use strict";
function checkRegisterNum(num) {
    var regExp = new RegExp(/^\d{6}-?\d{7}$/);
    return regExp.test(num);
}
//# sourceMappingURL=function.js.map