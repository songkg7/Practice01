function getTot(kor, eng, mat) {
  let total = kor + eng + mat;
  return total;
}

function getAvg(kor, eng, mat) {
  let avg = (kor + eng + mat) / 3;
  return avg;
}

console.log(getTot(50, 90, 90));
