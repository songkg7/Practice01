SELECT EMP_NO, EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY-MM-DD Q') || '/4분기'
FROM EMPLOYEE;
SELECT EMP_NO, EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY-MM-DD ') || TO_CHAR(HIRE_DATE, 'DY', 'NLS_DATE_LANGUAGE = Korean')
FROM EMPLOYEE;

-- 생일 출력
SELECT EMP_NO, EMP_NAME, TO_CHAR(TO_DATE('19' || SUBSTR(RESIST_NUM, 1, 6)), 'YYYY-MM-DD')
FROM EMPLOYEE;

SELECT EMP_NO, EMP_NAME, TO_DATE('19' || SUBSTR(RESIST_NUM, 1, 6), 'YYYY-MM-DD')
FROM EMPLOYEE;

-- 근속일수
SELECT EMP_NO, EMP_NAME, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

-- CREATE USER king IDENTIFIED BY k123;
-- GRANT CONNECT, DBA, RESOURCE TO king;

SELECT *
FROM EMPLOYEE;

-- column 의 명칭을 사용자화하여 출력하기
SELECT EMP_NO 직원번호, EMP_NAME 직원명, RANK 직급, SALARY || '만원' 연봉, HIRE_DATE 입사일
FROM EMPLOYEE;

-- employee table 에서 직원명 직급 연봉 세금을 검색
SELECT EMP_NAME, RANK, SALARY || '만원' AS 연봉, SALARY * 0.12 || '만원' AS TAX
FROM EMPLOYEE;

-- employee table 에서 직원명 직급 연봉 실수령액을 검색
SELECT EMP_NAME, RANK, SALARY || '만원' AS 연봉, SALARY - (SALARY * 0.12) || '만원' AS TAX
FROM EMPLOYEE;

-- employee table 에서 직급을 중복없이 검색
SELECT DISTINCT RANK AS 직급
FROM EMPLOYEE;
SELECT UNIQUE(RANK) AS 직급
FROM EMPLOYEE;

-- employee table 에서 부서번호와 직급을 중복없이 검색
SELECT DISTINCT DEP_NO AS 부서번호, RANK AS 직급
FROM EMPLOYEE
ORDER BY 1;

SELECT *
FROM EMPLOYEE
WHERE SALARY = 3000;

SELECT *
FROM EMPLOYEE
ORDER BY SALARY;

SELECT *
FROM EMPLOYEE
ORDER BY DEP_NO, SALARY DESC;

SELECT EMP_NO, EMP_NAME, DECODE(SUBSTR(RESIST_NUM, 7, 1), 1, '남', 3, '남', '여')
FROM EMPLOYEE;

SELECT CONCAT('Romeo', 'Juliet'),
       CONCAT('로미오', '줄리엣'),
       '로미오' || '줄리엣',
       INITCAP('abCDefGHi'),
       INITCAP('i am a boy'),
       LOWER('adbeFGC'),
       UPPER('abcdfeDG')
FROM DUAL; -- dummy table

SELECT LPAD('abc', 7, ' '),
       LPAD('abc', 7, '#'),
       LPAD('abc', 7, 's'),
       RPAD('abc', 7, ' '),
       RPAD('abc', 7, '#'),
       RPAD('abc', 7, 's')
FROM DUAL;

-- trim
SELECT TRIM(LEADING 'A' FROM 'AABBCCDD'),
       TRIM(TRAILING 'D' FROM 'AABBCCDD'),
       TRIM(BOTH 'A' FROM 'AABBCCDD'),
       TRIM('A' FROM 'AABBCCDD'),
       LTRIM(' ABCDEFG', ' '),
       LTRIM('ABCDEFG', 'AB'),
       LTRIM(' ABCDEFG', 'BC'),
       RTRIM('ABCDEFG ', ' '),
       RTRIM('ABCDEFG', 'FG'),
       RTRIM('ABCDEFG ', 'EF'),
       TRIM(' ABCDEFG '),
       LENGTH(TRIM(' ABCDEFG '))
FROM DUAL;

-- substr
SELECT SUBSTR('You are not alone', 9, 3),
       SUBSTR('You are not alone', 5),
       SUBSTR('You are not alone', 13, 2),
       SUBSTR('You are not alone', -5, 2),
       SUBSTR('You are not alone', 5, 0)
FROM DUAL;

-- replace
SELECT REPLACE('You are not alone', 'You', 'We'),
       REPLACE('You are not alone', 'You', ''),
       REPLACE('You are not alone', 'You', NULL),
       REPLACE('You are not alone', 'You'),
       TRANSLATE('You are not alone', 'You', 'We')
FROM DUAL;

SELECT ASCII('A'),
       ASCII('a'),
       ASCII('AB'),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la'),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la', 1),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la', 1, 2)
FROM DUAL;

-- Math
SELECT SIGN(32),
       SIGN(-32),
       SIGN(0),
       ROUND(0.62345678, 0),
       ROUND(0.12345678, 0),
       ROUND(0.12345678, 3),
       ROUND(0.12345678, 4),
       ROUND(1234.12345678, -2),
       TRUNC(1234.12345678, 0),
       TRUNC(1234.12345678, 2),
       TRUNC(1234.12345678, -2),
       CEIL(1234.12345678),
       CEIL(0.12345),
       FLOOR(1234.12345678),
       FLOOR(0.12345),
       POWER(3, 2),
       SQRT(2),
       MOD(9, 4)
FROM DUAL;

-- date
-- 2월 30일은 없으므로 마지막일이 리턴
SELECT ADD_MONTHS(TO_DATE('2020-1-30', 'YYYY-MM-DD'), 1)
FROM DUAL;

-- 12월 31일이 리턴
SELECT ADD_MONTHS(TO_DATE('2020-11-30', 'YYYY-MM-DD'), 1)
FROM DUAL;

SELECT ADD_MONTHS(SYSDATE, 5)
FROM DUAL;

SELECT SYSDATE + 100
FROM DUAL;

SELECT TO_DATE('1994-07-07') + 100
FROM DUAL;


SELECT ADD_MONTHS(SYSDATE, 5 + (20 * 12)) + 10
FROM DUAL;

SELECT ROUND(SYSDATE - TO_DATE('1968-04-20')) - ROUND(SYSDATE - TO_DATE('1994-07-07'))
FROM DUAL;

SELECT TO_CHAR(SYSDATE)
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'DD'),
       TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = English'),
       TO_CHAR(SYSDATE, 'DY'),
       TO_CHAR(SYSDATE, 'AD'),
       TO_CHAR(SYSDATE, 'YYYY/MM')
FROM DUAL;

-- 가장 빨리 돌아오는 월요일
-- 두번째 인자로 해당하는 요일의 숫자를 전달해준다.
SELECT NEXT_DAY(TO_DATE('1990-10-29'), 2)
FROM DUAL;

SELECT LAST_DAY(TO_DATE('1994-07-07'))
FROM DUAL;
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE),
       EXTRACT(MONTH FROM SYSDATE),
       EXTRACT(DAY FROM SYSDATE)
FROM DUAL;
