create database tutorial;
use tutorial;
CREATE TABLE TUTORIAL.students 
(   id INT NOT NULL AUTO_INCREMENT,   
name VARCHAR(50) NOT NULL,   
secondName VARCHAR(50) NOT NULL,   
groupNumber INT NOT NULL,   
PRIMARY KEY (id));
INSERT INTO TUTORIAL.students (name, secondName, groupNumber) VALUES ('Иван', 'Иванов', '2431');
INSERT INTO TUTORIAL.students (name, secondName, groupNumber) VALUES ('Петр','Петров', '2442');
INSERT INTO TUTORIAL.students (name, secondName, groupNumber) VALUES ('Аня', 'Уткина', '2431');
select * from students LIMIT 0, 1000