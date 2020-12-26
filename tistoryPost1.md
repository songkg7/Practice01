# 중복된 데이터 (JS)

## for 구문의 응용

### 주어진 배열에서 중복된 데이터의 값을 찾아 그 갯수가 많은 순서대로 정렬하세요.

- 파일이름은 READ ME 입니다.
- 조건2
- 조건3

**마크다운형식**으로 작성된 문서입니다.

```javascript
// 중복된 데이터 제거하기
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
    // Index 0번부터 ~ num[num.length-2] 까지 체크
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
// 정답 출력
const answer = result.sort((a, b) => b.count - a.count)[0];
console.log(answer);
```
