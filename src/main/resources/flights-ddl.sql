CREATE DATABASE IF NOT EXISTS flightsTestTask;
USE flightsTestTask;

CREATE TABLE aircompany
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at DATE,
    name       VARCHAR(255) UNIQUE ,
    type       enum ('LOW_COST', 'CHARTER', 'SCHEDULED')
);

CREATE TABLE airplane
(
    id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at            DATE,
    factory_serial_number VARCHAR(255) UNIQUE ,
    flight_distance       DOUBLE,
    fuel_capacity         INTEGER,
    name                  VARCHAR(255),
    number_of_flights     INTEGER,
    type                  ENUM ('CARGO', 'PASSENGER'),
    aircompany_id         BIGINT,
    FOREIGN KEY (aircompany_id) REFERENCES aircompany (id)
);

CREATE TABLE flight
(
    id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at            DATE,
    delay_started_at      DATETIME,
    departure_country     VARCHAR(255),
    destination_country   VARCHAR(255),
    distance              DOUBLE,
    ended_at              DATETIME,
    estimated_flight_time TIME,
    status                ENUM ('ACTIVE', 'COMPLETED', 'DELAYED', 'PENDING'),
    aircompany_id         BIGINT,
    airplane_id           BIGINT,
    FOREIGN KEY (aircompany_id) REFERENCES aircompany (id),
    FOREIGN KEY (airplane_id) REFERENCES airplane (id)
);