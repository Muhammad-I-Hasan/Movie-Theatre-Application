create user "sqluser" @"localhost" identified by "password";

create database theater;

CREATE TABLE `theater` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
);


create table movie(
movie varchar(50) primary key,
theatername varchar(50),
released boolean,
foreign key (theatername) references theater(name)
);

create table showtime(
id int auto_increment primary key,
showtime varchar(50),
moviename varchar(50),
date varchar(50),
foreign key (moviename) references movie(movie)
);

create table seat(
id int auto_increment primary key,
seatNum int,
showtimeid int,
available boolean,
foreign key (showtimeid) references showtime(id)
);

create table user(
email varchar(50) primary key,
cardnum varchar(50),
registered boolean,
name varchar(50),
address varchar(50),
password varchar(50)
);

create table ticket(
id int auto_increment primary key,
useremail varchar(50),
movieName varchar(50),
date varchar(50),
time varchar(50),
seatnum int,
foreign key (useremail) references user(email)
);

insert into theater (name)
values ("Cineplex");

insert into movie (movie,theatername,released)
values ("Frozen","Cineplex",false),
("Pulp Fiction","Cineplex",true),
("Titanic","Cineplex",true),
("Inception","Cineplex",true),
("The Godfather","Cineplex",true);

insert into showtime(showtime,moviename,date)
values ("12:00","Frozen","12-12-2022"),
("13:00","Frozen","12-12-2022"),
("14:00","Frozen","12-12-2022"),
("15:00","Frozen","12-12-2022"),
("16:00","Frozen","12-12-2022"),
("12:00","Pulp Fiction","4-12-2022"),
("13:00","Pulp Fiction","4-12-2022"),
("14:00","Pulp Fiction","4-12-2022"),
("15:00","Pulp Fiction","4-12-2022"),
("16:00","Pulp Fiction","4-12-2022"),
("12:00","Titanic","4-12-2022"),
("13:00","Titanic","4-12-2022"),
("14:00","Titanic","4-12-2022"),
("15:00","Titanic","4-12-2022"),
("16:00","Titanic","4-12-2022"),
("12:00","Inception","4-12-2022"),
("13:00","Inception","4-12-2022"),
("14:00","Inception","4-12-2022"),
("15:00","Inception","4-12-2022"),
("16:00","Inception","4-12-2022"),
("12:00","The Godfather","4-12-2022"),
("13:00","The Godfather","4-12-2022"),
("14:00","The Godfather","4-12-2022"),
("15:00","The Godfather","4-12-2022"),
("16:00","The Godfather","4-12-2022");

insert into seat (seatNum, showtimeid, available)
values(1,1,true),
(2,1,true),
(3,1,true),
(4,1,true),
(5,1,true),
(6,1,true),
(7,1,true),
(8,1,true),
(9,1,true),
(10,1,true),
(11,1,true),
(12,1,true),
(13,1,true),
(14,1,true),
(15,1,true),
(16,1,true),
(17,1,true),
(18,1,true),
(19,1,true),
(20,1,true),
(1,2,true),
(2,2,true),
(3,2,true),
(4,2,true),
(5,2,true),
(6,2,true),
(7,2,true),
(8,2,true),
(9,2,true),
(10,2,true),
(11,2,true),
(12,2,true),
(13,2,true),
(14,2,true),
(15,2,true),
(16,2,true),
(17,2,true),
(18,2,true),
(19,2,true),
(20,2,true),
(1,3,true),
(2,3,true),
(3,3,true),
(4,3,true),
(5,3,true),
(6,3,true),
(7,3,true),
(8,3,true),
(9,3,true),
(10,3,true),
(11,3,true),
(12,3,true),
(13,3,true),
(14,3,true),
(15,3,true),
(16,3,true),
(17,3,true),
(18,3,true),
(19,3,true),
(20,3,true),
(1,4,true),
(2,4,true),
(3,4,true),
(4,4,true),
(5,4,true),
(6,4,true),
(7,4,true),
(8,4,true),
(9,4,true),
(10,4,true),
(11,4,true),
(12,4,true),
(13,4,true),
(14,4,true),
(15,4,true),
(16,4,true),
(17,4,true),
(18,4,true),
(19,4,true),
(20,4,true),
(1,5,true),
(2,5,true),
(3,5,true),
(4,5,true),
(5,5,true),
(6,5,true),
(7,5,true),
(8,5,true),
(9,5,true),
(10,5,true),
(11,5,true),
(12,5,true),
(13,5,true),
(14,5,true),
(15,5,true),
(16,5,true),
(17,5,true),
(18,5,true),
(19,5,true),
(20,5,true),
(1,6,true),
(2,6,true),
(3,6,true),
(4,6,true),
(5,6,true),
(6,6,true),
(7,6,true),
(8,6,true),
(9,6,true),
(10,6,true),
(11,6,true),
(12,6,true),
(13,6,true),
(14,6,true),
(15,6,true),
(16,6,true),
(17,6,true),
(18,6,true),
(19,6,true),
(20,6,true),
(1,7,true),
(2,7,true),
(3,7,true),
(4,7,true),
(5,7,true),
(6,7,true),
(7,7,true),
(8,7,true),
(9,7,true),
(10,7,true),
(11,7,true),
(12,7,true),
(13,7,true),
(14,7,true),
(15,7,true),
(16,7,true),
(17,7,true),
(18,7,true),
(19,7,true),
(20,7,true),
(1,8,true),
(2,8,true),
(3,8,true),
(4,8,true),
(5,8,true),
(6,8,true),
(7,8,true),
(8,8,true),
(9,8,true),
(10,8,true),
(11,8,true),
(12,8,true),
(13,8,true),
(14,8,true),
(15,8,true),
(16,8,true),
(17,8,true),
(18,8,true),
(19,8,true),
(20,8,true),
(1,9,true),
(2,9,true),
(3,9,true),
(4,9,true),
(5,9,true),
(6,9,true),
(7,9,true),
(8,9,true),
(9,9,true),
(10,9,true),
(11,9,true),
(12,9,true),
(13,9,true),
(14,9,true),
(15,9,true),
(16,9,true),
(17,9,true),
(18,9,true),
(19,9,true),
(20,9,true),
(1,10,true),
(2,10,true),
(3,10,true),
(4,10,true),
(5,10,true),
(6,10,true),
(7,10,true),
(8,10,true),
(9,10,true),
(10,10,true),
(11,10,true),
(12,10,true),
(13,10,true),
(14,10,true),
(15,10,true),
(16,10,true),
(17,10,true),
(18,10,true),
(19,10,true),
(20,10,true),
(1,11,true),
(2,11,true),
(3,11,true),
(4,11,true),
(5,11,true),
(6,11,true),
(7,11,true),
(8,11,true),
(9,11,true),
(10,11,true),
(11,11,true),
(12,11,true),
(13,11,true),
(14,11,true),
(15,11,true),
(16,11,true),
(17,11,true),
(18,11,true),
(19,11,true),
(20,11,true),
(1,12,true),
(2,12,true),
(3,12,true),
(4,12,true),
(5,12,true),
(6,12,true),
(7,12,true),
(8,12,true),
(9,12,true),
(10,12,true),
(11,12,true),
(12,12,true),
(13,12,true),
(14,12,true),
(15,12,true),
(16,12,true),
(17,12,true),
(18,12,true),
(19,12,true),
(20,12,true),
(1,13,true),
(2,13,true),
(3,13,true),
(4,13,true),
(5,13,true),
(6,13,true),
(7,13,true),
(8,13,true),
(9,13,true),
(10,13,true),
(11,13,true),
(12,13,true),
(13,13,true),
(14,13,true),
(15,13,true),
(16,13,true),
(17,13,true),
(18,13,true),
(19,13,true),
(20,13,true),
(1,14,true),
(2,14,true),
(3,14,true),
(4,14,true),
(5,14,true),
(6,14,true),
(7,14,true),
(8,14,true),
(9,14,true),
(10,14,true),
(11,14,true),
(12,14,true),
(13,14,true),
(14,14,true),
(15,14,true),
(16,14,true),
(17,14,true),
(18,14,true),
(19,14,true),
(20,14,true),
(1,15,true),
(2,15,true),
(3,15,true),
(4,15,true),
(5,15,true),
(6,15,true),
(7,15,true),
(8,15,true),
(9,15,true),
(10,15,true),
(11,15,true),
(12,15,true),
(13,15,true),
(14,15,true),
(15,15,true),
(16,15,true),
(17,15,true),
(18,15,true),
(19,15,true),
(20,15,true),
(1,16,true),
(2,16,true),
(3,16,true),
(4,16,true),
(5,16,true),
(6,16,true),
(7,16,true),
(8,16,true),
(9,16,true),
(10,16,true),
(11,16,true),
(12,16,true),
(13,16,true),
(14,16,true),
(15,16,true),
(16,16,true),
(17,16,true),
(18,16,true),
(19,16,true),
(20,16,true),
(1,17,true),
(2,17,true),
(3,17,true),
(4,17,true),
(5,17,true),
(6,17,true),
(7,17,true),
(8,17,true),
(9,17,true),
(10,17,true),
(11,17,true),
(12,17,true),
(13,17,true),
(14,17,true),
(15,17,true),
(16,17,true),
(17,17,true),
(18,17,true),
(19,17,true),
(20,17,true),
(1,18,true),
(2,18,true),
(3,18,true),
(4,18,true),
(5,18,true),
(6,18,true),
(7,18,true),
(8,18,true),
(9,18,true),
(10,18,true),
(11,18,true),
(12,18,true),
(13,18,true),
(14,18,true),
(15,18,true),
(16,18,true),
(17,18,true),
(18,18,true),
(19,18,true),
(20,18,true),
(1,19,true),
(2,19,true),
(3,19,true),
(4,19,true),
(5,19,true),
(6,19,true),
(7,19,true),
(8,19,true),
(9,19,true),
(10,19,true),
(11,19,true),
(12,19,true),
(13,19,true),
(14,19,true),
(15,19,true),
(16,19,true),
(17,19,true),
(18,19,true),
(19,19,true),
(20,19,true),
(1,20,true),
(2,20,true),
(3,20,true),
(4,20,true),
(5,20,true),
(6,20,true),
(7,20,true),
(8,20,true),
(9,20,true),
(10,20,true),
(11,20,true),
(12,20,true),
(13,20,true),
(14,20,true),
(15,20,true),
(16,20,true),
(17,20,true),
(18,20,true),
(19,20,true),
(20,20,true),
(1,21,true),
(2,21,true),
(3,21,true),
(4,21,true),
(5,21,true),
(6,21,true),
(7,21,true),
(8,21,true),
(9,21,true),
(10,21,true),
(11,21,true),
(12,21,true),
(13,21,true),
(14,21,true),
(15,21,true),
(16,21,true),
(17,21,true),
(18,21,true),
(19,21,true),
(20,21,true),
(1,22,true),
(2,22,true),
(3,22,true),
(4,22,true),
(5,22,true),
(6,22,true),
(7,22,true),
(8,22,true),
(9,22,true),
(10,22,true),
(11,22,true),
(12,22,true),
(13,22,true),
(14,22,true),
(15,22,true),
(16,22,true),
(17,22,true),
(18,22,true),
(19,22,true),
(20,22,true),
(1,23,true),
(2,23,true),
(3,23,true),
(4,23,true),
(5,23,true),
(6,23,true),
(7,23,true),
(8,23,true),
(9,23,true),
(10,23,true),
(11,23,true),
(12,23,true),
(13,23,true),
(14,23,true),
(15,23,true),
(16,23,true),
(17,23,true),
(18,23,true),
(19,23,true),
(20,23,true),
(1,24,true),
(2,24,true),
(3,24,true),
(4,24,true),
(5,24,true),
(6,24,true),
(7,24,true),
(8,24,true),
(9,24,true),
(10,24,true),
(11,24,true),
(12,24,true),
(13,24,true),
(14,24,true),
(15,24,true),
(16,24,true),
(17,24,true),
(18,24,true),
(19,24,true),
(20,24,true),
(1,25,true),
(2,25,true),
(3,25,true),
(4,25,true),
(5,25,true),
(6,25,true),
(7,25,true),
(8,25,true),
(9,25,true),
(10,25,true),
(11,25,true),
(12,25,true),
(13,25,true),
(14,25,true),
(15,25,true),
(16,25,true),
(17,25,true),
(18,25,true),
(19,25,true),
(20,25,true);

insert into user(email, cardnum, registered, name,address, password)
values ("user1@gmail.com","1234",true,"user1","123 st","password"),
("user2@gmail.com","1234",true,"user2","123 blvd","password");


