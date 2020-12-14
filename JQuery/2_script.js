// jQuery 적용
// pattern validation
function checkPattern(val, regExp, msg) {
  if (regExp.test(val.val()) === false) {
    console.log(msg);
    val.val('');
    val.focus();
  }
}

// id check
// function checkId() {
//   const { uid } = document.memberRegForm;
//   const regExp = /^[a-z][a-z\d_]{5,14}$/;
//   if (regExp.test(uid.value)) {
//     console.log('아이디 형식이 맞습니다.');
//   } else {
//     console.log('아이디 형식이 아닙니다.');
//     uid.value = '';
//     uid.focus();
//   }
// }

function checkId() {
  const uid = $('.uid');
  if (uid.val() === '') {
    console.log('ID를 입력해주세요.');
  } else {
    checkPattern(uid, /^[a-z][a-z\d_]{5,14}$/, 'ID의 형식이 다릅니다.');
  }
}

// pwd validation
// function checkPwd() {
//   const { pwd } = document.memberRegForm;
//   const regExp = /^\w{5,9}$/;
//   if (regExp.test(pwd.value)) {
//     console.log('패스워드 형식이 맞습니다.');
//   } else {
//     console.log('패스워드 형식이 아닙니다.');
//     pwd.value = '';
//     pwd.focus();
//   }
// }

function checkPwd() {
  const pwd = $('.pwd');
  if (pwd.val() === '') {
    console.log('Password를 입력해주세요.');
  } else {
    checkPattern(pwd, /^\w{5,9}$/, 'Password의 형식이 다릅니다.');
  }
}

// pwd confirm
function confirmPwd() {
  const pwd = $('.pwd');
  const checkPwd = $('.checkPwd');
  // const regExp = /^\w{5,9}$/;
  if (pwd.val() !== checkPwd.val()) {
    console.log('Password가 일치하지 않습니다.');
    checkPwd.val('');
    checkPwd.focus();
  }
}

// checkbox validation
// 2개 이상 체크되도록 할 것
function checkBoxCnt() {
  const skillCnt = $('.skill:checked').length;
  if (skillCnt === 0) {
    console.log('스킬은 1개 이상 체크되어야 합니다.');
  }
}

// graduate validation
function checkGraduate() {
  const schoolCnt = $('.school:checked').length;
  if (schoolCnt !== 1) {
    console.log('학력은 반드시 체크해야합니다.');
  }
}

// address validation
function checkAddress() {
  const addr = $('.addr');
  if (addr.val() === '') {
    console.log('주소지를 선택해주세요.');
  }
}

// birthday validation (HTML5)
function checkBirth() {
  const date = $('.birthday');
  if (date.val() === '') {
    console.log('생일을 선택해주세요.');
  } else {
    $('.firstRegNum').val(
      date
        .val()
        .replace(/^\d{2}/, '')
        .replace(/-/g, ''),
    );
  }
}

function checkPic() {
  const picture = $('.pic');
  // const { value } = picture;
  if (picture.val() === '') {
    console.log('파일 선택은 필수입니다.');
  }
}

function checkCarrier() {
  const companyName = $('.companyName');
  const rank = $('.rank');
  const salary = $('.salary');
  const regExp = /^[1-9]\d*$/;
  if (salary.val() !== '' && !regExp.test(salary.val())) {
    console.log('연봉은 숫자만 입력가능합니다.');
    return false;
  }
  if (companyName.val() === '' && rank.val() === '' && salary.val() === '') {
    return true;
  }
  if (companyName.val() !== '' && salary.val() !== '') {
    return true;
  }
  if (rank.val() !== '') {
    if (companyName.val() !== '' && salary.val() !== '') {
      return true;
    }
  }
  return false;
}

function checkNotice() {
  const notice = $('.notice')[0];
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
  if (!checkCarrier()) {
    console.log('커리어의 입력양식을 지켜주세요.');
  }
  checkNotice();
}

// result
// $(document).ready(() => $('.saveMember').click(() => checkForm()));
// jQuery 3.0부터는 $(handler) 구문만 권장된다. 다른 구문은 여전히 작동하지만 더 이상 사용되지 않는다.
$(() => $('.saveMember').on('click', () => checkForm()));

// saveBt 이라는 id를 가진 요소를 선택해서 onclick event 실행
// const button = document.getElementById('saveBt');
// button.onclick = () => {
//   checkForm();
// };

// onChange
$('.birthday').on('change', () => checkBirth());
