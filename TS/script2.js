// pattern validation
function checkPattern(val, regExp, msg) {
  if (regExp.test(val.value) === false) {
    console.log(msg);
    val.value = '';
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
  const { uid } = document.memberRegForm;
  if (uid.value === '') {
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
  checkPattern(document.memberRegForm.pwd, /^\w{5,9}$/, 'Password의 형식이 다릅니다.');
}

// pwd confirm
function confirmPwd() {
  const { checkPwd } = document.memberRegForm;
  const regExp = /^\w{5,9}$/;
  if (regExp.test(checkPwd.value) === false) {
    console.log('Password가 일치하지 않습니다.');
    checkPwd.value = '';
    checkPwd.focus();
  }
}

// checkbox validation
// 2개 이상 체크되도록 할 것
function checkBoxCnt() {
  const { skill } = document.memberRegForm;
  let cnt = 0;
  for (let i = 0; i < skill.length; i++) {
    if (skill[i].checked === true) {
      cnt++;
    }
  }
  return cnt;
}

// graduate validation
function checkGraduate() {
  const { school } = document.memberRegForm;
  let cnt = 0;
  for (let i = 0; i < school.length; i++) {
    if (school[i].checked === true) {
      cnt++;
    }
  }
  if (cnt !== 1) {
    console.log('학력은 반드시 체크해야합니다.');
  }
}

// address validation
function checkAddress() {
  const addr = document.memberRegForm.addr.value;
  if (addr === '') {
    console.log('주소지를 선택해주세요.');
  }
}

// birthday validation (HTML5)
function checkBirth() {
  const date = document.memberRegForm.birthday.value;
  if (date === '') {
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

// result
const button = document.getElementById('saveBt');
button.onclick = () => {
  checkForm();
};
