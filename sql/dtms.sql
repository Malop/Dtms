create database  dtms;
--用户表
create table user(userid varchar(10) not null,
				username varchar(20) DEFAULT NULL,
				password varchar(32) DEFAULT NULL,
				realname varchar(32) DEFAULT NULL,
				sex varchar(4) DEFAULT NULL COMMENT '01男 02 女',
				phone varchar(20) DEFAULT NULL,
				email varchar(40) DEFAULT NULL,
				cttime datetime DEFAULT NULL,
				PRIMARY KEY (userid)
				)charset=utf8;

--新增用户信息
insert into user(userid,username,password,realname,sex,phone,email,cttime) values('1','admin','21232F297A57A5A743894A0E4A801FC3','adminName','01','137XXXXXXXX','XXX@email.com','2018-04-17 00:00:00');
			
--菜单表
create table menu(menuid int not NULL,
				parentid int,
				menuname varchar(20) DEFAULT NULL,
				type varchar(10) DEFAULT NULL COMMENT '1目录 2菜单 3按钮',
				uri varchar(200) DEFAULT NULL COMMENT '访问地址',
				icon varchar(100) DEFAULT NULL,
				cttime DATETIME DEFAULT NULL,
				PRIMARY KEY (menuid)
				)charset=utf8;

--新增菜单信息
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(1,0,'人员管理','1','','','2018-04-20');
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(2,1,'人员列表','2','/manage/index','','2018-04-20');

--人员菜单关系表
create table user_menu(userid varchar(10),menuid int,primary key(userid,menuid))charset=utf8;

--新增人员菜单信息
insert into user_menu(userid,menuid) values('1',1);
insert into user_menu(userid,menuid) values('1',2);

--图片表
create table picture(pictureid not null COMMENT '图片id',
				uderid not null COMMENT '所属人员号',
				pictureurl COMMENT '存储地址',
				cttime COMMENT '创建时间',
				PRIMARY KEY (pictureid)
				)charset=utf8;
