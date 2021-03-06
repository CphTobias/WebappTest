create database webapp;

create user 'YOURUSER'@'localhost';
grant all privileges on *.* to 'YOURUSER'@'localhost';
flush privileges;

DROP TABLE IF EXISTS properties;
CREATE TABLE properties (
    name VARCHAR(255) PRIMARY KEY,
    value VARCHAR(255) NOT NULL
);

INSERT INTO properties (name, value) VALUES ("version", "0");