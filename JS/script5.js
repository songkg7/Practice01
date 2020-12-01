// 중복된 데이터 제거하기3
// 각각의 값이 몇 번 반복되는지 체크
const num = [6, 5, 7, 8, 6, 5, 4, 2, 6, 8, 9, 4, 6, 9, 9, 10, 1, 3, 2, 2, 4];
const result = [];

// 원본 배열 sort
num.sort((a, b) => a - b);
console.log(num);
// 처음 인덱스부터 마지막 인덱스까지 검사
for (let i = 0; i < num.length; i++) {
  let count = 0;
  for (let j = 0; j < num.length; j++) {
    if (num[i] === num[j]) {
      count++;
    }
    if (j === num.length - 1) {
      result.push({ num: num[i], count });
    }
  }
}
const answer = result.sort((a, b) => b.count - a.count);
console.log(answer[0]);
// console.log(result[2].num);
