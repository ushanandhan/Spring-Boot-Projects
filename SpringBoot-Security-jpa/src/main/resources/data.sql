insert into user (id,active,password,username) values (1,true,'pass','ushan');
insert into user (id,active,password,username) values (2,false,'pass','ariya');
insert into user (id,active,password,username) values (3,true,'pass','kevin');

insert into role (id,name,user_id) values (1,'ROLE_ADMIN',1);
insert into role (id,name,user_id) values (2,'ROLE_USER',3);
insert into role (id,name,user_id) values (3,'ROLE_USER',2);
