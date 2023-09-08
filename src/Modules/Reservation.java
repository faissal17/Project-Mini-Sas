package Modules;
import java.sql.*;

import Connection.DbConnection;

public class Reservation {
    private int id;
    private  Book book;
    private  User user;
    private String bookTitle;
    private String bookIsbn;
    private  Date dateDeReservation;
    private  Date dateDeReturn;

    public Reservation(int id, String bookTitle, String bookIsbn, Date dateDeReservation, Date dateDeReturn, Book book, User user) {
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

    public Date getDateDeReservation() {
        return dateDeReservation;
    }

    public void setDateDeReservation(Date dateDeReservation) {
        this.dateDeReservation = dateDeReservation;
    }

    public Date getDateDeReturn() {
        return dateDeReturn;
    }

    public void setDateDeReturn(Date dateDeReturn) {
        this.dateDeReturn = dateDeReturn;
    }

    public static String ReserveBook(int id, String bookTitle, String UserName, String bookIsbn, Date dateDeReservation, Date dateDeReturn) {
        try {
            // check if the isbn is correct or not
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT id, quantity, quantityReserved FROM books WHERE isbn = ?");
            ps.setString(1, bookIsbn);
            ResultSet availableBook = ps.executeQuery();

            if (availableBook.next()) {
                int bookId = availableBook.getInt("id");
                int quantity = availableBook.getInt("quantity");
                int quantityReserved = availableBook.getInt("quantityReserved");
                int userLibrary = getTheUserIdByName(connection, UserName);

                if (userLibrary != -1) {
                    if (quantity > 0) {
                        Connection conDatabase = DbConnection.getConnection();
                        PreparedStatement prepare = conDatabase.prepareStatement("INSERT INTO reservations VALUES (?,?,?,?,?,?,?)");
                        prepare.setInt(1, bookId);
                        prepare.setInt(2, userLibrary);
                        prepare.setTimestamp(3, new java.sql.Timestamp(dateDeReservation.getTime()));
                        prepare.setTimestamp(4, new java.sql.Timestamp(dateDeReturn.getTime()));
                        prepare.executeUpdate();

                        // update the quantity and quantity reserved
                        PreparedStatement updateState = conDatabase.prepareStatement("UPDATE books SET quantity = ? ,quantityReserved = ? WHERE id = ?");
                        updateState.setInt(1, quantity - 1);
                        updateState.setInt(2, quantityReserved + 1);
                        updateState.setInt(3, bookId);
                        updateState.executeUpdate();
                    }
                }
            } else {
                System.out.println("Book with ISBN '" + bookIsbn + "' not found.");
                return "Book with ISBN '" + bookIsbn + "' not found.";
            }
        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e.getMessage();
        }
        String successMessage = "Book with ISBN '" + bookIsbn + "' borrowed successfully";
        System.out.println(successMessage);
        return successMessage;
    }



    private static int getTheUserIdByName(Connection connection, String userName) {
        int UserLibrary = -1;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `users` WHERE name =?");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UserLibrary = rs.getInt("id");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return UserLibrary;
    }
}

