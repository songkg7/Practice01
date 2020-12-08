// https://heropy.blog/2020/01/27/typescript/ 문제해결 참고

// pattern validation
function checkPattern(val: any, regExp: RegExp, msg: string): void {
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

function getCheckCnt(arr: any): number {
  let cnt = 0;
  // 일반 반복문
  // for (let i = 0; i < arr.length; i++) {
  //   if (arr[i].checked === true) {
  //     cnt++;
  //   }
  // }

  // forEach문
  arr.forEach((item: { checked: boolean }) => {
    if (item.checked === true) {
      cnt++;
    }
  });
  return cnt;
}

// checkbox validation
// 2개 이상 체크되도록 할 것
function checkBoxCnt(): void {
  const skill: any = document.getElementsByName('skill');
  if (getCheckCnt(skill) < 2) {
    console.log('스킬은 두개 이상 체크해야합니다.');
  }
}

// graduate validation
function checkGraduate(): void {
  const school: any = document.getElementsByName('school');
  if (getCheckCnt(school) !== 1) {
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
  } else {
    const regNum = <HTMLInputElement>document.getElementById('firstRegNum');
    // 정규식 패턴을 좀 더 공부하면 코드를 줄일 수 있다.
    regNum.value = value.replace(/^\d{2}/, '').replace(/-/g, '');
  }
}

// picture validation
function checkPic(): void {
  const picture = <HTMLInputElement>document.getElementById('pic');
  const { value } = picture;
  if (value === '') {
    console.log('파일 선택은 필수입니다.');
  }
}

// notice validation
function checkNotice(): void {
  const notice = <HTMLInputElement>document.getElementById('notice');
  if (!notice.checked) {
    console.log('숙지사항에 체크해주세요.');
  }
}

// Last validity
function checkForm(): void {
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

const selectDate = document.getElementById('birthday');
selectDate!.onchange = function () {
  checkBirth();
};

// result
const button = document.getElementById('saveBt');
button!.onclick = () => {
  checkForm();
};
