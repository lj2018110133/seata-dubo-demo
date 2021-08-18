CREATE TABLE `account` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `user_id` varchar(255) DEFAULT NULL,
                               `money` int(11) DEFAULT 0,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into account_tbl(id,money,user_id) values (1,1000,"No.00001");

insert into account_tbl(id,money,user_id) values (1,1000,"No.00002");