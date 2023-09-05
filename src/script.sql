DROP DATABASE if exists library;

CREATE DATABASE if not exists library;

USE library;

CREATE TABLE author (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE books (
   id INT PRIMARY KEY,
   title VARCHAR(255),
   author_id INT,
   isbn VARCHAR(255),
   status VARCHAR(255),
   quantityConstant INT,
   quantity INT,
   quantityLost INT,
   quantityReserved INT,
   FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE reservations (
  user_id VARCHAR(255),
  bookTitle VARCHAR(255),
  bookIsbn VARCHAR(255),
  dateDeReservation DATETIME,
  dateDeReturn DATETIME
);

CREATE TABLE user (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  idCard VARCHAR(255),
  phone VARCHAR(255)
);

CREATE TRIGGER reserve
    AFTER UPDATE
    ON books FOR EACH ROW
    UPDATE books
    SET quantityReserved = NEW.quantityReserved + 1;
