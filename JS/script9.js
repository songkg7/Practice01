// const lottos = [[], [], []];
// for (let i = 0; i < 3; i++) {
//   while (lottos[i].length < 6) {
//     const random = Math.floor(Math.random() * 45 + 1);
//     if (lottos[i].includes(random) === false) {
//       lottos[i].push(random);
//     }
//   }
// }

// console.log(lottos);

// 난수들의 평균이 설정된 값과 같을 때까지 난수 생성 반복
const avg = 80;
let result = 0;
const subjectCnt = 5;
let count = 0;
let grade = [];
while (!(avg === result)) {
  const arr = [];
  for (let i = 0; i < subjectCnt; i++) {
    const random = Math.floor(Math.random() * 100 + 1);
    arr.push(random);
  }

  // 배열의 합을 구한 뒤 평균값 내기
  result = arr.reduce((prev, cur) => prev + cur, 0) / arr.length;

  // add count
  count++;
  console.log(arr + ` -> 평균 ${result} : ${count}회째 실행`);

  if (avg === result) {
    grade = arr;
  }
}

console.log(grade);
