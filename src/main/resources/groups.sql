create database IF NOT EXISTS webproject;
use webproject;
CREATE TABLE if NOT EXISTS webproject.groups
(   
groupId INT NOT NULL AUTO_INCREMENT,   
groupNumber VARCHAR(50) NOT NULL,   
groupName VARCHAR(50) NOT NULL,     
PRIMARY KEY (groupId)
);

INSERT INTO webproject.groups (groupNumber, groupName) VALUES ('23531/2', 'ИКНТ');
INSERT INTO webproject.groups (groupNumber, groupName) VALUES ('45841/1','ГИ');
INSERT INTO webproject.groups (groupNumber, groupName) VALUES ('12432', 'ИММИТ');
select * from webproject.groups LIMIT 0, 1000