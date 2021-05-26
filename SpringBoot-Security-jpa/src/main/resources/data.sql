insert into user (id,active,password,username) values (1,true,'pass','admin');
insert into user (id,active,password,username) values (2,true,'pass','user1');
insert into user (id,active,password,username) values (3,false,'pass','user2');

insert into role (id,name,user_id) values (1,'ROLE_ADMIN',1);
insert into role (id,name,user_id) values (2,'ROLE_USER',3);
insert into role (id,name,user_id) values (3,'ROLE_USER',2);
