// const grade: any = {
//   stuNo: 1,
//   stuName: 'john',
//   kor: 90,
//   eng: 80,
//   mat: 70,
//   getTot(): number {
//     return this.kor + this.eng + this.mat;
//   },
//   getAvg(): number {
//     return this.getTot() / 3;
//   },
// };

const employees: any = [
  {
    empNo: 1,
    empName: '김란',
    rank: '부장',
    salary: 10000,
    skill: ['JSP', 'ASP'],
    family: [
      { relation: 'father', name: 'James' },
      { relation: 'mother', name: 'Kelly' },
    ],
  },
  {
    empNo: 2,
    empName: '황보민',
    rank: '과장',
    salary: 9000,
    skill: ['JSP', 'ASP', 'Oracle'],
    family: [
      { relation: 'father', name: 'James2' },
      { relation: 'mother', name: 'Kelly2' },
    ],
  },
  {
    empNo: 3,
    empName: '이성배',
    rank: '대리',
    salary: 5000,
    skill: ['JSP', 'Python'],
    family: [
      { relation: 'father', name: 'James3' },
      { relation: 'mother', name: 'Kelly3' },
    ],
  },
  {
    empNo: 4,
    empName: '박인선',
    rank: '사원',
    salary: 3000,
    skill: ['JSP', 'Delphi'],
    family: [
      { relation: 'father', name: 'James4' },
      { relation: 'mother', name: 'Kelly4' },
    ],
  },
];

// employees Table building
function buildEmpTable(data: any) {
  const table = document.getElementById('table1');
  for (let i = 0; i < data.length; i++) {
    let row = `
  <td>${data[i].empNo}</td>
  <td>${data[i].empName}</td>
  <td>${data[i].rank}</td>
  <td>${data[i].salary}</td>
  <td>${data[i].skill}</td>
  `;
    for (let j = 0; j < data[i].family.length; j++) {
      const familyRow = `
    <td>
    ${data[i].family[j].relation} 
    ${data[i].family[j].name}
    </td>
    `;
      row += familyRow;
    }
    table!.innerHTML += row;
  }
}

for (const i of employees) {
  console.log(i.family);
}

buildEmpTable(employees);
