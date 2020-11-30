// 중복된 데이터 제거하기1
// const num = [2, 4, 5, 6, 6, 7, 8, 9, 3, 4, 2];
// const result1 = [...new Set(num)];
// console.log(result1.sort((a, b) => a - b));

// 중복된 데이터 제거하기2
// 각각의 값이 몇 번 반복되는지 체크
const num = [2, 4, 5, 5, 6, 7, 7, 8, 8, 8];
const result = [];
let count = 0;

num.sort((a, b) => a - b);

// 마지막 값 체크가 안됨
for (let i = 0; i < num.length - 1; i++) {
  for (let j = i + 1; j < num.length; j++) {
    if (num[i] === num[j]) {
      count++;
      break;
    } else {
      // key:value 로 저장
      result.push({ num: num[i], count: count + 1 });
      count = 0;
      break;
    }
  }
}

// console.log(num);
console.log(result);

// 최대값은 num[num.length-1]
// 언제까지? num.length 가 0 이 될때까지
// 숫자를 앞에서부터 하나씩 찾아서 shift
// console.log(num.indexOf(num[num.length - 1]));
const result2 = [];
let count2 = 0;
for (let i = 0; i < num.length - 1; i++) {
  for (let j = num[0]; j < num[num.length - 1]; j++) {}
}

console.log(result2);
