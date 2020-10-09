DROP TABLE IF EXISTS kontaktbeskeder;
CREATE TABLE kontaktbeskeder (
    id INT PRIMARY KEY AUTO_INCREMENT,
    besvared BOOLEAN DEFAULT NULL,
    Navn VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    besked VARCHAR(255) DEFAULT NULL
);

UPDATE properties
SET value = '2'
WHERE name = "version";