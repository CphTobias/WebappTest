DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userid INT NOT NULL,
    carid VARCHAR(255) DEFAULT NULL,
    paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (userid) REFERENCES users(id)
);

UPDATE properties
SET value = '5'
WHERE name = "version";