drop table if exists accounts;
drop table if exists test;
drop table if exists departments;
drop table if exists workflows;

create table workflows
(
id serial primary key,
title text,
created_user_id integer,
created_datetime timestamp
);

create table departments
(
id serial primary key,
name text

);


create table test
(
id serial primary key,
content text
);


create table accounts
(
id serial primary key,
name text,
login_id text,
login_pw text,
is_admin boolean default false not null
);
