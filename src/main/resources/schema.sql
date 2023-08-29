CREATE TABLE IF NOT EXISTS `user` (
    id bigint AUTO_INCREMENT primary key,
    username varchar(100) not null,
    password varchar(50) not null,
    email varchar(50) not null
);