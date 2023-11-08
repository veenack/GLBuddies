insert into roles values (1, 'ROLE_USER');
insert into roles values (2, 'ROLE_ADMIN');
--insert into roles values (3, 'ROLE_SUPERADMIN');

insert into users values (1, 'nka', 'nkapassword');
insert into users_roles values (1,1);

insert into users values (2, 'kumar', 'kumarpassword');
--insert into users values (2, '$2a$10$u6ijlv/zWtVgpMIook4xg.nDRtrl0KgxGQX/iBln8iQY9ICdQwj9u', 'kumarpassword');
insert into users_roles values (2,2);

insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('mani@gmail.com','Mani','Kumar');
insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('kani@gmail.com','Kani','Kumar');
insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('rudhra@gmail.com','Rudhra','Devi');
insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('aaradhya@gmail.com','Aaradhya','Sri');
insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('zyna@gmail.com','Zyna','Sherin');
insert into employee (EMAIL,FIRSTNAME,LASTNAME) 
			values('mvarma@gmail.com','Mani','Varma');