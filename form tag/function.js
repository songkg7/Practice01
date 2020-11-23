// check 함수 선언
function checkMemForm() {
  // alert("test");
  const uid = document.memRegForm.uid.value;

  // 아이디를 가져와서 변수 uid로 테스트
  const regExpID = new RegExp(/^[a-z][a-z\d_]{4,9}$/);
  if (regExpID.test(uid) === false) {
    alert("아이디의 형식이 다릅니다.");
    return;
  }

  // 비밀번호를 가져와서 변수 pwd로 테스트
  const pwd = document.memRegForm.pwd.value;
  const regExpPWD = new RegExp(/^[a-z0-9_]{8,10}$/);
  if (regExpPWD.test(pwd) === false) {
    alert("올바른 패스워드 형식이 아닙니다.");
    return;
  }

  // 전화번호 유효성 체크
  const phone = document.memRegForm.phone_num.value;
  const regExpPN = new RegExp(/^\d{9,11}$/);
  if (regExpPN.test(phone) == false) {
    alert("올바른 전화번호형식이 아닙니다.");
    return;
  }
}
