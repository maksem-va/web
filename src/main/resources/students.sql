CREATE DATABASE IF NOT EXISTS webproject;

USE webproject;

CREATE TABLE IF NOT EXISTS webproject.students

(
    id        INT         NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName  VARCHAR(50) NOT NULL,
    groupName   VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

# INSERT INTO webproject.students (firstName, lastName, groupName)
# VALUES ('Иван', 'Иванов', '2431');
#
# INSERT INTO webproject.students (firstName, lastName, groupName)
# VALUES ('Петр', 'Петров', '2442');
#
# INSERT INTO webproject.students (firstName, lastName, groupName)
# VALUES ('Аня', 'Уткина', '2431');
