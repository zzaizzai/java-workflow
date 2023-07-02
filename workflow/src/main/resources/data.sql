insert into accounts(name, login_id, login_pw, is_admin) values('admin', 'admin', '1234', 'true');

insert into workflows(title, created_user_id,created_datetime) values('first workflow', '1', '2023-7-2'); 
insert into workflows(title, created_user_id,created_datetime) values('2nd workflow', '1', now()); 


insert into test(content) values('good');