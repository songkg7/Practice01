class Student {
  public stuNo: number;

  public name?: string;

  public kor: number;

  public eng: number;

  public mat: number;

  constructor(stuNo: number, kor: number, eng: number, mat: number) {
    this.stuNo = stuNo;
    this.kor = kor;
    this.eng = eng;
    this.mat = mat;
  }

  getStuNo(): number {
    return this.stuNo;
  }

  getTot(): number {
    const tot: number = this.kor + this.eng + this.mat;
    return tot;
  }

  // 평균을 리턴하는 메소드 선언
  getAvg(): number {
    const avg: number = this.getTot() / 3;
    return avg;
  }

  getGrade() {
    const avg = this.getAvg();
    if (avg >= 90) {
      return 'A';
    }
    if (avg >= 80) {
      return 'B';
    }
    if (avg >= 70) {
      return 'C';
    }
    if (avg >= 60) {
      return 'D';
    }
    return 'F';
  }
}

// 전체평균 구하기
function totAvg(arr: Student[]): number {
  let tot: number = 0;
  for (let i = 0; i < arr.length; i++) {
    tot += arr[i].getAvg();
  }
  return tot / arr.length;
}

function buildMainTable(data: Student[]): void {
  const table = <HTMLElement>document.getElementById('table1');
  let color: string = '';
  let rank: number = 0;

  for (let i = 0; i < data.length; i++) {
    switch (data[i].getGrade()) {
      case 'A':
        color = 'lightblue';
        break;
      case 'B':
        color = 'pink';
        break;
      case 'C':
        color = 'magenta';
        break;
      case 'D':
        color = 'orange';
        break;
      case 'F':
        color = 'gray';
        break;
      default:
        console.log(color);
    }

    //  평균이 같다면 랭킹이 증가하지 않도록 해결해야할 부분 (해결했지만 몰랐던 부분!)
    if (i !== 0 && data[i - 1].getAvg() !== data[i].getAvg()) {
      // rank에 i를 저장시켜놓고 다음 루프에서 if 문을 통과시키지 않으면
      // rank의 값은 갱신되지 않고 유지된다.
      rank = i + 1;
    } else if (i === 0) {
      rank = 1;
    }

    const row = `
      <tr bgcolor=${color}>
        <td name="rank">${rank}</td>
        <td>${data[i].getStuNo()}</td>
        <td>${data[i].kor}</td>
        <td>${data[i].eng}</td>
        <td>${data[i].mat}</td>
        <td>${data[i].getTot()}</td>
        <td>${data[i].getAvg().toFixed(2)}</td>
        <td>${data[i].getGrade()}</td>
        <td>${(data[i].getAvg() - totAvg(data)).toFixed(2)}</td>
      </tr>`;
    table!.innerHTML += row;
  }
}

function buildSubTable(data: Student[]): void {
  const table = <HTMLElement>document.getElementById('table2');
  let aCnt: number = 0;
  let bCnt: number = 0;
  let cCnt: number = 0;
  let dCnt: number = 0;
  let fCnt: number = 0;

  for (const i of data) {
    if (i.getGrade() === 'A') {
      aCnt++;
    }
    if (i.getGrade() === 'B') {
      bCnt++;
    }
    if (i.getGrade() === 'C') {
      cCnt++;
    }
    if (i.getGrade() === 'D') {
      dCnt++;
    }
    if (i.getGrade() === 'F') {
      fCnt++;
    }
  }

  const row = `
    <tr>
      <td>A</td>
      <td>${aCnt}</td>
      <td>${(aCnt / data.length) * 100}</td>
    </tr>
    <tr>
      <td>B</td>
      <td>${bCnt}</td>
      <td>${(bCnt / data.length) * 100}</td>
    </tr>
    <tr>
      <td>C</td>
      <td>${cCnt}</td>
      <td>${(cCnt / data.length) * 100}</td>
    </tr>
    <tr>
      <td>D</td>
      <td>${dCnt}</td>
      <td>${(dCnt / data.length) * 100}</td>
    </tr>
    <tr>
      <td>F</td>
      <td>${fCnt}</td>
      <td>${(fCnt / data.length) * 100}</td>
    </tr>
    `;
  table!.innerHTML += row;
}
// const student1 = new Student(1, 100, 100, 100);
// const student2 = new Student(2, 100, 100, 100);
// const student3 = new Student(3, 100, 100, 100);

// console.log('학번 : ' + student1.getStuNo());
// console.log('평균 : ' + student1.getAvg().toFixed(2));
// console.log('총점 : ' + student1.getTot());
// console.log('학점 : ' + student1.getGrade());

// 평균을 기준으로 내림차순 정렬
const gradeArr: Student[] = [];
// gradeArr.push(student1);
// gradeArr.push(student2);
// gradeArr.push(student3);

// insert dummy data
for (let i = 0; i < 200; i++) {
  const kor = Math.ceil(Math.random() * 100);
  const eng = Math.ceil(Math.random() * 100);
  const mat = Math.ceil(Math.random() * 100);
  gradeArr.push(new Student(gradeArr.length, kor, eng, mat));
}

console.log(totAvg(gradeArr));

// sort
const result: Student[] = gradeArr.sort((a: Student, b: Student) => {
  // 국어 점수 우선 정렬
  if (a.getAvg() === b.getAvg()) {
    return b.kor - a.kor;
  }
  return b.getAvg() - a.getAvg();
});

buildMainTable(result);
buildSubTable(result);
