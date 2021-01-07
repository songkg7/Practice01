SELECT emp_no, emp_name, TO_CHAR(hire_date, 'YYYY-MM-DD Q') || '/4분기'
FROM employee;
SELECT emp_no,
       emp_name,
       TO_CHAR(hire_date, 'YYYY-MM-DD ') ||
       TO_CHAR(hire_date, 'DY', 'NLS_DATE_LANGUAGE = Korean')
FROM employee;

-- 생일 출력
SELECT emp_no,
       emp_name,
       TO_CHAR(TO_DATE('19' || SUBSTR(resist_num, 1, 6)), 'YYYY-MM-DD')
FROM employee;

SELECT emp_no,
       emp_name,
       TO_DATE('19' || SUBSTR(resist_num, 1, 6), 'YYYY-MM-DD')
FROM employee;

-- 근속일수
SELECT emp_no, emp_name, SYSDATE - hire_date
FROM employee;

-- CREATE USER king IDENTIFIED BY k123;
-- GRANT CONNECT, DBA, RESOURCE TO king;

SELECT *
FROM employee;

-- column 의 명칭을 사용자화하여 출력하기
SELECT emp_no 직원번호, emp_name 직원명, rank 직급, salary || '만원' 연봉, hire_date 입사일
FROM employee;

-- employee table 에서 직원명 직급 연봉 세금을 검색
SELECT emp_name, rank, salary || '만원' AS 연봉, salary * 0.12 || '만원' AS tax
FROM employee;

-- employee table 에서 직원명 직급 연봉 실수령액을 검색
SELECT emp_name,
       rank,
       salary || '만원'                   AS 연봉,
       salary - (salary * 0.12) || '만원' AS tax
FROM employee;

-- employee table 에서 직급을 중복없이 검색
SELECT DISTINCT rank AS 직급
FROM employee;
SELECT UNIQUE(rank) AS 직급
FROM employee;

-- employee table 에서 부서번호와 직급을 중복없이 검색
SELECT DISTINCT dep_no AS 부서번호, rank AS 직급
FROM employee
ORDER BY 1;

SELECT *
FROM employee
WHERE salary = 3000;

SELECT *
FROM employee
ORDER BY salary;

SELECT *
FROM employee
ORDER BY dep_no, salary DESC;

SELECT emp_no,
       emp_name,
       DECODE(SUBSTR(resist_num, 7, 1), 1, '남', 3, '남', '여')
FROM employee;

SELECT CONCAT('Romeo', 'Juliet'),
       CONCAT('로미오', '줄리엣'),
       '로미오' || '줄리엣',
       INITCAP('abCDefGHi'),
       INITCAP('i am a boy'),
       LOWER('adbeFGC'),
       UPPER('abcdfeDG')
FROM dual; -- dummy table

SELECT LPAD('abc', 7, ' '),
       LPAD('abc', 7, '#'),
       LPAD('abc', 7, 's'),
       RPAD('abc', 7, ' '),
       RPAD('abc', 7, '#'),
       RPAD('abc', 7, 's')
FROM dual;

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
FROM dual;

-- substr
SELECT SUBSTR('You are not alone', 9, 3),
       SUBSTR('You are not alone', 5),
       SUBSTR('You are not alone', 13, 2),
       SUBSTR('You are not alone', -5, 2),
       SUBSTR('You are not alone', 5, 0)
FROM dual;

-- replace
SELECT REPLACE('You are not alone', 'You', 'We'),
       REPLACE('You are not alone', 'You', ''),
       REPLACE('You are not alone', 'You', NULL),
       REPLACE('You are not alone', 'You'),
       TRANSLATE('You are not alone', 'You', 'We')
FROM dual;

SELECT ASCII('A'),
       ASCII('a'),
       ASCII('AB'),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la'),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la', 1),
       INSTR('Every Sha-la-la-la Every wo-o-wo-o', 'la', 1, 2)
FROM dual;

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
FROM dual;

-- date
-- 2월 30일은 없으므로 마지막일이 리턴
SELECT ADD_MONTHS(TO_DATE('2020-1-30', 'YYYY-MM-DD'), 1)
FROM dual;

-- 12월 31일이 리턴
SELECT ADD_MONTHS(TO_DATE('2020-11-30', 'YYYY-MM-DD'), 1)
FROM dual;

SELECT ADD_MONTHS(SYSDATE, 5)
FROM dual;

SELECT SYSDATE + 100
FROM dual;

SELECT TO_DATE('1994-07-07') + 100
FROM dual;


SELECT ADD_MONTHS(SYSDATE, 5 + (20 * 12)) + 10
FROM dual;

SELECT ROUND(SYSDATE - TO_DATE('1968-04-20')) -
       ROUND(SYSDATE - TO_DATE('1994-07-07'))
FROM dual;

SELECT TO_CHAR(SYSDATE)
FROM dual;

-- th_char 은 문자형으로 데이터를 리턴한다
SELECT TO_CHAR(SYSDATE, 'DD'),
       TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = English'),
       TO_CHAR(SYSDATE, 'DY'),
       TO_CHAR(SYSDATE, 'D'),
       TO_CHAR(SYSDATE, 'AD'),
       TO_CHAR(SYSDATE, 'YYYY/MM')
FROM dual;

-- 가장 빨리 돌아오는 월요일
-- 두번째 인자로 해당하는 요일의 숫자를 전달해준다.
SELECT NEXT_DAY(TO_DATE('1990-10-29'), 2)
FROM dual;

SELECT LAST_DAY(TO_DATE('1994-07-07'))
FROM dual;
SELECT LAST_DAY(SYSDATE)
FROM dual;

SELECT EXTRACT(YEAR FROM SYSDATE),
       EXTRACT(MONTH FROM SYSDATE),
       EXTRACT(DAY FROM SYSDATE)
FROM dual;

SELECT MONTHS_BETWEEN('1994-07-07', SYSDATE)
FROM dual;

SELECT 7000000
FROM dual;

-- to_char pattern
-- 9 : 숫자가 있으면 그대로, 없으면 비운다.
-- 0 : 숫자가 있으면 그대로, 없으면 0을 채운다.
SELECT TO_CHAR(1234, '09999'),
       TO_CHAR(1234, '999,999'),
       TO_CHAR(1234, '99999.99'),
       TO_CHAR(0.5, '999.99'),
       TO_CHAR(0.5, '990.99'),
       TO_CHAR(0.5, '099.99'),
       TO_CHAR(1234, '$99,999.00'),
       TO_CHAR(1234, 'L99,999.00'), -- L 은 local
       '\' || TO_CHAR(1234, '99,999.00')
FROM dual;

-- to_number 패턴 전달에 주의
SELECT TO_NUMBER('123456.9'),
       TO_NUMBER('123,456.9', '999,999.9'),
       TO_NUMBER('1,234,567', '9,999,999'),
       TO_NUMBER('1,234,567', '9G999G999')
FROM dual;

-- decode (표준 SQL X)
SELECT emp_no,
       emp_name,
       DECODE(SUBSTR(resist_num, 7, 1), '1', '남', '3', '남', '여')
FROM employee;

-- case (표준 SQL O, 조건이 많을 경우 decode 보다 가독성이 좋다)
SELECT emp_no,
       emp_name,
       CASE SUBSTR(resist_num, 7, 1)
           WHEN '1' THEN '남'
           WHEN '3' THEN '남'
           ELSE '여'
           END
FROM employee;

SELECT emp_no,
       emp_name,
       CASE
           WHEN SUBSTR(resist_num, 7, 1) = '1' THEN '남'
           WHEN SUBSTR(resist_num, 7, 1) = '3' THEN '남'
           ELSE '여'
           END
FROM employee;

-- Ex) 월급 등급 나누기
SELECT emp_no,
       emp_name,
       CASE
           WHEN salary >= 5000 THEN 'A'
           WHEN salary < 5000 AND salary >= 4000 THEN 'B'
           WHEN salary < 4000 AND salary >= 3000 THEN 'C'
           WHEN salary < 3000 AND salary >= 2000 THEN 'D'
           WHEN salary < 2000 THEN 'F'
           END salary_rank
FROM employee;

-- Ex) Find min-salary, max-salary, avg-salary, sum-salary, count-emp in employee table
SELECT MIN(salary),
       MAX(salary),
       AVG(salary),
       SUM(salary),
       COUNT(emp_no)
FROM employee;

-- Ex)
SELECT COUNT(DISTINCT dep_no)
FROM employee;

-- Ex) 담당직원이 있는 고객 수
SELECT COUNT(emp_no)
FROM customer;

-- Ex) 고객을 담당하고 있는 직원 수
SELECT COUNT(DISTINCT emp_no)
FROM customer;

-- Ex)
SELECT emp_no, emp_name, TO_CHAR(hire_date, 'Q') || '/4분기' AS 입사분기
FROM employee;

-- Ex) 근속일수 계산
SELECT emp_no, emp_name, ROUND((SYSDATE - hire_date) / 365)
FROM employee;

-- Ex)
-- null 값 처리 (중요!!)
-- 자료형의 통일이 반드시 필요하다
SELECT cus_no, cus_name, NVL(TO_CHAR(emp_no), '없음')
FROM customer;

SELECT cus_no, cus_name, DECODE(emp_no, NULL, '없음', '있음')
FROM customer;

-- is null 의 사용
SELECT cus_no, cus_name, CASE WHEN emp_no IS NULL THEN '없음' ELSE '있음' END
FROM customer;

SELECT cus_no, cus_name, NVL2(emp_no, '있음', '없음')
FROM customer;

SELECT emp_no,
       emp_name,
       TRUNC((SYSDATE - TO_DATE(SUBSTR(resist_num, 1, 6))) / 365, 1) AS age,
       TRUNC((SYSDATE - TO_DATE(SUBSTR(resist_num, 1, 6))) / 365, -1) ||
       '대'                                                           AS 연령대
FROM employee;

-- Ex) 다양한 조건 sort
SELECT *
FROM employee
ORDER BY DECODE(rank, '사장', 1, '부장', 2, '과장', 3, '대리', 4, '주임', 5, 6);

SELECT *
FROM employee
ORDER BY CASE rank
             WHEN '사장' THEN 1
             WHEN '부장' THEN 2
             WHEN '과장' THEN 3
             WHEN '대리' THEN 4
             WHEN '주임' THEN 5
             ELSE 6
             END;

SELECT *
FROM employee
ORDER BY DECODE(rank, '사장', 1, '부장', 2, '과장', 3, '대리', 4, '주임', 5, 6),
         TRUNC((SYSDATE - TO_DATE(SUBSTR(resist_num, 1, 6))) / 365, 1) DESC;

-- Ex) 생일이 수요일인 직원 골라내기
-- NOTE: !!) 50 은 1950년, 49는 2049년으로 인식되므로 필요하다면 decode 를 통해 처해줘야한다.
SELECT *
FROM employee
WHERE TO_CHAR(TO_DATE(SUBSTR(resist_num, 1, 6)), 'D') = 4
ORDER BY hire_date;

-- 연산자
SELECT *
FROM employee 직원
WHERE 직원.rank = '과장';

SELECT *
FROM employee 직원
WHERE 직원.rank != '과장';

SELECT *
FROM employee 직원
WHERE 직원.rank <> '과장';

SELECT *
FROM employee 직원
WHERE 직원.rank = '과장'
  AND 직원.dep_no = 10;

SELECT *
FROM employee 직원
WHERE 직원.rank IN ('과장', '부장');

SELECT *
FROM employee 직원
WHERE 직원.rank = ANY ('과장', '부장');

SELECT *
FROM employee 직원
WHERE 직원.dep_no = 10 AND rank = '과장'
   OR dep_no = 20 AND rank = '과장';

SELECT *
FROM employee 직원
WHERE (dep_no = 10 OR dep_no = 20)
  AND rank = '과장';

SELECT *
FROM employee 직원
WHERE dep_no IN (10, 20)
  AND rank = '과장';

SELECT *
FROM customer
WHERE emp_no IS NULL;

SELECT *
FROM customer
WHERE emp_no IS NOT NULL;

-- NOTE: null check!!
SELECT *
FROM customer
WHERE emp_no != 9
   OR emp_no IS NULL;

SELECT *
FROM employee emp
WHERE emp.salary >= 4000;

SELECT *
FROM employee emp
WHERE emp.salary >= 3000
  AND emp.salary <= 4000;

SELECT *
FROM employee emp
WHERE emp.salary BETWEEN 3000 AND 4000;

SELECT *
FROM employee
WHERE salary * 1.05 >= 3000;

SELECT *
FROM employee
WHERE hire_date >= TO_DATE('1995-1-1');

SELECT *
FROM employee
WHERE hire_date BETWEEN TO_DATE('1990-1-1') AND TO_DATE('1999-12-31');
SELECT *
FROM employee
WHERE TO_NUMBER(TO_CHAR(hire_date, 'YYYY')) BETWEEN 1990 AND 1999;
SELECT *
FROM employee
WHERE EXTRACT(YEAR FROM hire_date) BETWEEN 1990 AND 1999;

-- Ex) like
SELECT *
FROM employee
WHERE TO_CHAR(hire_date, 'YYYY') LIKE '199%'; -- % => i don't care what is it

SELECT *
FROM employee
WHERE dep_no IN (10, 30)
  AND salary < 3000
  AND hire_date < TO_DATE('1996-1-1');

SELECT *
FROM employee
WHERE (dep_no = 10 AND salary < 2000)
   OR (dep_no = 20 AND salary >= 3500);

SELECT *
FROM employee
WHERE emp_name LIKE '김%';
SELECT *
FROM employee
WHERE SUBSTR(emp_name, 1, 1) = '김';

SELECT *
FROM employee
-- WHERE SUBSTR(emp_name, -1, 1) = '정';
WHERE SUBSTR(emp_name, LENGTH(emp_name), 1) = '정';
SELECT *
FROM employee
WHERE emp_name LIKE '%정';

SELECT *
FROM employee
WHERE LENGTH(emp_name) = 3
  AND emp_name LIKE '김%';
SELECT *
FROM employee
WHERE emp_name LIKE '김__'; -- _ => 언더바당 글자 하나씩 매칭

SELECT *
FROM employee
WHERE emp_name LIKE '%김%';

SELECT *
FROM employee
WHERE LENGTH(emp_name) = 2;
SELECT *
FROM employee
WHERE emp_name LIKE '__';

-- not like
SELECT *
FROM employee
WHERE emp_name LIKE '%김%'
  AND emp_name NOT LIKE '김%'
  AND emp_name NOT LIKE '%김';

-- regexp
SELECT *
FROM employee
WHERE REGEXP_LIKE(emp_name, '^[^미][미]+[^미]$');

-- 여직원 검색
SELECT *
FROM employee
WHERE SUBSTR(resist_num, 7, 1) IN (2, 4);

SELECT *
FROM employee
WHERE resist_num LIKE '______2%'
   OR resist_num LIKE '______4%';

SELECT *
FROM employee
WHERE SUBSTR(resist_num, 1, 1) IN ('6', '7')
  AND SUBSTR(resist_num, 7, 1) = '1';
SELECT *
FROM employee
WHERE resist_num LIKE '6_____1%'
   OR resist_num LIKE '7_____1%';

-- select birthday
SELECT emp_no,
       emp_name,
       resist_num,
--        CASE
--            WHEN TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '-' || TO_CHAR(TO_DATE(SUBSTR(resist_num, 1, 6)), 'MM-DD')) -
--                 SYSDATE < 0 THEN
--                TO_CHAR(TO_DATE(to_char(sysdate,'YYYY') || SUBSTR(resist_num, 3, 4)), 'YYYYMMDD')
--            ELSE
--                TO_CHAR(TO_DATE(EXTRACT(YEAR FROM SYSDATE) || SUBSTR(resist_num, 3, 4)), 'YYYYMMDD')
--            END AS 다가올생일,
--        CASE
--            WHEN TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '-' || TO_CHAR(TO_DATE(SUBSTR(resist_num, 1, 6)), 'MM-DD')) -
--                 SYSDATE < 0 THEN ROUND(TO_DATE(EXTRACT(YEAR FROM SYSDATE) + 1 || '-' ||
--                                                TO_CHAR(TO_DATE(SUBSTR(resist_num, 3, 4)), 'MM-DD')) - SYSDATE, 0)
--            ELSE ROUND(TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '-' ||
--                               TO_CHAR(TO_DATE(SUBSTR(resist_num, 3, 4)), 'MM-DD')) - SYSDATE)
--            END AS 생일까지남은날짜
       CASE
           WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYY') || SUBSTR(resist_num, 3, 4),
                        'YYYYMMDD') -
                SYSDATE > 0 THEN
               ROUND(TO_DATE(TO_CHAR(SYSDATE, 'YYYY') ||
                             SUBSTR(resist_num, 3, 4), 'YYYYMMDD') -
                     SYSDATE)
           ELSE ROUND(TO_DATE(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) + 1 ||
                              SUBSTR(resist_num, 3, 4),
                              'YYYYMMDD') -
                      SYSDATE) END "D-DAY"
FROM employee;

CREATE TABLE product
(
    p_no    number(3),
    p_name  varchar2(20) NOT NULL UNIQUE,
    tot_cnt varchar2(20) NOT NULL
);

INSERT INTO product
VALUES (1, '컴퓨터1', '20');
INSERT INTO product
VALUES (2, '컴퓨터2', '2');
INSERT INTO product
VALUES (3, '컴퓨터3', '4');
INSERT INTO product
VALUES (4, '컴퓨터4', '2');
INSERT INTO product
VALUES (5, '컴퓨터5', '16');
INSERT INTO product
VALUES (6, '컴퓨터6', '60');
INSERT INTO product
VALUES (7, '컴퓨터7', '30');
INSERT INTO product
VALUES (8, '컴퓨터8', '27');
INSERT INTO product
VALUES (9, '컴퓨터9', '25');
INSERT INTO product
VALUES (10, '컴퓨터10', '22');
INSERT INTO product
VALUES (11, '컴퓨터11', '34');
INSERT INTO product
VALUES (12, '컴퓨터12', '50');
INSERT INTO product
VALUES (13, '컴퓨터13', '8');
INSERT INTO product
VALUES (14, '컴퓨터14', '9');
INSERT INTO product
VALUES (15, '컴퓨터15', '10');

SELECT *
FROM product
ORDER BY TO_NUMBER(tot_cnt) DESC;
SELECT *
FROM product
ORDER BY LENGTH(tot_cnt) DESC, tot_cnt DESC;

-- NOTE: JOIN
SELECT emp_no, emp_name, rank, dep_no
FROM employee;

SELECT emp_name, resist_num, 'E' "구별"
FROM employee
UNION
SELECT cus_name, resist_num, 'C'
FROM customer;

SELECT employee.emp_no, employee.emp_name, employee.rank, dept.dep_name
FROM employee,
     dept
WHERE employee.dep_no = dept.dep_no;

-- Oracle 만 가능한 방법
SELECT emp_no 직원번호, emp_name 직원명, rank 직급, dep_name 부서명
FROM employee e,
     dept d
WHERE e.dep_no = d.dep_no;

-- 표준 SQL 방식 (ANSI)
SELECT emp_no 직원번호, emp_name 직원명, rank 직급, dep_name 부서명
FROM employee e
         INNER JOIN dept d ON d.dep_no = e.dep_no;
-- oracle
SELECT c.cus_name, c.tel_num, e.emp_name, e.rank
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no;
-- ANSI
SELECT cus_name, tel_num, emp_name, rank
FROM customer c
         INNER JOIN employee e ON e.emp_no = c.emp_no;

SELECT cus_name, tel_num, emp_name, rank
FROM customer c
         INNER JOIN employee e ON e.emp_no = c.emp_no
WHERE e.dep_no = 10;

-- 3중 inner join
-- oracle
SELECT e.emp_no, e.emp_name, e.rank, d.dep_name, c.cus_name, c.tel_num
FROM employee e,
     dept d,
     customer c
WHERE d.dep_no = e.dep_no
  AND e.emp_no = c.emp_no
ORDER BY e.emp_name;
-- ANSI
SELECT e.emp_no, e.emp_name, e.rank, d.dep_name, c.cus_name, c.tel_num
FROM (dept d INNER JOIN employee e ON d.dep_no = e.dep_no)
         INNER JOIN customer c ON c.emp_no = e.emp_no
ORDER BY e.emp_name;

-- 직원번호, 직원명, 직급, 연봉등급 출력 후 연봉등급 오름차순, 직급 오름차순, 나이 내림차순 유지하기
SELECT e.emp_no, e.emp_name, e.rank, sg.sal_grade_no
FROM employee e
         INNER JOIN salary_grade sg
                    ON e.salary BETWEEN sg.min_salary AND sg.max_salary
ORDER BY sg.sal_grade_no,
         DECODE(e.rank, '사장', 1, '부장', 2, '과장', 3, '대리', 4, '주임', 5, 6),
         TO_DATE(SUBSTR(resist_num, 1, 6)) - SYSDATE DESC;
-- 1949년 이전에 태어난 사람이 있을 경우는 수정해야함

-- SELF JOIN
SELECT e1.emp_name, e1.rank, e2.emp_name, e2.rank
FROM employee e1
         JOIN employee e2 ON e1.mgr_emp_no = e2.emp_no;

SELECT e1.emp_name, e1.rank, e2.emp_name, e2.rank
FROM employee e1
         JOIN employee e2 ON e2.mgr_emp_no = e1.emp_no;

-- ANSI
SELECT e1.emp_no,
       e1.emp_name,
       d.dep_name,
       e1.rank,
       sg.sal_grade_no,
       e2.emp_name,
       e2.rank,
       c.cus_name
FROM (((employee e1 INNER JOIN salary_grade sg ON e1.salary BETWEEN sg.min_salary AND sg.max_salary)
    INNER JOIN dept d ON e1.dep_no = d.dep_no) JOIN employee e2 ON e1.mgr_emp_no = e2.emp_no)
         INNER JOIN customer c ON c.emp_no = e1.emp_no;
-- Oracle
SELECT e1.emp_no,
       e1.emp_name,
       d.dep_name,
       e1.rank,
       sg.sal_grade_no,
       e2.emp_name,
       e2.rank,
       c.cus_name
FROM employee e1,
     dept d,
     salary_grade sg,
     employee e2,
     customer c
WHERE e1.dep_no = d.dep_no
  AND (e1.salary BETWEEN sg.min_salary AND sg.max_salary)
  AND e2.emp_no = e1.mgr_emp_no
  AND e1.emp_no = c.emp_no
ORDER BY 1;

-- OUTER JOIN
-- left join 과 left outer join 은 동일하다
-- oracle
SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank, e.dep_no
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no(+);

-- ANSI
SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank, e.dep_no
FROM customer c
         LEFT OUTER JOIN employee e ON c.emp_no = e.emp_no;

-- oracle
SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no(+)
  AND e.dep_no(+) = 10;

-- ANSI
SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank
FROM customer c
         LEFT JOIN employee e ON e.emp_no = c.emp_no AND e.dep_no = 10;
-- where 절이 나올 경우 행이 골라지므로 on 절 뒤에 나온다

-- oracle
SELECT c.cus_no,
       c.cus_name,
       c.tel_num,
       e.emp_name,
       e.rank,
       sg.sal_grade_no
FROM customer c,
     employee e,
     salary_grade sg
WHERE c.emp_no = e.emp_no(+)
  AND e.salary BETWEEN sg.min_salary(+) AND sg.max_salary(+)
ORDER BY 1;
-- (+)를 양쪽에 붙일 수는 없다.

-- ANSI
SELECT c.cus_no,
       c.cus_name,
       c.tel_num,
       e.emp_name,
       e.rank,
       sg.sal_grade_no
FROM (customer c LEFT JOIN employee e ON e.emp_no = c.emp_no)
         LEFT JOIN
     salary_grade sg ON e.salary BETWEEN sg.min_salary AND sg.max_salary
ORDER BY 1;

SELECT c.cus_no, c.cus_name, c.resist_num
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no
  AND (EXTRACT(YEAR FROM SYSDATE) -
       EXTRACT(YEAR FROM TO_DATE(SUBSTR(e.resist_num, 1, 6)))) + 1 >=
      40;
-- 한국 나이

-- 고객번호, 고객명, 담당직원번호, 담당직원명, 담당직원소속부서, 담당직원연봉등급, 담당직원직속상관명, 담당직원직속상관직급, 직속상관연봉등급
-- oracle
SELECT c.cus_no                             AS 고객번호,
       c.cus_name                           AS 고객명,
       NVL(TO_CHAR(e1.emp_no), '없음')        AS 담당직원번호,
       NVL(TO_CHAR(e1.emp_name), '없음')      AS 담당직원명,
       NVL(TO_CHAR(d.dep_name), '없음')       AS 담당직원소속부서,
       NVL(TO_CHAR(sg1.sal_grade_no), '없음') AS 담당직원연봉등급,
       NVL(TO_CHAR(e2.emp_name), '없음')      AS 담당직원직속상관명,
       NVL(TO_CHAR(e2.rank), '없음')          AS 담당직원직속상관직급,
       NVL(TO_CHAR(sg1.sal_grade_no), '없음') AS 직속상관연봉등급
FROM employee e1,
     employee e2,
     customer c,
     salary_grade sg1,
     salary_grade sg2,
     dept d
WHERE c.emp_no = e1.emp_no(+)
  AND d.dep_no(+) = e1.dep_no
  AND e1.mgr_emp_no = e2.emp_no(+)
  AND e1.salary BETWEEN sg1.min_salary(+) AND sg1.max_salary(+)
  AND e2.salary BETWEEN sg2.min_salary(+) AND sg2.max_salary(+)
ORDER BY 1;

-- ANSI
SELECT c.cus_no                             AS 고객번호,
       c.cus_name                           AS 고객명,
       NVL(TO_CHAR(e1.emp_no), '없음')        AS 담당직원번호,
       NVL(TO_CHAR(e1.emp_name), '없음')      AS 담당직원명,
       NVL(TO_CHAR(d.dep_name), '없음')       AS 담당직원소속부서,
       NVL(TO_CHAR(sg1.sal_grade_no), '없음') AS 담당직원연봉등급,
       NVL(TO_CHAR(e2.emp_name), '없음')      AS 담당직원직속상관명,
       NVL(TO_CHAR(e2.rank), '없음')          AS 담당직원직속상관직급,
       NVL(TO_CHAR(sg1.sal_grade_no), '없음') AS 직속상관연봉등급
FROM customer c
         LEFT JOIN employee e1 ON e1.emp_no = c.emp_no
         LEFT JOIN dept d ON e1.dep_no = d.dep_no
         LEFT JOIN salary_grade sg1
                   ON e1.salary BETWEEN sg1.min_salary AND sg1.max_salary
         LEFT JOIN employee e2 ON e1.mgr_emp_no = e2.emp_no
         LEFT JOIN salary_grade sg2
                   ON e2.salary BETWEEN sg2.min_salary AND sg2.max_salary
ORDER BY 1;

-- NOTE: sub-query

-- 비상관쿼리
SELECT *
FROM employee
WHERE salary = (SELECT MAX(salary) FROM employee);

SELECT *
FROM employee
WHERE salary >= (SELECT AVG(salary) FROM employee);

-- 20번 부서의 최고연봉자
SELECT *
FROM employee
WHERE salary =
      (SELECT MAX(salary) FROM employee WHERE dep_no = 20)
  AND dep_no = 20;

SELECT emp_name AS 직원명,
       rank     AS 직급,
       salary   AS 연봉,
       TO_CHAR(salary / (SELECT SUM(salary) FROM employee) * 100, '099') ||
       '%'      AS 비율
FROM employee;

-- 10번 부서가 관리하는 고객
SELECT c.cus_no, c.cus_name, c.emp_no
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no
  AND e.dep_no = 10;

SELECT cus_no, cus_name, emp_no
FROM customer
WHERE emp_no IN (SELECT emp_no FROM employee WHERE dep_no = 10);

SELECT cus_no, cus_name, emp_no
FROM customer
WHERE emp_no = ANY (SELECT emp_no FROM employee WHERE dep_no = 10);

-- 한국남과 직급이 동일한 직원을 검색 (이름이 같은 사람이 없는 경우)
SELECT *
FROM employee
WHERE rank = (SELECT rank FROM employee WHERE emp_name = '한국남');

-- 무궁화와 직급이 동일한 직원을 검색 (동명이인의 경우)
SELECT *
FROM employee
WHERE rank IN (SELECT rank FROM employee WHERE emp_name = '무궁화');


-- 담당 고객이 2명 이상인 직원의 정보
SELECT e.emp_no, e.emp_name, e.rank
FROM employee e
WHERE (SELECT COUNT(*) FROM customer c WHERE e.emp_no = c.emp_no) >= 2;

-- 최고 연봉 직원의 직원번호, 직원명, 부서명, 연봉을 검색
SELECT e.emp_no, e.emp_name, d.dep_name, e.salary
FROM employee e,
     dept d
WHERE e.dep_no = d.dep_no
  AND e.salary = (SELECT MAX(salary) FROM employee);

SELECT e.emp_no,
       e.emp_name,
       (SELECT dep_name FROM dept d WHERE e.dep_no = d.dep_no) AS 부서,
       e.salary
FROM employee e
WHERE e.salary = (SELECT MAX(salary) FROM employee);

SELECT e.emp_no, e.emp_name, e.salary
FROM employee e
WHERE e.salary >= (SELECT AVG(salary) FROM employee)
  AND e.salary < (SELECT MAX(salary) FROM employee);

-- rownum
-- 상위 5명 구하기
-- inline view
SELECT emp_no, emp_name, salary, rownum
FROM (SELECT emp_no, emp_name, salary
      FROM employee
      ORDER BY salary DESC)
WHERE rownum <= 5;

-- rownum 은 1이 포함되지 않으면 행을 골라낼 수 없다
SELECT emp_no, emp_name, salary, rownum
FROM (SELECT emp_no, emp_name, salary
      FROM employee
      ORDER BY salary DESC)
WHERE rownum <= 5
  AND rownum > 3;

SELECT *
FROM (SELECT e.*, rownum AS rnum
      FROM (SELECT * FROM employee ORDER BY salary DESC) e
      WHERE rownum <= 5)
WHERE rnum >= 3;

SELECT *
FROM (SELECT e.*, rownum AS rnum
      FROM (SELECT *
            FROM employee
            ORDER BY DECODE(rank, '사장', 1, '부장', 2, '과장', 3, '대리', 4, '주임', 5,
                            6), hire_date) e
      WHERE rownum <= 5)
WHERE rnum >= 2;

-- 태어난 순서 11~20위
SELECT *
FROM (SELECT e.*, rownum AS rnum
      FROM (SELECT *
            FROM employee
            ORDER BY TO_DATE(SUBSTR(resist_num, 1, 6))) e
      WHERE rownum <= 20)
WHERE rnum >= 11;

-- 연봉 순위 구하기
-- SELECT e.emp_no, e.emp_name, salary, rownum AS 연봉순위
-- FROM (SELECT *
--       FROM employee
--       ORDER BY salary DESC) e;

SELECT e1.emp_no,
       e1.emp_name,
       e1.salary,
       (SELECT COUNT(*) + 1
        FROM employee e2
        WHERE e2.salary > e1.salary) AS 연봉순위
FROM employee e1
ORDER BY 4;

SELECT e1.emp_no,
       e1.emp_name,
       e1.resist_num,
       (SELECT COUNT(*) + 1
        FROM employee e2
        WHERE TO_DATE(SUBSTR(e2.resist_num, 1, 6)) <
              TO_DATE(SUBSTR(e1.resist_num, 1, 6))) AS 출생순서
FROM employee e1
ORDER BY 4;

SELECT emp_no,
       emp_name,
       (SELECT COUNT(*) FROM customer c WHERE e.emp_no = c.emp_no) AS 담당고객수
FROM employee e;

-- NOTE: join 과 sub-query 의 활용
SELECT dep_name                            AS 직원명,
       (SELECT COUNT(dep_no) FROM employee e WHERE d.dep_no = e.dep_no) ||
       '명'                                 AS 직원총수,
       (SELECT COUNT(*)
        FROM employee e2,
             customer c
        WHERE e2.dep_no = d.dep_no
          AND e2.emp_no = c.emp_no) || '명' AS 담당총고객수
FROM dept d;

--
SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank, e.dep_no
FROM customer c,
     employee e
WHERE c.emp_no = e.emp_no(+)
ORDER BY c.cus_no;

SELECT c.cus_no, c.cus_name, c.tel_num, e.emp_name, e.rank, e.dep_no
FROM customer c
         LEFT JOIN employee e ON e.emp_no = c.emp_no
ORDER BY c.cus_no;

SELECT c.cus_no,
       c.cus_name,
       c.tel_num,
       (SELECT emp_name FROM employee e WHERE e.emp_no = c.emp_no) AS 담당직원명,
       (SELECT rank FROM employee e WHERE e.emp_no = c.emp_no)     AS 담당직원직급,
       (SELECT dep_no FROM employee e WHERE e.emp_no = c.emp_no)   AS 부서번호
FROM customer c
ORDER BY c.cus_no;

SELECT c.cus_no,
       c.cus_name,
       c.tel_num,
       (SELECT emp_name
        FROM employee e
        WHERE e.emp_no = c.emp_no
          AND e.dep_no = 10) AS 담당직원명,
       (SELECT rank
        FROM employee e
        WHERE e.emp_no = c.emp_no
          AND e.dep_no = 10) AS 담당직원직급,
       (SELECT dep_no
        FROM employee e
        WHERE e.emp_no = c.emp_no
          AND e.dep_no = 10) AS 부서번호
FROM customer c
ORDER BY c.cus_no;
--

-- NOTE: group by
-- 그룹을 지어서 결과를 내놓을 때 사용하는 키워드이다.
-- 현재 상태를 파악하고 미래를 예측하기 위해 사용될 경우가 많으므로 굉장히 중요하다.
-- ex) 직급별 평균 연봉
-- ex) 남여별 평균 연봉
-- ex) 나이별 평균 연봉

SELECT dep_no, SUM(salary), ROUND(AVG(salary), 0), COUNT(*)
FROM employee
GROUP BY dep_no;

SELECT rank, SUM(salary), ROUND(AVG(salary), 0), COUNT(*) || '명'
FROM employee
GROUP BY rank;

SELECT dep_no, rank, SUM(salary), AVG(salary), COUNT(*)
FROM employee
GROUP BY dep_no, rank
ORDER BY dep_no;

-- HAVING
-- WHERE 절의 조건은 FROM 테이블명 으로 지정된 테이블을 대상으로 한다.
-- GROUP BY 절에 의해서 생긴 각 그룹에 대해서 조건을 적용하려면 HAVING 절을 사용해야 한다.
SELECT dep_no, rank, SUM(salary), ROUND(AVG(salary), 0), COUNT(*) AS 인원수
FROM employee
GROUP BY dep_no, rank
HAVING COUNT(*) >= 3
ORDER BY dep_no;

SELECT dep_no,
       CASE
           WHEN SUBSTR(resist_num, 7, 1) IN (1, 3) THEN '남'
           ELSE '여' END   AS gender,
       SUM(salary)        AS 연봉합계,
       ROUND(AVG(salary)) AS 평균연봉,
       COUNT(*)           AS 인원수
FROM employee
GROUP BY dep_no,
         CASE WHEN SUBSTR(resist_num, 7, 1) IN (1, 3) THEN '남' ELSE '여' END
ORDER BY dep_no;

SELECT EXTRACT(YEAR FROM hire_date) AS 입사연도, COUNT(*) AS 인원수
FROM employee
GROUP BY EXTRACT(YEAR FROM hire_date)
ORDER BY 1;

SELECT emp_name,
       TO_DATE(SUBSTR(resist_num, 1, 6))                    AS 출생연도,
       EXTRACT(YEAR FROM SYSDATE) -
       EXTRACT(YEAR FROM TO_DATE(SUBSTR(resist_num, 1, 6))) AS 나이
FROM employee;

SELECT dep_no, ROUND(AVG((SYSDATE - hire_date) / 365), 1) AS 평균근속연수
FROM employee
GROUP BY dep_no;

SELECT TO_CHAR(hire_date, 'Q') || '분기' AS 입사분기, COUNT(*) AS 인원수
FROM employee
GROUP BY TO_CHAR(hire_date, 'Q')
ORDER BY 1;

SELECT TO_CHAR(hire_date, 'Q') || '분기' AS 입사분기, COUNT(*) AS 인원수
FROM employee
WHERE TO_CHAR(hire_date, 'Q') = 1
GROUP BY TO_CHAR(hire_date, 'Q');

SELECT SUBSTR(TO_CHAR(hire_date, 'YYYY'), 1, 3) || '0' AS 입사연대,
       CASE
           WHEN SUBSTR(resist_num, 7, 1) IN (1, 3) THEN '남'
           ELSE '여' END                                AS gender,
       COUNT(*)
FROM employee
GROUP BY SUBSTR(TO_CHAR(hire_date, 'YYYY'), 1, 3) || '0',
         CASE WHEN SUBSTR(resist_num, 7, 1) IN (1, 3) THEN '남' ELSE '여' END
ORDER BY 1;

SELECT emp_name,
       TO_CHAR(hire_date, 'YYYY-MM-DD Q') || '분기 ' ||
       TO_CHAR(hire_date, 'DAY')                                      AS 입사일,
       TO_CHAR(ADD_MONTHS(hire_date, 12 * 20 + 5) + 10, 'YYYY-MM-DD') AS 퇴직일
FROM employee;

-- 아래 2개의 코드는 차이 구분하기
SELECT e.dep_no, d.loc, COUNT(d.dep_no)
FROM employee e,
     dept d
WHERE e.dep_no = d.dep_no
GROUP BY e.dep_no, d.loc
ORDER BY e.dep_no;

SELECT d.dep_no, d.loc, COUNT(e.emp_name)
FROM employee e,
     dept d
WHERE e.dep_no(+) = d.dep_no
GROUP BY d.dep_no, d.loc
ORDER BY d.dep_no;

SELECT EXTRACT(MONTH FROM hire_date) || '월' AS 입사월, COUNT(*)
FROM employee
GROUP BY EXTRACT(MONTH FROM hire_date)
ORDER BY EXTRACT(MONTH FROM hire_date);

SELECT m.month || '월' AS 입사월, COUNT(e.emp_name) AS 입사인원수
FROM (SELECT CASE WHEN rownum < 10 THEN '0' ELSE '' END || rownum AS month
      FROM employee
      WHERE rownum <= 12) m,
     employee e
WHERE m.month = TO_CHAR(e.hire_date(+), 'MM')
GROUP BY m.month || '월'
ORDER BY 입사월;

SELECT rank, ROUND(AVG(salary)), COUNT(*)
FROM employee
GROUP BY rank
ORDER BY DECODE(rank, '사장', 1, '부장', 2, '과장', 3, '대리', 4, '주임', 5, 6);

-- NOTE:
SELECT d.dep_no,
       d.dep_name,
       (SELECT COUNT(*) FROM employee e WHERE e.dep_no = d.dep_no) AS 직원수,
       (SELECT COUNT(*)
        FROM employee e,
             customer c
        WHERE e.dep_no = d.dep_no
          AND e.emp_no = c.emp_no)                                 AS 담당고객수
FROM dept d;

SELECT d.dep_no                 AS 부서번호,
       d.dep_name               AS 부서명,
       COUNT(DISTINCT e.emp_no) AS 직원수,
       COUNT(c.emp_no)          AS 담당고객수
FROM employee e,
     customer c,
     dept d
WHERE d.dep_no = e.dep_no(+)
  AND c.emp_no(+) = e.emp_no
GROUP BY d.dep_no, d.dep_name
ORDER BY 1;

-- NOTE: err check
SELECT COUNT(*)
FROM (SELECT SYSDATE + rownum - 1 AS xday
      FROM employee
      WHERE rownum <= 5) m
WHERE TO_CHAR(m.xday, 'dy') != '토'
  AND TO_CHAR(m.xday, 'dy') != '일'
  AND TO_CHAR(m.xday, 'dy') != '월';

-- NOTE: 주말 제외 평일 구하기
SELECT MAX(x.yy)                          AS year
     , MAX(DECODE(x.mm, '01', x.day_cnt)) AS "01"
     , MAX(DECODE(x.mm, '02', x.day_cnt)) AS "02"
     , MAX(DECODE(x.mm, '03', x.day_cnt)) AS "03"
     , MAX(DECODE(x.mm, '04', x.day_cnt)) AS "04"
     , MAX(DECODE(x.mm, '05', x.day_cnt)) AS "05"
     , MAX(DECODE(x.mm, '06', x.day_cnt)) AS "06"
     , MAX(DECODE(x.mm, '07', x.day_cnt)) AS "07"
     , MAX(DECODE(x.mm, '08', x.day_cnt)) AS "08"
     , MAX(DECODE(x.mm, '09', x.day_cnt)) AS "09"
     , MAX(DECODE(x.mm, '10', x.day_cnt)) AS "10"
     , MAX(DECODE(x.mm, '11', x.day_cnt)) AS "11"
     , MAX(DECODE(x.mm, '12', x.day_cnt)) AS "12"
FROM (
         SELECT a.yy, a.mm, COUNT(1) AS day_cnt
         FROM (SELECT TO_CHAR(sdt + level - 1, 'YYYY')   AS yy,
                      TO_CHAR(sdt + level - 1, 'YYYYMM') AS ym,
                      TO_CHAR(sdt + level - 1, 'MM')     AS mm,
--                       TO_CHAR(sdt + level - 1, 'YYYYMMDD') AS dt,
                      TO_CHAR(sdt + level - 1, 'D')      AS d
               FROM (SELECT TO_DATE('20210101', 'YYYYMMDD') AS sdt
                          , TO_DATE('20211231', 'YYYYMMDD') AS edt
                     FROM dual)
               CONNECT BY level <= edt - sdt + 1
              ) a
         WHERE a.d NOT IN ('1', '7') --1: 일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토
         GROUP BY a.yy, a.ym, a.mm
         ORDER BY a.ym
     ) x;

-- exists(subquery)
-- null 이 아니면 true 를 리턴해준다
SELECT cus_no, cus_name, emp_no
FROM customer c
WHERE EXISTS(SELECT e.emp_no
             FROM employee e
             WHERE e.emp_no = c.emp_no
               AND e.dep_no = 10);

-- 중복체크할 것
SELECT AVG(EXTRACT(YEAR FROM SYSDATE) -
           EXTRACT(YEAR FROM TO_DATE(SUBSTR(e.resist_num, 1, 6))) +
           1) AS 평균나이
FROM employee e,
     customer c
WHERE c.emp_no = e.emp_no;

SELECT AVG(EXTRACT(YEAR FROM SYSDATE) -
           EXTRACT(YEAR FROM TO_DATE(SUBSTR(e.resist_num, 1, 6))) +
           1) AS 평균나이
FROM employee e
WHERE e.emp_no IN (SELECT emp_no FROM customer);

SELECT AVG(EXTRACT(YEAR FROM SYSDATE) -
           EXTRACT(YEAR FROM TO_DATE(SUBSTR(e.resist_num, 1, 6))) +
           1) AS 평균나이
FROM employee e
WHERE (SELECT COUNT(*) FROM customer c WHERE c.emp_no = e.emp_no) > 0;

SELECT rank,
       ROUND(AVG(EXTRACT(YEAR FROM SYSDATE) -
                 EXTRACT(YEAR FROM TO_DATE(SUBSTR(resist_num, 1, 6))) +
                 1), 1) AS 평균나이
FROM employee
GROUP BY rank;

SELECT TRUNC(EXTRACT(YEAR FROM SYSDATE) -
             EXTRACT(YEAR FROM TO_DATE(SUBSTR(resist_num, 1, 6))) + 1,
             -1) || '대' AS 연령대,
       COUNT(*) || '명'  AS 인원수
FROM customer
GROUP BY TRUNC(EXTRACT(YEAR FROM SYSDATE) -
               EXTRACT(YEAR FROM TO_DATE(SUBSTR(resist_num, 1, 6))) +
               1, -1)
ORDER BY 연령대;

-- NOTE: INSERT
INSERT INTO employee
VALUES (emp_sq.nextval, '장보고', 40, '대리', 3500, TO_DATE('2012-05-28'), '8311091109310',
        '01092499215', 3);

-- NOTE: PK값을 주는 좀 더 좋은 방법
INSERT INTO employee
VALUES ((SELECT NVL(MAX(emp_no), 0) + 1 FROM employee), '장보고', 40, '대리', 3500,
        TO_DATE('2012-05-28'), '8311091109310',
        '01092499215', 3);

UPDATE employee
SET salary = salary * 1.05
WHERE resist_num = '8410031281312'
  AND emp_name = '공부해';

UPDATE employee
SET salary = salary * 0.98
WHERE salary > 4000;

UPDATE employee
SET salary = salary + 50
WHERE salary < (SELECT AVG(salary) FROM employee);

UPDATE employee e
SET salary = salary * 1.05
WHERE e.emp_no IN (SELECT DISTINCT c.emp_no FROM customer c WHERE e.emp_no = c.emp_no);

UPDATE employee
SET salary = salary * 1.05
WHERE emp_no IN (SELECT DISTINCT emp_no FROM customer WHERE emp_no IS NOT NULL);

UPDATE employee
SET salary = salary * 0.9
WHERE emp_no IN
      (SELECT emp_no
       FROM (SELECT emp_no FROM employee ORDER BY salary DESC, hire_date)
       WHERE rownum <= 5);

-- 인원수가 제일 많은 직급 중, 연봉 1위인 직원의 연봉을 1% 삭감하기
-- TODO: level 을 사용하여 해결해보기
UPDATE employee
SET salary = salary * 0.99
WHERE emp_no = (SELECT emp_no
                FROM employee
                WHERE salary = (SELECT MAX(salary)
                                FROM employee
                                WHERE rank = (SELECT rank
                                              FROM (SELECT rank, COUNT(*) AS 인원수
                                                    FROM employee
                                                    GROUP BY rank
                                                    ORDER BY 인원수 DESC)
                                              WHERE rownum = 1)));

UPDATE employee
SET salary = salary * 0.99
WHERE emp_no =
      (SELECT emp_no
       FROM (SELECT emp_no,
                    rank,
                    (SELECT COUNT(*) FROM employee e2 WHERE e1.rank = e2.rank) AS cnt,
                    salary
             FROM employee e1
             ORDER BY cnt DESC, salary DESC)
       WHERE rownum = 1);

SELECT *
FROM employee;

-- copy table
CREATE TABLE employee2 AS
SELECT *
FROM employee;

CREATE TABLE student AS
SELECT emp_no AS stu_no, emp_name AS stu_name, resist_num
FROM employee;

-- NOTE: table view 가상테이블
-- 원하는 정보만 가공해서 다룰 수 있다.
-- 보안성 향상
CREATE VIEW employee_vw1 AS
SELECT *
FROM employee
ORDER BY salary DESC;

SELECT * FROM employee_vw1;

