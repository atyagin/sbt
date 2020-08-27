drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;

create table client (
    id int8 not null,
    created timestamp,
    name varchar(255),
    security_social_number varchar(255),
    primary key (id)
);

create table order_table (
    id int8 not null,
    description varchar(255),
    responsible varchar(255),
    client_id int8,
    primary key (id)
);

alter table if exists order_table
    add constraint FK45qdixgtn84q8aulwt0xgj81m
    foreign key (client_id) references client;
