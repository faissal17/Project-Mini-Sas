package Modules;
import java.sql.*;
import Modules.User;
import Connection.DbConnection;

import javax.lang.model.element.Name;

public class Reservation {
    private int id;
    private Book book;
    private User user;
    private String bookTitle;
    private String bookIsbn;
    private Timestamp dateDeReservation;
    private Timestamp dateDeReturn;

    public Reservation(int id, String bookTitle, String bookIsbn, Timestamp dateDeReservation, Timestamp dateDeReturn, Book book, User user) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookIsbn = bookIsbn;
        this.dateDeReservation = dateDeReservation;
        this.dateDeReturn = dateDeReturn;
        this.book = book;
        this.user = user;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Timestamp getDateDeReservation() {
        return dateDeReservation;
    }

    public void setDateDeReservation(Timestamp dateDeReservation) {
        this.dateDeReservation = dateDeReservation;
    }

    public Timestamp getDateDeReturn() {
        return dateDeReturn;
    }

    public void setDateDeReturn(Timestamp dateDeReturn) {
        this.dateDeReturn = dateDeReturn;
    }

    public void ReserveBook() {
        try {
            Connection connection = DbConnection.getConnection();

            // Check if the ISBN is correct or not
            PreparedStatement ps = connection.prepareStatement("SELECT id, quantity, quantityReserved FROM books WHERE isbn = ?");
            ps.setString(1, getBookIsbn());
            ResultSet isbnResult = ps.executeQuery();

            if (isbnResult.next()) {
                int bookId = isbnResult.getInt("id");
                int quantity = isbnResult.getInt("quantity");
                int quantityReserved = isbnResult.getInt("quantityReserved");

                int userId = User.AddUser(user);

                PreparedStatement prepare = connection.prepareStatement("INSERT INTO reservations VALUES (?,?,?,?,?,?)");
                prepare.setInt(1, getId());
                prepare.setInt(2, bookId);
                prepare.setInt(3, userId);
                prepare.setString(4, getBookIsbn());
                prepare.setTimestamp(5, getDateDeReservation());
                prepare.setTimestamp(6, getDateDeReturn());
                prepare.executeUpdate();

                PreparedStatement updateBookStatus = connection.prepareStatement("UPDATE books SET quantity = ?, quantityReserved = ? WHERE id = ?");
                updateBookStatus.setInt(1, quantity - 1);
                updateBookStatus.setInt(2, quantityReserved + 1);
                updateBookStatus.setInt(3, bookId);
                updateBookStatus.executeUpdate();
            } else {
                System.out.println("The ISBN is incorrect");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
