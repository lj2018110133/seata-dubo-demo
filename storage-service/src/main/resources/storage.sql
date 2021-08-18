CREATE TABLE `storage` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `commodity_id` varchar(255) DEFAULT NULL,
                           `count` int(11) DEFAULT 0,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into storage(id,count,commodity_id) values (1,1000,"No.00001");

insert into account_tbl(id,money,user_id) values (1,1000,"No.00002");