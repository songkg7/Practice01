function timeForm(): void {
  // 요일을 구분하는 함수를 정의
  function getWeeks(weekNo: number): string {
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
  //   if (month < 10) {
  //     month = '0' + month;
  //   }
  //   if (date < 10) {
  //     date = '0' + date;
  //   }
  //   if (hour < 10) {
  //     hour = '0' + hour;
  //   }
  //   if (minute < 10) {
  //     minute = '0' + minute;
  //   }
  //   if (sec < 10) {
  //     sec = '0' + sec;
  //   }

  const result = `${year}년 ${month}월 ${date}일 ${week}요일 ${isAM} ${hour}시 ${minute}분 ${sec}초`;

  document.getElementById('nowTime').innerHTML = result;
  //   return result;
}

function timer(): void {
  document.getElementById('second').innerHTML = '5';
  location.href = 'http://www.naver.com';
}

// function startTime() {}

window.onload = function () {
  window.setInterval(() => timer(), 5 * 1000);
  window.setInterval(() => timeForm(), 1 * 1000);
};
