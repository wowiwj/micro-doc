-- 用户表
create table "user"
(
  id               serial                              not null,
  username         varchar(20)                         not null,
  password         varchar(128)                        not null,
  sex              smallint  default 0                 not null,
  bio              varchar(256),
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  last_active_time timestamp
);

comment on table "user" is '用户表';
comment on column "user".username is '用户名';
comment on column "user".password is '密码';
comment on column "user".sex is '0未知，1 男，2 女';
comment on column "user".bio is '简介';
comment on column "user".create_time is '注册时间';
comment on column "user".last_active_time is '最后活跃时间';

create unique index udx_user_username on "user" (username);

-- 文档表
create table "doc"
(
  id          serial                              not null,
  name        varchar(64)                         not null,
  brief       varchar(512),
  header_url  varchar(512),
  user_id     int                                 not null,
  delete_at   timestamp,
  create_time timestamp default CURRENT_TIMESTAMP not null,
  update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table doc is '文档表';
comment on column "doc".name is '文档名称';
comment on column "doc".brief is '文档简介';
comment on column "doc".header_url is '文档封面';
comment on column "doc".user_id is '文档创建用户';
comment on column "doc".delete_at is '文档软删除时间';


create unique index udx_doc_name on doc (name);
create index idx_doc_user_id on doc (user_id);



