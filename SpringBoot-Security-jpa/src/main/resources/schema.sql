create table role (
    id integer not null,
    name varchar(255),
    user_id integer,
    primary key (id)
);

create table user (
    id integer not null,
    active boolean,
    password varchar(255),
    username varchar(255),
    primary key (id)
);

alter table role
       add constraint FK61g3ambult7v7nh59xirgd9nf
       foreign key (user_id)
       references user;

