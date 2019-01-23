create table  "user"
(
  id serial not null,
  username varchar(20) not null,
  password varchar(128) not null,
  sex smallint default 0 not null,
  bio varchar(256),
  create_time timestamp default CURRENT_TIMESTAMP not null,
  last_active_time timestamp
)
;

comment on column "user".sex is '0未知，1 男，2 女'
;
create unique index udx_user_username
  on "user" (username)
;



