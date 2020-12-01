function timeForm() {
  // 요일을 구분하는 함수를 정의
  function getWeeks(weekNo) {
    return ['일', '월', '화', '수', '목', '금', '토'][weekNo];
  }

  // 필요한 변수 선언
  const today = new Date();
  const year = today.getFullYear();
  let month = today.getMonth() + 1;
  let date = today.getDate();
  const week = getWeeks(today.getDay());
  let hour = today.getHours();
  let minute = today.getMinutes();
  let sec = today.getSeconds();
  let isAM = '오전';

  // 조건문으로 세부설정
  if (hour > 12) {
    isAM = '오후';
    hour -= 12;
  }
  if (month < 10) {
    month = '0' + month;
  }
  if (date < 10) {
    date = '0' + date;
  }
  if (hour < 10) {
    hour = '0' + hour;
  }
  if (minute < 10) {
    minute = '0' + minute;
  }
  if (sec < 10) {
    sec = '0' + sec;
  }

  const result = `${year}년 ${month}월 ${date}일 ${week}요일 ${isAM} ${hour}시 ${minute}분 ${sec}초`;

  return result;
}

// 결과 출력
console.log(timeForm());

const date1 = new Date(2019, 7, 7);
const date2 = new Date(2020, 7, 7);

function getIntervalDate(date1, date2) {
  const dateList = [];
  const a = date1.getTime() / 1000 / 60 / 60 / 24;
  const b = date2.getTime() / 1000 / 60 / 60 / 24;

  dateList.push(a);
  dateList.push(b);

  dateList.sort((a, b) => b - a);

  const result = dateList[0] - dateList[1];

  return result;
}

console.log(getIntervalDate(date1, date2) + '일');
