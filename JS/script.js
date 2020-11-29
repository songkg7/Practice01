// 총점
let no = 0;

function getTot(kor, eng, mat) {
  let total = kor + eng + mat;
  return total;
}

// 평균
function getAvg(kor, eng, mat) {
  let avg = getTot(kor, eng, mat) / 3;
  return avg.toFixed(1);
}

// 학점
function getCredit(kor, eng, mat) {
  const avg = getAvg(kor, eng, mat);
  let credit;
  if (avg >= 90) {
    credit = "A";
    return credit;
  } else if (avg >= 80) {
    credit = "B";
    return credit;
  } else if (avg >= 70) {
    credit = "C";
    return credit;
  } else if (avg >= 60) {
    credit = "D";
    return credit;
  } else {
    credit = "F";
    return credit;
  }
}

// 합격여부
function getPass(kor, eng, mat) {
  const avg = getAvg(kor, eng, mat);
  let result = "Reject";
  if (avg >= 60 && kor >= 40 && eng >= 40 && mat >= 40) {
    result = "Pass";
    return result;
  } else {
    let msg = "";
    let count = 0;
    msg += "(";

    if (avg < 60) {
      if (count++ > 0) {
        msg += ",";
      }
      msg += `평균점수미달`;
    }
    if (kor < 40) {
      if (count++ > 0) {
        msg += ",";
      }
      msg += `kor점수미달`;
    }
    if (eng < 40) {
      if (count++ > 0) {
        msg += ",";
      }
      msg += `eng점수미달`;
    }
    if (mat < 40) {
      if (count++ > 0) {
        msg += ",";
      }
      msg += `mat점수미달`;
    }
    msg += ")";
    // msg.split("").join(",");
    return result + msg;
  }
}

function getGradeInfo(stu_name, kor, eng, mat) {
  const tot = getTot(kor, eng, mat);
  const avg = getAvg(kor, eng, mat);
  const credit = getCredit(kor, eng, mat);
  const pass = getPass(kor, eng, mat);
  const html_src = `
        <tr>
          <td>${++no}</td>
          <td>${stu_name}</td>
          <td>${tot}</td>
          <td>${avg}</td>
          <td>${credit}</td>
          <td>${pass}</td>
        </tr>`;
  return html_src;
}

// console.log(getTot(50, 90, 90));
// console.log(getCredit(50, 50, 40));
// console.log(getPass(50, 50, 39));
// document.writeln(`<table border="1px">
//         <caption>
//           Student Info
//         </caption>
//         <tr>
//           <th>번호</th>
//           <th>학생명</th>
//           <th>총점</th>
//           <th>평균</th>
//           <th>학점</th>
//           <th>합격여부</th>
//         </tr>`);
// document.writeln(getGradeInfo("john", 90, 90, 80));
// document.writeln(getGradeInfo("bernard", 90, 70, 60));
// document.writeln(`</table>`);

let limit_count = 3;
var id_error_count = 0;
var pwd_error_count = 0;

function check_id() {
  let id = prompt("input your id", "");
  if (id === "abc") {
    return true;
  } else {
    id_error_count++;
    if (id_error_count < limit_count) {
      return check_id();
    }
    return false;
  }
}

function check_pwd() {
  let pwd = prompt("input your pwd", "");
  if (pwd === "123") {
    return true;
  } else {
    pwd_error_count++;
    if (pwd_error_count < limit_count) {
      return check_pwd();
    }
    return false;
  }
}

function control() {
  // check_id();
  if (check_id() && check_pwd()) {
    console.log("login success");
  } else {
    console.log("login fail");
  }
}
// console.log(check_id());
control();
