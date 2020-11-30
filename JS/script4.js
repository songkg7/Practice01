// 중복된 데이터 제거하기1
// Set 을 활용하여 간단하게 해결할 수 있다.
// const num = [2, 4, 5, 6, 6, 7, 8, 9, 3, 4, 2];
// const result1 = [...new Set(num)];
// console.log(result1.sort((a, b) => a - b));
// ----------------------------------------------------
// 중복된 데이터 제거하기2
// 각각의 값이 몇 번 반복되는지 체크
const num = [6, 5, 7, 8, 6, 6, 5, 4, 2, 6, 8, 9, 4, 6, 9, 9, 10, 1, 3, 2, 2, 4];
const result = [];
let count = 0;

// 원본 배열 sort
num.sort((a, b) => a - b);

for (let i = 0; i < num.length - 1; i++) {
  for (let j = i + 1; j < num.length; j++) {
    // 마지막 인덱스 체크
    if (j === num.length - 1) {
      if (num[j] === num[j - 1]) {
        count++;
        result.push({ num: num[j], count: count + 1 });
        break;
      } else {
        result.push({ num: num[j - 1], count: count + 1 });
        result.push({ num: num[j], count: 1 });
        break;
      }
    }
    // Index 0 ~ num[num.length-2] 까지 체크
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

// const answer = result.sort((a, b) => b.count - a.count)[0];
// // console.log(num);
// console.log(answer);

// // 최대값은 num[num.length-1]
// // 언제까지? num.length 가 0 이 될때까지
// // 숫자를 앞에서부터 하나씩 찾아서 shift
// // console.log(num.indexOf(num[num.length - 1]));
// const result2 = [];
// let count2 = 0;
// for (let i = 0; i < num.length - 1; i++) {
//   for (let j = num[0]; j < num[num.length - 1]; j++) {}
// }

// console.log(result2);
