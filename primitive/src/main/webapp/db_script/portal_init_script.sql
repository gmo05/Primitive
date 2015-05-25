-- -----------------------------------------------------
-- table `静态用户表`
-- -----------------------------------------------------
drop table if exists `static_user`;
create table `static_user` (
  `id` bigint(20) not null auto_increment,
  `auth_name` varchar(400) not null comment '认证用户名',
  `auth_password` varchar(400) default null comment '认证密码',
  `auth_type` varchar(45) not null default 'static' comment '认证终端类型',
  `mac` varchar(60) default null comment 'mac地址',
  `devId` varchar(64) default null comment '设备id',
  `radius_password` varchar(100) default null comment 'radius密码',
  `create_datetime` datetime not null default now() comment '创建时间',
  `status` varchar(45) not null default 'offline' comment 'online, offline, locked',
  `phone_number` varchar(32) default null,
  `desc` varchar(800) default null comment '备注',  
  primary key (`id`)) 
engine=innodb;
create index `su_create_datetime_idx` on `static_user` (`create_datetime`);

-- -----------------------------------------------------
-- 黑名单表
-- -----------------------------------------------------
drop table if exists `user_blacklist`;
create table `user_blacklist` (
  `id` bigint(20) not null auto_increment,
  `macs` text,
  `device_id` varchar(64) not null default '0',
  `create_datetime` datetime not null default now(),
  primary key (`id`),
  constraint `user_blacklist_ibfk_1` 
  	foreign key (`device_id`) 
  	references `device` (`device_id`) 
  	on delete no action 
  	on update no action) 
engine=innodb;
create index `user_blacklist_device_id_idx` on `user_blacklist` (`device_id`);    

-- -----------------------------------------------------
-- 白名单表
-- -----------------------------------------------------
drop table if exists `user_whitelist`;
create table `user_whitelist` (
  `id` bigint(20) not null auto_increment,
  `macs` text,
  `device_id` varchar(64) not null default '0',
  `create_datetime` datetime not null default now(),
  primary key (`id`),
  constraint `user_whitelist_ibfk_1` 
  	foreign key (`device_id`) 
  	references `device` (`device_id`) 
  	on delete no action 
  	on update no action) 
engine=innodb;
create index `user_whitelist_device_id_idx` on `user_whitelist` (`device_id`);

-- -----------------------------------------------------
-- portal显示策略表
-- -----------------------------------------------------
drop table if exists `portal_display_policy`;
create table `portal_display_policy` (
  `id` bigint(20) not null auto_increment,
  `name` varchar(200) not null,
  `account_id` bigint(20) not null,
  `device_ids` text,
  `status` varchar(45) not null default 'normal' comment 'normal / locked / deleted',
  `display_items` text,
  `latest_update_datetime` datetime default null,
  `latest_update_account_id` bigint(20) default null,
  `create_datetime` datetime not null default current_timestamp,
  primary key (`id`)
) engine=innodb auto_increment=200 default charset=utf8;

-- -----------------------------------------------------
-- portal站点表
-- -----------------------------------------------------
drop table if exists `portal_site`;
create table `portal_site` (
  `id` bigint(20) not null auto_increment,
  `site_name` varchar(200) default null,
  `description` text,
  `thumbnail_path` varchar(800) default null,
  `create_datetime` datetime not null default current_timestamp,
  `created_account_id` bigint(20) not null,
  `account_id` bigint(20) not null,
  `last_edit_account_id` bigint(20) default null,
  `last_update_datetime` datetime default null,
  `status` varchar(45) not null default 'normal' comment 'normal, locked, deletd',
  primary key (`id`)
) engine=innodb auto_increment=2 default charset=utf8;

-- -----------------------------------------------------
-- portal模版表
-- -----------------------------------------------------
drop table if exists `portal_template`;
create table `portal_template` (
  `id` bigint(20) not null auto_increment,
  `name` varchar(200) not null,
  `default_data` text,
  `type` varchar(15) not null comment 'enum: auth, login, insite',
  `auth_type` varchar(60) default null,
  `description` text,
  `thumbnail_path` varchar(800) default null,
  `template_frame` text not null,
  `create_datetime` datetime not null default current_timestamp,
  primary key (`id`)
) engine=innodb auto_increment=20 default charset=utf8;

-- -----------------------------------------------------
-- portal页面表
-- -----------------------------------------------------
drop table if exists `portal_page`;
create table `portal_page` (
  `id` bigint(20) not null auto_increment,
  `title` varchar(255) default null,
  `status` varchar(45) not null default 'normal' comment 'normal | deleted',
  `type` varchar(45) default null comment 'enum: auth, login, insite',
  `name` varchar(200) not null,
  `portal_template_id` bigint(20) not null,
  `content` text,
  `push_statis` bigint(20) not null default '0',
  `portal_site_id` bigint(20) not null,
  `create_datetime` datetime default current_timestamp,
  `thumbnail_path` varchar(800) default null,
  primary key (`id`),
  key `fk_portal_page_portal_template1_idx` (`portal_template_id`),
  key `fk_portal_page_portal_site1_idx` (`portal_site_id`),
  constraint `fk_portal_page_portal_site1` foreign key (`portal_site_id`) references `portal_site` (`id`) on delete no action on update no action,
  constraint `fk_portal_page_portal_template1` foreign key (`portal_template_id`) references `portal_template` (`id`) on delete no action on update no action
) engine=innodb auto_increment=709 default charset=utf8;
	

-- -----------------------------------------------------
-- 设备显示计划表
-- -----------------------------------------------------
drop table if exists `device_display_plan`;
create table `device_display_plan` (
  `id` bigint(20) not null auto_increment,
  `device_device_id` varchar(64) not null,
  `portal_site_id` bigint(20) not null,
  `clock` float not null,
  `effon` datetime default null,
  `effend` datetime default null,
  `create_datetime` datetime not null default current_timestamp,
  `latest_update_account_id` bigint(20) default null,
  `latest_update_datetime` datetime default null,
  `latest_update_policy_id` bigint(20) default null,
  primary key (`id`),
  key `fk_device_display_plan_device1_idx` (`device_device_id`),
  key `fk_device_display_plan_portal_site1_idx` (`portal_site_id`),
  constraint `fk_device_display_plan_device1` foreign key (`device_device_id`) references `device` (`device_id`) on delete no action on update no action,
  constraint `fk_device_display_plan_portal_site1` foreign key (`portal_site_id`) references `portal_site` (`id`) on delete no action on update no action
) engine=innodb auto_increment=12022 default charset=utf8;


-- -----------------------------------------------------
-- portal页面推送日志表
-- -----------------------------------------------------
drop table if exists `portal_page_push_log`;
create table `portal_page_push_log` (
  `id` bigint(20) not null auto_increment,
  `portal_page_id` bigint(20) not null,
  `device_id` varchar(64) default null,
  `create_datetime` datetime not null default current_timestamp,
  primary key (`id`),
  key `fk_portal_page_push_log_portal_page1_idx` (`portal_page_id`),
  key `idx_device_id` (`device_id`),
  key `pppl_create_datetime_idx` (`create_datetime`),
  constraint `fk_portal_page_push_log_portal_page1` foreign key (`portal_page_id`) references `portal_page` (`id`) on delete no action on update no action
) engine=innodb auto_increment=14417124 default charset=utf8;




-- -----------------------------------------------------
-- 终端用户认证日志表
-- -----------------------------------------------------
drop table if exists `terminal_user_authentication_log`;
create table `terminal_user_authentication_log` (
  `id` bigint(20) not null auto_increment,
  `terminal_user_id` bigint(20) not null,
  `log_content` text not null,
  `auth_type` varchar(45) default null comment 'email, phone, userpwd, general, redius',
  `token` varchar(60) default null,
  `device_id` varchar(64) not null,
  `status` varchar(45) default 'online' comment 'online / offline',
  `terminal_mac` varchar(64) default null,
  `offline_datetime` datetime default null,
  `terminal_type` varchar(100) default null,
  `browser_type` varchar(100) default null,
  `total_up_traffic` bigint(20) default '0',
  `total_dw_traffic` bigint(20) default '0',
  `modified_datetime` datetime default null,
  `auth_result` tinyint(1) default false comment '认证结果',
  `create_datetime` datetime not null default current_timestamp,
  primary key (`id`),
  key `fk_terminal_user_authentication_log_terminal_user1_idx` (`terminal_user_id`),
  key `fk_terminal_user_authentication_log_device1_idx` (`device_id`),
  key `tual_create_datetime_idx` (`create_datetime`),
  constraint `fk_terminal_user_authentication_log_device1` foreign key (`device_id`) references `device` (`device_id`) on delete no action on update no action,
  constraint `fk_terminal_user_authentication_log_terminal_user1` foreign key (`terminal_user_id`) references `terminal_user` (`id`) on delete no action on update no action
) engine=innodb auto_increment=466463 default charset=utf8;
