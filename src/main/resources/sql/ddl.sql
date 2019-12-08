DROP TABLE IF EXISTS users;

CREATE TABLE users (
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `admin` NUMBER(1) NOT NULL,
  PRIMARY KEY (username)
);

INSERT INTO users VALUES('Admin', 'admin@sabapathy.com','admin', 'password', 1);
