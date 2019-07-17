CREATE DATABASE IF NOT EXISTS webproject;

USE webproject;

CREATE TABLE IF NOT EXISTS webproject.students
(
    id        INT         NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName  VARCHAR(50) NOT NULL,
    groupName VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS webproject.groups
(
    groupId     INT         NOT NULL AUTO_INCREMENT,
    groupNumber VARCHAR(50) NOT NULL,
    groupName   VARCHAR(50) NOT NULL,
    PRIMARY KEY (groupId)
);


