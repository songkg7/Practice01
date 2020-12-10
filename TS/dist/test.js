"use strict";
var employees = [
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
function buildEmpTable(data) {
    var table = document.getElementById('table1');
    for (var i = 0; i < data.length; i++) {
        var row = "\n  <td>" + data[i].empNo + "</td>\n  <td>" + data[i].empName + "</td>\n  <td>" + data[i].rank + "</td>\n  <td>" + data[i].salary + "</td>\n  <td>" + data[i].skill + "</td>\n  ";
        for (var j = 0; j < data[i].family.length; j++) {
            var familyRow = "\n    <td>\n    " + data[i].family[j].relation + " \n    " + data[i].family[j].name + "\n    </td>\n    ";
            row += familyRow;
        }
        table.innerHTML += row;
    }
}
for (var _i = 0, employees_1 = employees; _i < employees_1.length; _i++) {
    var i = employees_1[_i];
    console.log(i.family);
}
buildEmpTable(employees);
//# sourceMappingURL=test.js.map