create table product(
                        id serial primary key,
                        title varchar(128),
                        price int
);

insert into product (title, price)
values ('T-Shirt', 1160), ('Jumper', 2340), ('Dress', 3400), ('Jeans', 2100), ('Shorts', 800), ('Trench coat', 6900);

create table person(
                       id serial primary key,
                       first_name varchar(128),
                       last_name varchar(128)
);

insert into person (first_name, last_name)
values ('Ruslan', 'Vorontsov'), ('Pavel', 'Bobrov'), ('Kristina', 'Kovalenko'), ('Svetlana', 'Sizikh');

create table transactions(
                             id serial primary key,
                             person_id bigint references person(id),
                             product_id bigint references product(id),
                             trans_date datetime default current_timestamp
);