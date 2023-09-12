DROP DATABASE if exists library;

CREATE DATABASE if not exists library;

USE library;

CREATE TABLE author (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(255)
);

CREATE TABLE books (
   id INT PRIMARY KEY auto_increment,
   title VARCHAR(255),
   author_id INT,
   isbn VARCHAR(255) unique,
   quantityTotal INT,
   quantity INT,
   quantityLost INT,
   quantityReserved INT,
   FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);
CREATE TABLE users (
   id INT PRIMARY KEY auto_increment,
   name VARCHAR(255),
   idCard VARCHAR(255),
   phone VARCHAR(255)
);
CREATE TABLE reservations (
  id INT PRIMARY KEY auto_increment,
  book_id INT,
  user_id INT,
  bookIsbn VARCHAR(255),
  dateDeReservation TIMESTAMP,
  dateDeReturn TIMESTAMP,
  FOREIGN KEY (book_id) REFERENCES books(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

DELIMITER //
CREATE TRIGGER before_update_book_status
    BEFORE UPDATE ON books
    FOR EACH ROW
BEGIN
    SET NEW.quantity = OLD.quantity - 1;
    SET NEW.quantityReserved = OLD.quantityReserved + 1;
END;
//
DELIMITER ;

