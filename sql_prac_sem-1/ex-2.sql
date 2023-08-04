#question-a
create table student(
rollno int,
name varchar(300),
dob date,
gender varchar(1),
doa date,
bcode int,
primary key(rollno),
check(gender in ('M','F','T'))
);


insert into student
(rollno,name,dob,gender,doa,bcode)
values
(100,'Vicky Vale','1999-10-02','F','1999-10-02'),

create table branch(
bcode int,
bname varchar(100),
dno int,
primary key(bcode)
);

create table department(
dno int,
dname varchar(100),
primary key(dno)
);

create table course(
ccode int,
cname varchar(100),
credits int,
dno int,
primary key(ccode),
FOREIGN KEY(dno) references department(dno)
);


create table branch_course(
bcode int,
ccode int,
semester int,
primary key(bcode,ccode),
FOREIGN key(bcode) references branch(bcode),
FOREIGN key(ccode) references course(ccode)
);


create table prereq_course(
ccode int,
pccode int,
primary key(ccode,pccode),
FOREIGN KEY(ccode) references course(ccode),
FOREIGN KEY(pccode) references course(ccode)
);

create table enrolls (
rollno int,
ccode int,
sess varchar(100),
grade enum('S','A','B','C','D','E','U'),
primary key(rollno,ccode,sess),
foreign key(rollno) references student(rollno),
foreign key(ccode) references course(ccode)
);




drop table prereq_course;
drop table enrolls;
drop table branch_course;
drop table course;
drop table department;
drop table branch;
drop table student;