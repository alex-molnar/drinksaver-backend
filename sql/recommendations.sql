create table recommendations (
    id serial primary key,
    user_id integer not null,
    name text not null,
    alcohol_type_id integer not null,
    alcohol_volume_id integer not null,
    brand_id integer,
    consumption_type_id integer
);


INSERT INTO recommendations (user_id, name, alcohol_type_id, alcohol_volume_id, brand_id, consumption_type_id) VALUES
(1, 'HJ pint', 2, 6, 3, 3),
(1, 'Office Chouffe', 2, 5, 4, 1),
(1, 'Small Heineken', 2, 5, 1, 1),
(1, 'Heineken Pint', 2, 6, 1, 3),
(1, 'Biergarten Pilsner', 2, 6, 7, 3),
(1, 'Biergarten Weizen', 2, 6, 8, 3);

INSERT INTO recommendations (user_id, name, alcohol_type_id, alcohol_volume_id) VALUES
(1, 'Gin & Tonic', 1, 2);
