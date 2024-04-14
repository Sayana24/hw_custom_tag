drop table if exists student;
create table student(
                        id int primary key generated always as identity,
                        name varchar(255) not null,
                        result int not null
);
insert into student(name, result) VALUES ('Иванов Иван', 100),
                                         ('Петров Иван', 100),
                                         ('Яковлев Яков', 99),
                                         ('Никитин Никита', 90),
                                         ('Сидоров Роман', 90),
                                         ('Ленина Лена', 5);

select name, result from student
where result in (select result from student
                 group by result
                 having count(*)>1)