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

insert into transactions (person_id, product_id)
values (4, 2), (3, 1), (3, 2), (1, 4), (2, 3), (2, 5),
       (3, 1), (2, 5), (1, 3), (4, 4), (3, 5), (4, 1);

select t.id, t.person_id,
       concat(pe.first_name, ' ', pe.last_name) as person,
       t.product_id,
       pr.title, pr.price,
       trans_date
from transactions t
         left join person pe on t.person_id = pe.id
         left join product pr on t.product_id = pr.id
where pe.id = :id;