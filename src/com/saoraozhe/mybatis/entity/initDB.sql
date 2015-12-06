create table message_type
(
	tid int primary key,
	tname varchar(20) not null
);
create table message
(
	mid int primary key,
	content varchar(256) not null,
    tid int
);
alter table message add constraint fk_message_tid foreign key (tid) references message_type(tid);