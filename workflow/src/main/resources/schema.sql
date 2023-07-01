drop table if exists accounts;
drop table if exists test;

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
is_admin boolean default false
);
