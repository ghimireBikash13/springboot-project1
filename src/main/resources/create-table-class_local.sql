create schema class_local_db;
use class_local_db;
create table student(
id int not null auto_increment,
first_name varchar(40),
last_name varchar(40),
email varchar(40),
phone varchar(15),
created_at datetime,
updated_at datetime,
uuid varchar(200) not null,
primary key (id)
);