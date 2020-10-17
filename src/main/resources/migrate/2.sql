DROP TABLE IF EXISTS contactmessages;
CREATE TABLE contactmessages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    createdat TIMESTAMP NOT NULL,
    name VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    topic VARCHAR(55) DEFAULT NULL,
    message VARCHAR(255) DEFAULT NULL,
    answered BOOLEAN DEFAULT FALSE
);

UPDATE properties
SET value = '2'
WHERE name = "version";