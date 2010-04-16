create table states(
id int auto_increment primary key,
name varchar(10) not null,
descr varchar(50)
);

create table dbdetail(
id int auto_increment primary key,
states_id int not null,
name varchar(100) not null,
password varchar(100) not null,
ip varchar(100) not null,
port int not null,
sid varchar(100) not null,
entry_date datetime not null,
descr varchar(500)
);
alter table dbdetail add constraint fk_states_id
foreign key (states_id)
references states(id);

create table bugdetail(
id int auto_increment primary key,
bug_number int
);

insert into states(name,descr) values('FLUI','FLUIEDC');
insert into states(name,descr) values('FL','FLEDC');
insert into states(name,descr) values('OKUI','OKUIEDC');
insert into states(name,descr) values('OK','OKEDC');
insert into states(name,descr) values('GA','GAEDC');
