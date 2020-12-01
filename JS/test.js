const num = [2, 4, 5, 6, 6, 2, 7, 2, 8, 9, 9, 9, 9, 3, 4, 2];
const arr1 = [];
const arr2 = [];
for (let i = 0; i < num.length; i++) {
  let cnt = 0;
  for (let j = 0; j < num.length; j++) {
    if (num[i] === num[j]) {
      cnt++;
    }
  }
}
