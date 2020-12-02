function lotto(num) {
  for (let j = 0; j < num; j++) {
    const lottos = [];
    while (lottos.length < 6) {
      let flag = false;
      const randomNo = Math.floor(Math.random() * 45 + 1);

      for (let i = 0; i < lottos.length; i++) {
        if (lottos[i] === randomNo) {
          flag = true;
          break;
        }
      }
      if (flag === false) {
        lottos.push(randomNo);
      }
    }
    console.log(lottos);
  }
}

// for (let i = 0; i < 5; i++) {
//   console.log('a');
// }

console.log(lotto(5));
