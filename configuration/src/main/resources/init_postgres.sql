CREATE USER demo_user WITH PASSWORD 'default001!';
create schema ghost_rider_app AUTHORIZATION demo_user;

create table ghost_rider_app.account(
    id serial primary key not null,
    name varchar(150) not null,
    email varchar(150) not null,
    cpf varchar(12) not null,
    car_plate varchar(30),
    is_passenger boolean not null default false,
    is_driver boolean not null default false
);