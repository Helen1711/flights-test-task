use flightsTestTask;

insert into aircompany(created_at, name, type)
VALUES ('2021-03-03', 'Ryanair', 'LOW_COST'),
       ('2021-02-10', 'Ukraine International Airlines', 'CHARTER'),
       ('2020-07-21', 'Delta Air Lines', 'SCHEDULED'),
       ('2018-02-11', 'ExpressJet Airlines', 'SCHEDULED'),
       ('2015-04-16', 'Frontier Airlines', 'SCHEDULED'),
       ('2014-02-03', 'JetBlue Airways', 'SCHEDULED');

insert into airplane (created_at, factory_serial_number, flight_distance, fuel_capacity, name, number_of_flights,
                      type, aircompany_id)
values ('2021-03-03', 'FG35GH', 3987, 7896, 'TY-34', 35, 'CARGO', 1),
       ('2021-02-03', 'FG32GH', 2544, 6784, 'TY-22', 35, 'PASSENGER', 5),
       ('2021-03-14', 'FH35GH', 6457, 7896, 'TY-56', 35, 'PASSENGER', 4),
       ('2020-03-03', 'FG34AH', 3987, 8304, 'TY-76', 35, 'CARGO', 6),
       ('2021-05-06', 'FB85GH', 1265, 5634, 'TY-34', 35, 'CARGO', 3),
       ('2019-03-03', 'FA35GH', 7653, 7896, 'TY-43', 35, 'PASSENGER', 2),
       ('2018-12-12', 'FK34GH', 8734, 4059, 'TY-23', 35, 'PASSENGER', 3),
       ('2021-09-97', 'YU33GH', 9654, 3059, 'TY-36', 35, 'PASSENGER', 1),
       ('2015-03-03', 'GH325GH', 2367, 7896, 'TY-77', 35, 'PASSENGER', 5),
       ('2016-05-08', 'IO65GH', 3578, 3049, 'TY-89', 35, 'CARGO', 1);

insert into flight(created_at, delay_started_at, departure_country, destination_country, distance, ended_at,
                   estimated_flight_time, status, aircompany_id, airplane_id)
values ('2021-03-03', '2021-03-27 22:38:49', 'Ukraine', 'Poland', 2738,
        '2021-03-27 23:38:49', '02:30:10', 'COMPLETED', 1, 1),
       ('2021-02-03', '2021-02-27 22:38:49', 'Ukraine', 'Poland', 2738,
        '2021-02-27 23:38:49', '02:30:10', 'COMPLETED', 1, 1),
       ('2021-03-15', '2021-03-27 22:38:49', 'Ukraine', 'Poland', 2738,
        '2021-03-27 23:38:49', '02:30:10', 'COMPLETED', 1, 1);