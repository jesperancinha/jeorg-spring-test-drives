create table if not exists car
(
    id                SERIAL PRIMARY KEY,
    model             varchar(255),
    brand             varchar(255),
    year              int,
    movie_appearances varchar(255)
);