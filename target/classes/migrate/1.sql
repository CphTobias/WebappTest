DROP TABLE IF EXISTS cars;
CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Horsepower INT DEFAULT NULL,
    Make VARCHAR(255) DEFAULT NULL,
    Model VARCHAR(255) DEFAULT NULL,
    Weight INT DEFAULT NULL,
    BuildYear INT DEFAULT NULL,
    Milage INT DEFAULT NULL,
    imagename VARCHAR(255) DEFAULT NULL
);

INSERT INTO cars VALUE (1, 220,'Audi','A6 3.0 4dr',3561,2009,35995,'images/Banner.jpg');

UPDATE properties
SET value = '1'
WHERE name = "version";