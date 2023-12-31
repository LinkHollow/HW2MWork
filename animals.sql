DROP DATABASE IF EXISTS human_friends;
-- Создание базы данных
CREATE DATABASE human_friends;
USE human_friends;
-- Создание таблицы класса животных
DROP TABLE IF EXISTS animals_base;
CREATE TABLE animals_base
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30)
);
-- Создание таблицы рода животных
DROP TABLE IF EXISTS animal_genus;
CREATE TABLE animal_genus
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES animals_base (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы экземпляров животых
DROP TABLE IF EXISTS animals;
CREATE TABLE animals
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30),
    genus_id INT,
    birth_date DATE,
    FOREIGN KEY (genus_id) REFERENCES animal_genus (id) -- связь по внешнему ключу
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы команды
DROP TABLE IF EXISTS commands;
CREATE TABLE commands
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30)
);

-- Создание таблицы для связи команд и животных
DROP TABLE IF EXISTS animal_commands;
CREATE TABLE animal_commands
(
    animal_id INT NOT NULL,
    command_id INT NOT NULL,

    PRIMARY KEY (animal_id, command_id),
    FOREIGN KEY (animal_id) REFERENCES animals (id)
     ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (command_id) REFERENCES commands (id)
     ON DELETE CASCADE  ON UPDATE CASCADE
);

-- Заполнение таблиц.
INSERT INTO animals_base (name)
VALUES
	 ('Pack animals'),
	 ('Pets');
     
INSERT INTO animal_genus (name, group_id)
VALUE
	('Dog', 2),
    ('Cat', 2),
    ('Hamster', 2),
    ('Horse', 1),
    ('Camel', 1),
    ('Donkey', 1);
SELECT * FROM animal_genus;    

INSERT INTO commands (name)
VALUE
	('Sit'),
    ('Stay'),
    ('Fetch'),
    ('Pounce'),
    ('Roll'),
    ('Hide'),
    ('Paw'),
    ('Bark'),
    ('Spin'),
    ('Scratch'),
    ('Meow'),
    ('Jump'),
    ('Trot'),
    ('Canter'),
    ('Gallop'),
    ('Walk'),
    ('Carry load'),
    ('Bray'),
    ('Kick'),
    ('Run');
    
INSERT INTO animals (name, birth_date, genus_id)
VALUE
	('Fido', '2020-01-01', 1),
    ('Whiskers', '2019-05-15', 2),
    ('Hammy', '2021-03-10', 3),
    ('Buddy',  '2018-12-10', 1),
    ('Smudge','2020-02-20', 2),
    ('Peanut','2021-08-01',3),
    ('Bella', '2019-11-11', 1),
    ('Oliver',  '2020-06-30', 2),
    ('Thunder', '2015-07-21', 4),
    ('Sandy',  '2016-11-03',  5),
    ('Eeyore', '2017-09-18', 6),
    ('Storm','2014-05-05',  4),
    ('Dune', '2018-12-12', 5),
    ('Burro', '2019-01-23', 6),
    ('Blaze', '2016-02-29', 4),
    ('Sahara', '2015-08-14', 5);
    
 -- Заполняем таблицу связи животных с коммандами
 INSERT INTO animal_commands(animal_id, command_id)
 VALUE
 (1, 1), (1, 2), (1, 3),
 (2, 1), (2, 4),
 (3, 5), (3, 6),
 (4, 1), (4, 7), (4, 8),
 (5, 1), (5, 4), (5,10),
 (6, 5), (6, 9),
 (7, 1), (7, 2), (7, 5),
 (8, 11), (8, 10), (8, 12),
 (9, 13), (9, 14), (9, 15),
 (10, 16), (10, 17),
 (11, 16), (11, 17), (11, 18),
 (12, 13), (12, 14),
 (13, 16), (13, 1),
 (14, 16), (14, 18), (14, 19),
 (15, 13), (15, 12), (15, 15),
 (16, 16), (16, 20)
 ;
    
-- Итоговая таблица с животными    
SELECT  animals.id, animals.name, animal_genus.name AS type, animals.birth_date, 
	 /*animal_commands.command_id AS command,*/ GROUP_CONCAT(commands.name)  AS commands
FROM animals
JOIN
animal_genus 
ON 
animals.genus_id=animal_genus.id
LEFT JOIN
animal_commands 
ON 
animal_commands.animal_id=animals.id
LEFT JOIN
commands
ON
commands.id=animal_commands.command_id
GROUP BY animals.id;

SELECT commands.name 
FROM commands
JOIN animal_commands
ON
commands.id = animal_commands.command_id;
 
SELECT * FROM animal_genus;

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
USE human_friends;
DELETE FROM animals WHERE animals.genus_id=5;
DROP TABLE IF EXISTS HorseDonkey;
CREATE TABLE HorseDonkey AS
SELECT * FROM animals WHERE animals.genus_id=4
UNION
SELECT * FROM animals WHERE animals.genus_id=6; 

SELECT * FROM HorseDonkey;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет 
-- и вычислить их возраст с точностью до месяца.
USE human_friends;
DROP TABLE IF EXISTS animals_1_3;
CREATE TABLE animals_1_3 AS
SELECT
*, TIMESTAMPDIFF(MONTH, birth_date, curdate()) AS age_months
FROM
animals;

SELECT * FROM animals_1_3;
 
-- Объединить все созданные таблицы в одну, 
-- сохраняя информацию о принадлежности к исходным таблицам.

USE human_friends;
DROP TABLE IF EXISTS animals_total;
CREATE TABLE animals_total AS
SELECT id, name, genus_id, birth_date FROM HorseDonkey
UNION
SELECT id, name, genus_id, birth_date FROM animals_1_3
ORDER BY
id;

SELECT * FROM animals_total;
