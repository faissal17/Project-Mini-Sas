package Modules;
import java.sql.Date;
import Connection.DbConnection;

public class Reservation {
    private int id;
    private Book book;
    private User user;
    private String bookTitle;
    private String bookIsbn;
    private Date dateDeReservation;
    private Date dateDeReturn;

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
    public static void ReserveBook(){

    }
}

