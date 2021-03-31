CREATE DATABASE IF NOT EXISTS flightsTestTask;
USE flightsTestTask;

CREATE TABLE aircompany
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at DATE,
    name       VARCHAR(20) UNIQUE NOT NULL,
    type       enum ('LOW_COST', 'CHARTER', 'SCHEDULED')
);

CREATE TABLE airplane
(
    id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at            DATE,
    factory_serial_number VARCHAR(10) UNIQUE NOT NULL ,
    flight_distance       DOUBLE,
    fuel_capacity         INTEGER,
    name                  VARCHAR(40),
    number_of_flights     INTEGER,
    type                  ENUM ('CARGO', 'PASSENGER') NOT NULL,
    aircompany_id         BIGINT,
    FOREIGN KEY (aircompany_id) REFERENCES aircompany (id)
);

CREATE TABLE flight
(
    id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at            DATE,
    delay_started_at      DATETIME,
    departure_country     VARCHAR(50) NOT NULL,
    destination_country   VARCHAR(50) NOT NULL,
    distance              DOUBLE,
    ended_at              DATETIME,
    estimated_flight_time TIME NOT NULL,
    status                ENUM ('ACTIVE', 'COMPLETED', 'DELAYED', 'PENDING') NOT NULL,
    aircompany_id         BIGINT NOT NULL,
    airplane_id           BIGINT NOT NULL,
    FOREIGN KEY (aircompany_id) REFERENCES aircompany (id),
    FOREIGN KEY (airplane_id) REFERENCES airplane (id)
);