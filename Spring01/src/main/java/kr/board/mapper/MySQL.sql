create table tboard(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(100) not null,
	writer varchar(100) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);

insert into tboard(title, content, writer)
values('Hunter Study1', '레오리오', '김석환');

insert into tboard(title, content, writer)
values('Hunter Study2', '트라피카', '김석환');

insert into tboard(title, content, writer)
values('Hunter Study3', '곤', '김석환');

insert into tboard(title, content, writer)
values('Hunter Study4', '키르아', '김석환');

select * from tboard;