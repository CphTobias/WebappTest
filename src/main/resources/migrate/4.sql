DROP TABLE IF EXISTS specialoffers;
CREATE TABLE specialoffers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    carID INT NOT NULL,
    offer VARCHAR(255) DEFAULT NULL,
    sideMessage VARCHAR(255) DEFAULT NULL,
    FOREIGN KEY (carID) REFERENCES cars(id)
);

UPDATE properties
SET value = '4'
WHERE name = "version";