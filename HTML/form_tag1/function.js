// check 함수 선언
function checkMemForm() {
  const formObj = document.memRegForm;

  // ID validation
  const uid = formObj.uid.value;
  let regExp = new RegExp(/^[a-z][a-z\d_]{4,9}$/);
  if (regExp.test(uid) === false) {
    alert('아이디의 형식이 다릅니다.');
    // value init
    formObj.uid.value = '';
    return;
  }
  // -------------------------------------------------
  // 1. password validation
  const pwd = formObj.pwd.value;
  regExp = new RegExp(/^[a-z0-9_]{8,10}$/);
  if (regExp.test(pwd) === false) {
    alert('올바른 패스워드 형식이 아닙니다.');
    formObj.pwd.value = '';
    return;
  }
  // -------------------------------------------------
  // 2. phone number validation
  const phone = formObj.phone_num.value;
  regExp = new RegExp(/^01(?:0|1|[6-9])[.-]?(\d{4})[.-]?(\d{4})$/);
  if (regExp.test(phone) === false) {
    alert('옳은 전화번호 형식이 아닙니다.');
    formObj.phone_num.value = '';
    return;
  }
  // -------------------------------------------------
  // 3. skill checkbox validation
  let skill_cnt = 0;
  const skillList = formObj.skill;

  // forEach 구문 활용
  skillList.forEach(element => {
    if (element.checked === true) {
      skill_cnt++;
    }
  });

  // 일반적인 for 문
  // for (let i = 0; i < formObj.skill.length; i++) {
  //   if (formObj.skill[i].checked === true) {
  //     skill_cnt++;
  //   }
  // }

  if (skill_cnt === 0) {
    alert('스킬은 하나 이상 체크해야합니다.');
    return;
  }
  // -------------------------------------------------
  // 4. Education validation
  let sch_cnt = 0;
  const schList = formObj.school;
  schList.forEach(element => {
    if (element.checked === true) {
      sch_cnt++;
    }
  });
  if (sch_cnt === 0) {
    alert('학력은 하나를 체크해야합니다.');
    return;
  }
  // -------------------------------------------------
  // 5. religion validation
  const religion = formObj.religion.value;
  if (religion === '') {
    alert('종교를 선택해야합니다.');
    return;
  }
  // -------------------------------------------------
  // 6. picture validation
  const pic = formObj.pic.value;
  if (pic === '') {
    alert('사진을 넣어주세요');
    return;
  }
  // -------------------------------------------------
  // 7. introduce validation
  let intro = formObj.introduce.value;

  while (intro.indexOf(' ') >= 0 || intro.indexOf('\n') >= 0) {
    intro = intro.replace(' ', '');
    intro = intro.replace('\n', '');
  }
  if (intro === '') {
    alert('자기소개를 입력해주세요');
    return;
  }
  // -------------------------------------------------
  if (confirm('정말 전송할까요?') === false) {
    return;
  }
  alert('Pass validation');
}
