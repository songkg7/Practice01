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
  const { value } = uid;
  if (value === '') {
    console.log('ID를 입력해주세요.');
  } else {
    checkPattern(uid, /^[a-z][a-z\d_]{5,14}$/, 'ID의 형식이 다릅니다.');
  }
}

function checkPwd(): void {
  const pwd = <HTMLInputElement>document.getElementById('pwd');
  const { value } = pwd;
  if (value === '') {
    console.log('Password를 입력해주세요.');
  } else {
    checkPattern(pwd, /^\w{5,9}$/, 'Password의 형식이 다릅니다.');
  }
}

// pwd confirm
function confirmPwd(): void {
  const checkPwd = <HTMLInputElement>document.getElementById('checkPwd');
  const { value } = checkPwd;
  if (value === '') {
    console.log('Password를 확인해주세요.');
  }
  // pwd 의 정규식 패턴이 변경될 경우 수정시 에러날 확률이 높으므로 코드 수정 필요
  checkPattern(checkPwd, /^\w{5,9}$/, 'Password가 일치하지 않습니다.');
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
  const { value } = addr;
  if (value === '') {
    console.log('주소지를 선택해주세요.');
  }
}

// birthday validation (HTML5)
function checkBirth(): void {
  const date = <HTMLInputElement>document.getElementById('birthday');
  const { value } = date;
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