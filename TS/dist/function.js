"use strict";
function checkRegisterNum(num) {
    var regExp = new RegExp(/^\d{6}-?\d{7}$/);
    return regExp.test(num);
}
function checkPhone(num) {
    if (num === 1) {
        var phone1 = document.myForm.phone1.value;
        var regexp = new RegExp(/^\d{0,3}$/);
        var result_1 = regexp.test(phone1);
        if (!result_1) {
            console.log('핸드폰 앞자리는 숫자 3개여야합니다.');
            document.myForm.phone1.value = '';
        }
        if (phone1.length === 3) {
            document.myForm.phone2.focus();
        }
    }
    else if (num === 2) {
        var phone1 = document.myForm.phone1.value;
        var phone2 = document.myForm.phone2.value;
        var regexp = new RegExp(/^\d{0,4}$/);
        var result_2 = regexp.test(phone2);
        if (phone1.length === 0) {
            console.log('첫번째 자리부터 입력해주세요.');
            document.myForm.phone2.value = '';
            document.myForm.phone1.focus();
        }
        if (phone1.length < 3) {
            console.log('첫번째 자리의 번호가 모자랍니다.');
            document.myForm.phone1.focus();
        }
        if (!result_2) {
            console.log('핸드폰 두번째 자리는 숫자 4개여야합니다.');
            document.myForm.phone2.value = '';
        }
        if (phone2.length === 4) {
            document.myForm.phone3.focus();
        }
    }
    else if (num === 3) {
        var phone1 = document.myForm.phone1.value;
        var phone2 = document.myForm.phone2.value;
        var phone3 = document.myForm.phone3.value;
        var regexp = new RegExp(/^\d{0,4}$/);
        var result_3 = regexp.test(phone3);
        if (phone1.length === 0) {
            console.log('첫번째 자리부터 입력해주세요.');
            document.myForm.phone3.value = '';
            document.myForm.phone1.focus();
        }
        if (phone2.length < 4) {
            console.log('두번째 자리의 번호가 모자랍니다.');
            document.myForm.phone2.focus();
        }
        if (!result_3) {
            console.log('핸드폰 세번째 자리는 숫자 4개여야합니다.');
            document.myForm.phone3.value = '';
        }
    }
}
function validatePhone(num) {
    var phone1 = document.myForm.phone1.value;
    var phone2 = document.myForm.phone2.value;
    var phone3 = document.myForm.phone3.value;
    if (num === 1) {
        if (phone1.length !== 3) {
            console.log('첫번째 자리의 숫자가 모자랍니다.');
            document.myForm.phone1.focus();
            return;
        }
    }
    else if (num === 2) {
        if (phone2.length !== 4) {
            console.log('두번째 자리의 숫자가 모자랍니다.');
            document.myForm.phone2.focus();
            return;
        }
    }
    else if (num === 3) {
        if (phone3.length !== 4) {
            console.log('세번째 자리의 숫자가 모자랍니다.');
            document.myForm.phone3.focus();
            return;
        }
    }
}
function residentNum(num) {
    var rrn1 = document.myForm.rr1;
    var rrn2 = document.myForm.rr2;
    if (num === 1) {
    }
}
//# sourceMappingURL=function.js.map