DROP SCHEMA IF EXISTS cinemaDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA cinemaDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON cinemaDB.* TO 'spq'@'localhost';

use cinemadb;
select * from user;