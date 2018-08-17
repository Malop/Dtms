--mysql –uroot –proot -dtms<1.sql
create database  dtms;
--用户表
--drop table user;
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

insert into user(userid,username,password,realname,sex,phone,email,cttime) values('1','admin','21232F297A57A5A743894A0E4A801FC3','adminName','01','137XXXXXXXX','XXX@email.com','2018-04-17 00:00:00');
			
--菜单表
--drop table menu;
create table menu(menuid int not NULL,
				parentid int,
				menuname varchar(20) DEFAULT NULL,
				type varchar(10) DEFAULT NULL COMMENT '1目录 2菜单 3按钮',
				uri varchar(200) DEFAULT NULL 4,
				icon varchar(100) DEFAULT NULL,
				cttime DATETIME DEFAULT NULL,
				PRIMARY KEY (menuid)
				)charset=utf8;

insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(1,0,'人员管理','1','','','2018-04-20');
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(2,1,'党员信息列表','2','/partymember/index/0','','2018-05-14');
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(3,1,'转出党员列表','2','/partymember/index/1','','2018-05-14');
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(4,1,'死亡党员列表','2','/partymember/index/2','','2018-05-14');
insert into menu(menuid,parentid,menuname,type,uri,icon,cttime) values(5,1,'出党党员列表','2','/partymember/index/3','','2018-05-14');

--人员菜单关系表
--drop table user_menu;
create table user_menu(userid varchar(10),menuid int,primary key(userid,menuid))charset=utf8;

insert into user_menu(userid,menuid) values('1',1);
insert into user_menu(userid,menuid) values('1',2);
insert into user_menu(userid,menuid) values('1',3);
insert into user_menu(userid,menuid) values('1',4);
insert into user_menu(userid,menuid) values('1',5);


--图片表
--drop table mfile;
create table mfile(mfileid varchar(20) not null COMMENT '图片id',
				mfilename varchar(50) DEFAULT NULL COMMENT '图片名称',
				userid varchar(20) DEFAULT NULL COMMENT '所属人员号',
				mfiletype varchar(4) DEFAULT NULL comment '图片类型',
				mfileurl varchar(40) DEFAULT NULL COMMENT '存储路径',
				cttime DATETIME DEFAULT NULL COMMENT '创建时间',
				PRIMARY KEY (mfileid)
				)charset=utf8;
				
insert into mfile(mfileid,mfilename,userid,mfiletype,mfileurl,cttime) values('1','中国共产党党员基本情况登记表','330106195705270012','01','/Dtms/uploadfiles/中国共产党党员基本情况登记表.tif','2018-06-24 00:00:00');
insert into mfile(mfileid,mfilename,userid,mfiletype,mfileurl,cttime) values('2','发展党员工作全程纪实表','330106195705270012','01','/Dtms/uploadfiles/发展党员工作全程纪实表.tif','2018-06-24 00:00:00');
insert into mfile(mfileid,mfilename,userid,mfiletype,mfileurl,cttime) values('3','入党申请书','330106195705270012','01','/Dtms/uploadfiles/入党申请书.tif','2018-06-24 00:00:00');
insert into mfile(mfileid,mfilename,userid,mfiletype,mfileurl,cttime) values('4','党内表彰奖励情况','330106195705270012','01','/Dtms/uploadfiles/党内表彰奖励情况.tif','2018-06-24 00:00:00');
insert into mfile(mfileid,mfilename,userid,mfiletype,mfileurl,cttime) values('5','党纪处分情况','330106195705270012','01','/Dtms/uploadfiles/党纪处分情况.tif','2018-06-24 00:00:00');

--党员信息表
--drop table partymember;
create table partymember(certid varchar(32) not null,
					partyName varchar(32) DEFAULT NULL,
					sex varchar(10) DEFAULT NULL COMMENT 'male男 female女',
					nation varchar(20) DEFAULT NULL COMMENT '民族',
					nativeplace varchar(20) DEFAULT NULL COMMENT '籍贯',
					isTaiwan varchar(4) DEFAULT NULL COMMENT '01是 02否',
					brithday varchar(10) DEFAULT NULL COMMENT '生日',
					age varchar(10) DEFAULT NULL COMMENT '年龄',
					education varchar(20) DEFAULT NULL COMMENT '学历',
					category varchar(20) DEFAULT NULL COMMENT '人员类别',
					partygroup varchar(32) DEFAULT NULL COMMENT '党组织',
					partytime varchar(32) DEFAULT NULL COMMENT '入党时间',
					fullpartytime varchar(32) DEFAULT NULL COMMENT '转正时间',
					job varchar(32) DEFAULT NULL COMMENT '工作岗位',
					timetowork varchar(32) DEFAULT NULL COMMENT '参加工作时间',
					address varchar(100) DEFAULT NULL COMMENT '地址',
					mobilephone varchar(32) DEFAULT NULL COMMENT '手机号码',
					telephone varchar(32) DEFAULT NULL COMMENT '固定电话',
					marriage varchar(10) DEFAULT NULL COMMENT '婚姻状况',
					archiveplace varchar(100) DEFAULT NULL COMMENT '档案所在地',
					technicaltitle varchar(32) DEFAULT NULL COMMENT '技术职称',
					sociallevel varchar(32) DEFAULT NULL COMMENT '社会阶层类型',
					situation varchar(32) DEFAULT NULL COMMENT '一线情况',
					training varchar(32) DEFAULT NULL COMMENT '培训情况',
					isworker varchar(4) DEFAULT NULL COMMENT '是否农民工',
					isoffline varchar(4) DEFAULT NULL COMMENT '是否失联党员',
					offdate varchar(32) DEFAULT NULL COMMENT '失联时间',
					isfloat varchar(4) DEFAULT NULL COMMENT '是否流动党员',
					floatdirection varchar(32) DEFAULT NULL COMMENT '外出流向',
					isout varchar(4) DEFAULT NULL COMMENT '是否转出',
					outtime varchar(32) DEFAULT NULL COMMENT '转出时间',
					infoprecent varchar(10) DEFAULT NULL COMMENT '档案资料完整度',
					maininfoprecent varchar(10) DEFAULT NULL COMMENT '关键档案资料完整度',
					cttime DATETIME DEFAULT NULL COMMENT '创建时间',
					PRIMARY KEY (certid)
					)charset=utf8;

--alter table partymember add maininfoprecent varchar(10) DEFAULT NULL COMMENT '关键档案资料完整度';
--alter table partymember drop column maininfoprecent;
