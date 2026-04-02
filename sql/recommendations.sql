create table recommendations (
    id serial primary key,
    user_id integer not null,
    name text not null,
    alcohol_type_id integer not null,
    alcohol_volume_id integer not null
);


INSERT INTO recommendations (user_id, name, alcohol_type_id, alcohol_volume_id) VALUES
(1, 'Office HJ', 67, 69),
(1, 'Office Chouffe', 67, 69),
(1, 'Office Corona', 67, 69),
(1, 'Small Heineken', 67, 69),
(1, 'Heineken Pint', 67, 69),
(1, 'Biergarten Pilsner', 67, 69),
(1, 'Biergarten Weizen', 67, 69);