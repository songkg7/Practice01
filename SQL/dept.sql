-- dept table 만들기
CREATE TABLE dept
(
    dep_no   number(2),
    dep_name varchar2(20) NOT NULL UNIQUE,
    loc      varchar2(20) NOT NULL,
    --------------------------------
    PRIMARY KEY (dep_no)
);
INSERT INTO dept(dep_no, dep_name, loc)
VALUES (10, '총무부', '서울');
INSERT INTO dept(dep_no, dep_name, loc)
VALUES (20, '영업부', '부산');
INSERT INTO dept(dep_no, dep_name, loc)
VALUES (30, '전산부', '대전');
INSERT INTO dept(dep_no, dep_name, loc)
VALUES (40, '자재부', '광주');
INSERT INTO dept
VALUES (50, '관리부', '광주');

-- 아래 2개의 코드는 같다.
UPDATE dept
SET loc='서울'
WHERE dep_no = 40;
UPDATE dept
SET loc='서울'
WHERE dep_name = '자재부';

-- show all table column
SELECT *
FROM dept;

SELECT LOC, COUNT(*)
FROM dept
GROUP BY LOC;

CREATE TABLE employee
(
    emp_no     number(2),
    emp_name   varchar2(30) NOT NULL,
    dep_no     number(2),
    rank       varchar2(10) NOT NULL,
    salary     number(10) DEFAULT 0,
    hire_date  date       DEFAULT SYSDATE,
    resist_num char(13)     NOT NULL UNIQUE,
    phone_num  varchar2(15) NOT NULL,
    mgr_emp_no number(2),
    -----------------------
    PRIMARY KEY (emp_no),
    FOREIGN KEY (dep_no) REFERENCES dept (dep_no),
    CONSTRAINT employee_mgr_emp_no_fk FOREIGN KEY (mgr_emp_no) REFERENCES employee (emp_no)
);

CREATE SEQUENCE emp_sq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999;

-- DROP SEQUENCE emp_sq;

CREATE SEQUENCE cus_sq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999;

-- DROP SEQUENCE cus_sq;

-- employee_mgr_emp_no_fk 의 제약조건 끄기
ALTER TABLE employee
    DISABLE CONSTRAINT employee_mgr_emp_no_fk;

INSERT INTO employee
VALUES (emp_sq.nextval, '홍길동', 10, '사장', 5000, TO_DATE('1980-01-01'), '7211271109410', '01099699515', NULL);
INSERT INTO employee
VALUES (emp_sq.nextval, '한국남', 20, '부장', 3000, TO_DATE('1988-11-01'), '6002061841224', '01024948424', 1);
INSERT INTO employee
VALUES (emp_sq.nextval, '이순신', 20, '과장', 3500, TO_DATE('1989-03-01'), '6209172010520', '01026352672', 2);
INSERT INTO employee
VALUES (emp_sq.nextval, '이미라', 30, '대리', 2503, TO_DATE('1983-04-01'), '8409282070226', '01094215694', 17);
INSERT INTO employee
VALUES (emp_sq.nextval, '이순라', 20, '사원', 1200, TO_DATE('1990-05-01'), '8401041483626', '01028585900', 3);
INSERT INTO employee
VALUES (emp_sq.nextval, '공부만', 30, '과장', 4003, TO_DATE('1995-05-01'), '8402121563616', '01191338328', 17);
INSERT INTO employee
VALUES (emp_sq.nextval, '놀기만', 20, '과장', 2300, TO_DATE('1996-06-01'), '8011221713914', '01029463523', 2);
INSERT INTO employee
VALUES (emp_sq.nextval, '채송화', 30, '대리', 1703, TO_DATE('1992-06-01'), '8105271014112', '01047111052', 17);
INSERT INTO employee
VALUES (emp_sq.nextval, '무궁화', 10, '사원', 1100, TO_DATE('1984-08-01'), '8303291319116', '01025672300', 12);
INSERT INTO employee
VALUES (emp_sq.nextval, '공부해', 30, '사원', 1303, TO_DATE('1988-11-01'), '8410031281312', '01027073174', 4);
INSERT INTO employee
VALUES (emp_sq.nextval, '류별나', 20, '과장', 1600, TO_DATE('1989-12-01'), '8409181463545', '01071628290', 2);
INSERT INTO employee
VALUES (emp_sq.nextval, '류명한', 10, '대리', 1800, TO_DATE('1990-10-01'), '8207211661117', '01042072622', 20);
INSERT INTO employee
VALUES (emp_sq.nextval, '무궁화', 10, '부장', 3000, TO_DATE('1996-11-01'), '8603231183011', '01098110955', 1);
INSERT INTO employee
VALUES (emp_sq.nextval, '채시라', 20, '사원', 3400, TO_DATE('1993-10-01'), '8001172065410', '01044452437', 3);
INSERT INTO employee
VALUES (emp_sq.nextval, '최진실', 10, '사원', 2000, TO_DATE('1991-04-01'), '8303101932611', '01027491145', 12);
INSERT INTO employee
VALUES (emp_sq.nextval, '김유신', 30, '사원', 4000, TO_DATE('1981-04-01'), '7912031009014', '01098218448', 4);
INSERT INTO employee
VALUES (emp_sq.nextval, '이성계', 30, '부장', 2803, TO_DATE('1984-05-01'), '8102261713921', '0165358075', 1);
INSERT INTO employee
VALUES (emp_sq.nextval, '강감찬', 30, '사원', 1003, TO_DATE('1986-07-01'), '8203121977315', '01033583130', 4);
INSERT INTO employee
VALUES (emp_sq.nextval, '임꺽정', 20, '사원', 2200, TO_DATE('1988-04-01'), '8701301040111', '01086253078', 7);
INSERT INTO employee
VALUES (emp_sq.nextval, '깨똥이', 10, '과장', 4500, TO_DATE('1990-05-01'), '8811232452719', '01090084876', 13);

ALTER TABLE employee
    ENABLE CONSTRAINT employee_mgr_emp_no_fk;
-- delete from employee;


CREATE TABLE customer
(
    cus_no     number(3),
    cus_name   varchar2(10) NOT NULL,
    tel_num    varchar2(15),
    resist_num char(13)     NOT NULL UNIQUE,
    emp_no     number(3),
    ----------------------------
    PRIMARY KEY (cus_no),
    FOREIGN KEY (emp_no) REFERENCES employee (emp_no)
);

INSERT INTO customer
VALUES (cus_sq.nextval, '류민이', '123-1234', '7001131537915', 3);
INSERT INTO customer
VALUES (cus_sq.nextval, '이강민', '343-1454', '6902161627914', 2);
INSERT INTO customer
VALUES (cus_sq.nextval, '이영희', '144-1655', '7503202636215', NULL);
INSERT INTO customer
VALUES (cus_sq.nextval, '김철이', '673-1674', '7704301234567', 4);
INSERT INTO customer
VALUES (cus_sq.nextval, '박류완', '123-1674', '7205211123675', 3);
INSERT INTO customer
VALUES (cus_sq.nextval, '서캔디', '673-1764', '6507252534566', NULL);
INSERT INTO customer
VALUES (cus_sq.nextval, '신똘이', '176-7677', '0006083648614', 7);
INSERT INTO customer
VALUES (cus_sq.nextval, '도쇠돌', '673-6774', '0008041346574', 9);
INSERT INTO customer
VALUES (cus_sq.nextval, '권홍이', '767-1234', '7312251234689', 13);
INSERT INTO customer
VALUES (cus_sq.nextval, '김안나', '767-1677', '7510152432168', 4);

SELECT *
FROM customer;

CREATE TABLE salary_grade
(
    sal_grade_no number(2) PRIMARY KEY,
    min_salary   number(5) NOT NULL,
    max_salary   number(5) NOT NULL
);

INSERT INTO salary_grade
VALUES (1, 8000, 10000);
INSERT INTO salary_grade
VALUES (2, 6000, 7999);
INSERT INTO salary_grade
VALUES (3, 4000, 5999);
INSERT INTO salary_grade
VALUES (4, 2000, 3999);
INSERT INTO salary_grade
VALUES (5, 1000, 1999);

-- select * from user_users;
-- DROP TABLE salary_grade;
-- DROP TABLE customer;
-- DROP TABLE employee;
-- DROP TABLE dept;
