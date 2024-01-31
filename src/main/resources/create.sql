CREATE TABLE BREWERY (
    id_brewery INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    gps_coordinates VARCHAR(255) NOT NULL,
    openning_date DATE
);