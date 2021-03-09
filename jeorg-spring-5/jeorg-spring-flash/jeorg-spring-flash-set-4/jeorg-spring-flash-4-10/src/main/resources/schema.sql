drop table if exists users;

create table if not exists users
(
    username varchar(255) not null,
    password varchar(255) not null,
    enabled  tinyint      not null,
    primary key (username)
);

drop table if exists user_roles;

create table if not exists user_roles
(
    user_role_id int          not null auto_increment,
    username     varchar(255) not null,
    role         varchar(255) not null,
    primary key (user_role_id),
    unique key uni_username_role (role,username),
    constraint fk_username foreign key (username) references users (username)
);
