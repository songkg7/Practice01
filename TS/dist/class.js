"use strict";
var Student = (function () {
    function Student(stuNo, kor, eng, mat) {
        this.stuNo = stuNo;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
    Student.prototype.getStuNo = function () {
        return this.stuNo;
    };
    Student.prototype.getTot = function () {
        var tot = this.kor + this.eng + this.mat;
        return tot;
    };
    Student.prototype.getAvg = function () {
        var avg = this.getTot() / 3;
        return avg;
    };
    Student.prototype.getGrade = function () {
        var avg = this.getAvg();
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
    };
    return Student;
}());
function totAvg(arr) {
    var tot = 0;
    for (var i = 0; i < arr.length; i++) {
        tot += arr[i].getAvg();
    }
    return tot / arr.length;
}
function buildMainTable(data) {
    var table = document.getElementById('table1');
    var color = '';
    var rank = 0;
    for (var i = 0; i < data.length; i++) {
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
        if (i !== 0 && data[i - 1].getAvg() !== data[i].getAvg()) {
            rank = i + 1;
        }
        else if (i === 0) {
            rank = 1;
        }
        var row = "\n      <tr bgcolor=" + color + ">\n        <td name=\"rank\">" + rank + "</td>\n        <td>" + data[i].getStuNo() + "</td>\n        <td>" + data[i].kor + "</td>\n        <td>" + data[i].eng + "</td>\n        <td>" + data[i].mat + "</td>\n        <td>" + data[i].getTot() + "</td>\n        <td>" + data[i].getAvg().toFixed(2) + "</td>\n        <td>" + data[i].getGrade() + "</td>\n        <td>" + (data[i].getAvg() - totAvg(data)).toFixed(2) + "</td>\n      </tr>";
        table.innerHTML += row;
    }
}
function buildSubTable(data) {
    var table = document.getElementById('table2');
    var aCnt = 0;
    var bCnt = 0;
    var cCnt = 0;
    var dCnt = 0;
    var fCnt = 0;
    for (var _i = 0, data_1 = data; _i < data_1.length; _i++) {
        var i = data_1[_i];
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
    var row = "\n    <tr>\n      <td>A</td>\n      <td>" + aCnt + "</td>\n      <td>" + (aCnt / data.length) * 100 + "</td>\n    </tr>\n    <tr>\n      <td>B</td>\n      <td>" + bCnt + "</td>\n      <td>" + (bCnt / data.length) * 100 + "</td>\n    </tr>\n    <tr>\n      <td>C</td>\n      <td>" + cCnt + "</td>\n      <td>" + (cCnt / data.length) * 100 + "</td>\n    </tr>\n    <tr>\n      <td>D</td>\n      <td>" + dCnt + "</td>\n      <td>" + (dCnt / data.length) * 100 + "</td>\n    </tr>\n    <tr>\n      <td>F</td>\n      <td>" + fCnt + "</td>\n      <td>" + (fCnt / data.length) * 100 + "</td>\n    </tr>\n    ";
    table.innerHTML += row;
}
var gradeArr = [];
for (var i = 0; i < 200; i++) {
    var kor = Math.ceil(Math.random() * 100);
    var eng = Math.ceil(Math.random() * 100);
    var mat = Math.ceil(Math.random() * 100);
    gradeArr.push(new Student(gradeArr.length, kor, eng, mat));
}
console.log(totAvg(gradeArr));
var result = gradeArr.sort(function (a, b) {
    if (a.getAvg() === b.getAvg()) {
        return b.kor - a.kor;
    }
    return b.getAvg() - a.getAvg();
});
buildMainTable(result);
buildSubTable(result);
//# sourceMappingURL=class.js.map