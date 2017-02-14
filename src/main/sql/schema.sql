-- 创建数据库myseckill
-- 使用数据库
-- 创建表 seckill和success_kill
-- 初始化数据:商品ID 商品名称  库存数量  秒杀开始时间  秒杀结束时间  创建时间
-- 设置主键：商品ID ，自增长1000，不为空，
-- 设置索引：秒杀开始时间  秒杀结束时间  创建时间
-- 设置引擎：innoDB(支持事务),编码格式为utf-8

create database [if not exists] myseckill;
use myseckill;
create table seckill(
  `seckill_id` bigint not null auto_increment comment '商品ID',
  `name`  varchar(120) not null comment '商品名称',
  `number`  int not null comment '商品库存',
  `create_time` timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
  `start_time` timestamp not null comment '秒杀开始时间',
  `end_time`  datetime not null comment '秒杀结束时间',
  primary key (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)engine=innodb auto_increment=1000 default charset=utf8 comment='秒杀库存表';

--初始化数据

insert into seckill(name,number,start_time,end_time)
values
('1000元秒杀iphone7s',100,'2016-12-01 00:00:00','2017-01-20 00:00:00'),
('1000元秒杀ipad',100,'2016-12-01 00:00:00','2017-01-22 00:00:00'),
('1000元秒杀mac book pro',100,'2016-12-01 00:00:00','2018-01-02 00:00:00'),
('1000元秒杀iMac',400,'2016-12-01 00:00:00','2016-12-02 00:00:00');

--秒杀成功明细表 success_kill
-- 用户登录认证相关信息(简化为手机号)
-- 字段：seckill_id user_phone state create_time

create table success_killed(
`seckill_id` bigint not null comment '秒杀商品ID',
`user_phone` bigint not null comment '用户手机号',
`state` tinyint not null default -1 comment '状态标识：-1:无效 0：成功 1：已付款 3：已发货',
`create_time` timestamp not null default current_timestamp comment '创建时间',
primary key(seckill_id,user_phone),
key idx_create_time(create_time)
)engine=innodb default cherset=utf8 comment='秒杀成功明细表'

--初始化表(测试)
insert into success_killed(seckill_id,user_phone,state)
values (1000,13877511732,0);


