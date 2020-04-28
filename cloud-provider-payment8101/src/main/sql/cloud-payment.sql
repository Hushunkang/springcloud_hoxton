create schema guli collate utf8_general_ci;

create table payment
(
    id bigint auto_increment comment '支付信息ID'
        primary key,
    serial varchar(200) null comment '支付流水号'
)
    comment '支付信息表';
