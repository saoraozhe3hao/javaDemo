create table company
(
	cid int primary key,
	cname varchar(20) not null
);
create table employee
(
	eid int primary key,
	ename varchar(20) not null,
	sex char(2),
	cid int
);
alter table employee add constraint fk_employee_cid foreign key (cid) references company(cid);