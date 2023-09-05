CREATE TABLE author(
    id INT PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE books(
    id INT PRIMARY KEY,
    title VARCHAR (255),
    author_id INT,
    isbn VARCHAR (255),
    status VARCHAR (255),
    quantity INT,
    quantityLost INT,
    quantityImprinted INT,
    FOREIGN KEY (author_id) REFERENCES author(id)
);
CREATE TABLE reservations (
    userIdCard VARCHAR(255),
    bookTitle VARCHAR(255),
    bookIsbn VARCHAR(255),
    dateDeReservation datetime,
    dateDeReturn datetime
);
CREATE TABLE user(
    id INT,
    name VARCHAR(255),
    idCard VARCHAR(255),
    phone VARCHAR(255)
)