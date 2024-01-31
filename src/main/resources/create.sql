CREATE TABLE BREWERY (
    id_brewery INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    gps_coordinates VARCHAR(255) NOT NULL,
    openning_date DATE
);

CREATE TABLE BEER (
    id_beer INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    beer_type VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    alcool_degree INT NOT NULL,
    note INT NOT NULL,
    id_brewery INT,
    CONSTRAINT fk_id_brewery FOREIGN KEY (id_brewery) REFERENCES BREWERY(id_brewery)
);

