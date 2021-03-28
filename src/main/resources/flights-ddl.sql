create database if not exists flightsTestTask;
use flightsTestTask;

create table aircompany
(
    id         bigint primary key auto_increment,
    created_at date,
    name       varchar(255) unique,
    type       enum ('LOW_COST', 'CHARTER', 'SCHEDULED')
);

create table airplane
(
    id                    bigint primary key auto_increment,
    created_at            date,
    factory_serial_number varchar(255) unique,
    flight_distance       double,
    fuel_capacity         integer,
    name                  varchar(255),
    number_of_flights     integer,
    type                  enum ('CARGO', 'PASSENGER'),
    aircompany_id         bigint,
    FOREIGN KEY (aircompany_id) references aircompany (id)
);

create table flight
(
    id                    bigint primary key auto_increment,
    created_at            date,
    delay_started_at      datetime,
    departure_country     varchar(255),
    destination_country   varchar(255),
    distance              double precision not null,
    ended_at              datetime,
    estimated_flight_time time,
    status                enum ('ACTIVE', 'COMPLETED', 'DELAYED', 'PENDING'),
    aircompany_id         bigint,
    airplane_id           bigint,
    FOREIGN KEY (aircompany_id) references aircompany (id),
    FOREIGN KEY (airplane_id) references airplane (id)
);