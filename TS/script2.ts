// https://heropy.blog/2020/01/27/typescript/ 문제해결 참고

// pattern validation
function checkPattern(val: any, regExp: any, msg: string): void {
  if (regExp.test(val.value) === false) {
    console.log(msg);
    val.value = '';
    val.focus();
  }
}

function checkId(): void {
  const uid = <HTMLInputElement>document.getElementById('uid');
  const value = uid.value;
  if (value === '') {
    console.log('ID를 입력해주세요.');
  } else {
    checkPattern(uid, /^[a-z][a-z\d_]{5,14}$/, 'ID의 형식이 다릅니다.');
  }
}

function checkPwd(): void {
  checkPattern(
    <HTMLInputElement>document.getElementById('pwd'),
    /^\w{5,9}$/,
    'Password의 형식이 다릅니다.',
  );
}

// pwd confirm
function confirmPwd(): void {
  const checkPwd = <HTMLInputElement>document.getElementById('checkPwd');
  const regExp = /^\w{5,9}$/;
  if (regExp.test(checkPwd.value) === false) {
    console.log('Password가 일치하지 않습니다.');
    checkPwd.value = '';
    checkPwd.focus();
  }
}

// checkbox validation
// 2개 이상 체크되도록 할 것
function checkBoxCnt(): number {
  const skill: any = document.getElementsByName('skill');
  let cnt = 0;
  for (let i = 0; i < skill.length; i++) {
    if (skill[i].checked === true) {
      cnt++;
    }
  }
  return cnt;
}

// graduate validation
function checkGraduate(): void {
  const school: any = document.getElementsByName('school');
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
function checkAddress(): void {
  const addr = <HTMLInputElement>document.getElementById('addr');
  const value = addr.value;
  if (value === '') {
    console.log('주소지를 선택해주세요.');
  }
}

// birthday validation (HTML5)
function checkBirth(): void {
  const date = <HTMLInputElement>document.getElementById('birthday');
  const value = date.value;
  if (value === '') {
    console.log('생일을 선택해주세요.');
  }
}

function checkForm(): void {
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
button!.onclick = () => {
  checkForm();
};
