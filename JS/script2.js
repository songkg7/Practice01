const kors = [];

kors.push(90);
kors.push(80);
kors.push(70);
kors.push(73);
kors.push(30);

kors.sort((a, b) => b - a);

console.log(kors);

// var xxx = new Array(3);
// 위 코드에서 3은 데이터가 아니라 만들어지는 배열변수의 개수이다.

const test = kors.slice(0, 2);
console.log(test);

kors.splice(1, 2);
console.log(kors);

// launch time question
const stu_name = ['박희병', '서원교', '김란', '황보민', '이성배'];
const avg = [78, 89, 91, 94, 88];

for (let i = 0; i < avg.length - 1; i++) {
  for (let j = i + 1; j < avg.length; j++) {
    if (avg[i] < avg[j]) {
      const temp = avg[i];
      avg[i] = avg[j];
      avg[j] = temp;
      const temp1 = stu_name[i];
      stu_name[i] = stu_name[j];
      stu_name[j] = temp1;
    }
  }
}

console.log(stu_name.slice(0, 3).join(' '));

// 학원에서 내준 문제를 직접 고쳐본 방식
const obj = [
  {
    name: '박희병',
    avg: 78,
  },
  {
    name: '서원교',
    avg: 89,
  },
  {
    name: '김란',
    avg: 91,
  },
  {
    name: '황보민',
    avg: 94,
  },
  {
    name: '이성배',
    avg: 88,
  },
];

obj.sort((a, b) => b.avg - a.avg);

const result = [];
obj.forEach(value => {
  if (value.avg > 90) {
    result.push(value.name);
  }
});

console.log(result);
