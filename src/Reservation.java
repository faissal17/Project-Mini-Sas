
public class Reservation {
    private Integer user_id;
    private Book Book;
    private User User;
    private String bookTitle;
    private String bookIsbn;
    private String dateDeReservation;
    private String dateDeReturn;

         public Reservation(Integer user_id, String bookTitle, String bookIsbn, String dateDeReservation, String dateDeReturn, Book Book, User User){
            this.user_id = user_id;
            this.bookTitle = bookTitle;
            this.bookIsbn = bookIsbn;
            this.dateDeReservation = dateDeReservation;
            this.dateDeReturn = dateDeReturn;
            this.Book = Book;
            this.User = User;
         }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Book getBook() {
        return Book;
    }

    public void setBook(Book book) {
        Book = book;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
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

    public String getDateDeReservation() {
        return dateDeReservation;
    }

    public void setDateDeReservation(String dateDeReservation) {
        this.dateDeReservation = dateDeReservation;
    }

    public String getDateDeReturn() {
        return dateDeReturn;
    }

    public void setDateDeReturn(String dateDeReturn) {
        this.dateDeReturn = dateDeReturn;
    }
}
