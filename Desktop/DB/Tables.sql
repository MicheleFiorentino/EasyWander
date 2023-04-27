drop table if exists user;
drop table if exists employee;
drop table if exists operator;

drop table if exists credit_card;
drop table if exists debit_card;
drop table if exists voucher;

drop table if exists scooter;
drop table if exists hub;
drop table if exists rental;
drop table if exists subscription;

#NB: per far rimanere semplici le cose, le date sono invece varchar(10),
#secondo il modello "GG-MM-YYYY"




#PEOPLE

create table user (
email varchar(50) primary key,
name varchar(25),
surname varchar(25),
password varchar(50),
birth_date varchar(10),
credit float
);

create table employee (
email varchar(50) primary key,
name varchar(25),
surname varchar(25),
password varchar(50),
birth_date varchar(10),
cell varchar(10),
fiscal_code varchar(11)
);

create table operator (
email varchar(50) primary key,
name varchar(25),
surname varchar(25),
password varchar(50),
birth_date varchar(10),
cell varchar(10),
fiscal_code varchar(11)
);


#PAYMENT FORMS

create table credit_card(
number varchar(16) primary key,
user_email varchar(50),
name varchar(30),
owner varchar(50),
expiration_date varchar(10)
);

create table debit_card(
number varchar(16) primary key,
user_email varchar(50),
name varchar(30),
owner varchar(50),
expiration_date varchar(10)
);

create table voucher(
name varchar(30) primary key,
value float,
expiration_date varchar(10)
);


#OTHER

create table scooter(
name varchar(10) primary key,
state bool,
inHub bool,
posX float,
posY float
);

create table hub(
name varchar(20) primary key,
posX float,
posY float
);

create table rental(
id int primary key auto_increment,
user_email varchar(50),
rental_time float
);

create table subscription(
name varchar(50) primary key,
cost float
);









