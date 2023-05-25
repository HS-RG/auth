create schema auth;

use auth;

create table auth
(
    user_id     bigint      not null
        primary key,
    username    varchar(50) not null,
    password    varchar(30) not null,
    is_admin    tinyint     null,
    update_time datetime    not null,
    create_time datetime    not null,
    constraint username
        unique (username)
);

