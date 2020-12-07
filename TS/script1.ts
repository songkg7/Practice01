// function hello(name: string): void {
//   let firstName = 'song';
//   console.log(name + firstName);
// }

// function sum(a: number, b: number) {
//   return a + b;
// }

// console.log(sum(1, 6));
// hello('song');

// RegExp
const id = 'abc123!';
const password = '1234ffff';
const regExp = new RegExp(/^[a-z][a-z0-9_]{5,14}$/);
const regExpPwd = new RegExp(/^[a-z0-9_]{5,13}$/);

const result = regExp.test(id);
const resultPwd = regExpPwd.test(password);

if (result) {
  console.log(`${id}는 적합한 패턴입니다.`);
} else {
  console.log(`${id}는 부적합한 패턴입니다.`);
}

if (resultPwd) {
  console.log(`${password}는 적합한 패턴입니다.`);
} else {
  console.log(`${password}는 부적합한 패턴입니다.`);
}

// phone number
const phoneNum = '010-7366-060';
const regExpPhone = new RegExp(/^01(0|1|6-9)[-]?\d{4}[-]?\d{4}$/);

const resultPhone = regExpPhone.test(phoneNum);

console.log(resultPhone);

// 정규식 한글 또는 영어로만 두 글자 이상인지 검사하는 정규식 작성
const person = '차효ab';
const regExpStr = new RegExp(/^(([가-힣]{2,})|([a-zA-Z]{2,}))$/);

const resultStr = regExpStr.test(person);
console.log(resultStr);

// const person1 = '김란';
const regist = '940403-3344354';
const regNum = new RegExp(/^\d{6}-?(1|3)\d{6}$/);

console.log(regNum.test(regist));
