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

select * from dept;

drop table dept;