function checkRegisterNum(num: string): boolean {
  const regExp = new RegExp(/^\d{6}-?\d{7}$/);
  return regExp.test(num);
}

function checkPhone(num: number): void {
  const form = document.myForm;
  // 첫번째 자리 검사
  if (num === 1) {
    const phone1: string = form.phone1.value;
    const regexp = new RegExp(/^\d{0,3}$/);
    const result: boolean = regexp.test(phone1);
    if (!result) {
      console.log('핸드폰 앞자리는 숫자 3개여야합니다.');
      form.phone1.value = '';
      //   return;
    }
    if (phone1.length === 3) {
      form.phone2.focus();
    }
    // 두번째 자리 검사
  } else if (num === 2) {
    const phone1: string = form.phone1.value;
    const phone2: string = form.phone2.value;
    const regexp = new RegExp(/^\d{0,4}$/);
    const result: boolean = regexp.test(phone2);
    if (phone1.length === 0) {
      console.log('첫번째 자리부터 입력해주세요.');
      form.phone2.value = '';
      form.phone1.focus();
      //   return;
    }
    if (phone1.length < 3) {
      console.log('첫번째 자리의 번호가 모자랍니다.');
      form.phone1.focus();
      //   return;
    }
    if (!result) {
      console.log('핸드폰 두번째 자리는 숫자 4개여야합니다.');
      form.phone2.value = '';
      //   return;
    }
    if (phone2.length === 4) {
      form.phone3.focus();
    }
    // 세번째 자리 검사
  } else if (num === 3) {
    const phone1: string = form.phone1.value;
    const phone2: string = form.phone2.value;
    const phone3: string = form.phone3.value;
    const regexp = new RegExp(/^\d{0,4}$/);
    const result = regexp.test(phone3);
    if (phone1.length === 0) {
      console.log('첫번째 자리부터 입력해주세요.');
      form.phone3.value = '';
      form.phone1.focus();
      //   return;
    }
    if (phone2.length < 4) {
      console.log('두번째 자리의 번호가 모자랍니다.');
      form.phone2.focus();
      //   return;
    }

    if (!result) {
      console.log('핸드폰 세번째 자리는 숫자 4개여야합니다.');
      form.phone3.value = '';
      //   return;
    }
  }
}

function validatePhone(num: number) {
  const form = document.myForm;
  const phone1: string = form.phone1.value;
  const phone2: string = form.phone2.value;
  const phone3: string = form.phone3.value;

  if (num === 1) {
    if (phone1.length !== 3) {
      console.log('첫번째 자리의 숫자가 모자랍니다.');
      form.phone1.focus();
      return;
    }
  } else if (num === 2) {
    if (phone2.length !== 4) {
      console.log('두번째 자리의 숫자가 모자랍니다.');
      form.phone2.focus();
      return;
    }
  } else if (num === 3) {
    if (phone3.length !== 4) {
      console.log('세번째 자리의 숫자가 모자랍니다.');
      form.phone3.focus();
      return;
    }
  }
}

// 주민등록번호 패턴
// 앞자리 중 3~6번째 숫자는 날짜를 벗어나면 안된다.
// 뒷자리 숫자중 첫번째가 3 또는 4 라면 앞자리는 00년생 이후여야한다.

function residentNum(num: number): void {
  const rrn1 = document.myForm.rr1;
  const rrn2 = document.myForm.rr2;

  if (num === 1) {
  }
  // const regExp = new RegExp(
  //   /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$/,
  // );
  // return regExp.test(num);
}
