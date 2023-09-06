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
   FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);
CREATE TABLE users (
   id INT PRIMARY KEY,
   name VARCHAR(255),
   idCard VARCHAR(255),
   phone VARCHAR(255)
);
CREATE TABLE reservations (
  id INT PRIMARY KEY,
  book_id INT,
  user_id INT,
  bookTitle VARCHAR(255),
  bookIsbn VARCHAR(255),
  dateDeReservation DATETIME,
  dateDeReturn DATETIME,
  FOREIGN KEY (book_id) REFERENCES books(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);
DELIMITER //
CREATE TRIGGER reserve
    AFTER UPDATE
    ON books FOR EACH ROW
BEGIN
    IF NEW.quantityReserved = OLD.quantityReserved + 1 THEN
        UPDATE books
        SET quantityReserved = NEW.quantityReserved;
    END IF;
END
//
DELIMITER ;