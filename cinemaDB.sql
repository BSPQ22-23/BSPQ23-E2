CREATE SCHEMA IF NOT EXISTS cinemaDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON cinemaDB.* TO 'spq'@'localhost';
