const str = 'Made in Korea';

console.log(str.charAt(2));
console.log(str.indexOf('K'));
console.log(str.indexOf('K', 9));

console.log(str.replace('Korea', 'USA'));

function getWeeks(weekNo) {
  switch (weekNo) {
    case 0:
      return '일';
    case 1:
      return '월';
    case 2:
      return '화';
    case 3:
      return '수';
    case 4:
      return '목';
    case 5:
      return '금';
    case 6:
      return '토';
    default:
      console.error('error');
      break;
  }
}

const today = new Date();
console.log(today.getHours());
console.log(today.getMinutes());
console.log(today.getSeconds());
console.log(getWeeks(today.getDay()));
