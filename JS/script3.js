const kors = [
  [80, 70, 90],
  [81, 71, 91],
  [82, 72, 92],
];

// 숫자를 그대로 출력
for (let i = 0; i < kors.length; i++) {
  for (let j = 0; j < kors[i].length; j++) {
    console.log(kors[i][j]);
  }
}

// join 으로 출력 (Type conversion to String)
kors.forEach((val) => {
  console.log(val.join(" "));
});

// 각 반의 점수를 내림차순으로 정렬하여 출력하기
kors.forEach((val) => {
  val.sort((a, b) => b - a);
  console.log(val.join(" "));
});

// 각 반의 평균 구하기
const result = [];
kors.forEach((v) => {
  result.push(
    v.reduce((prev, cur) => {
      return prev + cur;
    }, 0) / v.length
  );
});
console.log(result);
