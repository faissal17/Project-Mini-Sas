
public class reservation {
protected String userIdCard;
protected String bookTitle;
protected String bookIsbn;
protected String dateDeReservation;
protected String dateDeReturn;

public reservation (String userIdCard, String bookTitle, String bookIsbn, String dateDeReservation, String dateDeReturn){
    this.userIdCard = userIdCard;
    this.bookTitle = bookTitle;
    this.bookIsbn = bookIsbn;
    this.dateDeReservation = dateDeReservation;
    this.dateDeReturn = dateDeReturn;
}
}
