-- dept table 만들기
create table dept(
    dep_no number(2),
    dep_name varchar2(20) not null unique,
    loc varchar2(20) not null,
    --------------------------------
    primary key (dep_no)
);

insert into dept(dep_no, dep_name, loc) values (10, '총무부', '서울');
insert into dept(dep_no, dep_name, loc) values (20, '영업부', '부산');
insert into dept(dep_no, dep_name, loc) values (30, '전산부', '대전');
insert into dept(dep_no, dep_name, loc) values (40, '자재부', '광주');
insert into dept values (50, '관리부', '광주');

-- 아래 2개의 코드는 같다.
update dept set loc='서울' where dep_no=40;
update dept set loc='서울' where dep_name='자재부';

-- show all table column
select * from dept;

select LOC, count(*) from dept group by LOC;

create table employee (
    emp_no number(2),
    emp_name varchar2(30) not null,
    dep_no number(2),
    rank varchar2(10) not null,
    salary number(10) default 0,
    hire_date date default sysdate,
    resist_num char(13) not null unique,
    phone_num varchar2(15) not null,
    mgr_emp_no number(2),
    -----------------------
    primary key(emp_no),
    foreign key(dep_no) references dept(dep_no),
    constraint employee_mgr_emp_no_fk foreign key(mgr_emp_no) references employee(emp_no)
);

-- employee_mgr_emp_no_fk 의 제약조건 끄기
alter table employee disable constraint employee_mgr_emp_no_fk;
alter table employee enable constraint employee_mgr_emp_no_fk;

insert into employee values( 1, '홍길동', 10, '사장', 5000, to_date('1980-01-01'), '7211271109410', '01099699515', null );
insert into employee values( 2, '한국남', 20, '부장', 3000, to_date('1988-11-01'), '6002061841224', '01024948424', 1 );
insert into employee values( 3, '이순신', 20, '과장', 3500, to_date('1989-03-01'), '6209172010520', '01026352672', 2 );
insert into employee values( 4, '이미라', 30, '대리', 2503, to_date('1983-04-01'), '8409282070226', '01094215694', 17 );
insert into employee values( 5, '이순라', 20, '사원', 1200, to_date('1990-05-01'), '8401041483626', '01028585900', 3 );
insert into employee values( 6, '공부만', 30, '과장', 4003, to_date('1995-05-01'), '8402121563616', '01191338328', 17 );
insert into employee values( 7, '놀기만', 20, '과장', 2300, to_date('1996-06-01'), '8011221713914', '01029463523', 2 );
insert into employee values( 8, '채송화', 30, '대리', 1703, to_date('1992-06-01'), '8105271014112', '01047111052', 17 );
insert into employee values( 9, '무궁화', 10, '사원', 1100, to_date('1984-08-01'), '8303291319116', '01025672300', 12 );
insert into employee values( 10, '공부해', 30, '사원', 1303, to_date('1988-11-01'), '8410031281312', '01027073174', 4 );
insert into employee values( 11, '류별나', 20, '과장', 1600, to_date('1989-12-01'), '8409181463545', '01071628290', 2 );
insert into employee values( 12, '류명한', 10, '대리', 1800, to_date('1990-10-01'), '8207211661117', '01042072622', 20 );
insert into employee values( 13, '무궁화', 10, '부장', 3000, to_date('1996-11-01'), '8603231183011', '01098110955', 1 );
insert into employee values( 14, '채시라', 20, '사원', 3400, to_date('1993-10-01'), '8001172065410', '01044452437', 3 );
insert into employee values( 15, '최진실', 10, '사원', 2000, to_date('1991-04-01'), '8303101932611', '01027491145', 12 );
insert into employee values( 16, '김유신', 30, '사원', 4000, to_date('1981-04-01'), '7912031009014', '01098218448', 4 );
insert into employee values( 17, '이성계', 30, '부장', 2803, to_date('1984-05-01'), '8102261713921', '0165358075', 1 );
insert into employee values( 18, '강감찬', 30, '사원', 1003, to_date('1986-07-01'), '8203121977315', '01033583130', 4 );
insert into employee values( 19, '임꺽정', 20, '사원', 2200, to_date('1988-04-01'), '8701301040111', '01086253078', 7 );
insert into employee values( 20, '깨똥이', 10, '과장', 4500, to_date('1990-05-01'), '8811232452719', '01090084876', 13 );

-- delete from employee;

select * from employee;
select * from customer;

create table customer(
    cus_no number(3),
    cus_name varchar2(10) not null,
    tel_num varchar2(15),
    resist_num char(13) not null unique,
    emp_no number(3),
    ----------------------------
    primary key (cus_no),
    foreign key (emp_no) references employee(emp_no)
);

insert into customer values (1, '류민이', '123-1234', '7001131537915', 3);
insert into customer values (2, '이강민', '343-1454', '6901131537915', 3);

