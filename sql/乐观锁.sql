--ENGINE=InnoDB表示数据库表引擎 AUTO_INCREMENT=1268表示表自动递增列的初始数值=1268
CREATE TABLE `price`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',  
	`total` decimal(12,2) DEFAULT '0.00' COMMENT '总值',
	`front` decimal(12,2) DEFAULT '0.00' COMMENT '消费前',
	`end` decimal(12,2) DEFAULT '0.00' COMMENT '消费后',
	PRIMARY KEY (`id`)
	)ENGINE=InnoDB AUTO_INCREMENT=1268 DEFAULT CHARSET=utf8;

--支持乐观锁的数据有更新版本号的price表
CREATE TABLE `price_version`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',  
	`total` decimal(12,2) DEFAULT '0.00' COMMENT '总值',
	`front` decimal(12,2) DEFAULT '0.00' COMMENT '消费前',
	`end` decimal(12,2) DEFAULT '0.00' COMMENT '消费后',
	`version` int(11) DEFAULT '0' COMMENT '并发版本控制',
	PRIMARY KEY (`id`)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
